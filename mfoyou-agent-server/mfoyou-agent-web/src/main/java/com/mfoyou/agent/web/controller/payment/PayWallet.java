package com.mfoyou.agent.web.controller.payment;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuExtract;
import org.mfoyou.agent.common.dao.domain.HuawuStream;
import org.mfoyou.agent.common.dao.domain.HuawuWallet;
import org.mfoyou.agent.common.dao.domain.HuawuWalletLog;
import org.mfoyou.agent.common.entity.enums.CommonState;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.entity.enums.OrderType;
import org.mfoyou.agent.common.entity.enums.PayType;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.order.PaymentService;
import com.mfoyou.agent.web.service.session.SessionService;


@Path("pay/wallet")
@Service
public class PayWallet {

    @Autowired
    PaymentService paymentService;
    @Autowired
    SessionService sessionService;
//    @Autowiredo
//    OrderService   orderService;
//    @Autowired
//    SmsService     SmsService;

    @GET
    @Path("mywallet")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> getMyWallet(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        Integer userId = sessionService.currentUserId(request);
//        Integer userType = sessionService.currentUserType(request);//低位置位0
        HuawuWallet mfoyouWallet =  paymentService.getUserWallet(userId);
//        mfoyouWallet.setWalletExtractAmount(getUserextractAmount(mfoyouWallet,userType));
        return JsonRet.buildSuccRet(mfoyouWallet);
    }
    
    @POST
    @Path("bind/account")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> bindAccount(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        if (mfoyouMap == null) {
            return JsonRet.buildRet(-96);
        }
        Integer accountType = mfoyouMap.getInteger("accountType");
        if (accountType == null) {
            return JsonRet.buildRet(-96);
        }
        HuawuWallet mfoyouWallet = new HuawuWallet();
        if (accountType == 1) {
            mfoyouWallet.setWalletAlipayAccount(mfoyouMap.get("accountNumber"));
            mfoyouWallet.setWalletUserName(mfoyouMap.get("accountName"));
        } else if (accountType == 2) {
            mfoyouWallet.setWalletWechatAccount(mfoyouMap.get("accountNumber"));
            mfoyouWallet.setWalletUserName(mfoyouMap.get("accountName"));
        } else {
            return JsonRet.buildRet(-11);
        }
        mfoyouWallet.setUserId(sessionService.currentUserId(request));
        paymentService.modifyWallet(mfoyouWallet);
        return JsonRet.buildRet(0);

    }
    public static int getUserAmount(HuawuWallet mfoyouWallet, int userType) {

        return MfoyouUserType.agent.getValue() == userType || 32 == userType? mfoyouWallet.getWalletAgentAmount():
        	MfoyouUserType.runer.getValue() == userType ? mfoyouWallet.getWalletRunerAmount() : 
        		MfoyouUserType.store.getValue() == userType ? mfoyouWallet.getWalletStoreAmount():
        			16 == userType || 64 == userType ? mfoyouWallet.getWalletStoreAgentAmount() : 0;
    }
    // 提现申请
    @POST
    @Path("apply/extract")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> payextract(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        HuawuExtract mfoyouExtract = new HuawuExtract();
        if (mfoyouMap.getInteger("extractAmount") == null) {
            return JsonRet.buildRet(-97);
        }
        int extractAmount = mfoyouMap.getInteger("extractAmount");
//        if (extractAmount < 1000) {
//            return JsonRet.buildRet(-85);
//        }
        Integer type = sessionService.currentUserType(request);
        Integer userId = sessionService.currentUserId(request);
        Integer agentId = sessionService.currentUserAgentId(request);
        HuawuWallet mfoyouWallet = paymentService.getUserWallet(userId);
        int userAmount = getUserAmount(mfoyouWallet,type);
        int userextractAmount = mfoyouWallet.getWalletExtractAmount();
        if (extractAmount > userAmount + userextractAmount) {
            return JsonRet.buildRet(-94);
        }
        Date date = new Date();
        int eeAmount = userextractAmount >= extractAmount ? extractAmount : userextractAmount;
        int leAmount = extractAmount - eeAmount;
        Boolean bRet = paymentService.beginExtractWallet(userId, userextractAmount, eeAmount, userAmount, leAmount, DateUtils.yyyymmddhhmmss.format(date), 99,
            sessionService.currentUserAgentId(request), type);
        if (bRet) {
            mfoyouExtract.setUserId(userId);
            mfoyouExtract.setAgentId(agentId);
            mfoyouExtract.setExtractAmount(extractAmount);
            mfoyouExtract.setExtractType(1);
            mfoyouExtract.setExtractTime(date);
            mfoyouExtract.setExtractAccount(mfoyouWallet.getWalletAlipayAccount());
            mfoyouExtract.setExtractAccountName(mfoyouWallet.getWalletUserName());
            mfoyouExtract.setExtractState(CommonState.emauit.getValue());
            mfoyouExtract.setExtractUserType(type);
            mfoyouExtract.setExtractUserPhone(sessionService.currentUserPhone(request));
            mfoyouExtract.setExtractUserBalance(userextractAmount+userAmount - extractAmount);
            Integer id = paymentService.applyExtract(mfoyouExtract);
            paymentService.addStream(userId, extractAmount, -1, id, OrderType.extractOrder.getValue(), PayType.wallet.getValue(), PayType.alipay.getValue(), "提现",
            		type);
        }
        return JsonRet.buildRet(bRet ? 0 : -1);
    }
//
    // 提现列表
    @GET
    @Path("my/extract")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> extractList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize) {

        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        HuawuExtract mfoyouExtract = new HuawuExtract();
        mfoyouExtract.setExtractState(StrUtil.parseInteger(request.getParameter("extractState")));
        mfoyouExtract.setExtractAccount(request.getParameter("extractAccount"));
        mfoyouExtract.setExtractAuditResult(StrUtil.parseInteger(request.getParameter("extractAuditResult")));
        mfoyouExtract.setUserId(sessionService.currentUserId(request));
        mfoyouExtract.setExtractType(StrUtil.parseInteger(request.getParameter("extractType")));
        mfoyouExtract.setExtractUserType(sessionService.currentUserType(request));
        return JsonRet.buildRet(0, ListObject.BulidListObject(paymentService.getExtractList(1,mfoyouExtract, pageId, pageSize, startDate, endDate)));

    }


    @GET
    @Path("myWalletList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> getMyWalletList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize) {

        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        HuawuStream gxnnStream = new HuawuStream();
        gxnnStream.setStreamUserId(sessionService.currentUserId(request));
        gxnnStream.setStreamUserType(sessionService.currentUserType(request)) ;
        ArrayListObject<HuawuStream> listObject = paymentService.getStreamList(gxnnStream, pageId, pageSize, startDate, endDate);
        for (HuawuStream temp : listObject) {
            Integer type = temp.getStreamOrderType();
            if (type == null) {
                temp.setStreamState(CommonState.emeffect.getValue());
                continue;
            }
            if (type.equals(OrderType.extractOrder.getValue()) && (temp.getStreamOrderId() != null)) {
                HuawuExtract gxnnExtract = paymentService.getMfoyouExtract(temp.getStreamOrderId());
                if (gxnnExtract != null){
                	if(gxnnExtract.getExtractAuditResult().intValue() == -1){
                		 temp.setStreamState(3);
                	}else{
                		 temp.setStreamState(gxnnExtract.getExtractState());
                	}
                }
               continue;
            }
            temp.setStreamState(CommonState.emeffect.getValue());
        }
        return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
    }

//    @GET
//    @Path("storeWalletList")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> getstoreWalletList(@Context HttpServletRequest request, @Context HttpServletResponse response) {
//        Date startDate = DateUtils.parse(request.getParameter("startDate"));
//        Date endDate = DateUtils.parse(request.getParameter("endDate"));
//        Integer storeId = sessionService.currentUserId(request);
//        List<MfoyouStream> listObject = paymentService.getGoodOrderStreamList(storeId, startDate, endDate);
//        for (MfoyouStream temp : listObject) {
//            Integer type = temp.getStreamOrderType();
//            if (type == null) {
//                temp.setStreamState(CommonState.emeffect.getValue());
//                continue;
//            }
//            if (type.equals(OrderType.extractOrder.getValue()) && (temp.getStreamOrderId() != null)) {
//                MfoyouExtractV1 gxnnExtract = paymentService.getMfoyouExtract(temp.getStreamOrderId());
//                if (gxnnExtract != null){
//                	if(gxnnExtract.getExtractAuditResult().intValue() == -1){
//                		 temp.setStreamState(3);
//                	}else{
//                		 temp.setStreamState(gxnnExtract.getExtractState());
//                	}
//                }
//               continue;
//            }
//            temp.setStreamState(CommonState.emeffect.getValue());
//        }
//        return JsonRet.buildSuccRet(listObject);
//    }
    @GET
    @Path("agentWalletList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.STATIONMASTER)
    public JsonRet<?> getAgentWalletList(@Context HttpServletRequest request, @Context HttpServletResponse response,
    		@QueryParam("startDate") String ssdate, @QueryParam("endDate") String eedate, 
			@QueryParam("pageid") Integer pageid,@QueryParam("pagesize") Integer pageSize,@QueryParam("type")Integer type) {
        Date startDate = DateUtils.parse(ssdate);
        Date endDate = DateUtils.parse(eedate);
        int userType = 1;
        if(sessionService.currentUserType(request) == UserRight.STATIONMASTER.getValue()){
        	if(type !=null && type == 1){
        		userType=2;
        	}else{
        		userType = 0;
        	}
        }else if(type !=null && type == 1){
        	userType = 3;
        }
        Integer agentid = sessionService.currentUserId(request);
        ArrayListObject<HuawuWalletLog> listObject = paymentService.getAgentList(agentid, userType,startDate, endDate,pageid,pageSize);
        return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
    }
//    @GET
//    @Path("getStoreStream/{date}")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> getStoreStream(@Context HttpServletRequest request, @Context HttpServletResponse response,
//    		@PathParam("date")String date) throws ParseException {
//    	MfoyouStream mfoyouStream = new MfoyouStream();
//    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
//    	Date resultDate = simpleDateFormat.parse(date);
//    	Calendar calendar = Calendar.getInstance();
//    	calendar.add(Calendar.DATE, 1);
//    	Date time = calendar.getTime();
//    	mfoyouStream.setStreamUserId(100);
//    	mfoyouStream.setStreamOrderType(2);
//    	ArrayListObject<MfoyouStream> streamList = paymentService.getStreamList(mfoyouStream, null, null, resultDate, time);
//       return JsonRet.buildSuccRet(ListObject.BulidListObject(streamList));
//    }
//    @GET
//    @Path("adminWalletList")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.ADMINACCESS)
//    public JsonRet<?> getAdminWalletList(@Context HttpServletRequest request, @Context HttpServletResponse response,
//    		@QueryParam("startDate") String ssdate, @QueryParam("endDate") String eedate, 
//			@QueryParam("pageid") Integer pageid,@QueryParam("pagesize") Integer pageSize	) {
//        Date startDate = DateUtils.parse(ssdate);
//        Date endDate = DateUtils.parse(eedate);
//        ArrayListObject<MfoyouWalletLog> listObject = paymentService.getAdmin(startDate, endDate,pageid,pageSize);
//        return JsonRet.buildSuccRet(ListObject.BulidListObject(listObject));
//    }
//    @GET
//    @Path("freightStreamList")
//    @Produces("application/json;charset=UTF-8")
//    @UrlRight(UserRight.STOREACCESS)
//    public JsonRet<?> freightStreamList(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			@QueryParam("pageid") Integer pageid,@QueryParam("pagesize") Integer pageSize) {
//    	MfoyouStream stream = new MfoyouStream();
//    	stream.setStreamTarget(PayType.thirdOrder.getValue());
//    	stream.setStreamUserId(sessionService.currentUserId(request));
//    	ArrayListObject<MfoyouStream> streams = paymentService.freightStreamList(stream,pageid,pageSize);
//        return JsonRet.buildSuccRet(streams);
//    }
    @GET
   	@Path(value = "getCountData")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight({UserRight.AGENTACCESS})
   	public JsonRet<?> getCountData(@Context HttpServletRequest request, @Context HttpServletResponse response,@QueryParam("type")
   	Integer type) {
   		Integer agenid = sessionService.currentUserId(request);
   		Map<String, Object> hashMap = paymentService.getCountData(agenid,type);
   		return JsonRet.buildSuccRet(hashMap);
   	}
    @GET
   	@Path(value = "getPayList")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight({UserRight.AGENTACCESS})
   	public JsonRet<?> getPayList(@Context HttpServletRequest request, @Context HttpServletResponse response,
   			@QueryParam("pageid") Integer pageid,@QueryParam("pagesize") Integer pageSize,
   			@QueryParam("startDate") String ssdate, @QueryParam("endDate") String eedate,
   			@QueryParam("type") Integer type) {
    	Date startDate = ssdate==null ? null:DateUtils.parse(ssdate);
    	Date endDate = eedate == null ? null:DateUtils.parse(eedate);
   		Integer agenid = sessionService.currentUserId(request);
   		ArrayListObject<?> hashMap = paymentService.getPayList(agenid,pageid,pageSize,startDate,endDate,type);
   		return JsonRet.buildSuccRet(ListObject.BulidListObject(hashMap));
   	}
}
