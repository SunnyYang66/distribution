package com.mfoyou.agent.web.service.order;

import java.awt.Polygon;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.protocol.RequestUserAgent;
import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.PolygonArea;
import org.mfoyou.agent.utils.json.JSONMaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class OrderService {

	@Autowired
	IOrder iOrder;
	@Autowired
	OrderRunerService orderRunerService;
	@Autowired
	XGPushSerivce xgPushSerivce;
	@Autowired
	IGoodsOrder iGoodsOrder;
	@Autowired
	IStore iStore;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	GoodOrderService goodOrderService;
	@Autowired
	IStatistics iStatistics;
	@Autowired
	IIdentity iIdentity;
	public static final String SERVICE_ORDER_TIME1 = "wx:runner_push_data1";
	public static final String SERVICE_ORDER_TIME2 = "wx:runner_push_data2";
	public static final String XING_ORDER_PUSH = "xing:success:order:push";
	public static final String WX_PUSH = "wx:100:push";
	Logger logger = Logger.getLogger(OrderService.class);

	public OrderInfo getOrderInfo(Integer orderId, Integer orderType) {
		if (orderType.intValue() == OrderType.serviceOrder.getValue().intValue()) {
			HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(orderId);
			if (mfoyouServiceOrder != null) {
				return new OrderInfo(mfoyouServiceOrder);
			}
		} else if (orderType.intValue() == OrderType.goodsOrder.getValue().intValue()) {
			MfoyouGoodsOrder goodsOrder = iGoodsOrder.getGoodsOrderByOrderid(orderId);
			if (goodsOrder != null) {
				return new OrderInfo(goodsOrder);
			}
			return null;
			// 商品订单
		}
		// 未知
		return null;
	}

	public Boolean payOrder(Integer orderId, Integer orderType, int cash_free, Integer payType) {
		OrderInfo orderInfo = getOrderInfo(orderId, orderType);
		if (orderInfo == null)
			return false;
		int orderAuomentFree = orderInfo.getOrderAmount();
		int hasPay = orderInfo.getOrderPaidAmount();
		int total = cash_free + hasPay;
		if (total > orderAuomentFree) {
			logger.error("支付金额大于实际所需支付,请核查~!!!!\ntotal=" + total + "orderAuomentFree=" + orderAuomentFree);
		}
		boolean finshPay = (total-orderInfo.getCouponReduceMoney() >= orderAuomentFree);
		String orderPayRemark = orderInfo.getPayRemark();
		orderPayRemark = JSONMaker.addListItem(orderPayRemark, "payType", makePayType(payType, cash_free));
		if (orderType.intValue() == OrderType.serviceOrder.getValue()) {
			HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
			mfoyouServiceOrder.setServiceOrderId(orderId);
			mfoyouServiceOrder.setServiceOrderPayAmount(total);
			mfoyouServiceOrder.setServicePayType(orderPayRemark);
			// mfoyouServiceOrder.setAgentId(orderInfo.getAgentId());
			if (finshPay) {
				mfoyouServiceOrder.setServiceOrderState(OrderState.emPaySucess.getValue());
				if (orderRunerService.InsertSeekAgentRuner(orderId)) {
					// mfoyouServiceOrder.setServiceOrderAllSeeTime(new
					// Date(System.currentTimeMillis() + 1000 * 60 * 3));
				}
			}
			Boolean ret = mdfServiceOrder(mfoyouServiceOrder, orderInfo.getOrderUserId());
			xgPushSerivce.checkOrderState(orderId, System.currentTimeMillis() + 10 * 60 * 1000L);
			return ret;
		} else if (orderType.intValue() == OrderType.goodsOrder.getValue()) {
			// 付款
			MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
			mfoyouGoodsOrder.setOrderId(orderId);
			mfoyouGoodsOrder.setOrderPayAmount(total);
			mfoyouGoodsOrder.setOrderPayRemark(orderPayRemark);
			mfoyouGoodsOrder.setOrderPayTime(new Date());
			mfoyouGoodsOrder.setOrderTranspoetAmount(0);
			mfoyouGoodsOrder.setStoreId(orderInfo.getStoreId());
			HuawuStoreInfo storeInfo = iStore.getStoreInfo(orderInfo.getStoreId());
			if (finshPay) {
				String orderKey = "" + orderInfo.getStoreId() + DateUtils.yyyyMMdd.format(new Date());
				Long id = redisCacheManger.getIncr("store:order:" + orderKey, 24 * 3600);
				String orderNumber = orderKey + String.format("%4d", id % 10000).replace(" ", "0");
				mfoyouGoodsOrder.setOrderNumber(orderNumber);
				calcAmountAllot(mfoyouGoodsOrder);
				mfoyouGoodsOrder.setOrderState(GoodsOrderState.emWaitingAccept.getValue());
				HuawuStoreInfo save = new HuawuStoreInfo();
				save.setStoreTotalOrderCount(storeInfo.getStoreTotalOrderCount() + 1);
				save.setStoreSaleCount(storeInfo.getStoreSaleCount() + orderInfo.getSubItemCount());
				iStore.updateStoreInfoById(storeInfo.getStoreId(), save);
			}
			Boolean ret = iGoodsOrder.modifyGoodsOrder(mfoyouGoodsOrder);
			// wxpush 1---> 支付成功
			redisCacheManger.pushRList(WX_PUSH, "1:" + orderId);
			redisCacheManger.pushRList(WX_PUSH, "3:" + orderId);
			redisCacheManger.pushRList(XING_ORDER_PUSH, "2," + orderId);
			// 判断店铺是否自动接单,如果自动接单就调用一下接单
			if (ret && storeInfo.getStoreAutoReceipt() != null && storeInfo.getStoreAutoReceipt().intValue() == 1) {
				goodOrderService.receipt(orderId, orderInfo.getStoreId(), 2);
			}
			return ret;
		}
		return false;
	}

	private String makePayType(Integer payType, Integer amount) {
		String value = "" + (amount / 100) + '.';
		Integer dot = amount % 100;
		if (dot > 9) {
			value += dot + "元";
		} else {
			value += "0" + dot + "元";
		}
		if (payType == null) {
			return "未知:" + value;
		} else if (payType == PayType.wallet.getValue()) {
			return "钱包支付:" + value;
		} else if (payType == PayType.WeChat.getValue()) {
			return "微信支付:" + value;
		} else if (payType == PayType.alipay.getValue()) {
			return "支付宝支付:" + value;
		} else if (payType == PayType.goodsOrder.getValue()) {
			return "店铺订单扣除:" + value;
		}
		return null;
	}

	public Boolean mdfServiceOrder(HuawuServiceOrder mfoyouServiceOrder, Integer opUserId) {
		return iOrder.mdfServiceOrder(mfoyouServiceOrder, opUserId);
	}

	public int addMfoyouOrderLog(HuawuOrderLog mfoyouOrderLog) {
		return iOrder.addMfoyouOrderLog(mfoyouOrderLog);
	}

	public HuawuServiceOrder getServiceOrderInfo(Integer orderTransportId) {
		return iOrder.getServiceOrderInfo(orderTransportId);
	}

	public Boolean revokeServiceOrder(Integer orderId, Integer userId, Integer payAmount, Integer orderState,
			Integer targetPayAmount, Integer targetState) {
		return iOrder.revokeServiceOrder(orderId, userId, payAmount, orderState, targetPayAmount, targetState);
	}

	public Boolean payServiceTranspoetAmount(Integer orderId, Integer transportId, Integer amount) {
		MfoyouGoodsOrder orderInfo = iGoodsOrder.getGoodsOrderByOrderid(orderId);
		if (orderInfo == null)
			return false;
		orderInfo.setOrderTranspoetAmount(orderInfo.getOrderTranspoetAmount() + amount);
		if (calcAmountAllot(orderInfo)) {
			MfoyouGoodsOrder saveInfo = new MfoyouGoodsOrder();
			saveInfo.setOrderId(orderId);
			saveInfo.setOrderTranspoetAmount(orderInfo.getOrderTranspoetAmount());
			saveInfo.setOrderAdminAmount(orderInfo.getOrderAdminAmount());
			saveInfo.setOrderAgentAdmount(orderInfo.getOrderAgentAdmount());
			saveInfo.setOrderStoreAmount(orderInfo.getOrderStoreAmount());
			saveInfo.setOrderStationAmount(orderInfo.getOrderStationAmount());
			saveInfo.setOrderState(GoodsOrderState.emSeekRuner.getValue());
			saveInfo.setOrderTransportId(transportId);
			saveInfo.setOrderTransportState(OrderState.emSeekRuner.getValue());
			saveInfo.setOrderTransportType(2);
			return iGoodsOrder.modifyGoodsOrder(saveInfo);
		}
		return false;
	}

	public Boolean calcAmountAllot(MfoyouGoodsOrder orderInfo) {
		Integer storeId = orderInfo.getStoreId();
		HuawuStoreInfo mfoyouStoreInfo = iStore.getStoreInfo(storeId);// 10
		Integer storePercent = mfoyouStoreInfo.getStorePercentage();// 10
		// Integer adminPercent = storePercent;// 10
		// Integer stationPercent = 0;// 0
		//
		// if (adminPercent > storePercent) {
		// logger.info("adminPercent is too big in storeid " + storeId);
		// return false;
		// }

		Integer totalAmount = orderInfo.getOrderPayAmount() - orderInfo.getOrderTranspoetAmount();
		if (totalAmount == null || totalAmount < 0)
			return false;
		int storeAmount = (int) Math.round(totalAmount * (100 - storePercent) / 100.0);
		// int adminAmount = (int) Math.round(totalAmount * adminPercent /
		// 100.0);
		// int agentAmount = (int) Math.round((totalAmount - storeAmount -
		// adminAmount) * (100 - stationPercent) / 100.0);
		// int stationAmount = totalAmount - storeAmount - agentAmount -
		// adminAmount;
		int agentAmount = totalAmount - storeAmount;
		int stationAmount = 0;
		if(mfoyouStoreInfo.getStoreStationId()!=null){
			MfoyouStationMaster stationMasterByUserId = iIdentity.getStationMasterByUserId(mfoyouStoreInfo.getStoreStationId());
			if(stationMasterByUserId!=null && stationMasterByUserId.getStoreShareFee()!=null){
				stationAmount = agentAmount*stationMasterByUserId.getStoreShareFee()/100;
				agentAmount-=agentAmount;
			}
		}
		orderInfo.setOrderAdminAmount(0);
		orderInfo.setOrderAgentAdmount(agentAmount);
		orderInfo.setOrderStoreAmount(storeAmount);
		orderInfo.setOrderStationAmount(stationAmount);
		return true;
	}

	public Map<String, Object> getOrderTongji(Integer storeid) {
		Map<String, Object> tongji = iStatistics.getTongji(storeid);
		return tongji;
	}

	public Map<String, Object> getOrderTongjiV2(Integer storeid) {
		Map<String, Object> tongji = iStatistics.getTongjiV2(storeid);
		return tongji;
	}

	public Map<String, Map<String, Object>> getDataAnaly(Integer storeId, Date date) {
		return iStatistics.getTongjiV3(storeId, date);
	}

	public Map<String, Object> getDataAnaly(Integer storeid, Long startDate, Long endDate) {
		return iStatistics.getTongjiV3(storeid, startDate, endDate);
	}

	public boolean checkInside(List<MfoyouRegionCustom> list,Double fromlat,Double fromlon,Double tolat,Double tolon) {
		if(list==null || list.size()==0){
			return true;
		}
		if(fromlat==null || fromlon==null){
			if(tolat==null || tolon == null){
				return false;
			}else{
				for(int i=0;i<list.size();i++){
					MfoyouRegionCustom mfoyouRegionCustom = list.get(i);
					if(mfoyouRegionCustom.getAgentCoordinateArea()==null) continue;
					PolygonArea parseObject = JSON.parseObject(mfoyouRegionCustom.getAgentCoordinateArea(), PolygonArea.class);
					Polygon polygon = parseObject.makePolygon(1000000);
					if (polygon.contains(tolon * 1000000, tolat * 1000000)){
							return true;
					}
				}
				return false;
			}
		}
		for(int i=0;i<list.size();i++){
			MfoyouRegionCustom mfoyouRegionCustom = list.get(i);
			if(mfoyouRegionCustom.getAgentCoordinateArea()==null) continue;
			PolygonArea parseObject = JSON.parseObject(mfoyouRegionCustom.getAgentCoordinateArea(), PolygonArea.class);
			Polygon polygon = parseObject.makePolygon(1000000);
			if (polygon.contains(fromlon * 1000000, fromlat * 1000000)){
				if(tolat==null || tolon==null){
					return true;
				}
				if(polygon.contains(tolon* 1000000, tolat* 1000000)){
					return true;
				}
			}
		}
		return false;
	}
}
