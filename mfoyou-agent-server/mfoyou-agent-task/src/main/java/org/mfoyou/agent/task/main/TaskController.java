package org.mfoyou.agent.task.main;

import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;
import org.mfoyou.agent.common.dao.domain.HuawuAgentWxInfo;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuThirdUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouUserStatistics;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.ICommon;
import org.mfoyou.agent.common.inf.IGoodsOrder;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.task.common.ThreadFactoryImpl;
import org.mfoyou.agent.task.day.Day0Task;
import org.mfoyou.agent.task.second.Sencond0Task;
import org.mfoyou.agent.task.service.RedisCacheManger;
import org.mfoyou.agent.task.service.WxService;
import org.mfoyou.agent.task.utils.MfoyouYinian;
import org.mfoyou.agent.task.utils.WxPushUtil;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.mfoyou.agent.utils.map.ObjectToMappr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tencent.xinge.ClickAction;
import com.tencent.xinge.Message;
import com.tencent.xinge.PushData;
import com.tencent.xinge.Style;
import com.tencent.xinge.XingeApp;

@Service
public class TaskController {
	static Logger logger = Logger.getLogger(Logger.class);
	@Autowired
	private RedisCacheManger redisCacheManger;

	private final ScheduledExecutorService scheduledExecutorService = Executors
			.newSingleThreadScheduledExecutor(new ThreadFactoryImpl("NSScheduledThread"));
	@Autowired
	Day0Task day0Task;
	@Autowired
	Sencond0Task sencond0Task;
	@Autowired
	IOrder iOrder;
	@Autowired
	WxService wxService;
	@Autowired
	IStatistics iStatistics;
	@Autowired
	IAccount iAccount;
	@Autowired
	IStore iStore;
	@Autowired
	IGoodsOrder iGoodsOrder;
	@Autowired
	ICommon iCommon;
	// 推送给接单员有新的订单
	private static String NEWORDERPUSH = "xp:Line1";
	// 推送给代理商，检查3分钟后是否有人接单，没接单就指派
	private static String NEWORDERCHECK = "xp:Line2";
	// 所有用户都能看见时间
	private static String ORDERALLSEECHECK = "xp:Line3";
	// 10分钟检查一下订单是否被接 如果没有就通知一下
	private static String ORDERCHECKORDER = "xp:Line4";
	// 催单
	private static String REMINDERRUNNER = "xp:Line5";
	// 通知代理商 2分钟
	private static String NEWORDERAGENTCHECK = "xp:Line6";

	public static final String SERVICE_ORDER_REVOKE = "xp:Line9";

	// 易年云打印
	public static final String YINIANYUN = "yinianyun:1";
	// 打印 token
	public static final String TOKEN = "printer:token";

	public static final String PRINTER_PRE = "printer:machine:";

	public static final String WX_PUSH = "wx:100:push";

	public static final String WX_STATE = "wx:extract:push";

	private static final String STORE_CLOSE = "store:closelist";

	private static final String SERVICE_ORDER_TIME1 = "wx:runner_push_data1";

	private static final String SERVICE_ORDER_TIME2 = "wx:runner_push_data2";
	
	public static final String XING_ORDER_PUSH = "xing:success:order:push";
	
	public void init() {
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					logger.info("begin to finshCustomerOrder");
					sencond0Task.finshCustomerOrder();
					logger.info("end to finshCustomerOrder");
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 0, 10, TimeUnit.MINUTES);

		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine1();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 1000, 1000, TimeUnit.MILLISECONDS);
		//接单后推送
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine10();
				} catch (Exception e) {
					logger.error("", e);
				}

			}
		}, 10000, 10000, TimeUnit.MILLISECONDS);
		//推送给服务商
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine6();
				} catch (Exception e) {
					logger.error("", e);
				}

			}
		}, 5000, 5000, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine2();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 10, 10, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine3();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 20, 20, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// logger.info("begin to runxpLine3");
				try {
					runxpLine4();
				} catch (Exception e) {
					logger.error("", e);
				}
				// logger.info("end to runxpLine3");
			}
		}, 60, 60, TimeUnit.SECONDS);
		// 推送催单给用户
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine5();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 60, 60, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					runxpLine9();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 10, 10, TimeUnit.SECONDS);
		// 计算开店关店
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// logger.info("begin to runxpLine3");
				try {
					sencond0Task.checkStoreOpen();
				} catch (Exception e) {
					logger.error("", e);
				}
				// logger.info("end to runxpLine3");
			}
		}, 59, 59, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 定时处理超时
				logger.info("begin to dealWithTimeout order");
				sencond0Task.dealWithTimeOut();
				logger.info("end to dealWithTimeout order");
			}
		}, 60, 60, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 定时处理售后
				logger.info("begin to finshStoreOrder");
				sencond0Task.finshStoreOrder();
				logger.info("end to finshStoreOrder");
			}
		}, 5, 5, TimeUnit.MINUTES);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 系统确认完成订单
				logger.info("begin for system  to deal with StoreOrder");
				sencond0Task.systemOrder();
				logger.info("end for  system to deal with StoreOrder");
				countUser();
				logger.info("end for system to count the user");
			}
		}, getHoursFromnextDay(1), 24 * 60, TimeUnit.MINUTES);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 定时关店 closeStore in a time.
				logger.info("begin to CLOSE_STORE");
				closeStore();
				logger.info("end to CLOSE_STORE");
			}
		}, 60, 60, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 统计 定时
				logger.info("begin to COUNT");
				iStatistics.dailyCount();
				logger.info("end to COUNT");
			}
		}, getHoursFromnextDay(2), 24 * 60, TimeUnit.MINUTES);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 统计 定时
				logger.info("begin to completToday Service order ");
				sencond0Task.completTodays();
				logger.info("end to completToday Service order");
			}
		}, getHoursFromnextDay(1), 24 * 60, TimeUnit.MINUTES);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// logger.info("begin to runxpLine3");
				try {
					xingOrderPush();
				} catch (Exception e) {
					logger.error("", e);
				}
				// logger.info("end to runxpLine3");
			}
		}, 3, 3, TimeUnit.SECONDS);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				// 统计 定时
				logger.info("realse store every day start ");
				logger.info("realsed " + iStatistics.realseStore() + " stores");
				logger.info("realse store every day end ");
			}
		}, getHoursFromnextDay(2), 24 * 60, TimeUnit.MINUTES);
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					yinianyunprint();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}, 20, 5, TimeUnit.SECONDS);
	}
	public void countUser() {
		Set<String> keys = redisCacheManger.getKeys("store:visitor:*");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String currentNumber = simpleDateFormat.format(new Date());
		for(String key:keys){
			if(key.split(":")[3].equals(currentNumber)){
				continue;
			}
			String visitCountValue = redisCacheManger.getValue(key);
			logger.info(key+"----->"+visitCountValue);
			String userCountVaule = redisCacheManger.getValue(key.replace("visitor", "user"));
			logger.info(key+"----->||||||"+userCountVaule);
			MfoyouUserStatistics mfoyouUserStatistics = new MfoyouUserStatistics();
			mfoyouUserStatistics.setStoreId(Integer.parseInt(key.split(":")[2]));
			mfoyouUserStatistics.setDayId(Integer.parseInt(key.split(":")[3]));
			mfoyouUserStatistics.setUserCount(userCountVaule==null?0:Integer.parseInt(userCountVaule));
			mfoyouUserStatistics.setVisitCount(visitCountValue==null?0:Integer.parseInt(userCountVaule));
			iCommon.insertUserStatistics(mfoyouUserStatistics);
			redisCacheManger.deleteKey(key.replace("visitor", "user"));
			redisCacheManger.deleteKey(key);
		}
	}
	protected void xingOrderPush() {
		while (true) {
			String value = redisCacheManger.popLList(XING_ORDER_PUSH);
			if (value != null) {
				logger.info(XING_ORDER_PUSH + ":" + value);
				Message message = new Message();
				Style style = new Style(0);
				String[] split = value.split(",");
				String userId = null;
				Map<String, Object> custom = new HashMap<>(2);
				message.setTitle("新订单通知-外卖");
				MfoyouGoodsOrderWithPackage goodsOrderWith = iGoodsOrder.getGoodsOrderWith(Integer.parseInt(split[1]), false);
				List<MfoyouGoodsOrderItme> itmes = goodsOrderWith.getGoodsOrderItmes();
				String content = "";
				custom.put("messagetype", 0);
				if (itmes != null && itmes.size() > 0) {
					content += itmes.get(0).getGoodsName() + "(" + itmes.get(0).getItemNumber() + ");";
				}
				content += "点击查看更多。";
				message.setContent(content);
				custom.put("detail", JSON.toJSONString(goodsOrderWith));
				userId = goodsOrderWith.getStoreId() + "";
				style.setIconRes("R.mipmap.ic_launcher.png");
				message.setStyle(style);
				message.setExpireTime(60 * 5);
				message.setType(Message.TYPE_NOTIFICATION);
				message.setCustom(custom);
				logger.info("message:" + message.toJson());
				XingeApp xingeApp = getXingeApp(4,1);
				xingeAppDeepLink(2, message);
				if (userId.length() < 2) {
					userId = "0" + userId;
				}
				JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
				logger.info(object.toString());
			} else {
				break;
			}
		}
	}

	protected void runxpLine10() {
		Map<String, String> mapValue = redisCacheManger.getMapValue(SERVICE_ORDER_TIME1);
		Iterator<Entry<String, String>> iterator = mapValue.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			String[] split = next.getValue().split(":");
			long parseLong = Long.parseLong(split[1]);
			if (parseLong - System.currentTimeMillis() < 27 * 60 * 1000) {
				HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
				mfoyouServiceOrder.setServiceOrderState(0);
				mfoyouServiceOrder.setServiceOrderId(Integer.parseInt(split[2]));
				mfoyouServiceOrder.setAgentId(Integer.parseInt(split[3]));
				String modelId = wxService.getModelId(Integer.parseInt(split[3]), 2);
				HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(Integer.parseInt(split[3]), 100);
				pushTorunner(Integer.parseInt(split[0]), mfoyouServiceOrder, "2",modelId,agentWxInfo.getXcxId());
				redisCacheManger.hremove(SERVICE_ORDER_TIME1, next.getKey());
			}
		}
		Map<String, String> mapValue2 = redisCacheManger.getMapValue(SERVICE_ORDER_TIME2);
		Iterator<Entry<String, String>> iterator2 = mapValue2.entrySet().iterator();
		while (iterator2.hasNext()) {
			Entry<String, String> next = iterator2.next();
			String[] split = next.getValue().split(":");
			long parseLong = Long.parseLong(split[1]);
			if (System.currentTimeMillis() - parseLong > 27 * 60 * 1000) {
				HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
				mfoyouServiceOrder.setServiceOrderState(1);
				mfoyouServiceOrder.setServiceOrderId(Integer.parseInt(split[2]));
				mfoyouServiceOrder.setAgentId(Integer.parseInt(split[3]));
				String modelId = wxService.getModelId(Integer.parseInt(split[3]), 2);
				HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(Integer.parseInt(split[3]), 100);
				pushTorunner(Integer.parseInt(split[0]), mfoyouServiceOrder, "2",modelId,agentWxInfo.getXcxId());
				redisCacheManger.hremove(SERVICE_ORDER_TIME2, next.getKey());
			}
		}
	}

	
	protected void yinianyunprint() {
		String token = redisCacheManger.getValue(TOKEN);
		while (true) {
			String value = redisCacheManger.popLList(YINIANYUN);
			if (value != null) {
				logger.info(YINIANYUN + ":" + value);
				Integer orderId = Integer.parseInt(value);
				MfoyouGoodsOrderWithPackage goodsOrderWith = iGoodsOrder.getGoodsOrderWith(orderId,true);
				if (goodsOrderWith == null) {
					continue;
				}
				String printNumber = goodsOrderWith.getStoreInfo().getStorePrinterNumber();
				if (printNumber == null) {
					logger.error("打印机未设置成功");
					continue;
				}
				String hget = redisCacheManger.hget(PRINTER_PRE + printNumber, "isCloseVoice");
				if (hget == null) {
					hget = "0";
				}
				int model = Integer.parseInt(hget);
				logger.info(MfoyouYinian.print(goodsOrderWith, token, model));
			} else {
				break;
			}
		}
	}

	// the hour to 2 am in nextday;
	int getHoursFromnextDay(Integer n) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, n);
		calendar.set(Calendar.MINUTE, 0);
		long millis = calendar.getTimeInMillis() - System.currentTimeMillis();
		int min = (int) millis / 1000 / 60;
		return min;
	}

	// close store at a time in the future
	protected void closeStore() {
		List<String> list = new ArrayList<>();
		while (true) {
			String value = redisCacheManger.popLList(STORE_CLOSE);
			if (value != null) {
				logger.info(STORE_CLOSE + ":" + value);
				MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(value);
				Long timeStamp = mfoyouMap.getLong("timeStamp");
				if (timeStamp <= System.currentTimeMillis()) {// its a time for
																// close store
					Integer storeId = mfoyouMap.getInteger("storeId");
					HuawuStoreInfo info = new HuawuStoreInfo();
					info.setStoreCurrentOpenState(2);
					iStore.updateStoreInfoById(storeId, info);
					logger.info(storeId + "关闭");
				} else {
					list.add(value);
					// redisCacheManger.pushRList(STORE_CLOSE, value);
				}
			} else {
				break;
			}
		}
		for (String value : list) {
			redisCacheManger.pushRList(STORE_CLOSE, value);
		}
	}

	protected void runxpLine5() {
		// 被催单
		while (true) {
			String value = redisCacheManger.popLList(REMINDERRUNNER);
			if (value != null) {
				logger.info(REMINDERRUNNER + ":" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushLList(ORDERALLSEECHECK, value);
					break;
				}
				HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(pushData.getOrderId());
				if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
					continue;
				XingeApp xingeApp = getXingeApp(mfoyouServiceOrder.getAgentId(),0);
				String userId = "" + mfoyouServiceOrder.getServiceOrderReceiveUser();
				if (userId.length() < 2) {
					userId = "0" + userId;
				}
				if(xingeApp!=null){
					Message message = new Message();
					message.setTitle("你被催单:" + mfoyouServiceOrder.getServiceOrderTitle());
					if ((mfoyouServiceOrder.getServiceOrderSource() != null)
							&& (1 == mfoyouServiceOrder.getServiceOrderSource())) {
						message.setContent(makeGoodsOrderContent(mfoyouServiceOrder.getServiceOrderContent()));
					} else {
						message.setContent(StrUtil.replaceDigital(mfoyouServiceOrder.getServiceOrderContent(), "*"));
					}
					message.setExpireTime(60 * 5);
					message.setType(Message.TYPE_NOTIFICATION);
					Map<String, Object> custom = ObjectToMappr.ObjectToMapM(mfoyouServiceOrder);
					custom.put("messagetype", 1);
					message.setCustom(custom);
					logger.info("message:" + message.toJson());
					xingeAppDeepLink(1, message);
					JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
					logger.info(object.toString());
				}
			} else {
				break;
			}
		}
	}

	private void xingeAppDeepLink(Integer type, Message message) {
		ClickAction action = new ClickAction();
		action.setActionType(ClickAction.TYPE_ACTIVITY);
		String activity = null;
		if(type.intValue()==1){
			activity = "com.mfoyouclerk.androidnew.ui.activity.HomeActivity";
		}else{
			activity = "com.starshop.androidnew.ui.activity.HomeActivity";
		}
		action.setActivity(activity);
		message.setAction(action);
		message.setType(Message.TYPE_NOTIFICATION);
	}

	private XingeApp getXingeApp(Integer agentId,Integer type) {
		XingeApp xingeApp = wxService.getXingApp(agentId,type);
		return xingeApp;
	}

	// 所有用户都能够看见了
	public void runxpLine3() {
		while (true) {
			String value = redisCacheManger.popLList(ORDERALLSEECHECK);
			if (value != null) {
				logger.info(ORDERALLSEECHECK + ":" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushLList(ORDERALLSEECHECK, value);
					break;
				}
				HuawuServiceOrder oldmfoyouServiceOrder = new HuawuServiceOrder();
				oldmfoyouServiceOrder.setServiceOrderId(pushData.getOrderId());
				oldmfoyouServiceOrder.setServiceOrderState(OrderState.emPaySucess.getValue());
				HuawuServiceOrder newmfoyouServiceOrder = new HuawuServiceOrder();
				newmfoyouServiceOrder.setServiceOrderState(OrderState.emSeekRuner.getValue());
				iOrder.updateServiceOrderState(oldmfoyouServiceOrder, newmfoyouServiceOrder, -1);
			} else {
				break;
			}
		}
	}

	public void runxpLine4() {
		while (true) {
			String value = redisCacheManger.popLList(ORDERCHECKORDER);
			if (value != null) {
				logger.info(ORDERCHECKORDER + ":" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushLList(ORDERCHECKORDER, value);
					break;
				}
				HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(pushData.getOrderId());
				if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
					continue;
				XingeApp xingeApp = getXingeApp(mfoyouServiceOrder.getAgentId(),0);
				String userId = "" + mfoyouServiceOrder.getServiceOrderSendUser();
				if (userId.length() < 2) {
					userId = "0" + userId;
				}
				if(xingeApp!=null){
					Message message = new Message();
					message.setTitle("暂时无人接收的订单:" + mfoyouServiceOrder.getServiceOrderTitle());
					if ((mfoyouServiceOrder.getServiceOrderSource() != null)
							&& (1 == mfoyouServiceOrder.getServiceOrderSource())) {
						message.setContent(makeGoodsOrderContent(mfoyouServiceOrder.getServiceOrderContent()));
					} else {
						message.setContent(StrUtil.replaceDigital(mfoyouServiceOrder.getServiceOrderContent(), "*"));
					}
					message.setExpireTime(60 * 5);
					message.setType(Message.TYPE_NOTIFICATION);
					Map<String, Object> custom = ObjectToMappr.ObjectToMapM(mfoyouServiceOrder);
					custom.put("messagetype", 1);
					message.setCustom(custom);
					logger.info("message:" + message.toJson());
					xingeAppDeepLink(1, message);
					JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
					logger.info(object.toString());
				}
			} else {
				break;
			}

		}

	}

	public void pushTorunner(Integer userId, HuawuServiceOrder serviceOrder, String type,String modelId,String appid) {
		logger.info("start push to " + userId);
		String token = wxService.getTokenV1(serviceOrder.getAgentId(),200);
		if (token == null || token.equals("")) {
			return;
		}
		HuawuThirdUser thirdUser = iAccount.getThirdByUserId(userId, 200);
		if (thirdUser == null) {
			logger.info("userid is " + userId + "has no thireUserPart");
			return;
		}
		if(modelId==null){
			logger.info("model is null ");
			return;
		}
		try {
			String pushtoRunner = WxPushUtil.pushtoRunner(type, token, serviceOrder,
					thirdUser.getOpenId(),modelId,appid);
			logger.info("wxpushresult" + pushtoRunner);
		} catch (ConnectTimeoutException e) {
			e.printStackTrace();
		} catch (SocketTimeoutException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void runxpLine6() {
		while (true) {
			String value = redisCacheManger.popLList(NEWORDERAGENTCHECK);
			if (value != null) {
				logger.info(NEWORDERAGENTCHECK + ":" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushLList(NEWORDERAGENTCHECK, value);
					break;
				}
				HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(pushData.getOrderId());
				if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
					continue;
				XingeApp xingeApp = getXingeApp(mfoyouServiceOrder.getAgentId(),0);
				if(xingeApp==null) continue;
				Message message = new Message();
				message.setExpireTime(60 * 5);
				message.setType(Message.TYPE_NOTIFICATION);
				Map<String, Object> custom = ObjectToMappr.ObjectToMapM(mfoyouServiceOrder);
				custom.put("messagetype", 1);
				message.setCustom(custom);
				logger.info("message:" + message.toJson());
				xingeAppDeepLink(1, message);
				List<String> userIds = pushData.getUserIds();
				if (userIds.size() > 0) {
					message.setTitle("超时订单提醒");
					message.setContent("您有一个订单已超过两分钟无人接单，请及时进行订单分发，点击查看详情");
					JSONObject object = xingeApp.pushSingleAccount(0, userIds.get(0), message);
					logger.info(object.toString());
				}
			} else {
				break;
			}
		}
	}

	public void runxpLine2() {
		while (true) {
			String value = redisCacheManger.popLList(NEWORDERCHECK);
			if (value != null) {
				logger.info(NEWORDERCHECK + ":" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushLList(NEWORDERCHECK, value);
					break;
				}
				HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(pushData.getOrderId());
				if (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
					continue;
				XingeApp xingeApp = getXingeApp(mfoyouServiceOrder.getAgentId(),0);
				Message message = new Message();
				message.setExpireTime(60 * 5);
				message.setType(Message.TYPE_NOTIFICATION);
				Map<String, Object> custom = ObjectToMappr.ObjectToMapM(mfoyouServiceOrder);
				custom.put("messagetype", 1);
				message.setCustom(custom);
				logger.info("message:" + message.toJson());
				xingeAppDeepLink(1, message);
				List<String> userIds = pushData.getUserIds();
				if (userIds.size() > 0) {
					Integer agentId = StrUtil.parseInteger(userIds.get(0));
					userIds.remove(0);
					if (agentId != 0 && userIds.size() > 0) {
						// 对接单员进行筛选
						List<Integer> users = new ArrayList<>();
						for (String user : userIds) {
							users.add(StrUtil.parseInteger(user));
						}
						List<HuawuWorker> works = iAccount.getAgentMfoyouWorkerList(users, agentId);
						userIds.clear();
						for (HuawuWorker mfoyouWorker : works) {
							Integer userId = mfoyouWorker.getUserId();
							if (userId < 10) {
								userIds.add("0" + userId);
							} else {
								userIds.add("" + userId);
							}
						}
					}
					message.setTitle("新订单提醒" + mfoyouServiceOrder.getServiceOrderTitle());
					if ((mfoyouServiceOrder.getServiceOrderSource() != null)
							&& (1 == mfoyouServiceOrder.getServiceOrderSource())) {
						message.setContent(makeGoodsOrderContent(mfoyouServiceOrder.getServiceOrderContent()));
					} else {
						message.setContent(StrUtil.replaceDigital(mfoyouServiceOrder.getServiceOrderContent(), "*"));
					}
					xingeApp = getXingeApp(agentId,1);
					String modelId = wxService.getModelId(mfoyouServiceOrder.getAgentId(), 1);
					HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(mfoyouServiceOrder.getAgentId(), 101);
					xingeAppDeepLink(1, message);
					for (String userId : userIds) {
						if(agentWxInfo!=null)
							pushTorunner(Integer.parseInt(userId), mfoyouServiceOrder, "1",modelId,agentWxInfo.getXcxId());// 微信推送
							if(xingeApp!=null){
								logger.info("begin"+message.toJson());
								JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
								logger.info(object.toString());
							}
					}
				}
			} else {
				break;
			}
		}
	}

	// 推送给接单员有新的订单
	public void runxpLine1() {
		while (true) {
			// 推送 推送新订单给接单员
			String value = redisCacheManger.popLList(NEWORDERPUSH);
			if (value != null) {
				logger.info("xp:Line1 push:" + value);
				// 新的订单
				PushData pushData = JSON.parseObject(value, PushData.class);
				if (pushData.getEffectTime() != null && pushData.getEffectTime() > System.currentTimeMillis()) {
					redisCacheManger.pushRList(NEWORDERPUSH, value);
					break;
				}
				HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(pushData.getOrderId());
				Message message = new Message();
				String prefix = pushData.getTitlePrefix() == null ? "" : pushData.getTitlePrefix() + ":";
				message.setTitle(prefix + mfoyouServiceOrder.getServiceOrderTitle());
				if ((mfoyouServiceOrder.getServiceOrderSource() != null)
						&& (1 == mfoyouServiceOrder.getServiceOrderSource())) {
					message.setContent(makeGoodsOrderContent(mfoyouServiceOrder.getServiceOrderContent()));
				} else {
					message.setContent(StrUtil.replaceDigital(mfoyouServiceOrder.getServiceOrderContent(), "*"));
				}
				message.setExpireTime(60 * 5);
				message.setType(Message.TYPE_NOTIFICATION);
				Map<String, Object> custom = ObjectToMappr.ObjectToMapM(mfoyouServiceOrder);
				custom.put("messagetype", pushData.getType());
				message.setCustom(custom);
				XingeApp xingeApp = getXingeApp(mfoyouServiceOrder.getAgentId(),0);
				xingeAppDeepLink(1, message);
				logger.info("message:" + message.toJson());
				List<String> userIds = pushData.getUserIds();
				if (userIds.size() == 0) {
					// 重新计算要推送给谁
					Integer userId = null;
					if (pushData.getUserType() == null)
						continue;
					if (pushData.getUserType() == 3) {
						userId = mfoyouServiceOrder.getServiceOrderSendUser();
						if (pushData.getType() == 101) {
							message.setTitle("已接单");
							message.setContent("您的订单mfoyou达人已接单，可以在我的服务订单查看详情哟");
						} else if (pushData.getType() == 102) {
							message.setTitle("开始服务");
							message.setContent("您的订单mfoyou达人已开始服务，请保持电话通畅，以便及时与你取得联系签收订单");
						} else if (pushData.getType() == 103) {
							message.setTitle("完成服务");
							message.setContent("您的订单已完成，请及时作出评价，以便我们为您提供更好的服务");
						}
					} else if (pushData.getUserType() == 2) {
						userId = mfoyouServiceOrder.getAgentId();
					} else if (pushData.getUserType() == 1) {
						userId = mfoyouServiceOrder.getServiceOrderReceiveUser();
					} else {
						continue;
					}
					if (userId == null)
						continue;
					if (userId < 10) {
						userIds.add("0" + userId);
					} else {
						userIds.add("" + userId);
					}
				}
				String modelId = wxService.getModelId(mfoyouServiceOrder.getAgentId(), 1);
				HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(mfoyouServiceOrder.getAgentId(),101);
				if(modelId==null || agentWxInfo==null ){
					modelId = wxService.getModelId(-2, 1);
					agentWxInfo = iAccount.getAgentWxInfo(-2, 101);
					mfoyouServiceOrder.setAgentId(-2);
				}
				if (userIds.size() >= 10) {
					if(xingeApp!=null){
						JSONObject object = xingeApp.pushAccountList(0, pushData.getUserIds(), message);
						logger.info(object.toString());
					}
					for(String userId:userIds){
						pushTorunner(Integer.parseInt(userId), mfoyouServiceOrder, "1",modelId,agentWxInfo.getXcxId());// 微信推送
					}
				} else {
					for (String userId : userIds) {
						if(agentWxInfo!=null)
						pushTorunner(Integer.parseInt(userId), mfoyouServiceOrder, "1",modelId,agentWxInfo.getXcxId());// 微信推送
						if(xingeApp!=null){
							logger.info("begin"+message.toJson());
							JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
							logger.info(object.toString());
						}
					}
				}
			} else {
				break;
			}
		}
	}
	protected void runxpLine9() {
		while (true) {
			String value = redisCacheManger.popLList(SERVICE_ORDER_REVOKE);
			if (value != null) {
				logger.info(SERVICE_ORDER_REVOKE + ":" + value);
				// 新的订单
				HuawuServiceOrder serviceOrderInfo = iOrder.getServiceOrderInfo(Integer.parseInt(value));
				if (serviceOrderInfo.getServiceOrderReceiveUser() == null) {
					logger.info("订单号为" + serviceOrderInfo.getServiceOrderId() + "的订单未被接单");
					continue;
				}
				Message message = new Message();
				message.setTitle("撤销订单提醒。");
				message.setExpireTime(60 * 5);
				message.setType(Message.TYPE_NOTIFICATION);
				Map<String, Object> custom = new HashMap<>(2);
				custom.put("messagetype", 2);
				message.setCustom(custom);
				message.setContent("服务订单到"+serviceOrderInfo.getServiceOrderDeliveryAddress()+"被取消。");
				logger.info("message:" + message.toJson());
				XingeApp xingeApp = getXingeApp(1,0);
				xingeAppDeepLink(1, message);
				String userId = serviceOrderInfo.getServiceOrderReceiveUser() + "";
				if (userId.length() < 2) {
					userId = "0" + userId;
				}
				JSONObject object = xingeApp.pushSingleAccount(0, userId, message);
				logger.info(object.toString());
				String modelId = wxService.getModelId(serviceOrderInfo.getAgentId(), 7);
				HuawuAgentWxInfo agentWxInfo = iAccount.getAgentWxInfo(serviceOrderInfo.getAgentId(),101);
				if(modelId==null || agentWxInfo==null ){
					modelId = wxService.getModelId(-2, 7);
					agentWxInfo = iAccount.getAgentWxInfo(-2, 101);
					serviceOrderInfo.setAgentId(-2);
				}
				if(agentWxInfo!=null)
					pushTorunner(Integer.parseInt(userId), serviceOrderInfo, "3",modelId,agentWxInfo.getXcxId());// 微信推送
			} else {
				break;
			}
		}
	}
	private static String makeGoodsOrderContent(String json) {
		if (json == null) {
			return "";
		}
		JSONArray arrary = Json2Object.json2JsonObject(json).getJSONArray("detail");
		if (arrary == null)
			return "";
//		List<MfoyouGoodsOrderItme> list = Json2Object.json2Arrary(arrary.toJSONString(), MfoyouGoodsOrderItme.class);
		String content = "\n";
//		if (list == null) {
//			return content;
//		}
//		for (MfoyouGoodsOrderItme item : list) {
//			content += item.getGoodsName() + " X " + item.getItemNumber() + "\n";
//		}
		return content;
	}
}
