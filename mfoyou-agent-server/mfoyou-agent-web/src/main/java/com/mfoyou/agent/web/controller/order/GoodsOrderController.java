package com.mfoyou.agent.web.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

import org.mfoyou.agent.common.dao.domain.HuawuPay;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderDetail;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderEx;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.GoodsOrderState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreActiveService;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.order.GoodOrderService;
import com.mfoyou.agent.web.service.order.OrderService;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;
import com.mfoyou.agent.web.service.wx.WXBaseService;
import com.mfoyou.agent.web.utils.common.GoodsOrderAmount;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Path("order/goods")
@Service
public class GoodsOrderController {
    @Autowired
    private SessionService     sessionService;
    @Autowired
    private GoodOrderService   goodOrderService;
    @Autowired
    private StoreService       storeService;
    @Autowired
    private OrderService       orderService;
    @Autowired
    private XGPushSerivce      xGPushSerivce;
    @Autowired
    private RedisCacheManger   redisCacheManger;
    @Autowired
    private PaymentService     paymentService;
    @Autowired
    private WXBaseService      wxBaseService;
    @Autowired
    private StoreActiveService storeActiveService;

    //public static final String YINIANYUN   = "yinianyun:1";
    //public static final String PRINTER_PRE = "printer:machine:";
    private static Logger      logger      = new Logger(GoodsOrderController.class);
    public static final String WX_PUSH = "wx:100:push";
    public static final String SERVICE_ORDER_REVOKE = "xp:Line9";
    @GET
    @Path(value = "getorder/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> getOrderList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("state") String goodsStat, @QueryParam("pageSize") Integer pageSize,
                                   @QueryParam("pageId") Integer pageid) {
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        List<Integer> status = null;
        if (goodsStat != null) {
            status = new ArrayList<Integer>();
            String[] goodsstates = goodsStat.split(",");
            for (String statu : goodsstates) {
                status.add(Integer.parseInt(statu));
            }
        }
        Integer storeId = sessionService.currentUserId(request);
        order.setStoreId(storeId);
        ArrayListObject<MfoyouGoodsOrder> orders = goodOrderService.getGoodsOrderList(order, null, null, pageid, pageSize, status, null);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(orders));
    }
    
    @GET
    @Path(value = "exception/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> exceptionorder(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageSize") Integer pageSize, @QueryParam("pageId") Integer pageid) {
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        Integer storeId = sessionService.currentUserId(request);
        order.setStoreId(storeId);
        int i=1;
        String isNeed = request.getParameter("isNeedAll");
        if(isNeed!=null){
        	i=2;
        }
        ArrayListObject<MfoyouGoodsOrderWithPackage> orders = goodOrderService.getExceptionOrder(storeId, pageid, pageSize, i);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(orders));
    }
    /**
     * 
     * @param request
     * @param response
     * @param goodsStat
     * @param pageSize
     * @param pageid
     * @param isNeed   参数为0或者null 时表示数字不需要特殊处理  只返回云购订单  参数为1  表示数字需要特殊处理  参数为2  表示不需要特殊处理 返回所有订单
     * @param startDate  开始时间
     * @param endDate  结束时间
     * @param key  搜索key
     * @return
     */
    @GET
    @Path(value = "getwithPacket/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> getWithPaclet(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("state") String goodsStat, @QueryParam("pageSize") Integer pageSize,
                                    @QueryParam("pageId") Integer pageid,@QueryParam("isNeedAll")Integer isNeed,
                                    @QueryParam("startDate")Long startDate,@QueryParam("endDate")Long endDate,@QueryParam("key")String key) {
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        List<Integer> status = null;
        if (goodsStat != null) {
            status = new ArrayList<Integer>();
            String[] goodsstates = goodsStat.split(",");
            for (String statu : goodsstates) {
                status.add(Integer.parseInt(statu));
            }
        }
        Date start = startDate==null ? null:new Date(startDate);
        Date end = endDate ==null ? null:new Date(endDate);
        Integer storeId = sessionService.currentUserId(request);
        order.setStoreId(storeId);
        ArrayListObject<MfoyouGoodsOrderWithPackage> orders = goodOrderService.getGoodsOrderWithPackageList(order, start, end, pageid, pageSize, status, isNeed,key);
        if(status!=null && status.contains(60)){
        	//不显示订单不足钱的异常
        	Iterator<MfoyouGoodsOrderWithPackage> iterator = orders.iterator();
        	while(iterator.hasNext()){
        		if((iterator.next().getOrderExceptionState().intValue() & 0x04) > 0){
        			iterator.remove();
        		}
        	}
        }
        return JsonRet.buildSuccRet(ListObject.BulidListObject(orders));
    }

    //商家接单
    @POST
    @Path(value = "receipt/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> receipt(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        //1是老流程 2 是新流程
        int mode = request.getParameter("mode")!=null ? 1:2;
        return goodOrderService.receipt(orderId, storeId,mode);
    }
    
    private Integer revokeOrder(Integer orderId,String context) {
        MfoyouGoodsOrder order = goodOrderService.getOrder(orderId);
        if (order == null)
            return -100;
        HuawuPay mfoyoupay = new HuawuPay();
        mfoyoupay.setPayOrderType(OrderType.goodsOrder.getValue());
        mfoyoupay.setPayOrderId(orderId);
        mfoyoupay.setPayState(1);
        ArrayListObject<HuawuPay> listObject = paymentService.getServicePayList(mfoyoupay, null, null, null, null);
        for (HuawuPay mfoyouPay : listObject) {
            int payType = mfoyouPay.getPayType();
            Boolean ret = false;
            if (payType == 2) {
                //微信
                ret = wxBaseService.refundPay(order.getAreaAgentId(),mfoyouPay.getPayAppId(), mfoyouPay.getPayNumber(), mfoyouPay.getPayAmount());
                paymentService.addStream(order.getUserId(), mfoyouPay.getPayAmount(), 1, orderId, OrderType.goodsOrder.getValue(), PayType.goodsOrder.getValue(), PayType.WeChat.getValue(), context,
                    MfoyouUserType.customer.getValue());
            } else {
                logger.error("未知的支付类型" + JSON.toJSONString(mfoyouPay));
            }
            HuawuPay savePay = new HuawuPay();
            savePay.setPayId(mfoyouPay.getPayId());
            savePay.setPayState(ret ? CommonState.emauitSucess.getValue() : CommonState.emauitfail.getValue());
            paymentService.modifyMfoyouPay(savePay);
        }
        storeActiveService.delMfoyouUserActiveAttend(orderId);
        return 0;
    }

    //拒绝订单
    @POST
    @Path(value = "refuse/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> refuse(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        order.setOrderId(orderId);
        order.setStoreId(storeId);
        int result = goodOrderService.updateGoodsOrder(order, null, GoodsOrderState.emWaitingAccept.getValue(), GoodsOrderState.emOrderRefuse.getValue());
        if (result == 1) {
            revokeOrder(orderId,"商品订单撤销");
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-50);
    }
    
    //自配送订单
    @POST
    @Path(value = "selfdis/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> selfdis(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        MfoyouGoodsOrder oldOrder = goodOrderService.getOrder(orderId);
        if ((oldOrder.getOrderState().intValue() >= GoodsOrderState.emAccect.getValue()) || (storeId.intValue() != oldOrder.getStoreId().intValue())) {
            logger.error("订单状态错误");
            return JsonRet.buildRet(-1106);
        }
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        if (oldOrder.getOrderTransportType()!=null&& oldOrder.getOrderTransportType().intValue()!=6 && oldOrder.getOrderState().intValue() == GoodsOrderState.emSeekRuner.getValue()) {
            //撤销服务订单
            HuawuServiceOrder mfoyouServiceOrder = orderService.getServiceOrderInfo(oldOrder.getOrderTransportId());
            Boolean bRet = orderService.revokeServiceOrder(mfoyouServiceOrder.getServiceOrderId(), mfoyouServiceOrder.getServiceOrderSendUser(), mfoyouServiceOrder.getServiceOrderPayAmount(),
                mfoyouServiceOrder.getServiceOrderState(), 0, OrderState.emServiceRevoke.getValue());
            if (!bRet) {
                logger.error("撤销服务订单失败");
                return JsonRet.buildRet(-1106);
            }
            oldOrder.setOrderTranspoetAmount(0);
            if (orderService.calcAmountAllot(oldOrder)) {
                order.setOrderAdminAmount(oldOrder.getOrderAdminAmount());
                order.setOrderAgentAdmount(oldOrder.getOrderAgentAdmount());
                order.setOrderStoreAmount(oldOrder.getOrderStoreAmount());
                order.setOrderStationAmount(oldOrder.getOrderStationAmount());
                order.setOrderTranspoetAmount(0);
                order.setOrderTransportId(0);
                order.setOrderTransportType(1);
                order.setOrderState(GoodsOrderState.emBeginDelivery.getValue());
                order.setOrderTransportRunerPhone(sessionService.currentUserPhone(request));
                order.setOrderTransportRunerName(oldOrder.getStoreName());
            } else {
                return JsonRet.buildRet(-1106);
            }
        }else if(oldOrder.getOrderState().intValue() == GoodsOrderState.emStoreAccept.getValue()){
        	order.setOrderExceptionState(oldOrder.getOrderExceptionState() & 0x03);//第三位置0  & 0011
        	order.setOrderState(GoodsOrderState.emBeginDelivery.getValue());
        }
        order.setOrderId(orderId);
        Boolean result = goodOrderService.mdfGoodsOrder(order);
        if (result) {
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-1106);
    }

    //获取订单  
    @GET
    @Path(value = "user/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> usergetOrderList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("state") String goodsStat, @QueryParam("pageSize") Integer pageSize,
                                       @QueryParam("pageId") Integer pageid) {
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        List<Integer> status = null;
        if (goodsStat != null) {
            status = new ArrayList<Integer>();
            String[] goodsstates = goodsStat.split(",");
            for (String statu : goodsstates) {
                status.add(Integer.parseInt(statu));
            }
        }
        Integer storeId = sessionService.currentUserId(request);
        order.setUserId(storeId);
        ArrayListObject<MfoyouGoodsOrderWithPackage> orders = goodOrderService.getGoodsOrderWithPackageList(order, null, null, pageid, pageSize, status,1,null);
        for(MfoyouGoodsOrderWithPackage mfoyouGoodsOrderWithPackage : orders){
        	mfoyouGoodsOrderWithPackage.setStoreStr(MfoyouEncrypt.enCode(mfoyouGoodsOrderWithPackage.getStoreId()));
        }
        return JsonRet.buildSuccRet(ListObject.BulidListObject(orders));
    }
  //获取带退款的订单 
    @GET
    @Path(value = "user/returnOrderlist")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> usergetOrderListWithReturnOrder(@Context HttpServletRequest request, @Context HttpServletResponse response,  @QueryParam("pageSize") Integer pageSize,
                                       @QueryParam("pageId") Integer pageid) {
        
        Integer storeId = sessionService.currentUserId(request);
        ArrayListObject<MfoyouGoodsOrderWithPackage> orders = goodOrderService.getGoodsOrderWithPackageList(storeId, pageid, pageSize);
        for(MfoyouGoodsOrderWithPackage mfoyouGoodsOrderWithPackage : orders){
        	mfoyouGoodsOrderWithPackage.setStoreStr(MfoyouEncrypt.enCode(mfoyouGoodsOrderWithPackage.getStoreId()));
        }
        return JsonRet.buildSuccRet(ListObject.BulidListObject(orders));
    }
    // 申请退款
    @POST
    @Path(value = "apply/drawback/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> drawback(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        MfoyouGoodsOrder goodsOrder = goodOrderService.getOrder(orderId);
        if (goodsOrder == null || (sessionService.currentUserId(request).intValue() != goodsOrder.getUserId().intValue())) {
            return JsonRet.buildRet(-95);
        }
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        order.setOrderId(orderId);
        order.setOrderExceptionState(goodsOrder.getOrderExceptionState() | 0x08);
        int result = goodOrderService.updateGoodsOrderByPrimaryKey(order);
      //撤销订单
        redisCacheManger.pushRList(WX_PUSH, "5:"+orderId);
        //推送给商家通知有新的退款订单      
        return result == 1?JsonRet.buildRet(0):JsonRet.buildRet(-50);
    }
    // 商家同意退款
    @POST
    @Path(value = "agree/drawback/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> agreeDrawback(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId,@QueryParam("isNative")Integer isnative) {
        MfoyouGoodsOrder order = goodOrderService.getOrder(orderId);
        if (order == null || (sessionService.currentUserId(request).intValue() != order.getStoreId().intValue())) {
            return JsonRet.buildRet(-95);
        }
        MfoyouGoodsOrder goodsorder = new MfoyouGoodsOrder();
        goodsorder.setOrderId(orderId);
        goodsorder.setOrderState(GoodsOrderState.emReturnMoney.getValue());
        int result = goodOrderService.updateGoodsOrderByPrimaryKey(goodsorder);
        if((isnative==null || isnative==0 ) && result==1){
        	revokeOrder(orderId, "商品订单退款");
        	if(order.getOrderTransportId()!=null && (!order.getOrderTransportId().equals(0))){
        		HuawuServiceOrder mfoyouServiceOrder = orderService.getServiceOrderInfo(order.getOrderTransportId());
        		 Boolean bRet = orderService.revokeServiceOrder(mfoyouServiceOrder.getServiceOrderId(), mfoyouServiceOrder.getServiceOrderSendUser(), mfoyouServiceOrder.getServiceOrderPayAmount(),
        	                mfoyouServiceOrder.getServiceOrderState(), 0, OrderState.emServiceRevoke.getValue());
        		if(order.getOrderState() >= OrderState.emRunerAccept.getValue() && bRet){
        			redisCacheManger.pushRList(SERVICE_ORDER_REVOKE, order.getOrderTransportId()+"");
        		}
        	}
        }
        return result == 1?JsonRet.buildRet(0):JsonRet.buildRet(-50);
    }
    // 撤销订单
    @POST
    @Path(value = "withdraw/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> withdraw(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        MfoyouGoodsOrder goodsOrder = goodOrderService.getOrder(orderId);
        if (goodsOrder == null || goodsOrder.getOrderState().intValue() >= GoodsOrderState.emStoreAccept.getValue()
            || (sessionService.currentUserId(request).intValue() != goodsOrder.getUserId().intValue())) {
            return JsonRet.buildRet(-95);
        }
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        order.setOrderId(orderId);
        order.setUserId(storeId);
        int result = goodOrderService.updateGoodsOrder(order, null, null, GoodsOrderState.emOrderRevoke.getValue());
        if (result == 1) {
            revokeOrder(orderId,"商品订单撤销");
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-50);
    }

    //  催单
    @POST
    @Path(value = "reminder/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> reminder(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer userid = sessionService.currentUserId(request);
        MfoyouGoodsOrder order = goodOrderService.getOrder(orderId);
        if (!order.getUserId().equals(userid)) {
            return JsonRet.buildRet(-1003);
        }
        if (order.getOrderTransportId() != null && order.getOrderState() < GoodsOrderState.emCustomerFinsh.getValue()) { //订单正在配送中
            //催跑腿员
            xGPushSerivce.pushNoticeReminderToRunner(null, order.getOrderTransportId(), null, null, System.currentTimeMillis());
        }
        MfoyouGoodsOrder mfoyouGoodsOrder = new MfoyouGoodsOrder();
        mfoyouGoodsOrder.setOrderId(orderId);
        mfoyouGoodsOrder.setOrderExceptionState(order.getOrderExceptionState() | 0x02);
        mfoyouGoodsOrder.setOrderUserUrge(order.getOrderUserUrge() + 1);// 催单次数加一
        int result = goodOrderService.updateGoodsOrderByPrimaryKey(mfoyouGoodsOrder);
        if (result == 1) {
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-50);
    }

    // 用户确认收货
    @POST
    @Path(value = "user/delivery/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> userdelivery(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        order.setOrderId(orderId);
        order.setUserId(storeId);
        int result = goodOrderService.updateGoodsOrder(order, null, null, GoodsOrderState.emCustomerFinsh.getValue());
        if (result == 1) {
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-50);
    }

    @POST
    @Path(value = "store/sureorder/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STOREACCESS)
    public JsonRet<?> sureorder(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        Integer storeId = sessionService.currentUserId(request);
        MfoyouGoodsOrder order = new MfoyouGoodsOrder();
        order.setOrderId(orderId);
        order.setStoreId(storeId);
        int result = goodOrderService.updateGoodsOrder(order, null, null, GoodsOrderState.emStoreFinsh.getValue());
        if (result == 1) {
            return JsonRet.buildRet(0);
        }
        return JsonRet.buildRet(-50);
    }

    //  订单详情
    @GET
    @Path(value = "detail/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> getdetail(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        MfoyouGoodsOrderWithPackage goodsOrderWithPackageList = goodOrderService.getGoodsOrderWith(orderId);
        goodsOrderWithPackageList.setStoreStr(MfoyouEncrypt.enCode(goodsOrderWithPackageList.getStoreId()));
        return JsonRet.buildSuccRet(goodsOrderWithPackageList);
    }

//    //统计
//    @GET
//    @Path(value = "statistics")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> statistics(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//        Integer storeId = sessionService.currentUserId(request);
//        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
//        String format2 = format.format(new Date());
//        Integer monthId = Integer.parseInt(format2);
//        Map<String, Object> orderCount = goodOrderService.getOrderCount(storeId, monthId);
//        return JsonRet.buildSuccRet(orderCount);
//    }

//    //获取某月的数据
//    @GET
//    @Path(value = "month/statistics/{monthId}")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> monthStatistics(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("monthId") Integer monthId) {
//        Integer storeId = sessionService.currentUserId(request);
//        MfoyouOrderStatistics monthOrder = goodOrderService.getMonthOrder(storeId, monthId);
//        return JsonRet.buildSuccRet(monthOrder);
//    }

    //订单价格预估
    @POST
    @Path(value = "amountCalc")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> amountCalc(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouGoodsOrderEx orderStore = Json2Object.json2Object(json, MfoyouGoodsOrderEx.class);
        ObjectUtil.checkInputValue(orderStore, orderStore.getStoreId(), orderStore.getOrderDistance(), orderStore.getList());
        GoodsOrderAmount orderAmount = new GoodsOrderAmount();
        orderStore.setUserId(sessionService.currentUserId(request));
        int ret = goodOrderService.orderAmountCalc(orderStore, orderAmount, false, false);
        return JsonRet.buildRet(ret, orderAmount);
    }
    @GET
    @Path(value = "getCanUseCoupon")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> getCanUseCoupon(@Context HttpServletRequest request, 
    		@QueryParam("storeStr")String storeStr,@QueryParam("amount")Integer amount) {
    	HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(MfoyouEncrypt.decode(storeStr));
    	List<MfoyouAgentStoreCoupon> canUseCoupon = goodOrderService.getCanUseCoupon(sessionService.currentUserId(request), 
    			mfoyouStoreInfo.getStoreId(), mfoyouStoreInfo.getStoreType(), amount, mfoyouStoreInfo.getStoreAgentId());
        return JsonRet.buildSuccRet(canUseCoupon);
    }
    //添加订单
    @POST
    @Path(value = "add")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> addOrder(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouGoodsOrderEx order = Json2Object.json2Object(json, MfoyouGoodsOrderEx.class);
        ObjectUtil.checkInputValue(order, order.getStoreId(), order.getList());
        GoodsOrderAmount orderAmount = new GoodsOrderAmount();
        order.setUserId(sessionService.currentUserId(request));
        int ret = goodOrderService.orderAmountCalc(order, orderAmount, true, true);
        if (ret != 0)
            return JsonRet.buildRet(ret);
        order.setOrderActiveId(orderAmount.getStoreActiveId());
        order.setOrderActiveAmount(orderAmount.getStoreActiveAmount());
        order.setOrderActiveContent(orderAmount.getStoreActiveContent());
        order.setOrderAttachAmount(orderAmount.getAttachAmount());
        order.setOrderFreightAmount(orderAmount.getFreightAmount());
        order.setOrderGoodsAmount(orderAmount.getDiscountAmount());
        order.setOrderTotalAmount(orderAmount.getOrderTotalAmount());
        order.setOrderGoodsCostAmount(orderAmount.getCostAmount());
        order.setPackageFee(orderAmount.getPackageFee());
        order.setOrderPayDiscostAmount(0);
        order.setTouchId(orderAmount.getTouchId());
        order.setCouponReduceMoney(orderAmount.getCouponReduceFee());
        order.setOrderPayAmount(0);
        order.setOrderState(GoodsOrderState.emOpenOrder.getValue());
        order.setOrderWeight(0);
        HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(order.getStoreId());
        if (mfoyouStoreInfo == null) {
            return JsonRet.buildRet(-1);
        }
        order.setAreaAgentId(mfoyouStoreInfo.getStoreAgentId());
        order.setStationId(mfoyouStoreInfo.getStoreStationId());
        /*if(order.getOrderUserExpectTime() == null){
            order.setOrderUserExpectTime(new Date());
        }*/
        order.setOrderUserUrge(0);
        order.setUserId(sessionService.currentUserId(request));
        order = goodOrderService.addGoodsOrder(order);
        if (order.getOrderId() == null) {
            return JsonRet.buildRet(-1);
        } else {
            //清理购物车
            goodOrderService.delAllMfoyouGoodsOrderCart(order.getUserId(), order.getStoreId());
            return JsonRet.buildRet(0, order);
        }
    }
   
    //订单价格预估
    @GET
    @Path(value = "getOrderPosition/{orderid}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getOrderPosition(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderid") Integer orderId) {
        MfoyouGoodsOrderDetail orderPosition = goodOrderService.getOrderPosition(orderId);
        HuawuWorker worker = orderPosition.getMfoyouWorker();
        if(worker!=null){
        	 Map<String, String> mapValue = redisCacheManger.getMapValue("u:" + worker.getUserId());
        	 String latstring = mapValue.get("lat");
        	 if(latstring!=null){
        		 worker.setWorkerLat(Double.parseDouble(latstring));
        	 }
        	 String lonstring = mapValue.get("lon");
        	 if(lonstring!=null){
        		 worker.setWorkerLong(Double.parseDouble(lonstring));
        	 }
             orderPosition.setMfoyouWorker(worker);
        }
        return JsonRet.buildSuccRet(orderPosition);
    }

//    @GET
//    @Path(value = "getCount/{dayId}")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> getCount(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("dayId") String dayId) {
//        Integer storeId = sessionService.currentUserId(request);
//        List<MfoyouGoodsOrder> mfoyouGoodsOrders = goodOrderService.getOrderListBydays(storeId, dayId);
//        return JsonRet.buildSuccRet(mfoyouGoodsOrders);
//    }
//
//    @GET
//    @Path(value = "getCurrentCount")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> getCurrentCount(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//        Integer storeId = sessionService.currentUserId(request);
//        HashMap<String, Object> hashMap = goodOrderService.getCurrentCount(storeId);
//        return JsonRet.buildSuccRet(hashMap);
//    }
//    @GET
//    @Path(value = "getTagByscore")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.ALLACCESS)
//    public JsonRet<?> getTagByscore(@Context HttpServletRequest request, @Context HttpServletResponse response,@QueryParam("score")Integer score) {
//    	if(score == null){
//    		return JsonRet.buildRet(-96);
//    	}
//        List<MfoyouGoodsEvaluateTag> mfoyouGoodsEvaluateTags = goodOrderService.getTagsByscore(score);
//        return JsonRet.buildSuccRet(mfoyouGoodsEvaluateTags);
//    }
//    @POST
//    @Path(value = "addGoodsOrderEvaluate")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.LOGINACCESS)
//    public JsonRet<?> addGoodsOrderEvaluate(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
//    	Integer currentUserId = sessionService.currentUserId(request);
//    	MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
//    	if(mfoyouMap.getInteger("orderId")==null || mfoyouMap.getInteger("storeId")==null || mfoyouMap.getInteger("score")==null){
//    		return JsonRet.buildRet(-96);
//    	}
//    	MfoyouGoodsOrderEvaluate mfoyouGoodsOrderEvaluate = new MfoyouGoodsOrderEvaluate();
//    	mfoyouGoodsOrderEvaluate.setEvaluateStar(mfoyouMap.getInteger("score"));
//    	mfoyouGoodsOrderEvaluate.setOrderId(mfoyouMap.getInteger("orderId"));
//    	mfoyouGoodsOrderEvaluate.setOrderType(2);
//    	mfoyouGoodsOrderEvaluate.setStoreId(mfoyouMap.getInteger("storeId"));
//    	mfoyouGoodsOrderEvaluate.setEvaluateContent(mfoyouMap.get("content"));
//    	mfoyouGoodsOrderEvaluate.setEvaluateTag(mfoyouMap.get("tag"));
//    	mfoyouGoodsOrderEvaluate.setIsAnonymous(mfoyouMap.getInteger("isAnonymous"));
//    	if(mfoyouMap.getInteger("isAnonymous")==null || mfoyouMap.getInteger("isAnonymous").intValue() == 0){
//    		mfoyouGoodsOrderEvaluate.setUserHeadUrl(sessionService.currentHeadUrl(request));
//    		mfoyouGoodsOrderEvaluate.setUserName(sessionService.currentNickName(request));
//    	}
//    	mfoyouGoodsOrderEvaluate.setUserId(currentUserId);
//    	int ret = goodOrderService.addGoodsOrderEvaluate(mfoyouGoodsOrderEvaluate);
//        return JsonRet.buildSuccRet(ret-1);
//    }
    // 用户确认收货
  
}
