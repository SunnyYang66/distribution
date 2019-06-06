package com.mfoyou.agent.web.service.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.mfoyou.agent.common.OP.OrderComonOp;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.entity.MfoyouCommonUtil;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderEx;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IPayment;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.json.JSONMaker;
import org.mfoyou.agent.utils.map.ReflectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.service.account.StoreAgentService;
import com.mfoyou.agent.web.service.common.GeoService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.AmapService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.utils.common.MfoyouPriceV2;
import com.mfoyou.agent.web.utils.common.PriceData;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class ServiceOrderService {
	@Autowired
	AmapService amapService;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	IStatistics iStatistics;
	@Autowired
	IIdentity iIdentity;
	@Autowired
	IAccount iAccount;
	@Autowired
	IOrder iOrder;
	@Autowired
	SessionService sessionService;
	@Autowired
	GeoService geoService;
	@Autowired
	XGPushSerivce xgPushSerivce;
	@Autowired
	PaymentService paymentService;
	@Autowired
	OrderService orderService;
	@Autowired
	IGoodsOrder iGoodsOrder;
	@Autowired
	StoreAgentService storeAgentService;
	@Autowired
	IPayment iPayment;
	public static final String SERVICE_ORDER_TIME1 = "wx:runner_push_data1";
	public static final String SERVICE_ORDER_TIME2 = "wx:runner_push_data2";
	Logger logger = Logger.getLogger(ServiceOrderService.class);

	public int checkMfoyouOrder(HuawuServiceOrder huawuServiceOrder, int mode) {
		String[] fileds = new String[] { "serviceTagName", "serviceOrderBespeak", "serviceOrderContent",
				"serviceOrderWeight", "serviceOrderDistance" };
		if (!ReflectUtil.checkField(huawuServiceOrder, fileds)) {
			return -96;
		}
		int orderType = huawuServiceOrder.getServiceOrderType();
		Double srcLat = huawuServiceOrder.getServiceOrderPickupAddressLat();
		Double srcLon = huawuServiceOrder.getServiceOrderPickupAddressLon();
		Double desLat = huawuServiceOrder.getServiceOrderDeliveryAddressLat();
		Double desLon = huawuServiceOrder.getServiceOrderDeliveryAddressLon();
		if(orderType!=4){
			List<MfoyouRegionCustom> list = iOrder.getCustomRegionListByAgentId(huawuServiceOrder.getAgentId());
			boolean checkInside = orderService.checkInside(list, srcLat, srcLon, desLat, desLon);
			if(!checkInside){
				return -3333;
			}
		}
		if (orderType == 1 || orderType == 2 || orderType == 3) {
			if (huawuServiceOrder.getServiceOrderDeliveryAddressLat() == null
					|| huawuServiceOrder.getServiceOrderDeliveryAddressLon() == null) {
				return -96;
			}
		}
		if (orderType == 1 || orderType == 2) {
			if (srcLat == null || huawuServiceOrder.getServiceOrderPickupAddressLon() == null) {
				return -96;
			}
		}
		if (huawuServiceOrder.getServiceOrderDeliveryAddressLat() != null
				&& huawuServiceOrder.getServiceOrderDeliveryAddressLon() != null) {
			huawuServiceOrder.setServiceUserLat(huawuServiceOrder.getServiceOrderDeliveryAddressLat());
			huawuServiceOrder.setServiceUserLon(huawuServiceOrder.getServiceOrderDeliveryAddressLon());
		}
		huawuServiceOrder.setServiceOrderId(null);
		huawuServiceOrder.setServiceOrderNumber("" + huawuServiceOrder.getServiceOrderType()
				+ huawuServiceOrder.getServiceOrderSendUser() + System.currentTimeMillis());
		huawuServiceOrder.setServiceOrderPayAmount(0);
		huawuServiceOrder.setServiceOrderState(OrderState.emOpenOrder.getValue());
		if ((huawuServiceOrder.getServiceOrderBespeak() != 1)
				|| huawuServiceOrder.getServiceOrderEffectTime() == null) {
			huawuServiceOrder.setServiceOrderEffectTime(new Date());
		}
		int distance = 0;
		if (srcLat != null && srcLon != null && desLat != null && desLon != null) {
			// distance = amapService.getDistance(srcLat, srcLon, desLat,
			// desLon);
			distance = (int) (1000 * GisUtils.distVincenty(srcLat, srcLon, desLat, desLon));
			if (huawuServiceOrder.getServiceOrderDistance() > distance) {
				distance = huawuServiceOrder.getServiceOrderDistance();
			} else {
				logger.error("distance=" + distance + ";mfoyouServiceOrder.getServiceOrderDistance()="
						+ huawuServiceOrder.getServiceOrderDistance());
				distance = amapService.getDistance(srcLat, srcLon, desLat, desLon);
			}
		} else {
			distance = huawuServiceOrder.getServiceOrderDistance();
		}
		if (huawuServiceOrder.getServiceOrderAttachAmount() == null
				|| huawuServiceOrder.getServiceOrderAttachAmount() < 0) {
			huawuServiceOrder.setServiceOrderAttachAmount(0);
		}
		PriceData priceData = null;
		if (huawuServiceOrder.getServiceOrderSource() != null
				&& huawuServiceOrder.getServiceOrderSource().intValue() == 1) {
			priceData = calOrderPriceStoreV2(huawuServiceOrder.getAgentId(), huawuServiceOrder.getServiceOrderWeight(),
					distance, huawuServiceOrder.getServiceOrderEffectTime());
		} else {
			priceData = calOrderPriceV2(huawuServiceOrder.getAgentId(), orderType,
					huawuServiceOrder.getServiceOrderWeight(), distance, huawuServiceOrder.getServiceTagName(),
					huawuServiceOrder.getServiceOrderEffectTime());
		}
		if (priceData == null) {
			return -1;
		}
		huawuServiceOrder.setServiceOrderStartAmount(priceData.getServiceOrderStartAmount());
		huawuServiceOrder.setServiceOrderAmount(
				priceData.getServiceOrderAmount() + huawuServiceOrder.getServiceOrderAttachAmount());
		huawuServiceOrder.setServiceOrderWeightAmount(priceData.getServiceOrderWeightAmount());
		huawuServiceOrder.setServiceOrderDistanceAmount(priceData.getServiceOrderDistanceAmount());
		return 0;
	}

	public PriceData calOrderPriceStoreV2(Integer agentId, Integer weight, Integer distance, Date time) {
		String key = "pricev2:" + agentId + weight + distance + time;
		String value = redisCacheManger.getValue(key);
		if (!(value == null || value.equals(""))) {
			PriceData priceData = JSON.parseObject(value, PriceData.class);
			return priceData;
		}
		MfoyouPriceV2 mfoyouPrice = storeAgentService.getServicePrice(agentId);
		PriceData priceData = mfoyouPrice.calPriceData(weight, distance, time, 2);
		redisCacheManger.setValue(key, JSON.toJSONString(priceData), 60);
		logger.info(JSON.toJSONString(priceData) + "--->v2");
		return priceData;
	}

	public PriceData calOrderPriceV2(int agentId, int type, Integer weight, Integer distance, String tagName, Date dt) {
		String key = "pricev2:" + agentId + type + weight + distance + tagName;
		logger.info("1111"+key);
		String value = redisCacheManger.getValue(key);
		if (!(value == null || value.equals(""))) {
			PriceData priceData = JSON.parseObject(value, PriceData.class);
			logger.info(value);
			return priceData;
		}
		String priceinfo = iStatistics.getPriceInfo(agentId, type);
		MfoyouPriceV2 mfoyouPriceV2 = getBaseAmount(priceinfo, tagName, dt);
		if (mfoyouPriceV2 == null) {
			return null;
		}
		PriceData priceData = mfoyouPriceV2.calPriceData(weight, distance, dt, type);
		redisCacheManger.setValue(key, JSON.toJSONString(priceData), 10);
		return priceData;
	}
	public PriceData calOrderPriceV2(int agentId, int type, Integer weight, Integer distance, Integer tagId, Date dt) {
		String key = "pricev2:" + agentId + type + weight + distance + tagId;
		String value = redisCacheManger.getValue(key);
		if (!(value == null || value.equals(""))) {
			PriceData priceData = JSON.parseObject(value, PriceData.class);
			return priceData;
		}
		String priceinfo = iStatistics.getPriceInfo(agentId, type);
		MfoyouPriceV2 mfoyouPriceV2 = getBaseAmount(priceinfo, tagId, dt);
		if (mfoyouPriceV2 == null) {
			return null;
		}
		PriceData priceData = mfoyouPriceV2.calPriceData(weight, distance, dt, type);
		redisCacheManger.setValue(key, JSON.toJSONString(priceData), 60);
		return priceData;
	}
	private MfoyouPriceV2 getBaseAmount(String priceinfo, Integer tagId, Date dt) {
		if (priceinfo == null) {
			return null;
		}
		JSONObject parseObject = JSONObject.parseObject(priceinfo);
		JSONArray jsonArrayTime = parseObject.getJSONArray("allowTime");
		if (jsonArrayTime != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dt);
			int time = calendar.get(Calendar.HOUR_OF_DAY) * 100 + calendar.get(Calendar.MINUTE);
			boolean isIntime = false;
			for (int i = 0; i < jsonArrayTime.size(); i++) {
				JSONObject jsonObject = jsonArrayTime.getJSONObject(i);
				if ((jsonObject.getIntValue("startTime") < jsonObject.getIntValue("endTime")
						&& time > jsonObject.getIntValue("startTime") && time < jsonObject.getIntValue("endTime"))
						|| (jsonObject.getIntValue("startTime") > jsonObject.getIntValue("endTime")
								&& time < jsonObject.getIntValue("startTime")
								&& time > jsonObject.getIntValue("endTime"))) {
					isIntime = true;
				}
			}
			if (!isIntime)
				return null;
		}
		JSONArray jsonArray = parseObject.getJSONArray("data");
		for (int i = 0, s = jsonArray.size(); i < s; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if (tagId.equals(jsonObject.getInteger("tagId"))) {
				return jsonObject.getObject("tagPrice", MfoyouPriceV2.class);
			}
		}
		logger.info("没有相关tagid:" + tagId);
		return null;
	}

	private MfoyouPriceV2 getBaseAmount(String priceinfo, String tagName, Date dt) {
		if (priceinfo == null) {
			return null;
		}
		JSONObject parseObject = JSONObject.parseObject(priceinfo);
		JSONArray jsonArrayTime = parseObject.getJSONArray("allowTime");
		if (jsonArrayTime != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dt);
			int time = calendar.get(Calendar.HOUR_OF_DAY) * 100 + calendar.get(Calendar.MINUTE);
			boolean isIntime = false;
			for (int i = 0; i < jsonArrayTime.size(); i++) {
				JSONObject jsonObject = jsonArrayTime.getJSONObject(i);
				if ((jsonObject.getIntValue("startTime") < jsonObject.getIntValue("endTime")
						&& time > jsonObject.getIntValue("startTime") && time < jsonObject.getIntValue("endTime"))
						|| (jsonObject.getIntValue("startTime") > jsonObject.getIntValue("endTime")
								&& time < jsonObject.getIntValue("startTime")
								&& time > jsonObject.getIntValue("endTime"))) {
					isIntime = true;
				}
			}
			if (!isIntime)
				return null;
		}
		JSONArray jsonArray = parseObject.getJSONArray("data");
		for (int i = 0, s = jsonArray.size(); i < s; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			if (tagName.equals(jsonObject.getString("tagName"))) {
				return jsonObject.getObject("tagPrice", MfoyouPriceV2.class);
			}
		}
		logger.info("没有相关tagid:" + tagName);
		return null;
	}

	public HuawuServiceOrder addServiceOrder(HuawuServiceOrder huawuServiceOrder) {
		return iOrder.addServiceOrder(huawuServiceOrder);
	}

	public HuawuServiceOrder getServiceOrderInfo(Integer orderId) {

		return iOrder.getServiceOrderInfo(orderId);
	}

	public Boolean updateServiceOrderState(HuawuServiceOrder oldOrder, HuawuServiceOrder targetOrder,
			Integer opUserId) {
		if (oldOrder.getServiceOrderId() == null) {
			return false;
		}
		Boolean updateState = iOrder.updateServiceOrderState(oldOrder, targetOrder, opUserId);
		HuawuServiceOrder serviceOrderInfo = iOrder.getServiceOrderInfo(oldOrder.getServiceOrderId());
		if (serviceOrderInfo.getServiceOrderSource() == 1) {
			MfoyouGoodsOrder oldGoodsOrder = new MfoyouGoodsOrder();
			oldGoodsOrder.setOrderTransportId(serviceOrderInfo.getServiceOrderId());
			MfoyouGoodsOrder newGoodsOrder = new MfoyouGoodsOrder();
			newGoodsOrder.setOrderTransportState(oldOrder.getServiceOrderState());
			if (targetOrder.getServiceOrderState() == OrderState.emServiceStart.getValue()) {
				newGoodsOrder.setOrderState(GoodsOrderState.emBeginDelivery.getValue());
			} else if (targetOrder.getServiceOrderState() == OrderState.emServiceFinshTake.getValue()) {
				newGoodsOrder.setOrderState(GoodsOrderState.emFinshDelivery.getValue());
			} else if (targetOrder.getServiceOrderState() == OrderState.emServiceRunerFinsh.getValue()) {
				newGoodsOrder.setOrderState(GoodsOrderState.emStoreFinsh.getValue());
				oldOrder.setServiceOrderState(OrderState.emServiceRunerFinsh.getValue());
				targetOrder.setServiceOrderState(OrderState.emServiceUserFinsh.getValue());
				iOrder.updateServiceOrderState(oldOrder, targetOrder, opUserId);
				OrderComonOp.finshOrderV1(serviceOrderInfo, iIdentity, iOrder, iPayment);
			}
			int result = 0;
			if (targetOrder.getServiceOrderState().intValue() != OrderState.emRunerAccept.getValue()) {
				result = iGoodsOrder.updateGoodOrder(oldGoodsOrder, newGoodsOrder);
			} else {
				result = 2;
			}
			if (result == 0) {
				logger.error("订单更新状态失败到，服务订单状态是" + oldOrder.getServiceOrderState());
			}
		}
		return updateState;
	}
	public ArrayListObject<HuawuServiceOrder> getServiceOrderList(HuawuServiceOrder mfoyouServiceOrder, Integer pageId,
			Integer pageSize, Date startDate, Date endDate, List<Integer> state, Integer orderby) {

		return iOrder.getServiceOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, state, orderby);
	}

	public ArrayListObject<JSONObject> attachWorkUserInfo(ArrayListObject<HuawuServiceOrder> listObject,
			String[] keys) {
		ArrayListObject<JSONObject> jsonObjects = new ArrayListObject<JSONObject>();
		List<Integer> workerids = listObject.stream()
				.map((huawuServiceOrder) -> huawuServiceOrder.getServiceOrderReceiveUser())
				.collect(Collectors.toList());
		Map<Integer, HuawuUser> mapUser = null;
		Map<Integer, HuawuWorker> mapworker = null;
		if (workerids.size() == 0) {
			mapworker = new HashMap<>();
			mapUser = new HashMap<>();
		} else {
			List<Integer> arrUser = new ArrayList<>();
			arrUser.addAll(workerids);
			mapworker = getMfoyouWorkerMap(arrUser);
			mapUser = userMapById(arrUser);
		}
		for (HuawuServiceOrder mfoyouEvaluate : listObject) {
			if (mfoyouEvaluate.getServiceOrderReceiveUser() != null)
				jsonObjects.add(JSONMaker.mergeJson(mfoyouEvaluate,
						JSONMaker.mergeJson(mapUser.get(mfoyouEvaluate.getServiceOrderReceiveUser()),
								mapworker.get(mfoyouEvaluate.getServiceOrderReceiveUser())),
						keys));
			else
				jsonObjects.add(JSONMaker.mergeJson(mfoyouEvaluate, new JSONObject(), keys));
		}
		jsonObjects.setCurSize(listObject.getCurSize());
		jsonObjects.setPageId(listObject.getPageId());
		jsonObjects.setPageSize(listObject.getPageSize());
		jsonObjects.setTotalCount(listObject.getTotalCount());
		return jsonObjects;

	}

	private Map<Integer, HuawuWorker> getMfoyouWorkerMap(List<Integer> arrUser) {
		ArrayList<Integer> listState = new ArrayList<>();
		listState.add(OrderState.emRunerAccept.getValue());
		listState.add(OrderState.emServiceFinshPick.getValue());
		listState.add(OrderState.emServiceStart.getValue());
		Map<Integer, Integer> mfoyouServiceOrderCountMap = iOrder.getWorkerOrder(arrUser, listState, null, null);
		List<HuawuWorker> list = iIdentity.getMfoyouWorkerList(arrUser);
		Map<Integer, HuawuWorker> hashmap = new HashMap<>();
		list.stream().map((HuawuWorker huawuWorker) -> {
			Map<String, String> map = redisCacheManger.getMapValue("u:" + huawuWorker.getUserId());
			if (map != null) {
				if (map.get("lon") != null && map.get("lat") != null) {
					huawuWorker.setWorkerLong(Double.parseDouble(map.get("lon")));
					huawuWorker.setWorkerLat(Double.parseDouble(map.get("lat")));
				}
				if (huawuWorker.getWorkerName() == null)
					huawuWorker.setWorkerName(map.get("userName"));
				if (huawuWorker.getWorkerName() == null){
					HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(huawuWorker.getUserId());
					if(idcardInfo!=null){
						huawuWorker.setWorkerName(idcardInfo.getUserTrueName());
					}
				}
				
			}
			huawuWorker.setWorkerOrderCount(mfoyouServiceOrderCountMap.get(huawuWorker.getUserId()));
			return huawuWorker;
		}).forEach((huawuWorker) -> hashmap.put(huawuWorker.getUserId(), huawuWorker));
		return hashmap;
	}

	public Map<Integer, HuawuUser> userMapById(List<Integer> ids) {
		if (ids == null || ids.size() == 0) {
			return new HashMap<>();
		}
		List<HuawuUser> list = iAccount.userListById(ids);
		Map<Integer, HuawuUser> map = new HashMap<>();
		for (HuawuUser mfoyouUser : list) {
			
			map.put(mfoyouUser.getUserId(), mfoyouUser);
		}
		logger.info("get user list " + ids + "\n map = " + map);
		return map;
	}

	public List<HuawuServiceOrder> getServiceOrderListbyId(List<Integer> listId, List<Integer> listState,
			List<Integer> workerIds) {
		return iOrder.getServiceOrderListbyId(listId, listState, workerIds);
	}

	public Integer getOrderCount(HuawuServiceOrder mfoyouServiceOrder, Date startDate, Date endDate,
			List<Integer> states) {
		return iOrder.getOrderCount(mfoyouServiceOrder, startDate, endDate, states);
	}

	public Boolean gainOrder(HttpServletRequest request, Integer runerId, Integer orderId) {
		HuawuWorker mfoyouWorkerInfo = iAccount.getWorkerInfo(runerId);
		HuawuServiceOrder oldOrder = new HuawuServiceOrder();
		oldOrder.setServiceOrderId(orderId);
		oldOrder.setServiceOrderState(OrderState.emPaySucess.getValue());
		oldOrder.setAgentId(mfoyouWorkerInfo.getAgentId());
		HuawuServiceOrder newOrder = new HuawuServiceOrder();
		newOrder.setServiceOrderState(OrderState.emRunerAccept.getValue());
		newOrder.setServiceOrderReceiveUser(runerId);
		// 计算提成金额
		HuawuServiceOrder mfoyouServiceOrder = getServiceOrderInfo(orderId);
		MfoyouStationMaster mfoyouStationMaster = iIdentity.getMfoyouStationInfo(mfoyouWorkerInfo.getStationId());
		MfoyouCommonUtil.calcOrderPercentage(mfoyouServiceOrder, mfoyouWorkerInfo.getWorkerFee(),mfoyouStationMaster);
		newOrder.setServiceAgentAmount(mfoyouServiceOrder.getServiceAgentAmount());
		newOrder.setServiceStationAmount(mfoyouServiceOrder.getServiceStationAmount());
		newOrder.setStationId(mfoyouWorkerInfo.getStationId());
		Boolean bRet = updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
		if (bRet) {
			if (mfoyouServiceOrder.getServiceOrderSource() == 1) { // 商品订单
				MfoyouGoodsOrder oldGoodsOrder = new MfoyouGoodsOrder();
				oldGoodsOrder.setOrderTransportId(orderId);
				MfoyouGoodsOrder newGoodsOrder = new MfoyouGoodsOrder();
				newGoodsOrder.setOrderState(GoodsOrderState.emAccect.getValue());
				newGoodsOrder.setOrderTransportState(OrderState.emRunerAccept.getValue());
				if (mfoyouWorkerInfo != null) {
					newGoodsOrder.setOrderTransportRunerName(mfoyouWorkerInfo.getWorkerName());
					newGoodsOrder.setOrderTransportRunerPhone(mfoyouWorkerInfo.getWorkerPhone());
				}
				int result = iGoodsOrder.updateGoodOrder(oldGoodsOrder, newGoodsOrder);
				if (result == 0) {
					logger.error("订单更新状态失败");
				}
			}
			geoService.removeOrderPos("" + orderId);
			if (sessionService.currentUserId(request).equals(runerId)) {
				xgPushSerivce.pushOrderNoticeUser(null, orderId, 3, 101, "已接单");
				if (mfoyouServiceOrder.getServiceOrderEffectTime() != null) {
					if (mfoyouServiceOrder.getServiceOrderBespeak() == 1)
						redisCacheManger.hset(SERVICE_ORDER_TIME1, orderId + "",
								runerId + ":" + mfoyouServiceOrder.getServiceOrderEffectTime().getTime() + ":" + orderId
										+ ":" + mfoyouWorkerInfo.getAgentId());
					else
						redisCacheManger.hset(SERVICE_ORDER_TIME2, orderId + "", runerId + ":" + new Date().getTime()
								+ ":" + orderId + ":" + mfoyouWorkerInfo.getAgentId());
				}
			} else {
				xgPushSerivce.pushOrderNoticeUser(null, orderId, 3, 101, "订单已被接收");
			}
		}
		return bRet;
	}

	public ArrayListObject<HuawuEvaluate> getEvaluate(HuawuEvaluate mfoyouEvaluate, Integer pageId, Integer pageSize,
			Date startDate, Date endDate, Integer minScore, Integer maxScore) {
		return iOrder.getEvaluate(mfoyouEvaluate, pageId, pageSize, startDate, endDate, minScore, maxScore);
	}

	public Map<Integer, Integer> getEvaluateScoreCount(Integer agentId, Date startDate, Date endDate) {
		return iOrder.getEvaluateScoreCount(agentId, startDate, endDate);
	}

	public Map<Integer, Integer> getRunerEvaluateScoreCount(Integer userId, Date startDate, Date endDate) {
		return iOrder.getRunerEvaluateScoreCount(userId, startDate, endDate);
	}

	public Boolean revokeServiceOrder(Integer orderId, Integer userId, Integer payAmount, Integer orderState,
			Integer targetPayAmount, Integer targetState) {
		return iOrder.revokeServiceOrder(orderId, userId, payAmount, orderState, targetPayAmount, targetState);
	}

	public ArrayListObject<HuawuServiceOrder> getServiceOrderSquareList(HuawuServiceOrder mfoyouServiceOrder,
			Integer pageIndex, Integer pageSize, Date startDate, Date endDate, int usertype, List<Integer> states,
			long posHash) {
		return iOrder.getServiceOrderSquareList(mfoyouServiceOrder, pageIndex, pageSize, startDate, endDate, usertype,
				states, posHash);
	}

	public ArrayListObject<JSONObject> attachWorkerInfo(ArrayListObject<HuawuServiceOrder> listObject, String[] keys) {
		ArrayListObject<JSONObject> jsonObjects = new ArrayListObject<JSONObject>();
		List<Integer> userIds = new ArrayList<>();
		for (HuawuServiceOrder mfoyouEvaluate : listObject) {
			Integer workId = mfoyouEvaluate.getServiceOrderReceiveUser();
			if (workId == null)
				continue;
			userIds.add(mfoyouEvaluate.getServiceOrderReceiveUser());
		}
		Map<Integer, HuawuWorker> map = null;
		if (userIds.size() == 0) {
			map = new HashMap<>();
		} else {
			map = getMfoyouWorkerMap(userIds);
		}
		for (HuawuServiceOrder mfoyouEvaluate : listObject) {
			jsonObjects.add(
					JSONMaker.mergeJson(mfoyouEvaluate, map.get(mfoyouEvaluate.getServiceOrderReceiveUser()), keys));
		}
		jsonObjects.setCurSize(listObject.getCurSize());
		jsonObjects.setPageId(listObject.getPageId());
		jsonObjects.setPageSize(listObject.getPageSize());
		jsonObjects.setTotalCount(listObject.getTotalCount());
		return jsonObjects;

	}

	public Map<String, Object> getAllOrderCount(Integer currentUserId, int type) {
		return iStatistics.getOrderCountAll(currentUserId, 0);
	}

	public ArrayListObject<HuawuServiceOrder> getAbnormalOrderList(HuawuServiceOrder mfoyouServiceOrder, Integer pageId,
			Integer pageSize, Date startDate, Date endDate, String type) {
		return iOrder.getAbnormalOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, type);
	}

	public int addServiceOrder(MfoyouGoodsOrderEx mfoyouGoodsOrder, HuawuStoreInfo storeinfo, int mode) {
		HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
		mfoyouServiceOrder.setServiceOrderSendUser(storeinfo.getStoreId());
		mfoyouServiceOrder.setServiceOrderNumber(mfoyouGoodsOrder.getOrderNumber());
		mfoyouServiceOrder.setServiceOrderSmallType(2);
		mfoyouServiceOrder.setServiceOrderType(2);
		mfoyouServiceOrder.setServiceOrderBespeak(mfoyouGoodsOrder.getOrderUserExpectTime() == null ? 0 : 1);
		mfoyouServiceOrder.setServiceOrderEffectTime(mfoyouGoodsOrder.getOrderUserExpectTime());
		mfoyouServiceOrder.setServiceTagId(-1);
		mfoyouServiceOrder.setServiceOrderDeliveryAddressLat(mfoyouGoodsOrder.getOrderUserLat());
		mfoyouServiceOrder.setServiceOrderDeliveryAddressLon(mfoyouGoodsOrder.getOrderUserLon());
		mfoyouServiceOrder.setServiceUserLat(mfoyouGoodsOrder.getOrderUserLat());
		mfoyouServiceOrder.setServiceUserLon(mfoyouGoodsOrder.getOrderUserLon());
		mfoyouServiceOrder.setServiceOrderPickupAddressLat(storeinfo.getStoreLocalLat());
		mfoyouServiceOrder.setServiceOrderPickupAddressLon(storeinfo.getStoreLocalLon());
		mfoyouServiceOrder.setServiceOrderAmount(mfoyouGoodsOrder.getOrderFreightAmount());
		mfoyouServiceOrder.setServiceOrderAttachAmount(0);
		mfoyouServiceOrder.setServiceOrderContent(mfoyouGoodsOrder.getOrderNote());
		mfoyouServiceOrder.setServiceOrderDeliveryAddress(mfoyouGoodsOrder.getOrderUserAddress());
		mfoyouServiceOrder.setServiceOrderDeliveryContactName(mfoyouGoodsOrder.getOrderUserName());
		mfoyouServiceOrder.setServiceOrderDeliveryContactNumber(mfoyouGoodsOrder.getOrderUserPhone());
		mfoyouServiceOrder.setServiceOrderDistance(mfoyouGoodsOrder.getOrderDistance());
		mfoyouServiceOrder.setServiceOrderPickupAddress(storeinfo.getStoreAddress());
		mfoyouServiceOrder.setServiceOrderPickupContactName(storeinfo.getStoreName());
		mfoyouServiceOrder.setServiceOrderPickupContactNumber(storeinfo.getStorePhone());
		mfoyouServiceOrder.setServiceOrderContent(makeContent(mfoyouGoodsOrder));
		mfoyouServiceOrder.setServiceOrderSourceId(mfoyouGoodsOrder.getOrderId());
		mfoyouServiceOrder.setServiceTagName("商城货物订单");
		mfoyouServiceOrder.setServiceOrderWeight(mfoyouGoodsOrder.getOrderWeight());
		mfoyouServiceOrder.setServiceOrderTitle("华悟云商商品送货");
		mfoyouServiceOrder.setAgentId(mfoyouGoodsOrder.getAreaAgentId());
		mfoyouServiceOrder.setServiceOrderSource(1);
		mfoyouServiceOrder.setServiceOrderBespeak(mfoyouGoodsOrder.getOrderBespeak());
		mfoyouServiceOrder.setServiceOrderEffectTime(mfoyouGoodsOrder.getExpectTime());
		mfoyouServiceOrder.setServiceOrderRemark(mfoyouGoodsOrder.getOrderMark());
		int ret = checkMfoyouOrder(mfoyouServiceOrder, mode);
		logger.info("计算结果：" + ret);
		mfoyouServiceOrder.setServiceOrderState(OrderState.emOpenOrder.getValue());
		if (ret != 0) {
			return ret;
		}
		int result = iOrder.addServiceOrderV1(mfoyouServiceOrder);
		logger.info("订单号" + result);
		if (result != 0) {
			// 自动付款
			if (!autoPayServiceOrder(mfoyouGoodsOrder, result)) {
				return -1002;
			}
			return result;
		}
		return -1002;
	}

	private Boolean autoPayServiceOrder(MfoyouGoodsOrderEx mfoyouGoodsOrder, Integer serviceId) {

		OrderInfo orderInfo = orderService.getOrderInfo(serviceId, OrderType.serviceOrder.getValue());
		if (orderInfo == null) {
			logger.info("orderInfo is null");
			return false;
		}
		if (!orderInfo.getOrderUserId().equals(mfoyouGoodsOrder.getStoreId())) {
			logger.error("user is error");
			return false;
		}
		if (orderInfo.getOrderState() >= OrderState.emPaySucess.getValue()) {
			return true;
		}
		int goodsOrderPayedAmount = mfoyouGoodsOrder.getOrderPayAmount(); // 实付
		int servicePayAmount = orderInfo.getOrderAmount() - orderInfo.getOrderPaidAmount();
		if (goodsOrderPayedAmount < servicePayAmount) {
			logger.error("运费钱不足");
			return false;
		}
		if (!orderService.payServiceTranspoetAmount(mfoyouGoodsOrder.getOrderId(), serviceId, servicePayAmount)) {
			return false;
		}
		orderService.payOrder(orderInfo.getOrderId(), OrderType.serviceOrder.getValue(), servicePayAmount,
				PayType.goodsOrder.getValue());

		paymentService.addStream(mfoyouGoodsOrder.getStoreId(), servicePayAmount, -1, serviceId,
				OrderType.serviceOrder.getValue(), PayType.goodsOrder.getValue(), PayType.serviceOrder.getValue(),
				"服务订单", MfoyouUserType.store.getValue());
		return true;
	}

	public String makeContent(MfoyouGoodsOrderEx mfoyouGoodsOrderEx) {
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("ordernumber", mfoyouGoodsOrderEx.getOrderNumber());
		hashMap.put("detail", mfoyouGoodsOrderEx.getList());
		return JSON.toJSONString(hashMap);
	}

}
