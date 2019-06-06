package com.mfoyou.agent.web.service.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentUserCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserActiveAttend;
import org.mfoyou.agent.common.entity.GoodsLock;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderDetail;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderEx;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.service.account.GoodsService;
import com.mfoyou.agent.web.service.account.StoreActiveService;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.utils.common.GoodsOrderAmount;
import com.mfoyou.agent.web.utils.common.StoreActiveInfo;
import com.mfoyou.agent.web.utils.common.StoreDispatchUtil;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class GoodOrderService {
	@Autowired
	IGoodsOrder iGoodsOrder;
	@Autowired
	IOrder iOrder;
	@Autowired
	IStore  iStore;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
//	@Autowired
//	private IStaffUser iStaffUser;
//	@Autowired
//	private IStatistics iStatistics;
	@Autowired
	private RedisCacheManger redisCacheManger;
	@Autowired
	private StoreActiveService storeActiveService;
	@Autowired
	ServiceOrderService serviceOrderService;
	@Autowired
	OrderService  orderService;
//	@Autowired
//	IPayment iPayment;
//	@Autowired
//	PaymentService paymentService;
//	@Autowired
//	DadaCService dadaCService;
//	@Autowired
//	FengniaoService fengniaoService;
	public static final String YINIANYUN = "yinianyun:1";
	public static final String PRINTER_PRE = "printer:machine:";
	public static final String CONF_ADMIN_FEE = "conf:admin:storefee";
	private static Logger logger = new Logger(GoodOrderService.class);

	public JsonRet<?> receipt(Integer orderId, Integer storeId, int mode) {
		MfoyouGoodsOrder order = new MfoyouGoodsOrder();
		order.setOrderId(orderId);
		MfoyouGoodsOrderEx orderEx = getGoodsOrder(orderId);
		if (!orderEx.getStoreId().equals(storeId)) {
			return JsonRet.buildRet(-50);
		}
		if (orderEx.getOrderState() != GoodsOrderState.emWaitingAccept.getValue()) {
			return JsonRet.buildFailRet("请勿重复点击");
		}
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() != null) {
			String hget = redisCacheManger.hget(PRINTER_PRE + storeInfo.getStorePrinterNumber(), "autoprint");
			if (hget != null && hget.equals("1")) {
				redisCacheManger.pushRList(YINIANYUN, orderId + "");
			}
		}
		//优先达达
//		if (storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() >> 8 & 3) == 1) {
//			return pushtoDada(orderEx);
//		}
//		else if(storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() >> 8 & 3) == 2){
//			return pushtoFengNiao(orderEx,storeInfo);
//		}
		else if(storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() & 1) == 1){
			return pushToMfoyou(orderEx, storeInfo, mode);
		}
		int result = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emStoreAccept.getValue());
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
	}
//	/**
//	 * 推送给蜂鸟
//	 * @param orderEx
//	 * @return
//	 */
//	private JsonRet<?> pushtoFengNiao(MfoyouGoodsOrderEx orderEx,MfoyouStoreInfo mfoyouStoreInfo) {
//		logger.info("fengniao start");
//		try {
//			MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
//			mfoyouGoodsOrder.setOrderId(orderEx.getOrderId());
//			String addOrder = FengniaoUtil.addOrder(orderEx, mfoyouStoreInfo, fengniaoService.getToken());
//			logger.info("addOrderInfo:"+addOrder);
//			JSONObject jsonObject = JSONObject.parseObject(addOrder);
//			int code = jsonObject.getIntValue("code");
//			if(code==200){
//				int ret = updateGoodsOrder(mfoyouGoodsOrder, null, null, GoodsOrderState.emSeekRuner.getValue());
//				logger.info("添加蜂鸟订单成功 但是更新结果" + ret);
//				return ret == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
//			}else{
//				int ret = updateGoodsOrder(mfoyouGoodsOrder, null, null, GoodsOrderState.emStoreAccept.getValue());
//				logger.info("添加蜂鸟订单失败 但是更新结果" + ret);
//				return ret == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return JsonRet.buildRet(-1);
//	}
	/**
	 * 推送给华悟快送
	 * @return
	 */
	private JsonRet<?> pushToMfoyou(MfoyouGoodsOrderEx orderEx,HuawuStoreInfo storeInfo, int mode){
		MfoyouGoodsOrder order = new MfoyouGoodsOrder();
		order.setOrderId(orderEx.getOrderId());
		if (storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() & 0x01) != 1) {
			int result = updateGoodsOrder(order, null, null, GoodsOrderState.emStoreAccept.getValue());
			return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
		}
		int ret = serviceOrderService.addServiceOrder(orderEx, storeInfo, mode);
		if (ret > 0) {
			logger.info("服务订单号：" + ret);
		} else if (ret == -1002) {
			logger.info("钱不足订单" + orderEx.getOrderId());
			// 支付钱不足
			order.setOrderExceptionState(orderEx.getOrderExceptionState() | 0x04);
		}
		int result = ret <= 0 ? updateGoodsOrder(order, null, null, GoodsOrderState.emStoreAccept.getValue())
				: updateGoodsOrder(order, OrderState.emSeekRuner.getValue(), null,
						GoodsOrderState.emSeekRuner.getValue());
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(ret);
	}

	    
//	/**
//	 * 推送给达达订单
//	 * @param orderEx
//	 * @return
//	 */
//	private JsonRet<?> pushtoDada(MfoyouGoodsOrderEx orderEx) {
//		JSONObject createOrder = dadaCService.createOrder(orderEx);
//		Double fee = createOrder.getDouble("fee");
//		String diliveryNo = createOrder.getString("deliveryNo");
//		MfoyouWallet userMfoyouWallet = iPayment.getUserMfoyouWallet(orderEx.getStoreId());
//		if (userMfoyouWallet == null) {
//			return JsonRet.buildRet(-1);
//		}
//		Integer walletFreightAccount = userMfoyouWallet.getWalletFreightAccount();
//		if (fee * 100 > walletFreightAccount) {
//			int updateGoodsOrder = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emStoreAccept.getValue());
//			logger.error(String.format("钱包钱不够,钱包目前的金额为：%.2f元,但是订单金额为：%.2f元,更新状态为"+updateGoodsOrder, (double) walletFreightAccount / 100, fee));
//			return JsonRet.buildFailRet(
//					String.format("钱包金额不足,钱包目前的金额为：%.2f元,但是订单金额为：%.2f元", (double) walletFreightAccount / 100, fee));
//		}
//		Boolean payAddTransporFee = paymentService.payAddTransporFee(orderEx.getStoreId(), walletFreightAccount,
//				-(int) (fee * 100), orderEx.getOrderNumber(), OrderType.dadaOrder.getValue(), orderEx.getAreaAgentId(),
//				null);
//		if (payAddTransporFee) {
//			boolean addAfterQuery = dadaCService.addAfterQuery(diliveryNo);
//			if (addAfterQuery) {
//				orderEx.setOrderNote(diliveryNo);
//				orderEx.setOrderTransportType(6);
//				int ret = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emSeekRuner.getValue());
//				logger.info("添加达达订单成功 但是更新结果" + ret);
//				return ret == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
//			} else {
//				orderEx.setOrderNote(diliveryNo);
//				int ret = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emStoreAccept.getValue());
//				return ret == 1 ? JsonRet.buildRet(-1004) : JsonRet.buildRet(-1002);
//			}
//		} else {
//			int ret = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emStoreAccept.getValue());
//			return ret == 1 ? JsonRet.buildRet(-1004) : JsonRet.buildRet(-1002);
//		}
//	}

//	private JsonRet<?> receiptNative(MfoyouGoodsOrderEx orderEx) {
//		MfoyouStoreInfo storeInfo = storeService.getStoreInfo(orderEx.getStoreId());
//		if (storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() >> 8 & 1) == 1) {
//			return pushtoDada(orderEx);
//		}else if(storeInfo.getStoreAutoDispatch() == null || (storeInfo.getStoreAutoDispatch().intValue() & 1) == 1){
//			return pushToMfoyou()
//		}
//		int result = updateGoodsOrder(orderEx, null, null, GoodsOrderState.emStoreAccept.getValue());
//		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1002);
//		
//	}

	public ArrayListObject<MfoyouGoodsOrder> getGoodsOrderList(MfoyouGoodsOrder order, Date sdate, Date edate,
			Integer pageid, Integer pageSize, List<Integer> status, Integer i) {
		// get order
		return iGoodsOrder.getMfoyouGoodsOrderList(order, pageid, pageSize, sdate, edate, status, i);
	}

	public ArrayListObject<MfoyouGoodsOrderWithPackage> getGoodsOrderWithPackageList(MfoyouGoodsOrder order, Date sdate,
			Date edate, Integer pageid, Integer pageSize, List<Integer> status, Integer i, String key) {
		// get order withPackage
		return iGoodsOrder.getMfoyouGoodsOrderWithPackList(order, pageid, pageSize, sdate, edate, status, i, key);
	}

	public int updateGoodsOrder(MfoyouGoodsOrder order, Integer transportState, Integer fromState, Integer orderState) {
		return iGoodsOrder.updateOrderState(order, transportState, fromState, orderState);
	}

	public Boolean mdfGoodsOrder(MfoyouGoodsOrder order) {
		return iGoodsOrder.mdfGoodsOrder(order);
	}

	public int updateGoodsOrderByPrimaryKey(MfoyouGoodsOrder order) {
		return iGoodsOrder.updateOrderByPromaryKey(order);
	}

	public MfoyouGoodsOrder getOrder(Integer orderid) {
		return iGoodsOrder.getGoodsOrderByOrderid(orderid);
	}

	public Boolean modifyGoodsOrder(MfoyouGoodsOrder order) {
		if (order.getOrderId() == null)
			return false;
		return iGoodsOrder.modifyGoodsOrder(order);
	}

	public ArrayListObject<MfoyouGoodsOrderWithPackage> getExceptionOrder(Integer storeId, Integer pageid,
			Integer pageSize, int i) {
		// TODO Auto-generated method stub
		return iGoodsOrder.getExceptionOrder(storeId, pageSize, pageid, i);
	}
//
//	public Map<String, Object> getOrderCount(Integer storeId, Integer monthId) {
//		// TODO Auto-generated method stub
//		Map<String, Object> hashmap = new HashMap<String, Object>();
////		hashmap.put("todayDayid", iStatistics.getDayid());
//		List<MfoyouOrderStatistics> currentDay = iOrder.getCurrentDay(storeId, 0);
//		hashmap.put("current7Day", currentDay);
//		MfoyouOrderStatistics todayCount = iOrder.getTodayCount(storeId);
//		hashmap.put("today", todayCount);
//		MfoyouOrderStatistics monthCount = iOrder.getMonthCount(storeId, monthId);
//		hashmap.put("month", monthCount);
//		return hashmap;
//	}
//
//	public MfoyouOrderStatistics getMonthOrder(Integer storeId, Integer monthId) {
//		return iOrder.getMonthCount(storeId, monthId);
//	}

	
	public int orderAmountCalc(MfoyouGoodsOrderEx orderStore, GoodsOrderAmount orderAmount, Boolean bCalcDistance,
			Boolean checkStock) {
		ObjectUtil.checkInputValue(orderStore, orderStore.getStoreId(), orderStore.getOrderDistance(),
				orderStore.getList(),orderStore.getOrderUserLon(),orderStore.getOrderUserLat());
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(orderStore.getStoreId());
		if (storeInfo == null)
			return -98;
		StoreActiveInfo storeActiveInfo = storeActiveService.getStoreActive(orderStore.getStoreId());
		if (bCalcDistance) {
			// 校验距离
			Double sLon = storeInfo.getStoreLocalLat();
			Double sLat = storeInfo.getStoreLocalLon();
			Double cLon = orderStore.getOrderUserLon();
			Double cLat = orderStore.getOrderUserLat();
			ObjectUtil.checkDataValue(sLon, sLat, cLon, cLat);
			Integer distance = (int) Math.round((1000 * GisUtils.distVincenty(sLat, sLon, cLat, cLon)));
			if (distance < orderStore.getOrderDistance()) {
				return -37;
			}
			orderStore.setOrderTitle(storeInfo.getStoreName());
			orderStore.setStoreName(storeInfo.getStoreName());
			int day = storeInfo.getStoreSettlementDelay() == null ? 2 : storeInfo.getStoreSettlementDelay();
			orderStore.setOrderSettlementDate(
					new Date(DateUtils.getTimesmorning().getTime() + (day + 1) * 3600L * 24 * 1000));
		}
		// 计算商品总价
		Integer totalCostAmount = 0;
		Integer totalDiscountAmount = 0;
		Integer totalGoodsCount = 0;
		Integer totalpackageFee = 0;
		Integer couponReduceFee = 0;
		List<MfoyouGoodsOrderItme> orderList = orderStore.getList();
		List<GoodsLock> lockList = new ArrayList<>();
		if (orderList.size() > 100) {
			return -39;
		}
		for (MfoyouGoodsOrderItme orderItem : orderList) {
			Integer goodsId = orderItem.getGoodsId();
			Integer packetId = orderItem.getPackageId();
			Integer number = orderItem.getItemNumber();
			if (number <= 0 || number > 200) {
				// 不合理的数量
				return -39;
			}
			ObjectUtil.checkInputValue(number);
			ObjectUtil.checkDataRange(number, 1, 999);
			totalGoodsCount += number;
			if (packetId != null) {
				MfoyouGoodsPackage mfoyouGoodsPackage = goodsService.getPackage(packetId);
				if (mfoyouGoodsPackage == null) {
					// 部分商品已经失效
					return -39;
				}
				goodsId = mfoyouGoodsPackage.getGoodsId();
				orderItem.setGoodsId(mfoyouGoodsPackage.getGoodsId());
				if (checkStock) {
					if (mfoyouGoodsPackage.getPackageNumber() >= 0 && number > mfoyouGoodsPackage.getPackageNumber()) {
						return -36;
					}
				}
				orderItem.setGoodsOriginalPrice(mfoyouGoodsPackage.getPackageCostPrice());
				orderItem.setGoodsDealPrice(mfoyouGoodsPackage.getPackageDiscountPrice());
				orderItem.setPackageName(mfoyouGoodsPackage.getPackageName());
				if (mfoyouGoodsPackage.getPackageDiscountPrice() == null) {
					totalDiscountAmount += mfoyouGoodsPackage.getPackageCostPrice() * number;
					totalCostAmount += mfoyouGoodsPackage.getPackageCostPrice() * number;
					orderItem.setItemTotalAmount(mfoyouGoodsPackage.getPackageCostPrice() * number);
				} else {
					totalDiscountAmount += mfoyouGoodsPackage.getPackageDiscountPrice() * number;
					totalCostAmount += mfoyouGoodsPackage.getPackageCostPrice() * number;
					orderItem.setItemTotalAmount(mfoyouGoodsPackage.getPackageDiscountPrice() * number);
				}
				totalpackageFee += mfoyouGoodsPackage.getPackagePackageFee() * number;
				orderItem.setPackageFee(mfoyouGoodsPackage.getPackagePackageFee() * number);
				if (checkStock && goodsId != null) {
					MfoyouGoodsInfo mfoyouGoodsInfo = goodsService.getMfoyouGoodsInfo(goodsId);
					orderItem.setGoodsName(mfoyouGoodsInfo.getGoodsTitle());
					orderItem.setGoodsPic(mfoyouGoodsInfo.getGoodsMainPic());
					if (mfoyouGoodsPackage.getPackageNumber() > 0) {
						// 减库存
						GoodsLock goodsLock = new GoodsLock();
						goodsLock.setPackageId(packetId);
						goodsLock.setCurCount(mfoyouGoodsPackage.getPackageNumber());
						goodsLock.setSubCount(number);
						goodsLock.setSaleCount(mfoyouGoodsInfo.getGoodsTotalSale());
						goodsLock.setGoodsId(goodsId);
						lockList.add(goodsLock);
					}
				}
				continue;
			}
			if (goodsId != null) {
				MfoyouGoodsInfo mfoyouGoodsInfo = goodsService.getMfoyouGoodsInfo(goodsId);
				if (mfoyouGoodsInfo == null) {
					// 商品失效
					return -39;
				}
				if (checkStock) {
					if (mfoyouGoodsInfo.getGoodsNumber() >= 0 && number > mfoyouGoodsInfo.getGoodsNumber()) {
						return -36;
					} else if (mfoyouGoodsInfo.getGoodsNumber() > 0) {
						// 减库存
						GoodsLock goodsLock = new GoodsLock();
						goodsLock.setGoodsId(goodsId);
						goodsLock.setCurCount(mfoyouGoodsInfo.getGoodsNumber());
						goodsLock.setSubCount(number);
						goodsLock.setSaleCount(mfoyouGoodsInfo.getGoodsTotalSale());
						lockList.add(goodsLock);
					} else if (mfoyouGoodsInfo.getGoodsNumber() == -1) {
						GoodsLock goodsLock = new GoodsLock();
						goodsLock.setGoodsId(goodsId);
						goodsLock.setSubCount(number);
						goodsLock.setSaleCount(mfoyouGoodsInfo.getGoodsTotalSale());
						lockList.add(goodsLock);
					}
				}
				if (!mfoyouGoodsInfo.getStoreId().equals(orderStore.getStoreId())) {
					return -35;
				}
				orderItem.setGoodsName(mfoyouGoodsInfo.getGoodsTitle());
				orderItem.setGoodsOriginalPrice(mfoyouGoodsInfo.getGoodsCostPrice());
				orderItem.setGoodsDealPrice(mfoyouGoodsInfo.getGoodsDiscountPrice());
				orderItem.setGoodsPic(mfoyouGoodsInfo.getGoodsMainPic());
				if (mfoyouGoodsInfo.getGoodsDiscountPrice() == null) {
					orderItem.setItemTotalAmount(mfoyouGoodsInfo.getGoodsCostPrice() * number);
					totalDiscountAmount += mfoyouGoodsInfo.getGoodsCostPrice() * number;
					totalCostAmount += mfoyouGoodsInfo.getGoodsCostPrice() * number;

				} else {
					orderItem.setItemTotalAmount(mfoyouGoodsInfo.getGoodsDiscountPrice() * number);
					totalDiscountAmount += mfoyouGoodsInfo.getGoodsDiscountPrice() * number;
					totalCostAmount += mfoyouGoodsInfo.getGoodsCostPrice() * number;
				}
				totalpackageFee += mfoyouGoodsInfo.getGoodsPackageFee() * number;
				orderItem.setPackageFee(mfoyouGoodsInfo.getGoodsPackageFee() * number);
				continue;
			}
			// 传的数据不正常
			return -39;
		}
		if (totalCostAmount < 0) {
			// 这不科学
			return -39;
		}
		Integer activeId = null;
		int amount = 0;
		String content = null;
		// 判断活动减免
		if (storeActiveInfo.getNewUserActiveState() != null
				&& storeActiveInfo.getNewUserActiveState().intValue() == 1) {
			// 判断是否为新用户
			int count = storeActiveService.getUserStoreActiveCount(orderStore.getUserId(), orderStore.getStoreId());
			if (count == 0) {
				activeId = 101;
				amount = Math.min(storeActiveInfo.getNewUserReductionAmount(), totalDiscountAmount);
				content = storeActiveInfo.getNewUserActiveContent()+"||"+amount;;
			}
		}
		if (activeId == null && storeActiveInfo.getFullcutActiveState() != null
				&& storeActiveInfo.getFullcutActiveState().intValue() == 1) {
			// 判断是否满足条件
			amount = Math.min(storeActiveInfo.getFullcutAmount(totalDiscountAmount),totalDiscountAmount);
			if (amount > 0) {
				activeId = 201;
				content = storeActiveInfo.getFullcutActiveContent()+"||"+amount;
			}
		}
		Integer freightAmount = 0;
		MfoyouStoreDispatch mfoyouStoreDispatch = iStore.getDispatchInfo(storeInfo.getStoreId());
		int startAmount = StoreDispatchUtil.getStartPrice(orderStore.getOrderUserLat(), orderStore.getOrderUserLon(), mfoyouStoreDispatch, storeInfo.getStoreLocalLat(), storeInfo.getStoreLocalLon());
		// 判断是否免邮
		if (storeInfo.getStoreFreeFreightAmount() == null || totalDiscountAmount.intValue() < storeInfo.getStoreFreeFreightAmount().intValue()) {
//			freightAmount = getDistancePrice(orderStore.getOrderDistance(), 
//					orderStore.getStoreId(),storeInfo,orderStore.getOrderUserLat(),orderStore.getOrderUserLon());
			freightAmount = StoreDispatchUtil.getMinprice(orderStore.getOrderUserLat(), orderStore.getOrderUserLon(), mfoyouStoreDispatch, storeInfo.getStoreLocalLat(), storeInfo.getStoreLocalLon());
		}else{
			logger.info("免邮");
		}
		Integer totalAmount = totalDiscountAmount - amount+  freightAmount +totalpackageFee;
		if(!checkStock){
			List<MfoyouAgentStoreCoupon> canUseCoupon = getCanUseCoupon(orderStore.getUserId(), orderStore.getStoreId(), storeInfo.getStoreType(), totalDiscountAmount, storeInfo.getStoreAgentId());
			if(canUseCoupon!=null && canUseCoupon.size()>0 && orderStore.getTouchId()==null){
				MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon = canUseCoupon.get(0);
				orderStore.setTouchId(mfoyouAgentStoreCoupon.getTouchId());
			}
			orderAmount.setList(canUseCoupon);
		}
		if(orderStore.getTouchId()!=null && orderStore.getTouchId().intValue()!=-1){
			MfoyouAgentUserCoupon mfoyouAgentUserCoupon= iGoodsOrder.getTouchById(orderStore.getTouchId());
			if(mfoyouAgentUserCoupon!=null&&mfoyouAgentUserCoupon.getTouchState()==1){
				MfoyouAgentStoreCoupon couponById = iGoodsOrder.getCouponById(mfoyouAgentUserCoupon.getCouponId());
				if(couponById!=null && checkCanUseCoupon(totalDiscountAmount, storeInfo.getStoreAgentId(), couponById)){
					orderAmount.setTouchId(orderStore.getTouchId());
					content = content == null ? "" : content + "||";
					couponReduceFee = couponById.getReducevalue()>totalAmount-1?totalAmount-1:couponById.getReducevalue();
					content+="优惠券：减免"+StrUtil.fen2yuan(couponById.getReducevalue())+"元||"+couponReduceFee;
				}
			}
		}
		if(totalAmount<=0) totalAmount=1;
		orderAmount.setStoreActiveId(activeId);
		orderAmount.setStoreActiveAmount(amount);
		orderAmount.setStoreActiveContent(content);
		orderAmount.setStoreActiveInfo(storeActiveInfo);
		orderAmount.setCostAmount(totalCostAmount);
		orderAmount.setDiscountAmount(totalDiscountAmount);
		orderAmount.setFreightAmount(freightAmount);
		orderAmount.setAttachAmount(0);
		orderAmount.setOrderTotalAmount(totalAmount);
		orderAmount.setStoreFreeFreightAmount(storeInfo.getStoreFreeFreightAmount());
		orderAmount.setStoreMinGoodsAmount(startAmount);
		orderAmount.setPackageFee(totalpackageFee);
		orderAmount.setCouponReduceFee(couponReduceFee);
		if (checkStock) {
			orderStore.setOrderGoodsCount(totalGoodsCount);
			// 锁定库存
			Boolean bLock = iGoodsOrder.lockGoods(lockList);
			if (!bLock) {
				return -34;
			}
		}
		if(startAmount<0){
			return -3333;
		}
		if(startAmount>totalDiscountAmount){
			return -3334;
		}
		return 0;
	}
	public boolean checkCanUseCoupon(Integer amount,Integer agentId,MfoyouAgentStoreCoupon mfoyouAgentStoreCoupon){
		return mfoyouAgentStoreCoupon.getAgentId().equals(agentId)&&mfoyouAgentStoreCoupon.getLimitmoney()<amount;
	}
	public List<MfoyouAgentStoreCoupon> getCanUseCoupon(Integer userId,Integer storeId,Integer storeType,Integer amount,Integer agentId){
		if(userId==null || amount==null || agentId==null){
			return null;
		}
		List<MfoyouAgentStoreCoupon> agentCouponListByUser = iGoodsOrder.getUserCanUseCouponList(userId, agentId,amount);
		return agentCouponListByUser.stream().filter(coupon->coupon.getUseType()==2?
				Arrays.asList(coupon.getStoreList().split(",")).contains(storeType+"")
				:coupon.getUseType()==3?Arrays.asList(coupon.getStoreList().split(","))
						.contains(storeId+""):true).collect(Collectors.toList());
	}
	public MfoyouGoodsOrderEx addGoodsOrder(MfoyouGoodsOrderEx goodsOrder) {
		MfoyouGoodsOrderEx order = iGoodsOrder.addGoodsOrder(goodsOrder);
		if (order.getOrderId() != null && order.getOrderActiveId() != null) {
			// 成功了
			MfoyouUserActiveAttend mfoyouUserActiveAttend = new MfoyouUserActiveAttend();
			mfoyouUserActiveAttend.setAttendActiveContent(order.getOrderActiveContent());
			mfoyouUserActiveAttend.setAttendActiveId(order.getOrderActiveId());
			mfoyouUserActiveAttend.setAttendOrderId(order.getOrderId());
			mfoyouUserActiveAttend.setAttendStoreId(order.getStoreId());
			mfoyouUserActiveAttend.setAttendUserId(order.getUserId());
			mfoyouUserActiveAttend.setAttendOrderAmount(order.getOrderActiveAmount());
			storeActiveService.addMfoyouUserActiveAttend(mfoyouUserActiveAttend);
		}
		if(order.getTouchId()!=null){
			iGoodsOrder.modifyCouponState(order.getTouchId(), 0,order.getOrderId(),order.getCouponReduceMoney());
		}
		return order;
	}
	
	public MfoyouGoodsOrderEx getGoodsOrder(Integer orderId) {
		return iGoodsOrder.getGoodsOrder(orderId);
	}

	public MfoyouGoodsOrderWithPackage getGoodsOrderWith(Integer orderId) {
		return iGoodsOrder.getGoodsOrderWith(orderId,true);
	}


	public Boolean payServiceTranspoetAmount(Integer orderId, Integer transportId, Integer amount) {
		MfoyouGoodsOrder orderInfo = iGoodsOrder.getGoodsOrderByOrderid(orderId);
		if (orderInfo == null)
			return false;
		orderInfo.setOrderTranspoetAmount(orderInfo.getOrderTranspoetAmount() + amount);
		if (orderService.calcAmountAllot(orderInfo)) {
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

	public HashMap<String, Object> settlementQuery(Integer agentId, Integer dayCount, int userType) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("allData", iOrder.settlementQuery(agentId, dayCount, userType));
		hashMap.put("yesterDay", iOrder.getAgentToday(agentId, 1, userType));
		hashMap.put("dayBeforeYes", iOrder.getAgentToday(agentId, 2, userType));
		hashMap.put("today", iOrder.getAgentToday(agentId, 0, userType));
		return hashMap;
	}

	public MfoyouGoodsOrderDetail getOrderPosition(Integer orderid) {
		return iGoodsOrder.getMfoyouOrderPosition(orderid);

	}

//	public HashMap<String, Object> getCurrentCount(Integer storeId) {
//		// TODO Auto-generated method stub
//		HashMap<String, Object> hashMap = new HashMap<>();
//		List<MfoyouOrderStatistics> currentDay = iOrder.getCurrentDay(storeId, 1);
//		List<MfoyouOrderStatistics> newcurrentDay = new ArrayList<>();
//		int n = currentDay.size();
//		// 到顺序
//		for (int i = 0; i < n; i++) {
//			newcurrentDay.add(currentDay.get(n - i - 1));
//		}
//		hashMap.put("current7day", newcurrentDay);
//		hashMap.put("unliquidated", iOrder.getunliquidated(storeId));
//		return hashMap;
//	}

//	public List<MfoyouGoodsOrder> getOrderListBydays(Integer storeId, String dayId) {
//		// TODO Auto-generated method stub
//		return iOrder.getOrderListBydays(storeId, dayId);
//	}
//
	public List<MfoyouOrderStatistics> getAgentStatistics(Integer agentid, Date sdate, Date edate, int userType) {
		return iGoodsOrder.getAgentStatistics(agentid, sdate, edate, userType);
	}

	public ArrayListObject<MfoyouGoodsOrderWithPackage> getGoodsOrderWithPackageList(Integer storeId, Integer pageid,
			Integer pageSize) {
		return iGoodsOrder.getGoodsOrderWithPackageListV1(storeId, pageid, pageSize);
	}

	public void delAllMfoyouGoodsOrderCart(Integer userId, Integer storeId) {
		iGoodsOrder.delAllMfoyouGoodsOrderCart(userId, storeId);
	}
}
