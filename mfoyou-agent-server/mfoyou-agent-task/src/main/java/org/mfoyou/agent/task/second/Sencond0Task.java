package org.mfoyou.agent.task.second;

import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.List;

import org.apache.http.conn.ConnectTimeoutException;
import org.mfoyou.agent.common.OP.OrderComonOp;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.entity.StoreOpenInfo;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.HttpsUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.common.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service
public class Sencond0Task {

	Logger logger = Logger.getLogger(Sencond0Task.class);
	@Autowired
	IIdentity iIdentity;
	@Autowired
	private IOrder iOrder;
	@Autowired
	private IPayment iPayment;
	@Autowired
	IStore    iStore;
	@Autowired
	IGoodsOrder iGoodsOrder;
	@Value("#{settings['sys.debug']?:false}")
	private Boolean isDebug;

	public void finshSystemOrder() {
		HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
		mfoyouServiceOrder.setServiceOrderState(OrderState.emServiceUserFinsh.getValue());
		ArrayListObject<HuawuServiceOrder> listObject = iOrder.getServiceOrderList(mfoyouServiceOrder, null, null, null,
				null, null, null);
		for (HuawuServiceOrder tempServiceOrder : listObject) {
			logger.info("begin process:" + JSON.toJSONString(tempServiceOrder));
			try {
				OrderComonOp.finshOrderV1(tempServiceOrder, iIdentity, iOrder, iPayment);
			} catch (Exception e) {
				logger.error("", e);
			}
			logger.info("finsh process");
		}

	}

	//
	public void finshCustomerOrder() {
		iOrder.mdfServiceOrderByStateTime(OrderState.emServiceRunerFinsh.getValue(),
				OrderState.emServiceUserFinsh.getValue(), null,
				new Date(System.currentTimeMillis() - 24L * 3600 * 1000), -1);
		finshSystemOrder();
	}

	public void finshStoreOrder() {
		iGoodsOrder.mdfStoreServiceByStateTime(GoodsOrderState.emStoreFinsh.getValue(),
				GoodsOrderState.emCustomerFinsh.getValue(), null,
				new Date(System.currentTimeMillis() - 24L * 3600 * 1000), -1);
	}

	public void dealWithTimeOut() {
		// TODO Auto-generated method stub
		List<MfoyouGoodsOrder> orders = iGoodsOrder.getMfoyouGoodsOrder(new Date());// 根据当前时间获取超时的订单
		for (MfoyouGoodsOrder order : orders) {
			MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
			mfoyouGoodsOrder.setOrderId(order.getOrderId());
			mfoyouGoodsOrder.setOrderExceptionState(order.getOrderExceptionState() | 0x01);
			iGoodsOrder.updateOrderByPromaryKey(mfoyouGoodsOrder);
		}
	}
//
	public void systemOrder() {
		iGoodsOrder.fininshOrder();// 结算日期还没确认收货的直接确认收货
		MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
		mfoyouGoodsOrder.setOrderState(GoodsOrderState.emCustomerFinsh.getValue());
		List<MfoyouGoodsOrder> mfoyouGoodsOrderList = iGoodsOrder.getGoodsOrderList(mfoyouGoodsOrder);
		for (MfoyouGoodsOrder goodsOrder : mfoyouGoodsOrderList) {
			logger.info("begin process:" + JSON.toJSONString(goodsOrder));
			try {
				OrderComonOp.finshStoreOrderV1(goodsOrder, iGoodsOrder, iPayment);
			} catch (Exception e) {
				logger.error("", e);
			}
			logger.info("finsh process");
		}
	}

	public void checkStoreOpen() {
		logger.info("开始计算店铺开关状态:" );
		int pageId = 1;
		while (true) {
			List<StoreOpenInfo> list = iStore.getStoreOpenList(pageId, 100);
			for (StoreOpenInfo info : list) {
				if (info.getMfoyouStoreInfo().getStoreCurrentOpenState().intValue() == 2) {
					continue;
				}
				if (info.getList() == null || info.getList().size() == 0) {
					continue;
				}
				int open = calcOpen(info.getList());
				if (open != info.getMfoyouStoreInfo().getStoreCurrentOpenState()) {
					// 需要更新
					logger.info("修改店铺开关状态:" + info.getMfoyouStoreInfo().getStoreId() + ";state=" + open);
					HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
					mfoyouStoreInfo.setStoreId(info.getMfoyouStoreInfo().getStoreId());
					mfoyouStoreInfo.setStoreCurrentOpenState(open);
					iStore.mdfMfoyouStoreInfo(mfoyouStoreInfo);
				}
			}
			pageId++;
			if (list.size() < 100)
				break;
		}
	}
	private int calcOpen(List<MfoyouStoreOpen> list) {
		if (list == null)
			return 0;
		Integer curret = StrUtil.parseInteger(DateUtils.hhmm.format(new Date()));
		for (MfoyouStoreOpen mfoyouStoreOpen : list) {
			if (mfoyouStoreOpen.getOpenStartTime() != null) {
				if (mfoyouStoreOpen.getOpenStartTime().intValue() > curret) {
					continue;
				}
			}
			if (mfoyouStoreOpen.getOpenEndTime() != null) {
				if (mfoyouStoreOpen.getOpenEndTime().intValue() < curret) {
					continue;
				}
			}
			return 1;
		}
		return 0;

	}

	public void completTodays() {
		String baseUrl = isDebug ? "https://api-d.mfoyou.com/" : "https://api.mfoyou.com/";
		List<HuawuServiceOrder> needCompletServiceOrder = iOrder.getNeedCompletServiceOrder();
		for (HuawuServiceOrder mfoyouServiceOrder : needCompletServiceOrder) {
			try {
				logger.info("orderId为" + mfoyouServiceOrder.getServiceOrderId() + "的订单正在自动退单处理");
				String postJson = HttpsUtils.postParameters(baseUrl + "order/service/revoke/order/"
						+ mfoyouServiceOrder.getServiceOrderId() + "?key=" + StringUtils.getSecrteString(), "");
				logger.info("orderId为" + mfoyouServiceOrder.getServiceOrderId() + "结果为" + postJson);
			} catch (ConnectTimeoutException e) {
				e.printStackTrace();
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		logger.info("complet todays order waimai");
		logger.info("start deal state=1 goodsorder ");
		int modifyWaimaiOrder = iGoodsOrder.modifyWaimaiOrder();
		logger.info("modifyWaimaiOrder:  ret is" + modifyWaimaiOrder);
	}
}
