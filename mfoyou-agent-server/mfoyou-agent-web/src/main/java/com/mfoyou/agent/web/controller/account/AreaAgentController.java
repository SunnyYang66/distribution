package com.mfoyou.agent.web.controller.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentServicePricev2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentTypeInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouOrderStatistics;
import org.mfoyou.agent.common.entity.MfoyouAgentStoreInfo;
import org.mfoyou.agent.common.entity.enums.MfoyouUserType;
import org.mfoyou.agent.common.inf.IAccount;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.json.Json2Object;
import org.mfoyou.agent.utils.map.ObjectToMappr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AgentService;
import com.mfoyou.agent.web.service.account.StoreAgentService;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.common.GeoService;
import com.mfoyou.agent.web.service.order.GoodOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
@Path("storeagent")
public class AreaAgentController {

	@Autowired
	SessionService sessionService;
	@Autowired
	StoreService storeService;
	@Autowired
	GoodOrderService goodOrderService;
	@Autowired
	StoreAgentService storeAgentservice;
	@Autowired
	IAccount iAccount;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	GeoService geoService;
	@Autowired
	AgentService agentService;
	@Autowired
	IIdentity iIdentity;
	public static final String PIC_MAIN = "main:carousel:";
	/**
	 * 
	 * @param request
	 * @param response
	 * @param sDate
	 * @param eDate
	 * @param pageSize
	 * @param pageId
	 * @param station 为1商品订单 0跑腿station  2 表示返回商店数量
	 * @return  为2 的时候   (跑腿员数量station_amount ,商家数量order_count)	
	 */
	@GET
	@Path(value = "get/stationList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getStationMaster(@Context HttpServletRequest request, @Context HttpServletResponse response
			,@QueryParam("sDate")String sDate,@QueryParam("eDate")String eDate,@QueryParam("pageSize")Integer pageSize,
			@QueryParam("pageId")Integer pageId,@QueryParam("station")Integer station){
		Integer agentId = sessionService.currentUserId(request);
		if(sDate == null || eDate == null){
			return JsonRet.buildRet(-96);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date start = null;
		try {
			start = simpleDateFormat.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date endDate = null;
		try {
			endDate = simpleDateFormat.parse(eDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MfoyouStationMaster mfoyouStationMaster = new MfoyouStationMaster();
		mfoyouStationMaster.setAgentId(agentId);
		mfoyouStationMaster.setPowerState(station);
		return JsonRet.buildSuccRet(ListObject.BulidListObject(agentService.getStationMaster(mfoyouStationMaster,start,endDate,pageSize,pageId)));
	}
	@GET
	@Path(value = "get/stationListv1")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getStationMasterv1(@Context HttpServletRequest request, @Context HttpServletResponse response ,
			@QueryParam("station")Integer station,@QueryParam("type")Integer type){
		Integer agentId = sessionService.currentUserId(request);
		if(station == null){
			return JsonRet.buildRet(-96);
		}
		List<MfoyouStationMaster> stationByAgentId = agentService.getStationByAgentId(agentId);
		ArrayList<MfoyouStationMaster> arrayList = new ArrayList<>();
		for(MfoyouStationMaster mfoyouStationMaster : stationByAgentId){
			if((mfoyouStationMaster.getPowerState().intValue() >> station & 1)> 0){
				arrayList.add(mfoyouStationMaster);
			}
		}
		return JsonRet.buildSuccRet(arrayList);
	}
	@POST
	@Path(value = "modify/station")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> modifyStation(@Context HttpServletRequest request, @Context HttpServletResponse response
			,String json){
		Integer agentId = sessionService.currentUserId(request);
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		MfoyouStationMaster mfoyouStationMaster = new MfoyouStationMaster();
		mfoyouStationMaster.setAgentId(agentId);
		Integer station_id = json2MfoyouMap.getInteger("station_id");
		if(station_id==null){
			return JsonRet.buildRet(-96); 
		}
		String stationName = json2MfoyouMap.get("stationName");
		Integer store_fee = json2MfoyouMap.getInteger("store_fee");
		Integer runnerfee = json2MfoyouMap.getInteger("runner_fee");
		String agentArea = json2MfoyouMap.get("agentArea");
		Integer type = json2MfoyouMap.getInteger("power");
		mfoyouStationMaster.setStationAreaName(stationName);
		mfoyouStationMaster.setStationId(station_id);
		mfoyouStationMaster.setStoreShareFee(store_fee);
		mfoyouStationMaster.setRunnerShareFee(runnerfee);
		mfoyouStationMaster.setAgentCoordinateArea(agentArea);
		mfoyouStationMaster.setPowerState(type);
		return JsonRet.buildRet(agentService.updateByAgent(mfoyouStationMaster)-1);
	}
	
	@POST
	@Path(value = "delete/station")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> deleteStation(@Context HttpServletRequest request, @Context HttpServletResponse response
			,String json){
		Integer agentId = sessionService.currentUserId(request);
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		MfoyouStationMaster mfoyouStationMaster = new MfoyouStationMaster();
		mfoyouStationMaster.setAgentId(agentId);
		Integer station_id = json2MfoyouMap.getInteger("station_id");
		if(station_id==null){
			return JsonRet.buildRet(-96);
		}
		mfoyouStationMaster.setStationId(station_id);
		return JsonRet.buildRet(agentService.deleteByPrimaryKey(mfoyouStationMaster)-1);
	}
	
	@GET
	@Path(value = "getlist")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> getList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("pageid") Integer pageid, @QueryParam("pagesize") Integer pagesize,
			@QueryParam("storePhone") String storePhone,@QueryParam("startDate")String startDate,
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
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		Integer userId = sessionService.currentUserId(request);
		if(sessionService.currentUserType(request).intValue() == UserRight.AGENTACCESS.getValue()){
			mfoyouStoreInfo.setStoreAgentId(userId);
		}else{
			mfoyouStoreInfo.setStoreStationId(userId);
		}
		mfoyouStoreInfo.setStoreLoginNumber(storePhone);
		ArrayListObject<MfoyouAgentStoreInfo> storeInfo = storeService.getStoreInfoByAgent(mfoyouStoreInfo, pageid, pagesize,sdate,eDate);
		return JsonRet.buildSuccRet(ListObject.BulidListObject(storeInfo));
	}

	@GET
	@Path(value = "gethomedata")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> gethomedata(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer agenid = sessionService.currentUserId(request);
		int userType = 0;
		if(sessionService.currentUserType(request).intValue() == UserRight.STATIONMASTER.getValue()){
			userType = 1;
		}
		HashMap<String, Object> hashMap = storeService.getAgentMoneyDate(agenid,userType);
		return JsonRet.buildSuccRet(hashMap);
	}

	@GET
	@Path(value = "getOrderList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> getOrderList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("sdate") String ssdate, @QueryParam("edate") String eedate,
			@QueryParam("pageId") Integer pageid, @QueryParam("pageSize") Integer pageSize,
			@QueryParam("orderNumber") String orderNumber) throws ParseException {
		Integer agenid = sessionService.currentUserId(request);
		MfoyouGoodsOrder order = new MfoyouGoodsOrder();
		order.setOrderNumber(orderNumber);
		if(sessionService.currentUserType(request).intValue() == UserRight.AGENTACCESS.getValue()){
			order.setAreaAgentId(agenid);
		}else if(sessionService.currentUserType(request).intValue() == UserRight.STATIONMASTER.getValue()){
			order.setStationId(agenid);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null;
		Date edate = null;
		if (ssdate != null) {
			sdate = simpleDateFormat.parse(ssdate);
		}
		if (eedate != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(simpleDateFormat.parse(eedate));
			calendar.add(Calendar.DATE, 1);
			edate = calendar.getTime();
		}
		ArrayListObject<MfoyouGoodsOrder> goodsOrderList = goodOrderService.getGoodsOrderList(order, sdate, edate,
				pageid, pageSize, null, 0);
		return JsonRet.buildSuccRet(ListObject.BulidListObject(goodsOrderList));
	}


	// 统计
	@GET
	@Path(value = "periodTime/{startDate}/{endData}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> periodTime(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("startDate") String sdate, @PathParam("endData") String edate) throws ParseException {
		Integer agentid = sessionService.currentUserId(request);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Date startDate = simpleDateFormat.parse(sdate);
		Date endDate = simpleDateFormat.parse(edate);
		int userType = 0;
		if(sessionService.currentUserType(request).intValue() == UserRight.STATIONMASTER.getValue()){
			userType = 1;
		}
		List<MfoyouOrderStatistics> mfoyouOrderStatistics = goodOrderService.getAgentStatistics(agentid, startDate,
				endDate,userType);
		return JsonRet.buildSuccRet(mfoyouOrderStatistics);
	}

	@POST
	@Path(value = "addStoreToagent/{storeid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> addStoreToagent(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("storeid") Integer storeid) {
		Integer userId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeid);
		if (storeInfo == null) {
			return JsonRet.buildRet(-98);
		}
		if(storeInfo.getStoreAgentId()!=null && storeInfo.getStoreAgentId()!=-1){
			return JsonRet.buildRet(-28);
		}
		HuawuStoreInfo huawuStoreInfo = new HuawuStoreInfo();
		if(sessionService.currentUserType(request)==UserRight.STATIONMASTER.getValue()){
			huawuStoreInfo.setStoreAgentId(sessionService.currentUserAgentId(request));
			huawuStoreInfo.setStoreStationId(userId);
		}else{
			huawuStoreInfo.setStoreAgentId(userId);
		}
		return JsonRet.buildSuccRet(storeService.updateStoreInfoById(storeid, huawuStoreInfo));
	}

	@GET
	@Path(value = "getStroeInfo/{storePhone}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> getStroeInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("storePhone") String storePhone) {
		HuawuUser userInfoByPhone = iAccount.getUserInfoByPhone(storePhone, -2);
		if(userInfoByPhone==null){
			return JsonRet.buildRet(-98);
		}
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(userInfoByPhone.getUserId());
		if (storeInfo == null) {
			return JsonRet.buildRet(-98);
		}
		return JsonRet.buildSuccRet(storeInfo);
	}

	@POST
	@Path("{method}/pic")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.AGENTACCESS, UserRight.ADMINACCESS })
	public JsonRet<?> addMainPic(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json, @PathParam("method") String method) {
		Integer agentId = null;
//		if (sessionService.currentUserType(request).intValue() == UserRight.ADMINACCESS.getValue()) {
//			String agent = request.getParameter("agentId");
//			if (agent == null) {
//				return JsonRet.buildRet(-96);
//			}
//			agentId = Integer.parseInt(agent);
//		} else {
			agentId = sessionService.currentUserId(request);
//		}
		if (method.equals("add")) {
			redisCacheManger.setValue(PIC_MAIN + agentId, json, Integer.MAX_VALUE);
			// JSONObject jsonObject = JSONObject.parseObject(json);
			// JSONArray jsonArray = jsonObject.getJSONArray("mainPic");
			// if(jsonArray!=null && jsonArray.size()!=0){
			// redisCacheManger.setValue(PIC_MAIN+agentId,
			// jsonArray.toJSONString(), Integer.MAX_VALUE);
			// }
			// JSONObject jsonObject2 =
			// jsonObject.getJSONObject("advertisement");
			// if(jsonObject2!=null){
			// redisCacheManger.setValue(ADWERT+agentId,
			// jsonObject2.toJSONString(), Integer.MAX_VALUE);
			// }
		} else if (method.equals("get")) {
			String carset = redisCacheManger.getValue(PIC_MAIN + agentId);
			if (carset == null) {
				carset = redisCacheManger.getValue(PIC_MAIN + 0);
				redisCacheManger.setValue(PIC_MAIN + agentId, carset, Integer.MAX_VALUE);
			}
			return JsonRet.buildSuccRet(carset);
		} else {
			return JsonRet.buildRet(-11);
		}
		return JsonRet.buildSuccRet(0);
	}

	@GET
	@Path("get/setting")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getSpecialSetting(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer agentId = sessionService.currentUserId(request);
		HuawuAgentStoreSetting setting = agentService.getAgentSetting(agentId);
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
		HuawuAgentStoreSetting mfoyouAgentStoreSetting11 = agentService.getAgentSetting(agentId);
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
		mfoyouAgentStoreSetting.setStorePhone(json2MfoyouMap.get("storePhone"));
		if (agentThirdPart != null) {
			int type = mfoyouAgentStoreSetting11.getStoreModelType();
			mfoyouAgentStoreSetting.setStoreModelType((agentThirdPart & 0x0f) | (type & 0xf0));
		}
		mfoyouAgentStoreSetting.setAgentId(agentId);
		int result = agentService.updateMfoyouAgentSetting(mfoyouAgentStoreSetting);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-11);
	}

	@POST
	@Path("postTypeInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> deleteTypeid(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		Integer agentid = sessionService.currentUserId(request);
		MfoyouAgentTypeInfo mfoyouAgentTypeInfo = new MfoyouAgentTypeInfo();
		mfoyouAgentTypeInfo.setStoreAgentId(agentid);
		mfoyouAgentTypeInfo.setTypeContent(json);
		int result = storeAgentservice.saveTypeInfo(mfoyouAgentTypeInfo);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
	}

	@GET
	@Path("getTypeInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getTypeInfo(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer agentid = sessionService.currentUserId(request);
		String agentTypeInfo = storeAgentservice.getAgentTypeInfo(agentid);
		return JsonRet.buildSuccRet(agentTypeInfo);
	}

	@GET
	@Path("getStoreTypeCount/{typeid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getStoreTypeCount(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("typeid") Integer typeid) {
		Integer agentid = sessionService.currentUserId(request);
		return JsonRet.buildSuccRet(storeAgentservice.getStoreTypeCount(agentid, typeid));
	}

	@POST
	@Path(value = "/configure/priceV2")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> priceV2(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		if (json == null)
			return JsonRet.buildRet(-99);
		MfoyouAgentServicePricev2 mfoyouAgentServicePricev2 = new MfoyouAgentServicePricev2();
		mfoyouAgentServicePricev2.setAgentId(sessionService.currentUserId(request));
		mfoyouAgentServicePricev2.setServicePrice(json);
		int result = storeAgentservice.applyMfoyouServiceV2(mfoyouAgentServicePricev2);
		return JsonRet.buildRet(result-1);
	}
	
	@GET
	@Path(value = "/getService/priceV2")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> getServicePriceV2(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		MfoyouAgentServicePricev2 mfoyouAgentServicePricev2 = storeAgentservice.getStoreServicePriceV2(sessionService.currentUserId(request),true);
		return JsonRet.buildSuccRet(mfoyouAgentServicePricev2);
	}

	@GET
	@Path(value = "newUserCount")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.AGENTACCESS)
	public JsonRet<?> newUserCount(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer result = storeAgentservice.getNewUserAmount(sessionService.currentUserId(request));
		return JsonRet.buildSuccRet(result);
	}
	@GET
	@Path(value = "storeinfo/{storeId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.ADMINACCESS, UserRight.AGENTACCESS, UserRight.STATIONMASTER })
	public JsonRet<?> myinfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("storeId") Integer storeId) {
		HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(storeId);
		if (mfoyouStoreInfo == null) {
			return JsonRet.buildRet(-98);
		} else {
			mfoyouStoreInfo.setStorestr(MfoyouEncrypt.enCode(mfoyouStoreInfo.getStoreId()));
			if(mfoyouStoreInfo.getStoreStationId()!=null){
				MfoyouStationMaster stationMasterByUserId = iIdentity.getStationMasterByUserId(mfoyouStoreInfo.getStoreStationId());
				if(stationMasterByUserId!=null){
					mfoyouStoreInfo.setStationName(stationMasterByUserId.getStationName());
				}
			}
			Map<String, Object> objectToMaps = ObjectToMappr.ObjectToMap(mfoyouStoreInfo);
//			objectToMaps.put("storeType",
//					storeAgentservice.getTypeName(mfoyouStoreInfo.getStoreType(), mfoyouStoreInfo.getStoreAgentId()));
			objectToMaps.put("agentStr", MfoyouEncrypt.enCode(mfoyouStoreInfo.getStoreAgentId()));
			return JsonRet.buildRet(0, objectToMaps);
		}
	}
	@POST
	@Path("modifystore")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.ADMINACCESS, UserRight.AGENTACCESS, UserRight.STATIONMASTER })
	public JsonRet<?> modifystore(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap json2MfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer storeid = json2MfoyouMap.getInteger("storeid");
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		if (storeid == null) {
			return JsonRet.buildRet(-96);
		}
		mfoyouStoreInfo.setStoreId(storeid);
		Integer storeState = json2MfoyouMap.getInteger("storeState");
		if (storeState != null) {
			mfoyouStoreInfo.setStoreOpenState(storeState);
		}
		Integer type = json2MfoyouMap.getInteger("storeType");
		if (type != null) {
			mfoyouStoreInfo.setStoreType(type);
		}
		String typeName = json2MfoyouMap.get("storeTypeName");
		if (typeName != null) {
			mfoyouStoreInfo.setStoreTypeName(typeName);
		}
		Integer tax = json2MfoyouMap.getInteger("tax");
		if (tax != null) {
			mfoyouStoreInfo.setStorePercentage(tax);
		}
		Integer currentstate = json2MfoyouMap.getInteger("currentstate");
		if (currentstate != null) {
			mfoyouStoreInfo.setStoreCurrentOpenState(currentstate);
		}
		Integer forbidden = json2MfoyouMap.getInteger("isforbidden");
		if (forbidden != null) {
			if (forbidden.intValue() == 1) {
				sessionService.logout(storeid, MfoyouUserType.store.getValue());
			}
			mfoyouStoreInfo.setStoreReject(forbidden);
		}
		Integer stationId = json2MfoyouMap.getInteger("stationId");
		if (stationId != null) {
			if (sessionService.currentUserType(request).intValue() != UserRight.STATIONMASTER.getValue()) {
				mfoyouStoreInfo.setStoreStationId(stationId);
			} else {
				return JsonRet.buildRet(-98);
			}
		}
		Integer allowModify = json2MfoyouMap.getInteger("allowModify");
		if (allowModify != null && (allowModify.intValue() == 1 || allowModify.intValue() == 0)) {
			HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeid);
			Integer storeAutoDispatch = storeInfo.getStoreAutoDispatch().intValue() & (~allowModify & 0x07);
			mfoyouStoreInfo.setStoreAutoDispatch(storeAutoDispatch & 0xfb | (allowModify << 2));
		}
		int updateStoreInfoById = storeService.updateStoreInfoById(storeid, mfoyouStoreInfo);
		return updateStoreInfoById == 0 ? JsonRet.buildRet(-50) : JsonRet.buildRet(0);
	}
	@GET
	@Path(value = "settlement/query")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> settlementQuery(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("dayCount") Integer dayCount) {
		if (dayCount < 3) {
			return JsonRet.buildRet(-11);
		}
		Integer userId = sessionService.currentUserId(request);
		int userType = 0;
		if(sessionService.currentUserType(request).intValue() == UserRight.STATIONMASTER.getValue()){
			userType = 1;
		}
		HashMap<String, Object> mfoyouOrderStatistics = goodOrderService.settlementQuery(userId, dayCount,userType);
		return JsonRet.buildSuccRet(mfoyouOrderStatistics);
	}
}
