package com.mfoyou.agent.web.controller.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuAgentInfo;
import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.domain.MfoyouRegionCustom;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.common.inf.IOrder;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.StrUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AccountService;
import com.mfoyou.agent.web.service.account.AgentService;
import com.mfoyou.agent.web.service.order.OrderRunerService;
import com.mfoyou.agent.web.service.order.ServiceOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.service.thirdPart.XGPushSerivce;


@Path("agent")
@Service
public class AgentController {
	@Autowired
	SessionService sessionService;
	@Autowired	
	IIdentity iIdentity;
	@Autowired
	IAccount iAccount;
	@Autowired
	AgentService agentService;
	@Autowired
	IOrder iOrder;
	@Autowired
	OrderRunerService orderRunerService;
	@Autowired
	ServiceOrderService serviceOrderService;
	@Autowired
	XGPushSerivce xgPushSerivce;
	@Autowired
	AccountService accountService;
	@GET
    @Path(value = "myinfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> myinfo(@Context HttpServletRequest request, @Context HttpServletResponse response) {
    	Integer userId = sessionService.currentUserId(request);
    	if(sessionService.currentUserType(request)==UserRight.AGENTACCESS.getValue()){
    		  HuawuAgentInfo mfoyouAgent = iIdentity.getAgentInfo(userId);
    	        if (mfoyouAgent == null) {
    	            return JsonRet.buildRet(-98);
    	        }
    	        return JsonRet.buildRet(0,mfoyouAgent); 
    	}
    	MfoyouStationMaster stationMasterByUserId = iIdentity.getStationMasterByUserId(userId);
    	if(stationMasterByUserId!=null){
    		Integer agentId = stationMasterByUserId.getAgentId();
    		String agentName = iIdentity.getAgentInfo(agentId).getAgentName();
    		stationMasterByUserId.setAgentName(agentName);
    	}
    	return JsonRet.buildRet(0,stationMasterByUserId);
    }
	// 修改代理信息
    @POST
    @Path(value = "modify/myinfo")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.AGENTACCESS)
    public JsonRet<?> applyModify(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
        if (mfoyouMap == null || mfoyouMap.size() == 0)
            return JsonRet.buildRet(-99);
        if (mfoyouMap.get("agentTeamName") != null || mfoyouMap.get("agentContactsName") != null || mfoyouMap.get("agentContactsPhone") != null) {
            HuawuAgentInfo mfoyouAgent = new HuawuAgentInfo();
            mfoyouAgent.setAgentId(sessionService.currentUserAgentId(request));
            mfoyouAgent.setAgentName(mfoyouMap.get("agentTeamName"));
            mfoyouAgent.setAgentUserContacts(mfoyouMap.get("agentContactsName"));
            mfoyouAgent.setAgentPhone(mfoyouMap.get("agentContactsPhone"));
            iIdentity.modifyMfoyouAgent(mfoyouAgent);
        }
        if (mfoyouMap.get("userHeadUrl") != null) {
            HuawuUser mfoyouUser = new HuawuUser();
            mfoyouUser.setUserId(sessionService.currentUserId(request));
            mfoyouUser.setUserHeadUrl(mfoyouMap.get("userHeadUrl"));
            iAccount.modifyUser(mfoyouUser);
        }
        return JsonRet.buildRet(0);
    }
    // 指派订单
    @POST
    @Path(value = "/gain/{userId}/{orderId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> runerGain(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("orderId") Integer orderId, @PathParam("userId") Integer userId) {
        Boolean bRet = serviceOrderService.gainOrder(request, userId, orderId);
        if(bRet){
            xgPushSerivce.pushNoticeUser( userId, orderId, 1, "已接新订单提醒", "获取到团队指派的新订单，请及时查看");
        }
        return JsonRet.buildRet(bRet ? 0 : -92, bRet);
    }
    // 骑手列表
    @GET
    @Path(value = "/runer/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> runerList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId,
                                @QueryParam("pageSize") Integer pageSize) throws ParseException {
        Date startDate = DateUtils.parse(request.getParameter("startDate"));
        Date endDate = DateUtils.parse(request.getParameter("endDate"));
        HuawuWorker mfoyouWorker = new HuawuWorker();
        mfoyouWorker.setAgentId(sessionService.currentUserAgentId(request));
        mfoyouWorker.setWorkerOpenState(StrUtil.parseInteger(request.getParameter("openState")));
        mfoyouWorker.setWorkerPhone(request.getParameter("phone"));
        mfoyouWorker.setWorkerState(StrUtil.parseInteger(request.getParameter("state")));
        return JsonRet.buildSuccRet(ListObject.BulidListObject(iIdentity.getMfoyouWorkerList(mfoyouWorker, pageId, pageSize, startDate, endDate)));
    }
    @GET
    @Path("info/{agentId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({ UserRight.ADMINACCESS, UserRight.RUNERACCESS ,UserRight.STATIONMASTER})
    public JsonRet<?> info(@Context HttpServletRequest request, @Context HttpServletResponse response, @PathParam("agentId") Integer agentId) throws ParseException {
        HuawuAgentInfo mfoyouAgent = iIdentity.getAgentInfo(agentId);
        HuawuAgentStoreSetting huawuAgentStoreSetting = iIdentity.getSpecialSettingV1(agentId);
        if(huawuAgentStoreSetting!=null){
        	mfoyouAgent.setAgentPhone(huawuAgentStoreSetting.getPhone());
        }
        if (mfoyouAgent == null) {
            return JsonRet.buildRet(-98);
        } else {
            return JsonRet.buildRet(0, mfoyouAgent);
        }
    }
    //listV2   state 0 -1 为没被解雇和解雇   1 为认证中   2为认证成功  其他为未认证
    @GET
    @Path(value = "/runer/listv2")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> runerListV2(@Context HttpServletRequest request, @Context HttpServletResponse response,
    		@QueryParam("pageId") Integer pageId,
                         @QueryParam("pageSize") Integer pageSize,
                         @QueryParam("startDate")String startDate,
                         @QueryParam("endDate")String endDate) throws ParseException {
    	Date sdate = null;
		Date eDate = null;
		if(startDate==null || endDate == null){
			eDate = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, -1);
			sdate = calendar.getTime();
		}else{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			sdate = simpleDateFormat.parse(startDate);
			eDate = simpleDateFormat.parse(endDate);
		}
        HuawuWorker mfoyouWorker = new HuawuWorker();
        Integer userId = sessionService.currentUserId(request);
		if(sessionService.currentUserType(request).intValue() == UserRight.AGENTACCESS.getValue()){
			mfoyouWorker.setAgentId(userId);
		}else {
//			mfoyouWorker.setAgentId(sessionService.currentUserAgentId(request));
        	mfoyouWorker.setStationId(sessionService.currentUserId(request));
		}
        mfoyouWorker.setWorkerOpenState(StrUtil.parseInteger(request.getParameter("openState")));
        mfoyouWorker.setWorkerPhone(request.getParameter("phone"));
        mfoyouWorker.setWorkerState(StrUtil.parseInteger(request.getParameter("state")));
        return JsonRet.buildSuccRet(ListObject.BulidListObject(agentService.getMfoyouWorkerListV2(mfoyouWorker, pageId, pageSize, sdate, eDate)));
    }
    @GET
    @Path(value = "/runer/listV3")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> runerListV3(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("pageId") Integer pageId,
                                @QueryParam("pageSize") Integer pageSize) throws ParseException {
        HuawuWorker mfoyouWorker = new HuawuWorker();
        if(sessionService.currentUserType(request).intValue() == MfoyouUserType.agent.getValue()){
        	 mfoyouWorker.setAgentId(sessionService.currentUserId(request));
        }else{
//        	mfoyouWorker.setAgentId(sessionService.currentUserAgentId(request));
        	mfoyouWorker.setStationId(sessionService.currentUserId(request));
        }
        mfoyouWorker.setWorkerOpenState(StrUtil.parseInteger(request.getParameter("openState")));
        mfoyouWorker.setWorkerPhone(request.getParameter("phone"));
        return JsonRet.buildSuccRet(ListObject.BulidListObject(agentService.getMfoyouWorkerListV3(mfoyouWorker, pageId, pageSize)));
    }
    @GET
    @Path(value = "/my/configure/price/listV2")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.AGENTACCESS)
    public JsonRet<?> myConfigurePriceListV2(@Context HttpServletRequest request, @Context HttpServletResponse response) throws ParseException {
    	Integer agentId = sessionService.currentUserId(request);
    	HuawuServicePrice mfoyouServicePricev2 = agentService.getConfigurePrice(agentId,true);
        return JsonRet.buildSuccRet(mfoyouServicePricev2);
    }
    // 价格调整
    @POST
    @Path(value = "/configure/priceV2")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS})
    public JsonRet<?> configurePricev2(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        if (json == null)
            return JsonRet.buildRet(-99);
        Integer agentId = sessionService.currentUserId(request);
        HuawuServicePrice mfoyouServicePricev2 = Json2Object.json2Object(json, HuawuServicePrice.class);
        mfoyouServicePricev2.setAgentId(agentId);
        int ret = agentService.updatePriceV2ByagentId(mfoyouServicePricev2);
        return ret == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-95);
    }
    // 获取订单周围人
    @GET
    @Path(value = "/runer/pickup")
    @Produces("application/json;charset=UTF-8")
    @UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
    public JsonRet<?> runerPickup(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("orderId") Integer orderId) {
        HuawuServiceOrder order = iOrder.getServiceOrderInfo(orderId);
        if(request.getParameter("type") != null && request.getParameter("type").equals("1")){
        	order.setServiceOrderSource(-2);
        }
        return JsonRet.buildRet(0, orderRunerService.orderMatchAgentRuner(order));
    }
    @POST
   	@Path(value = "modify/worker")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight({UserRight.AGENTACCESS})
   	public JsonRet<?> modifyWorker(@Context HttpServletRequest request, @Context HttpServletResponse response,String json){
       	MfoyouMap map = Json2Object.json2MfoyouMap(json);
   		Integer workerid = map.getInteger("workerId");
   		if(workerid==null){
   			return JsonRet.buildRet(-96);
   		}
   		HuawuWorker mfoyouWorker = new HuawuWorker();
   		mfoyouWorker.setUserId(workerid);
   		Integer fee = map.getInteger("fee");
   		Integer stationId = map.getInteger("stationId");
   		mfoyouWorker.setWorkerFee(fee);
   		mfoyouWorker.setStationId(stationId);
   		return JsonRet.buildRet(iIdentity.modifyMfoyouWorkerInfo(mfoyouWorker)==1?0:-1);
   	}
    @POST
   	@Path(value = "addruner/{userPhone}")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
   	public JsonRet<?> addWorker(@Context HttpServletRequest request, @Context HttpServletResponse response
   			,@PathParam("userPhone")String userPhone){
    	if (userPhone == null)
			return JsonRet.buildRet(-96);
		Integer agentId = sessionService.currentUserId(request);
		HuawuUser userInfo = iAccount.getUserInfoByPhoneV2(userPhone, agentId);
		if (userInfo == null) {
			return JsonRet.buildFailRet("此用户不存在。");
		}
		HuawuWorker mfoyouWorker = iIdentity.getMfoyouWorkerInfoV2(userInfo.getUserId(), agentId);
   		if(mfoyouWorker==null || mfoyouWorker.getAgentId()!=null){
   			return JsonRet.buildRet(-87);
   		}
   		HuawuWorker huawuWorker = new HuawuWorker();
   		if(sessionService.currentUserType(request)==UserRight.STATIONMASTER.getValue()){
   			huawuWorker.setAgentId(sessionService.currentUserAgentId(request));
   			huawuWorker.setStationId(sessionService.currentUserId(request));
   		}else{
   			huawuWorker.setAgentId(sessionService.currentUserId(request));
   		}
   		huawuWorker.setUserId(mfoyouWorker.getUserId());
   		huawuWorker.setJoinTime(new Date());
   		int modifyMfoyouWorkerInfo = iIdentity.modifyMfoyouWorkerInfo(huawuWorker);
   		sessionService.modifyWorkerAgent(sessionService.currentUserId(request),mfoyouWorker.getUserId());
   		return JsonRet.buildRet(modifyMfoyouWorkerInfo-1);
   	}
    @GET
	@Path("get/setting")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getSpecialSetting(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer agentId = sessionService.currentUserId(request);
		HuawuAgentStoreSetting setting = iIdentity.getSpecialSettingV1(agentId);
		return JsonRet.buildSuccRet(setting);
	}
    @POST
	@Path("setting")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> settingThird(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer agentId = sessionService.currentUserId(request);
		HuawuAgentStoreSetting mfoyouAgentStoreSetting11 = iIdentity.getSpecialSettingV1(agentId);
		HuawuAgentStoreSetting mfoyouAgentStoreSetting = new HuawuAgentStoreSetting();
		String storeName = json2MfoyouMap.get("storeName");
		mfoyouAgentStoreSetting.setStoreName(storeName);
		String storeLogo = json2MfoyouMap.get("storeLogo");
		mfoyouAgentStoreSetting.setStoreLogoUrl(storeLogo);
		String serviceName = json2MfoyouMap.get("serviceName");
		mfoyouAgentStoreSetting.setServiceName(serviceName);
		String serviceLogo = json2MfoyouMap.get("serviceLogo");
		mfoyouAgentStoreSetting.setServiceLogo(serviceLogo);
		Integer agentThirdPart = json2MfoyouMap.getInteger("agentThirdPart");
		mfoyouAgentStoreSetting.setPhone(json2MfoyouMap.get("phone"));
		if (agentThirdPart != null) {
			int type = mfoyouAgentStoreSetting11.getStoreModelType();
			mfoyouAgentStoreSetting.setStoreModelType((agentThirdPart & 0x0f) | (type & 0xf0));
		}
		mfoyouAgentStoreSetting.setAgentId(agentId);
		int result = iIdentity.updateMfoyouAgentSetting(mfoyouAgentStoreSetting);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-11);
	}
    @GET
	@Path(value = "gethomedata")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> gethomedata(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer agenid = sessionService.currentUserId(request);
		int userType = 1;
		if(sessionService.currentUserType(request).intValue() == UserRight.STATIONMASTER.getValue()){
			userType = 0;
		}
		HashMap<String, Object> hashMap = agentService.getAgentMoneyDate(agenid,userType);
		return JsonRet.buildSuccRet(hashMap);
	}
    @GET
	@Path(value = "dismissWorker")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> dismissWorker(@Context HttpServletRequest request,@QueryParam("workerId")Integer workerId,@QueryParam("state")Integer state) {
		
		HuawuWorker mfoyouWorkerInfo = iIdentity.getMfoyouWorkerInfo(workerId, null);
		if(mfoyouWorkerInfo==null){
			return JsonRet.buildRet(-52);
		}
		if(sessionService.currentUserType(request)==UserRight.STATIONMASTER.getValue()){
			if(mfoyouWorkerInfo.getStationId()==null || !mfoyouWorkerInfo.getStationId().equals(sessionService.currentUserId(request))){
				return JsonRet.buildRet(-53);
			}
		}else{
			Integer agenid = sessionService.currentUserId(request);
			if(mfoyouWorkerInfo.getAgentId()==null || !mfoyouWorkerInfo.getAgentId().equals(agenid)){
				return JsonRet.buildRet(-53);
			}
		}
		HuawuWorker huawuWorker = new HuawuWorker();
		huawuWorker.setUserId(workerId);
		if(state!=null &&state.intValue()==-1){
			huawuWorker.setWorkerState(0);//解聘
		}else{
			huawuWorker.setWorkerState(-1);//解聘
		}
		int modifyMfoyouWorkerInfo = iIdentity.modifyMfoyouWorkerInfo(huawuWorker);
		return JsonRet.buildSuccRet(modifyMfoyouWorkerInfo-1);
	}
    @POST
	@Path(value = "addRegionInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> addRegionInfo(@Context HttpServletRequest request,String json) {
    	MfoyouRegionCustom parseObject = JSON.parseObject(json,MfoyouRegionCustom.class);
    	parseObject.setAgentId(sessionService.currentUserId(request));
    	int ret = iOrder.addRegionCustom(parseObject);
		return JsonRet.buildRet(ret-1);
	}
    @POST
   	@Path(value = "updateRegionInfo")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight(UserRight.AGENTACCESS)
   	public JsonRet<?> updateRegionInfo(@Context HttpServletRequest request,String json) {
       	MfoyouRegionCustom parseObject = JSON.parseObject(json,MfoyouRegionCustom.class);
       	parseObject.setAgentId(sessionService.currentUserId(request));
       	int ret = iOrder.updateRegionCustom(parseObject);
   		return JsonRet.buildRet(ret-1);
   	}
    @GET
   	@Path(value = "deleteRegionInfo")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight(UserRight.AGENTACCESS)
   	public JsonRet<?> deleteRegionInfo(@Context HttpServletRequest request,@QueryParam("regionId")Integer regionId) {
       	int ret = iOrder.deleteRegionCustom(regionId);
   		return JsonRet.buildRet(ret-1);
   	}
    @GET
   	@Path(value = "getRegionInfos")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight(UserRight.AGENTACCESS)
   	public JsonRet<?> getRegionInfos(@Context HttpServletRequest request) {
       	Integer agentId = sessionService.currentUserId(request);
       	List<MfoyouRegionCustom> customRegionListByAgentId = iOrder.getCustomRegionListByAgentId(agentId);
   		return JsonRet.buildSuccRet(customRegionListByAgentId);
   	}
    @POST
   	@Path(value = "addStation")
   	@Produces("application/json;charset=UTF-8")
   	@UrlRight(UserRight.AGENTACCESS)
   	public JsonRet<?> registStation(@Context HttpServletRequest request,String json) {
       	Integer agentId = sessionService.currentUserId(request);
       	MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
       	String phone = mfoyouMap.get("phone");
       	HuawuUser userInfoByPhone = iAccount.getUserInfoByPhone(phone, -3);
       	if(userInfoByPhone!=null){
       		return JsonRet.buildRet(-3001);
       	}
       	String passwd = mfoyouMap.get("passwd");
       	String name = mfoyouMap.get("name");
       	Integer shareRun = mfoyouMap.getInteger("runnerShare");
       	Integer storeShareFee = mfoyouMap.getInteger("storeShare");
       	Integer powerState = mfoyouMap.getInteger("powerState");
       	HuawuUser huawuUser = new HuawuUser();
       	huawuUser.setUserPhone(phone);
       	huawuUser.setUserPassword(passwd);
       	huawuUser.setAgentId(-3);
       	HuawuUser registUser = accountService.registUser(huawuUser);
       	MfoyouStationMaster mfoyouStationMaster = new MfoyouStationMaster();
       	mfoyouStationMaster.setAgentId(agentId);
       	mfoyouStationMaster.setStationLoginNumber(phone);
       	mfoyouStationMaster.setStationId(registUser.getUserId());
       	mfoyouStationMaster.setStationName(name);
       	mfoyouStationMaster.setStoreShareFee(storeShareFee);
       	mfoyouStationMaster.setRunnerShareFee(shareRun);
       	mfoyouStationMaster.setPowerState(powerState);
       	int ret = iIdentity.addStation(mfoyouStationMaster);
   		return JsonRet.buildRet(ret-1);
   	}
}
