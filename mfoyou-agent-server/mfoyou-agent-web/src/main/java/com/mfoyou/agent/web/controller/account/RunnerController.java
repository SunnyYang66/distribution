package com.mfoyou.agent.web.controller.account;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.entity.MfoyouCommonUtil;
import org.mfoyou.agent.common.entity.MfoyouWorkStatistics;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.JSONMaker;
import org.mfoyou.agent.utils.json.Json2Object;
import org.mfoyou.agent.utils.map.MapObjectTrans;
import org.mfoyou.agent.utils.map.ObjectToMappr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.common.GeoService;
import com.mfoyou.agent.web.service.order.OrderService;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.order.ServiceOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.utils.common.RunerServicePosInfo;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import redis.clients.jedis.GeoRadiusResponse;

@Path("runer")
@Service
public class RunnerController {
	@Autowired
	SessionService sessionService;
	@Autowired
	IAccount iAccount;
	@Autowired
	IIdentity iIdentity;
	@Autowired
	GeoService geoService;
	@Autowired
	ServiceOrderService orderService;
	@Autowired
	PaymentService payService;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	XGPushSerivce xGPushSerivce;
	@POST
	@Path(value = "/apply")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.RUNERACCESS)
	public JsonRet<?> apply(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) throws ParseException {
		Integer userId = sessionService.currentUserId(request);
		HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(userId);
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		String name = json2MfoyouMap.get("workerName");
		String code = json2MfoyouMap.get("workerIdcardNumber");
		String fact = json2MfoyouMap.get("workerIdcardFact");
		String reverse = json2MfoyouMap.get("workerIdcardReverse");
		String hand = json2MfoyouMap.get("workerIdcardHand");
		Integer agentId = json2MfoyouMap.getInteger("agentId");
		agentId = agentId==null?-2:agentId;
		HuawuIdcardInfo huawuIdcardInfo = new HuawuIdcardInfo();
		huawuIdcardInfo.setUserId(userId);
		huawuIdcardInfo.setUserHandleIdcard(hand);
		huawuIdcardInfo.setUserFactIdcard(fact);
		huawuIdcardInfo.setUserReverseIdcard(reverse);
		huawuIdcardInfo.setUserTrueName(name);
		huawuIdcardInfo.setUserIdCode(code);
		if(!agentId.equals(-2)){
			huawuIdcardInfo.setAgentid(agentId);
		}
		huawuIdcardInfo.setState(CommonState.emauit.getValue());
		int result = 0;
		if (idcardInfo == null) {
			result = iAccount.addIdcardInfo(huawuIdcardInfo);
		} else {
			result = iAccount.updateMfoyouIdcardInfo(huawuIdcardInfo);
		}
		if(result==1 && !agentId.equals(-2)){
			HuawuWorker huawuWorker = new HuawuWorker();
			huawuWorker.setUserId(userId);
			huawuWorker.setAgentId(agentId);
			iIdentity.modifyMfoyouWorkerInfo(huawuWorker);
		}
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-11);
	}

	@GET
	@Path(value = "/info/{userId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> runerInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("userId") Integer userId) throws ParseException {
		if (userId == null)
			return JsonRet.buildRet(-96);
		Integer agentId = sessionService.currentUserId(request);
		return JsonRet.buildRet(0, iIdentity.getMfoyouWorkerInfo(userId, agentId));
	}

	@GET
	@Path(value = "/infobyphone/{userPhone}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> runerInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("userPhone") String userPhone) throws ParseException {
		if (userPhone == null)
			return JsonRet.buildRet(-96);
		Integer agentId = null;
		if(sessionService.currentUserType(request)==UserRight.AGENTACCESS.getValue()){
			agentId = sessionService.currentUserId(request);
		}else {
			agentId = sessionService.currentUserAgentId(request);
		}
		HuawuUser userInfo = iAccount.getUserInfoByPhoneV2(userPhone, agentId);
		if (userInfo == null) {
			return JsonRet.buildFailRet("此用户不存在。"); 
		}
		HuawuWorker mfoyouWorker = iIdentity.getMfoyouWorkerInfoV2(userInfo.getUserId(), agentId);
		if(mfoyouWorker!=null){
			HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(userInfo.getUserId());
			if(idcardInfo!=null)
			mfoyouWorker.setWorkerName(idcardInfo.getUserTrueName());
			mfoyouWorker.setWorkerPhone(userPhone);
		}
		return JsonRet.buildRet(0, mfoyouWorker);
	}

	@GET
	@Path(value = "/info/{userId}/V1")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.AGENTACCESS, UserRight.ADMINACCESS })
	public JsonRet<?> runerInfoV1(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("userId") Integer userId) throws ParseException {
		ObjectUtil.checkInputValue(userId);
		HuawuUser huawuUser = iAccount.getUserInfoByUserId(userId);
		HuawuWorker huawuWorker = iAccount.getWorkerInfo(userId);
		HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(userId);
		if (idcardInfo != null) {
			huawuWorker.setWorkerAuth(idcardInfo.getUserType());
			huawuWorker.setWorkerIdcardHand(idcardInfo.getUserHandleIdcard());
			huawuWorker.setWorkerIdcardFact(idcardInfo.getUserFactIdcard());
			huawuWorker.setWorkerIdcardNumber(idcardInfo.getUserIdCode());
			huawuWorker.setWorkerIdcardReverse(idcardInfo.getUserReverseIdcard());
		}
		JSONObject retObject = JSONMaker.mergeJson(huawuWorker, huawuUser, new String[] { "userPhone", "userNickName",
				"userHeadUrl", "userName", "userSex", "userDisable", "userLastLogin" });
		return JsonRet.buildRet(0, retObject);
	}

	// 接单员当前状态
	@GET
	@Path(value = "my/info")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.RUNERACCESS })
	public JsonRet<?> myInfo(@Context HttpServletRequest request, @Context HttpServletResponse response)
			throws ParseException {
		Integer userId = sessionService.currentUserId(request);
		HuawuWorker mfoyouWorkerInfo = iAccount.getWorkerInfo(userId);
		if (mfoyouWorkerInfo == null) {
			return JsonRet.buildRet(-2001);
		}
		HuawuIdcardInfo idcardInfo = iAccount.getIdcardInfo(userId);
		// 保持与身份证表的认证状态一致
		if (idcardInfo != null) {
			Integer sqareFieldInt = idcardInfo.getState();
			mfoyouWorkerInfo.setWorkerAuth(sqareFieldInt.intValue());
		} else {
			mfoyouWorkerInfo.setWorkerAuth(0);
		}
		return JsonRet.buildRet(0, mfoyouWorkerInfo);
	}
	 // 接单员状态更新
    @POST
    @Path(value = "/my/work/update")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> workUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) throws ParseException {

        HuawuWorker mfoyouWorker = Json2Object.json2Object(json, HuawuWorker.class);
        if (mfoyouWorker == null || mfoyouWorker.getWorkerLong() == null || mfoyouWorker.getWorkerLat() == null)
            JsonRet.buildRet(-99);
        HuawuWorker huawuWorker = new HuawuWorker();
        huawuWorker.setUserId(sessionService.currentUserId(request));
        huawuWorker.setWorkerOpenState(mfoyouWorker.getWorkerOpenState());
//        huawuWorker.setWorkerServiceType(mfoyouWorker.getWorkerServiceType());
        huawuWorker.setWorkerLong(mfoyouWorker.getWorkerLong());
        huawuWorker.setWorkerLat(mfoyouWorker.getWorkerLat());
        geoService.removeRunerPos(sessionService.currentUserAgentId(request), sessionService.currentUserId(request));
        geoService.removeRunerPos(0, sessionService.currentUserId(request));
        if (mfoyouWorker.getWorkerOpenState() != null && mfoyouWorker.getWorkerOpenState().intValue() == 1 && mfoyouWorker.getWorkerLong()!=null) {
            //开工中
            geoService.updateRunerPos(mfoyouWorker.getWorkerLong(), mfoyouWorker.getWorkerLat(), sessionService.currentUserId(request), sessionService.currentUserAgentId(request));
        }
        iIdentity.modifyMfoyouWorkerInfo(huawuWorker);
        sessionService.loginAppend(request, MapObjectTrans.objectToMap(huawuWorker));
//        Integer openState = sessionService.currentWorkerOpenState(request);
//        if (openState != null && openState == 1) {
//            agentService.incTodayOpenRuner(sessionService.currentUserAgentId(request), sessionService.currentUserId(request));
//        }
//        agentService.incTodayHuoYueRuner(sessionService.currentUserAgentId(request), sessionService.currentUserId(request));
        return JsonRet.buildRet(0);
    }
 // 指定位置半径内接单人员数目
    @GET
    @Path(value = "/raduis/info")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> posCount(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat,
                               @QueryParam("type") Integer type, @QueryParam("smallType") Integer smallType, @QueryParam("raduis") Integer raduis) {

        /*Integer agentId = agentService.Pos2Angent(lat, lon);*/
        /* if (agentId == null)
            return JsonRet.buildRet(0);*/
        List<GeoRadiusResponse> list = geoService.getRuner(0, lon, lat, raduis);
        List<RunerServicePosInfo> ret = new ArrayList<>();
        for (GeoRadiusResponse geoRadiusResponse : list) {
            RunerServicePosInfo runerServicePosInfo = new RunerServicePosInfo();
            runerServicePosInfo.setUserId(StrUtil.parseInteger(GeoService.runer_getUserId(geoRadiusResponse.getMemberByString())));
            runerServicePosInfo.setServiceType(255L);
            runerServicePosInfo.setLon(geoRadiusResponse.getCoordinate().getLongitude());
            runerServicePosInfo.setLat(geoRadiusResponse.getCoordinate().getLatitude());
            ret.add(runerServicePosInfo);
        }
        return JsonRet.buildRet(0, ListObject.BulidListObject(ret));
    }
    //当前可接的订单
    @GET
    @Path(value = "/raduis/order")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> posOrder(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat,
                               @QueryParam("raduis") Integer raduis) {
        if (raduis == null || lon == null || lat == null) {
            return JsonRet.buildRet(-96);
        }
        Integer type = sessionService.currentWorderType(request);
        //agentId = mfoyouRegionCustom.getAgentId();
        List<GeoRadiusResponse> geoRadiusResponses = geoService.getOrder(lon, lat, raduis);
        List<Integer> listId = new ArrayList<>();
        for (GeoRadiusResponse geoRadiusResponse : geoRadiusResponses) {
            Integer id = StrUtil.parseInteger(geoRadiusResponse.getMemberByString());
            listId.add(id);
        }
        if (listId.size() == 0) {
            return JsonRet.buildRet(0, ListObject.BulidListObject(new ArrayList<HuawuServiceOrder>()));
        }
        List<Integer> listState = new ArrayList<>();
        listState.add(OrderState.emSeekRuner.getValue());
        if (type == 1) {
            listState.add(OrderState.emPaySucess.getValue());
        }
        List<HuawuServiceOrder> list = orderService.getServiceOrderListbyId(listId, listState, null);
        //计算当前用户如果抢到单被提成的金额
        MfoyouCommonUtil.calcOrderPercentage(list, sessionService.currentWorkFee(request));
        return JsonRet.buildRet(0, ListObject.BulidListObject(list));
    }
    @GET
    @Path(value = "/raduis/orderCount")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> posOrderCount(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat,
                                    @QueryParam("raduis") Integer raduis) {
        if (raduis == null || lon == null || lat == null) {
            return JsonRet.buildRet(-96);
        }
        //agentId = mfoyouRegionCustom.getAgentId();
        List<GeoRadiusResponse> geoRadiusResponses = geoService.getOrder(lon, lat, raduis);
        int count = 0;
        if (geoRadiusResponses != null) {
            count = geoRadiusResponses.size();
        }
        return JsonRet.buildRet(0, count);
    }
    @POST
    @Path("gain/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> gainUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) throws ParseException {
    	HuawuWorker mfoyouWorkerInfo = iIdentity.getMfoyouWorkerInfo(sessionService.currentUserId(request), null);
    	if(mfoyouWorkerInfo.getWorkerState()==-1){
    		return JsonRet.buildRet(-54);
    	}
    	HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        
        List<Integer> list = new ArrayList<>();
        list.add(OrderState.emRunerAccept.getValue());
        list.add(OrderState.emServiceStart.getValue());
        list.add(OrderState.emServiceFinshPick.getValue());
        list.add(OrderState.emServiceFinshTake.getValue());
        int count = orderService.getOrderCount(newOrder, null, null, list);
        if (count >= 50) {
            return JsonRet.buildRet(-16);
        }
        Boolean bRet = orderService.gainOrder(request, sessionService.currentUserId(request), orderId);
        if (bRet) {
            return JsonRet.buildRet(0, bRet);
        }
        return JsonRet.buildRet(-92);
    }
    @POST
    @Path("begin/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> beginUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) throws ParseException {
        HuawuServiceOrder oldOrder = new HuawuServiceOrder();
        oldOrder.setServiceOrderId(orderId);
        oldOrder.setServiceOrderState(OrderState.emRunerAccept.getValue());
        oldOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderState(OrderState.emServiceStart.getValue());
        Boolean bRet = orderService.updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
        if (bRet) {
            xGPushSerivce.pushOrderNoticeUser(null, orderId, 3, 102, "已接开始服务");
            redisCacheManger.hremove(OrderService.SERVICE_ORDER_TIME2, orderId+"");
            return JsonRet.buildRet(0, bRet);
        }
        return JsonRet.buildRet(-95);
    }
    @POST
    @Path("finsh/pick/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> finshPickUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) throws ParseException {
    	HuawuServiceOrder oldOrder = new HuawuServiceOrder();
        oldOrder.setServiceOrderId(orderId);
        // oldOrder.setServiceOrderState(OrderState.emRunerAccept.getValue());
        oldOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderState(OrderState.emServiceFinshPick.getValue());
        Boolean bRet = orderService.updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
        if (bRet) {
            return JsonRet.buildRet(0, bRet);
        }
        return JsonRet.buildRet(-95);
    }
    @POST
    @Path("finsh/take/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> finshTakeUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) throws ParseException {
        HuawuServiceOrder oldOrder = new HuawuServiceOrder();
        oldOrder.setServiceOrderId(orderId);
        // oldOrder.setServiceOrderState(OrderState.emRunerAccept.getValue());
        oldOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderState(OrderState.emServiceFinshTake.getValue());
        Boolean bRet = orderService.updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
        if (bRet) {
            return JsonRet.buildRet(0, bRet);
        }
        return JsonRet.buildRet(-95);
    }
    @POST
    @Path("finsh/all/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> finshUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) throws ParseException {
        HuawuServiceOrder oldOrder = new HuawuServiceOrder();
        oldOrder.setServiceOrderId(orderId);
        // oldOrder.setServiceOrderState(OrderState.emRunerAccept.getValue());
        oldOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        HuawuServiceOrder newOrder = new HuawuServiceOrder();
        newOrder.setServiceOrderState(OrderState.emServiceRunerFinsh.getValue());
        Boolean bRet = orderService.updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
        if (bRet) {
//        	HuawuServiceOrder mfoyouServiceOrder = orderService.getServiceOrderInfo(orderId);
//        	Integer serviceOrderSourceId = mfoyouServiceOrder.getServiceOrderSourceId();
//        	if(serviceOrderSourceId != null && serviceOrderSourceId.intValue() == -1){
//        		elemeService.complet(orderId,mfoyouServiceOrder.getServiceOrderSendUser());
//        	}
//        	redisCacheManger.hremove(OrderService.SERVICE_ORDER_TIME1, orderId+"");
//            xGPushSerivce.pushOrderNoticeUser(null, orderId, 3, 103, "订单已完成");
            return JsonRet.buildRet(0, bRet);
        }
        return JsonRet.buildRet(-95);
    }
    // 接单员订单列表
    @GET
    @Path(value = "/my/order/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> orderlist(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                @QueryParam("state") Integer[] state) throws ParseException {
        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        mfoyouServiceOrder.setServiceOrderId(StrUtil.parseInteger(request.getParameter("orderId")));
        // mfoyouServiceOrder.setServiceOrderState(StrUtil.parseInteger(request.getParameter("state")));
        mfoyouServiceOrder.setServiceOrderType(StrUtil.parseInteger(request.getParameter("type")));
        mfoyouServiceOrder.setServiceTagId(StrUtil.parseInteger(request.getParameter("tagId")));
        mfoyouServiceOrder.setServiceTagName((request.getParameter("tagName")));
        mfoyouServiceOrder.setServiceOrderSmallType(StrUtil.parseInteger(request.getParameter("smallType")));
        List<Integer> states = new ArrayList<>();
        if (state != null && state.length > 0) {
            for (Integer value : state)
                states.add(value);
        }
        return JsonRet.buildRet(0, orderService.getServiceOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, states, null));
    }
    @GET
    @Path(value = "/my/count")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> ordercount(@Context HttpServletRequest request, @Context HttpServletResponse response) throws ParseException {
    	String start = request.getParameter("sDate");
        String end = request.getParameter("eDate");
        Date sDate = start == null ? null : DateUtils.parse(start);
        Date eDate = end == null ? null : DateUtils.parse(end);
        MfoyouWorkStatistics userWallet = payService.getUserWallet(sessionService.currentUserId(request), sDate, eDate, 1,MfoyouUserType.runer.getValue());
        Map<String, Object> objectToMap = ObjectToMappr.ObjectToMap(userWallet);
        if(sDate != null){
        	MfoyouWorkStatistics userWalletV2 = payService.getUserWallet(sessionService.currentUserId(request), null, null, 1,MfoyouUserType.runer.getValue());
        	objectToMap.put("totalAmount", userWalletV2.getOrderAoument());
        	objectToMap.put("totalCount", userWalletV2.getOrderCount());
        }
        return JsonRet.buildRet(0, objectToMap);
    }
    //
    @GET
    @Path("Evaluate/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> getOrderEvaluateList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                           @QueryParam("minScore") Integer minScore, @QueryParam("maxScore") Integer maxScore, @QueryParam("agentId") Integer agentId,
                                           @QueryParam("customerId") Integer customerId, @QueryParam("orderType") Integer orderType) {
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Date startDate = start == null ? null : DateUtils.parse(start);
        Date endDate = end == null ? null : DateUtils.parse(end);
        HuawuEvaluate mfoyouEvaluate = new HuawuEvaluate();
        mfoyouEvaluate.setAgentId(agentId);
        mfoyouEvaluate.setCustomerId(customerId);
        mfoyouEvaluate.setOrderType(orderType);
        mfoyouEvaluate.setWorkerId(sessionService.currentUserId(request));
        ArrayListObject<HuawuEvaluate> listObject = orderService.getEvaluate(mfoyouEvaluate, pageId, pageSize, startDate, endDate, minScore, maxScore);
        if (listObject != null) {
            return JsonRet.buildSuccRet(listObject);
        }
        return JsonRet.buildRet(-97);
    }

    @GET
    @Path("Evaluate/score")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> getOrderEvaluateScore(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("minScore") Integer minScore,
                                            @QueryParam("maxScore") Integer maxScore, @QueryParam("customerId") Integer customerId, @QueryParam("orderType") Integer orderType,
                                            @QueryParam("runerId") Integer runerId) {
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Date startDate = start == null ? null : DateUtils.parse(start);
        Date endDate = end == null ? null : DateUtils.parse(end);
        return JsonRet.buildSuccRet(orderService.getRunerEvaluateScoreCount(sessionService.currentUserId(request), startDate, endDate));
    }
    @GET
    @Path("my/achievement")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> getMyachievement(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        MfoyouWorkStatistics mfoyouWorkStatistics = payService.getUserWallet(sessionService.currentUserId(request), null, null, 1,MfoyouUserType.runer.getValue());
        return JsonRet.buildSuccRet(mfoyouWorkStatistics);
    }
    @POST
    @Path(value = "/my/pos/update")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> posUpate(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) throws ParseException {
        HuawuWorker mfoyouWorker = Json2Object.json2Object(json, HuawuWorker.class);
        if (mfoyouWorker == null || mfoyouWorker.getWorkerLong() == null || mfoyouWorker.getWorkerLat() == null)
            return JsonRet.buildRet(-99);
        if (Math.random() < 0.5) {
            Map<String, String> map = new HashMap<>();
            map.put("lon", "" + mfoyouWorker.getWorkerLong());
            map.put("lat", "" + mfoyouWorker.getWorkerLat());
            redisCacheManger.setMapValue("u:" + sessionService.currentUserId(request), map, 3600 * 24 * 180);
        }
        Integer userId = sessionService.currentUserId(request);
        if (sessionService.currentWorkerOpenState(request) == null || sessionService.currentWorkerOpenState(request).intValue() != 1) {
            return JsonRet.buildRet(0);
        }
        if (Math.random() < 0.3) { // 随机更新数据库 MfoyouWorker mfoyouWorkerSave =
            HuawuWorker mfoyouWorkerSave = new HuawuWorker();
            mfoyouWorkerSave.setUserId(sessionService.currentUserId(request));
            mfoyouWorkerSave.setWorkerLong(mfoyouWorker.getWorkerLong());
            mfoyouWorkerSave.setWorkerLat(mfoyouWorker.getWorkerLat());
            iIdentity.modifyMfoyouWorkerInfo(mfoyouWorkerSave);
        }
        Integer agentId = sessionService.currentUserAgentId(request);
        if(agentId==null || agentId.intValue()==-2){
        	HuawuWorker workerInfo = iAccount.getWorkerInfo(userId);
        	if(workerInfo==null || workerInfo.getAgentId()==null){
        		return JsonRet.buildRet(-26);
        	}
        	agentId = workerInfo.getAgentId();
        	sessionService.loginAppend(request, "agentId", workerInfo.getAgentId()+"");
        }
        geoService.updateRunerPos(mfoyouWorker.getWorkerLong(), mfoyouWorker.getWorkerLat(), sessionService.currentUserId(request), agentId);
        return JsonRet.buildRet(0);
    }
    @POST
    @Path(value = "/audit/{userId}/{auditState}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> audit(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("userId") Integer userId,
                            @PathParam("auditState") Integer auditState) throws ParseException {
    	HuawuIdcardInfo mfoyouIdcardInfo = new HuawuIdcardInfo();
        mfoyouIdcardInfo.setUserId(userId);
        if (auditState == 1) {
        	mfoyouIdcardInfo.setState(CommonState.emeffect.getValue());
//            HuawuUser mfoyouUser = accountSvc.userInfoV1(userId);
        } else if (auditState == -1) {
        	mfoyouIdcardInfo.setState(CommonState.emauitfail.getValue());  
        } else {
            JsonRet.buildRet(-11);
        }
        return JsonRet.buildRet(iAccount.updateMfoyouIdcardInfo(mfoyouIdcardInfo)==1 ? 0 : -1);
    }
}
