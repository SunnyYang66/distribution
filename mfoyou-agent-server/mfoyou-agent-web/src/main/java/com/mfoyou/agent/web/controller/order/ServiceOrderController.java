package com.mfoyou.agent.web.controller.order;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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

import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuPay;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.entity.MfoyouCommonUtil;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.common.StringUtils;
import org.mfoyou.agent.utils.json.JSONMaker;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.RunnerService;
import com.mfoyou.agent.web.service.common.GeoService;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.order.ServiceOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.common.PriceData;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

import static jdk.nashorn.internal.runtime.PropertyDescriptor.GET;

@Path("/order/service")
@Service
public class ServiceOrderController {
	@Autowired
	SessionService sessionService;
	@Autowired
	ServiceOrderService serviceOrderService;
	@Autowired
	RunnerService runnerService;
	@Autowired
	IOrder iOrder;
	@Autowired
	GeoService geoService;
	@Autowired
	PaymentService paymentService;
	@Autowired
	WXBaseService wxBaseService;
	@Autowired
	IAccount iAccount;
	@Autowired
	RedisCacheManger redisCacheManger;
	Logger logger = Logger.getLogger(ServiceOrderController.class);
	public static final String SERVICE_ORDER_REVOKE = "xp:Line9";
	@POST
    @Path(value = "/add/serviceOrder/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> addOrder(@Context HttpServletRequest request, @Context HttpServletResponse response, 
    		@PathParam("agentId")Integer agentId,String json) {
        HuawuServiceOrder huawuServiceOrder = Json2Object.json2Object(json, HuawuServiceOrder.class);
        huawuServiceOrder.setServiceOrderSendUser(sessionService.currentUserId(request));
        huawuServiceOrder.setServiceOrderState(OrderState.emOpenOrder.getValue());
        huawuServiceOrder.setServiceOrderCreateTime(null);
        huawuServiceOrder.setServiceOrderModifyTime(null);
        huawuServiceOrder.setServiceOrderId(null);
        huawuServiceOrder.setServiceOrderSmallType(2);
        int ret = serviceOrderService.checkMfoyouOrder(huawuServiceOrder,1);
        if (ret != 0) {
            return JsonRet.buildRet(ret);
        }
        huawuServiceOrder = serviceOrderService.addServiceOrder(huawuServiceOrder);
        if (huawuServiceOrder != null) {
            return JsonRet.buildSuccRet(huawuServiceOrder);
        } else {
            return JsonRet.buildRet(-1);
        }
    }
	 // 追加附加費 
    @POST
    @Path(value = "/additional/order/{orderId}/{amount}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> additionalTip(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId, @PathParam("amount") Integer amount) {
        HuawuServiceOrder mfoyouServiceOrder = serviceOrderService.getServiceOrderInfo(orderId);
        if (mfoyouServiceOrder == null || (mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue())
            || (!sessionService.currentUserId(request).equals(mfoyouServiceOrder.getServiceOrderSendUser()))) {
            return JsonRet.buildRet(-95);
        }
        if (amount == null || amount <= 0) {
            return JsonRet.buildRet(-14);
        }
        HuawuServiceOrder checkServiceOrder = new HuawuServiceOrder();
        HuawuServiceOrder updateServiceOrder = new HuawuServiceOrder();
        checkServiceOrder.setServiceOrderId(orderId);
        checkServiceOrder.setServiceOrderAttachAmount(mfoyouServiceOrder.getServiceOrderAttachAmount());
        checkServiceOrder.setServiceOrderState(mfoyouServiceOrder.getServiceOrderState());
        updateServiceOrder.setServiceOrderAttachAmount(mfoyouServiceOrder.getServiceOrderAttachAmount() + amount);
        updateServiceOrder.setServiceOrderState(OrderState.emPayingOrder.getValue());
        updateServiceOrder.setServiceOrderAmount(mfoyouServiceOrder.getServiceOrderAmount() + amount);
        if (serviceOrderService.updateServiceOrderState(checkServiceOrder, updateServiceOrder, sessionService.currentUserId(request))) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-15);
        }
    }
 // 筛选我的订单
    @GET
    @Path(value = "/my/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> myList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                             @QueryParam("type") Integer service_order_type, @QueryParam("tagId") Integer service_tagId, @QueryParam("smalltype") Integer smalltype,
                             @QueryParam("state") Integer[] service_order_state, @QueryParam("orderby") Integer orderby,@QueryParam("orderSource")Integer  orderSource) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderSendUser(sessionService.currentUserId(request));
        mfoyouServiceOrder.setServiceOrderType(service_order_type);
        mfoyouServiceOrder.setServiceTagId(service_tagId);
        mfoyouServiceOrder.setServiceOrderSmallType(smalltype);
        logger.info("ccdkjfdsldkjf");
        if(sessionService.currentUserType(request).intValue() == UserRight.STOREACCESS.getValue()){
        	 mfoyouServiceOrder.setServiceOrderSource(3);
        }else{
        	mfoyouServiceOrder.setServiceOrderSource(0);
        }
        logger.info("request的值"+request.getParameter("token"));
        mfoyouServiceOrder.setAgentId(sessionService.currentUserAgentId(request));
        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        ArrayListObject<HuawuServiceOrder> listObject = serviceOrderService.getServiceOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, ObjectUtil.arrary2List(service_order_state),
            orderby);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(
            serviceOrderService.attachWorkUserInfo(listObject, new String[] { "userName", "userHeadUrl", "userPhone", "workerCommentCount", "workerName", "workerPhone", "workerStar", "userNickName" })));
    }
    @GET
    @Path(value = "/priceV2")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> servicePriceV2(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("distance") Integer distance, @QueryParam("weight") Integer weight,
                                   @QueryParam("type") Integer service_order_type, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat, @QueryParam("tagId") Integer tagId,
                                   @QueryParam("dt") Long dt, @QueryParam("agentStr")String agentStr, @QueryParam("tagName") String tagName) throws ParseException {
    	if(tagName == null || service_order_type == null||agentStr==null){
    		return JsonRet.buildRet(-96);
    	}
        Date time = dt==null? new Date() : new Date(dt);
        Integer agentId = MfoyouEncrypt.decode(agentStr);
        logger.info("agentId "+agentId);
        PriceData calOrderPriceV2 = serviceOrderService.calOrderPriceV2(agentId,service_order_type, weight, distance, tagName, time);
//        PriceData calOrderPriceV2 = serviceOrderService.calOrderPriceV2(agentId,service_order_type, weight, distance, tagId, time); 
        if(calOrderPriceV2==null){
        	return JsonRet.buildRet(-2999);
        }
        return JsonRet.buildSuccRet(calOrderPriceV2);
    }

    @GET
    @Path(value = "/encode")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> encode(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("agentId") Integer agentId) throws ParseException {
        String agentStr = MfoyouEncrypt.enCode(agentId);
        logger.info("agentStr "+agentStr);
        return JsonRet.buildSuccRet(agentStr);

    }

    @GET
    @Path(value = "/checkPos")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> checkPos(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("distance") Integer distance, @QueryParam("weight") Integer weight,
                                   @QueryParam("type") Integer service_order_type, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat, @QueryParam("tagId") Integer tagId,
                                   @QueryParam("dt") Long dt, @QueryParam("agentStr")String agentStr, @QueryParam("tagName") String tagName) throws ParseException {
    	if(tagName == null || service_order_type == null||agentStr==null){
    		return JsonRet.buildRet(-96);
    	}
        Date time = dt==null? new Date() : new Date(dt);
        Integer agentId = MfoyouEncrypt.decode(agentStr);
        logger.info("agentId "+agentId);
        PriceData calOrderPriceV2 = serviceOrderService.calOrderPriceV2(agentId,service_order_type, weight, distance, tagName, time);
//        PriceData calOrderPriceV2 = serviceOrderService.calOrderPriceV2(agentId,service_order_type, weight, distance, tagId, time); 
        if(calOrderPriceV2==null){
        	return JsonRet.buildRet(-2999);
        }
        return JsonRet.buildSuccRet(calOrderPriceV2);
    }
    @GET
    @Path(value = "/info")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> orderInfo(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("orderId") Integer orderId) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        Integer userType = sessionService.currentUserType(request);
        if (userType == 1 || userType==8) {
            mfoyouServiceOrder.setServiceOrderSendUser(sessionService.currentUserId(request));
        } else if (userType == 4) {
            mfoyouServiceOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        } else if (userType == 2) {
            mfoyouServiceOrder.setAgentId(sessionService.currentUserAgentId(request));
        } else {
            return JsonRet.buildRet(-97);
        }
        mfoyouServiceOrder.setServiceOrderId(orderId);
        ArrayListObject<HuawuServiceOrder> listObject = serviceOrderService.getServiceOrderList(mfoyouServiceOrder, null, null, null, null, null, null);
//        if (mfoyouAgent != null) {
//            MfoyouCommonUtil.calcOrderPercentage(listObject, sessionService.currentWorkFee(request));
//        }
        if (listObject.size() == 1) {
        	JSONObject ret = JSONMaker.AttachSubJsonString(listObject.get(0), "servicePayType");
            List<HuawuOrderLog> status = iOrder.getOrderLog(orderId, OrderType.serviceOrder.getValue()); 
            Date start = null;
            Date finsh = null;
            for (HuawuOrderLog mfoyouOrderLog : status) {
                if (mfoyouOrderLog.getOrderLogState() == OrderState.emServiceStart.getValue()) {
                    start = mfoyouOrderLog.getOrderLogTime();
                }
                if (mfoyouOrderLog.getOrderLogState() == OrderState.emServiceRunerFinsh.getValue()) {
                    finsh = mfoyouOrderLog.getOrderLogTime();
                }
            }
            if (finsh != null && start != null) {
                long value = finsh.getTime() - start.getTime();
                ret.put("taskDuration", value / 1000);
            }
            ret.put("flowList", JSON.toJSON(status));
            Integer wokerId = listObject.get(0).getServiceOrderReceiveUser();
            if (wokerId != null) {
                ret.putAll(runnerService.getWorkKeysInfo(wokerId, new String[] { "userName", "userHeadUrl", "userPhone", "workerCommentCount", "workerName", "workerPhone", "workerStar", "userNickName",
                                                                              "workerOrderCount", "workerServiceDistance", "workerLong", "workerLat" }));
            }
            return JsonRet.buildSuccRet(ret);
        }
        return JsonRet.buildRet(-98);
    }
 // 撤销订单
    @POST
    @Path(value = "/revoke/order/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> revokeOrder(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId,@QueryParam("key")String weiToken) {
        logger.info("begin revokeOrder orderId=" + orderId);
        Integer userId = sessionService.currentUserId(request);
        if(userId == null && weiToken == null){
        	return JsonRet.buildRet(-50);
        }
        if(weiToken != null && weiToken.equals(StringUtils.getSecrteString())){
        	logger.info("远程调用，orderid "+orderId);
        	userId = 0;
        }
        HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(orderId);
        if ((mfoyouServiceOrder.getServiceOrderState() >= OrderState.emRunerAccept.getValue()) || (!userId.equals(mfoyouServiceOrder.getServiceOrderSendUser())
        		&& userId.intValue()!=0)) {
            return JsonRet.buildRet(-95);
        }
        Boolean bRet = serviceOrderService.revokeServiceOrder(orderId, mfoyouServiceOrder.getServiceOrderSendUser(), mfoyouServiceOrder.getServiceOrderPayAmount(), mfoyouServiceOrder.getServiceOrderState(),
            0, OrderState.emServiceRevoke.getValue());
        geoService.removeOrderPos("" + orderId);
        logger.info("fish revokeOrder bRet=" + bRet);
        if (!bRet) {
            return JsonRet.buildRet(-100);
        } else {
            revokeOrder(mfoyouServiceOrder);
        }
        logger.info("fish paybackOrder ");
        return JsonRet.buildRet(0);

    }
    public void revokeOrder(HuawuServiceOrder mfoyouServiceOrder){
    	HuawuPay mfoyoupay = new HuawuPay();
        mfoyoupay.setPayOrderType(OrderType.serviceOrder.getValue());
        mfoyoupay.setPayOrderId(mfoyouServiceOrder.getServiceOrderId());
        mfoyoupay.setPayState(1);
        ArrayListObject<HuawuPay> listObject = paymentService.getServicePayList(mfoyoupay, null, null, null, null);
        for (HuawuPay mfoyouPay : listObject) {
            int payType = mfoyouPay.getPayType();
            Boolean ret = false;
            if (payType == 2) {
                //微信
                ret = wxBaseService.refundPay(mfoyouServiceOrder.getAgentId(),mfoyouPay.getPayAppId(), mfoyouPay.getPayNumber(), mfoyouPay.getPayAmount());
                paymentService.addStream(mfoyouServiceOrder.getServiceOrderSendUser(), mfoyouPay.getPayAmount(), 1, mfoyouServiceOrder.getServiceOrderId(), OrderType.serviceOrder.getValue(), PayType.serviceOrder.getValue(),
                    PayType.WeChat.getValue(), "服务订单撤销", MfoyouUserType.customer.getValue());
                if(ret){
                	redisCacheManger.pushRList(SERVICE_ORDER_REVOKE, mfoyouServiceOrder.getServiceOrderId()+"");
                }
            } else {
                logger.error("未知的支付类型" + JSON.toJSONString(mfoyouPay));
            }
            HuawuPay savePay = new HuawuPay();
            savePay.setPayId(mfoyouPay.getPayId());
            savePay.setPayState(ret ? CommonState.emauitSucess.getValue() : CommonState.emauitfail.getValue());
            paymentService.modifyMfoyouPay(savePay);
        }
    }
    // 撤销订单
    @POST
    @Path(value = "/revokeAgent/order/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> agentrevokeOrder(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId) {
        logger.info("agent begin revokeOrder orderId=" + orderId);
        Integer agentId = sessionService.currentUserId(request);
        HuawuServiceOrder mfoyouServiceOrder = iOrder.getServiceOrderInfo(orderId);
        if ((mfoyouServiceOrder.getServiceOrderState() >= OrderState.emServiceRunerFinsh.getValue()) || !mfoyouServiceOrder.getAgentId().equals(agentId)) {
            return JsonRet.buildRet(-95);
        }
        Boolean bRet = serviceOrderService.revokeServiceOrder(orderId, mfoyouServiceOrder.getServiceOrderSendUser(), mfoyouServiceOrder.getServiceOrderPayAmount(), mfoyouServiceOrder.getServiceOrderState(),
            0, OrderState.emServiceRevoke.getValue());
        geoService.removeOrderPos("" + orderId);
        logger.info("fish revokeOrder bRet=" + bRet);
        if (!bRet) {
            return JsonRet.buildRet(-100);
        } else {
            revokeOrder(mfoyouServiceOrder);
        }
        logger.info("fish paybackOrder ");
        return JsonRet.buildRet(0);
    }
    // 筛选订单列表
    @GET
    @Path(value = "square/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.AGENTACCESS, UserRight.RUNERACCESS })
    public JsonRet<?> squarelist(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                 @QueryParam("type") Integer service_order_type, @QueryParam("tagId") Integer service_tagId, @QueryParam("smalltype") Integer smalltype,
                                 @QueryParam("state") Integer[] service_order_state, @QueryParam("runerId") Integer runerId,@QueryParam("isNew")Integer isnew) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderType(service_order_type);
        mfoyouServiceOrder.setServiceTagId(service_tagId);
        mfoyouServiceOrder.setServiceOrderSmallType(smalltype);
        mfoyouServiceOrder.setServiceOrderReceiveUser(runerId);
        mfoyouServiceOrder.setAgentId(sessionService.currentUserAgentId(request));
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Date startDate = start == null ? null : DateUtils.date_sdf.parse(start);
        Date endDate = end == null ? null : DateUtils.date_sdf.parse(end);
        Integer loginType = sessionService.currentUserType(request);
        if (loginType == null) {
            loginType = 4;
        }
        long hashValue = 0;
        if(isnew != null && isnew.intValue()==1){
        	hashValue = 1;
        	mfoyouServiceOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        }
        if (loginType == 4) {//接单员
        	HuawuWorker mfoyouWorkerInfo = iAccount.getWorkerInfo(sessionService.currentUserId(request));
        	if(mfoyouWorkerInfo.getWorkerState()==-1){
        		return JsonRet.buildRet(-54);
        	}
            Integer agentId = sessionService.currentUserAgentId(request);
            if (agentId == null)
                agentId = 0;
            logger.info("agentId"+agentId);
            mfoyouServiceOrder.setAgentId(agentId);
        }
        String lon = request.getParameter("lon");
        String lat = request.getParameter("lat");
        if (lon != null && lat != null) {
            mfoyouServiceOrder.setServiceUserLon(StrUtil.parseDouble(lon));
            mfoyouServiceOrder.setServiceUserLat(StrUtil.parseDouble(lat));
        } else {
            Map<String, String> map = redisCacheManger.getMapValue("u:" + sessionService.currentUserId(request));
            if (map != null && map.get("lon") != null && map.get("lat") != null) {
                mfoyouServiceOrder.setServiceUserLon(StrUtil.parseDouble(map.get("lon")));
                mfoyouServiceOrder.setServiceUserLat(StrUtil.parseDouble(map.get("lat")));
            } else if (sessionService.currentUserlat(request) != null && sessionService.currentUserlon(request) != null) {
                mfoyouServiceOrder.setServiceUserLon(sessionService.currentUserlon(request));
                mfoyouServiceOrder.setServiceUserLat(sessionService.currentUserlat(request));
            }
        }
        List<Integer> states = null;
        if (service_order_state != null && service_order_state.length > 0) {
            states = new ArrayList<>();
            for (Integer state : service_order_state) {
                states.add(state);
            }
        }
        ArrayListObject<HuawuServiceOrder> listObject = serviceOrderService.getServiceOrderSquareList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, loginType, states, hashValue);
        //计算当前用户如果抢到单被提成的金额
        MfoyouCommonUtil.calcOrderPercentage(listObject, sessionService.currentWorkFee(request));
        return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));

    }
    // 筛选我的订单
    @GET
    @Path(value = "/runer/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.RUNERACCESS)
    public JsonRet<?> runerList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                @QueryParam("type") Integer service_order_type, @QueryParam("tagId") Integer service_tagId, @QueryParam("smalltype") Integer smalltype,
                                @QueryParam("state") Integer[] service_order_state,@QueryParam("isNew")Integer isnew) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        mfoyouServiceOrder.setServiceOrderType(service_order_type);
        mfoyouServiceOrder.setServiceTagId(service_tagId);
        mfoyouServiceOrder.setServiceOrderSmallType(smalltype);
//      mfoyouServiceOrder.setServiceOrderSource(1);
// 		mfoyouServiceOrder.setServiceOrderState(service_order_state);
        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        String lon = request.getParameter("lon");
        String lat = request.getParameter("lat");
        int flag = 1;
        if(isnew!=null && isnew.intValue() == 1){
        	if (lon != null && lat != null) {
                 mfoyouServiceOrder.setServiceUserLon(StrUtil.parseDouble(lon));
                 mfoyouServiceOrder.setServiceUserLat(StrUtil.parseDouble(lat));
             } else {
                 Map<String, String> map = redisCacheManger.getMapValue("u:" + sessionService.currentUserId(request));
                 if (map != null && map.get("lon") != null && map.get("lat") != null) {
                     mfoyouServiceOrder.setServiceUserLon(StrUtil.parseDouble(map.get("lon")));
                     mfoyouServiceOrder.setServiceUserLat(StrUtil.parseDouble(map.get("lat")));
                 } else if (sessionService.currentUserlat(request) != null && sessionService.currentUserlon(request) != null) {
                     mfoyouServiceOrder.setServiceUserLon(sessionService.currentUserlon(request));
                     mfoyouServiceOrder.setServiceUserLat(sessionService.currentUserlat(request));
                 }
             }
        	 HuawuWorker mfoyouWorker = iAccount.getWorkerInfo(sessionService.currentUserId(request));
             if (mfoyouWorker != null) {
            	 if(mfoyouWorker.getAgentId()==null)
            	 {
            		 return JsonRet.buildRet(-2001);
            	 }
                 mfoyouServiceOrder.setAgentId(mfoyouWorker.getAgentId());
             }
        	flag = 4;
        }
        ArrayListObject<HuawuServiceOrder> listObject = iOrder.getServiceOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, ObjectUtil.arrary2List(service_order_state), flag);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
    }
 // 筛选订单列表
    @GET
    @Path(value = "agent/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> agentlist(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                @QueryParam("type") Integer service_order_type, @QueryParam("tagId") Integer service_tagId, @QueryParam("smalltype") Integer smalltype,
                                @QueryParam("state") Integer[] service_order_state, @QueryParam("runerId") Integer runerId,@QueryParam("orderNum")String orderNumber) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderType(service_order_type);
        mfoyouServiceOrder.setServiceTagId(service_tagId);
        mfoyouServiceOrder.setServiceOrderSmallType(smalltype);
        mfoyouServiceOrder.setServiceOrderReceiveUser(runerId);
        mfoyouServiceOrder.setServiceOrderNumber(orderNumber);
        String source = request.getParameter("source");
        if(source !=null){
        	  mfoyouServiceOrder.setServiceOrderSource(Integer.parseInt(source));
        }
        if(sessionService.currentUserType(request).intValue() == UserRight.AGENTACCESS.getValue()){
        	mfoyouServiceOrder.setAgentId(sessionService.currentUserId(request));
        }else{
        	mfoyouServiceOrder.setStationId(sessionService.currentUserId(request));
        }
        String start = request.getParameter("sdate");
        String end = request.getParameter("edate");
        Date startDate = start == null ? null : DateUtils.date_sdf.parse(start);
        Date endDate = end == null ? null : DateUtils.date_sdf.parse(end);
        ArrayListObject<HuawuServiceOrder> listObject = iOrder.getServiceOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate, ObjectUtil.arrary2List(service_order_state), null);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(serviceOrderService.attachWorkerInfo(listObject, null)));
    }
    @GET
    @Path(value = "getAllOrderCount")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.AGENTACCESS,UserRight.STATIONMASTER })
    public JsonRet<?> getAllOrderCount(@Context HttpServletRequest request, @Context HttpServletResponse response ){
    	int type = sessionService.currentUserType(request).intValue() == 2 ? 0 :1;
       Map<String, Object> allOrderCount = serviceOrderService.getAllOrderCount(sessionService.currentUserId(request),type);
        //return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
        return JsonRet.buildSuccRet(allOrderCount);
    }
    @GET
    @Path(value = "abnormalOrder")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.AGENTACCESS, UserRight.RUNERACCESS,UserRight.STATIONMASTER })
    public JsonRet<?> urgeAbnormal(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                   @QueryParam("runerId") Integer runerId) throws ParseException {
        HuawuServiceOrder mfoyouServiceOrder = new HuawuServiceOrder();
        mfoyouServiceOrder.setServiceOrderReceiveUser(runerId);
        mfoyouServiceOrder.setAgentId(sessionService.currentUserAgentId(request));
        Integer loginType = sessionService.currentUserType(request);
        if (loginType.intValue() == MfoyouUserType.runer.getValue()) {
            mfoyouServiceOrder.setServiceOrderReceiveUser(sessionService.currentUserId(request));
        } else if(loginType.intValue() == MfoyouUserType.agent.getValue()){
            mfoyouServiceOrder.setAgentId(sessionService.currentUserId(request));
        }else{
        	mfoyouServiceOrder.setAgentId(sessionService.currentUserAgentId(request));
        	mfoyouServiceOrder.setStationId(sessionService.currentUserId(request));
        }
        String source = request.getParameter("source");
        if(source !=null){
        	  mfoyouServiceOrder.setServiceOrderSource(Integer.parseInt(source));
        }
        String start = request.getParameter("startDate");
        String end = request.getParameter("endDate");
        Date startDate = start == null ? null : DateUtils.date_sdf.parse(start);
        Date endDate = end == null ? null : DateUtils.date_sdf.parse(end);
        String type = request.getParameter("type");
        ArrayListObject<HuawuServiceOrder> listObject = serviceOrderService.getAbnormalOrderList(mfoyouServiceOrder, pageId, pageSize, startDate, endDate,type);
        //return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
        return JsonRet.buildSuccRet(ListObject.BulidListObject(
            serviceOrderService.attachWorkUserInfo(listObject, new String[] { "userName", "userHeadUrl", "userPhone", "workerCommentCount", "workerName", "workerPhone", "workerStar", "userNickName" })));
    }
}
