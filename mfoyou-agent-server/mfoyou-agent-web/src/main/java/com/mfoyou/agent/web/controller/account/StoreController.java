package com.mfoyou.agent.web.controller.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreFreight;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreType;
import org.mfoyou.agent.common.entity.StoreTypeV1;
import org.mfoyou.agent.common.inf.IIdentity;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.json.Json2Object;
import org.mfoyou.agent.utils.map.ObjectToMappr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreActiveService;
import com.mfoyou.agent.web.service.account.StoreAgentService;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.common.FullcutActiveInfo;
import com.mfoyou.agent.web.utils.common.StoreActiveInfo;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Path("store")
@Service
public class StoreController {
	
	@Autowired
	SessionService sessionService;
	@Autowired
	StoreService   storeService;
	@Autowired
	IIdentity 	   iIdentity;
	@Autowired
	StoreAgentService storeAgentService; 
	@Autowired
	StoreActiveService storeActiveService;
	@Autowired
	RedisCacheManger redisCacheManger;
	private static final String STORE_CLOSE = "store:closelist";

	// 测试接口
	@POST
	@Path(value = "test")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> test(@Context HttpServletRequest request, @Context HttpServletResponse responsen) {
		return JsonRet.buildRet(-21);
	}

	// 申请店铺
	@POST
	@Path(value = "apply")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> apply(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
		String currentUserPhone = sessionService.currentUserPhone(request);
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String address = mfoyouMap.get("address");
		String city = mfoyouMap.get("city");
		String county = mfoyouMap.get("country");
		Double lon = mfoyouMap.getDouble("lon");
		Double lat = mfoyouMap.getDouble("lat");
		String name = mfoyouMap.get("name");
		String phone = mfoyouMap.get("phone");
		String province = mfoyouMap.get("province");
		Integer type = mfoyouMap.getInteger("type");
		String typeName = mfoyouMap.get("typeName");
		String logo = mfoyouMap.get("logo");
		Integer agentId = mfoyouMap.getInteger("agentId");
		if (city == null || phone == null || address == null) {
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(storeId);
		if (mfoyouStoreInfo != null) {
			return JsonRet.buildRet(-70);
		}
		mfoyouStoreInfo = new HuawuStoreInfo();
		mfoyouStoreInfo.setStoreAuditState(mfoyouMap.getInteger("audit")==null?0:-1);
		mfoyouStoreInfo.setStoreAddress(address);
		mfoyouStoreInfo.setStoreTypeName(typeName);
		mfoyouStoreInfo.setStoreCity(city);
		//以前的字段没用，用来存cityCode
		mfoyouStoreInfo.setStoreId(storeId);
		mfoyouStoreInfo.setStoreCounty(county);
		mfoyouStoreInfo.setStoreLogo(logo);
		mfoyouStoreInfo.setStoreLocalLat(lat);
		mfoyouStoreInfo.setStoreLocalLon(lon);
		mfoyouStoreInfo.setStoreProvince(province);
		mfoyouStoreInfo.setStoreName(name);
		mfoyouStoreInfo.setStoreType(type);
		mfoyouStoreInfo.setStorePhone(phone);
		mfoyouStoreInfo.setStoreLoginNumber(currentUserPhone);
		mfoyouStoreInfo.setStoreAgentId(agentId);
		if(typeName!=null  && agentId!=null){
			Integer percent = storeAgentService.getPercentByTypeName(typeName, agentId);
			mfoyouStoreInfo.setStorePercentage(percent);
		}
		int addStoreInfo = storeService.addStoreInfo(mfoyouStoreInfo);
		if (addStoreInfo == 1) {
			return JsonRet.buildRet(0);
		}
		return JsonRet.buildRet(-96);
	}

	@GET
	@Path(value = "myinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> myinfo(@Context HttpServletRequest request, @Context HttpServletResponse response,@QueryParam("model")Integer model) {
		Integer currentUserId = sessionService.currentUserId(request);
		HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(currentUserId);
		if (mfoyouStoreInfo == null) {
			return JsonRet.buildRet(-98);
		} else {
			Map<String, Object> objectToMaps = ObjectToMappr.ObjectToMap(mfoyouStoreInfo);
			Integer storeAgentId = mfoyouStoreInfo.getStoreAgentId();
			if (storeAgentId != null) {
				HuawuAgentStoreSetting specialSettingV1 = iIdentity.getSpecialSettingV1(storeAgentId);
				if (specialSettingV1 != null) {
					objectToMaps.put("storePower", specialSettingV1.getStoreModelType());
				}
			}
			objectToMaps.put("storeType", storeService.getTypeByid(mfoyouStoreInfo.getStoreType()));
			objectToMaps.put("openinfos", storeService.getMfoyouStoreOpenByStoreId(currentUserId));
			return JsonRet.buildRet(0, objectToMaps);
		}
	}

	@POST
	@Path(value = "modify/myinfo/{path}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> nameModify(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("path") String path, String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		HuawuStoreInfo storeInfo = new HuawuStoreInfo();
		Integer storeId = sessionService.currentUserId(request);
		if (path.equals("name")) {
			String name = mfoyouMap.get("name");
			if (name == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreName(name);
		} else if (path.equals("city")) {
			String province = mfoyouMap.get("province");
			String city = mfoyouMap.get("city");
			String country = mfoyouMap.get("country");
			if (province == null || city == null || country == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreCounty(country);
			storeInfo.setStoreProvince(province);
			storeInfo.setStoreCity(city);
		} else if (path.equals("address")) {
			String address = mfoyouMap.get("address");
			Double lon = mfoyouMap.getDouble("lon");
			Double lat = mfoyouMap.getDouble("lat");
			if (address == null || lon == null || lat == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreLocalLon(lon);
			storeInfo.setStoreLocalLat(lat);
			storeInfo.setStoreAddress(address);
		} else if (path.equals("phone")) {
			String phone = mfoyouMap.get("phone");
			if (phone == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStorePhone(phone);
		} else if (path.equals("type")) {
			Integer type = mfoyouMap.getInteger("type");
			if (type == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreType(type);
		} else if (path.equals("isMfoyouSend")) {
			HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(storeId);
			Integer isMfoyouSend = mfoyouMap.getInteger("isMfoyouSend");
			if (isMfoyouSend == null) {
				return JsonRet.buildRet(-98);
			}
			if ((mfoyouStoreInfo.getStoreAutoDispatch() >> 2 & 1) == 1) {
				return JsonRet.buildRet(-102);
			}
			storeInfo.setStoreAutoDispatch(mfoyouStoreInfo.getStoreAutoDispatch() & 0xfe | isMfoyouSend);
		} else if (path.equals("openstate")) {
			Integer openstate = mfoyouMap.getInteger("openstate");
			if (openstate == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreCurrentOpenState(openstate);
			if (openstate.intValue() == -1) {
				storeInfo.setStoreCurrentOpenState(0);
			}
		} else if (path.equals("logo")) {
			String logo = mfoyouMap.get("logo");
			if (logo == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreLogo(logo);
		} else if (path.equals("autoReceipt")) {
			Integer isauto = mfoyouMap.getInteger("autoReceipt");
			if (isauto == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreAutoReceipt(isauto);
		} else if (path.equals("freeAmount")) {
			Integer isFreeAmount = mfoyouMap.getInteger("isFreeAmount");
			if (isFreeAmount == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreFreeFreightAmount(isFreeAmount);
		} else if (path.equals("notice")) {
			String notice = mfoyouMap.get("notice");
			if (notice == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreNotice(notice);
		} else if (path.equals("showLev")) {
			Integer storeLeve = mfoyouMap.getInteger("showLev");
			if (storeLeve == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreLeve(storeLeve);
		} else if (path.equals("banner")) {
			String banner = mfoyouMap.get("banner");
			if (banner == null) {
				return JsonRet.buildRet(-98);
			}
			storeInfo.setStoreBanner(banner);
		} else {
			return JsonRet.buildRet(-404);
		}
		return storeService.updateStoreInfoById(storeId, storeInfo) == 1 ? JsonRet.buildSuccRet(mfoyouMap)
				: JsonRet.buildRet(-24);
	}

	@POST
	@Path(value = "modify/allmyinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifyallmyinfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			 String json) {
		JSONObject jsonObject = JSONObject.parseObject(json);
		HuawuStoreInfo storeInfo = new HuawuStoreInfo();
		Integer storeId = sessionService.currentUserId(request);
		storeInfo.setStoreName(jsonObject.getString("name"));
		storeInfo.setStoreCounty(jsonObject.getString("country"));
		storeInfo.setStoreProvince(jsonObject.getString("province"));
		storeInfo.setStoreCity(jsonObject.getString("city"));
		storeInfo.setStoreLocalLon(jsonObject.getDouble("lon"));
		storeInfo.setStoreLocalLat(jsonObject.getDouble("lat"));
		storeInfo.setStoreAddress(jsonObject.getString("address"));
		storeInfo.setStorePhone(jsonObject.getString("phone"));
		storeInfo.setStoreLogo(jsonObject.getString("logo"));
		storeInfo.setStorePics(jsonObject.getString("pics"));
		storeInfo.setStoreBanner(jsonObject.getString("banner"));
		storeInfo.setStoreNotice(jsonObject.getString("notice"));
		storeInfo.setStoreAutoReceipt(jsonObject.getInteger("autoReceipt"));
		storeInfo.setStoreMinGoodsAmount(jsonObject.getInteger("minGoodsAmount"));
		storeInfo.setStoreFreeFreightAmount(jsonObject.getInteger("storeFreeFreightAmount"));
		Integer sends = jsonObject.getInteger("isMfoyouSend");
		if(sends!=null){
			HuawuStoreInfo mfoyouStoreInfo = storeService.getStoreInfo(storeId);
			storeInfo.setStoreAutoDispatch(mfoyouStoreInfo.getStoreAutoDispatch() & 0xfe | sends);
		}
		JSONArray jsonArray = jsonObject.getJSONArray("openInfos");
		if(jsonArray!=null){
			List<MfoyouStoreOpen> mfoyouStoreOpens = new ArrayList<>();
			for(int i = 0 ;i< jsonArray.size();i++){
				MfoyouStoreOpen mfoyouStoreOpen = new MfoyouStoreOpen();
				mfoyouStoreOpen.setStoreId(storeId);
				mfoyouStoreOpen.setOpenStartTime(jsonArray.getJSONObject(i).getInteger("startTime"));
				mfoyouStoreOpen.setOpenEndTime(jsonArray.getJSONObject(i).getInteger("endtime"));
				mfoyouStoreOpens.add(mfoyouStoreOpen);
			}
			storeInfo.setOpens(mfoyouStoreOpens);
		}
		JSONArray jsonArrayFright = jsonObject.getJSONArray("distanceInfos");
		if(jsonArrayFright!=null){
			List<MfoyouStoreFreight> mfoyouStoreFreights = new ArrayList<>();
			for(int i = 0 ;i< jsonArrayFright.size();i++){
				MfoyouStoreFreight mfoyouStoreFreight = new MfoyouStoreFreight();
				mfoyouStoreFreight.setStoreId(storeId);
				mfoyouStoreFreight.setFreightMaxDistance(jsonArrayFright.getJSONObject(i).getInteger("distance"));
				mfoyouStoreFreight.setFreightPrice(jsonArrayFright.getJSONObject(i).getInteger("price"));
				mfoyouStoreFreights.add(mfoyouStoreFreight);
			}
			storeService.modifyFrigths(storeId,mfoyouStoreFreights);
		}
		return storeService.updateStoreInfoById(storeId, storeInfo) == 1 ? JsonRet.buildSuccRet(jsonObject)
				: JsonRet.buildRet(-24);
	}

	@GET
	@Path(value = "openInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getOpenStat(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer id = sessionService.currentUserId(request);
		List<MfoyouStoreOpen> storeOpens = storeService.getMfoyouStoreOpenByStoreId(id);
		return JsonRet.buildSuccRet(storeOpens);
	}
//
	@POST
	@Path(value = "modify/expressfee")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getOpenfee(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		Integer id = sessionService.currentUserId(request);
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer isexpree = mfoyouMap.getInteger("isNeedPayExpree");
		Integer expressFee = mfoyouMap.getInteger("expressFee");
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		mfoyouStoreInfo.setStoreId(id);
		mfoyouStoreInfo.setStoreFreeFreightAmount(isexpree);
		mfoyouStoreInfo.setStoreBasicFreight(expressFee);
		int updateStoreInfoById = storeService.updateStoreInfoById(id, mfoyouStoreInfo);
		return JsonRet.buildRet(updateStoreInfoById - 1);
	}
//
	// 更改简介
	@POST
	@Path(value = "modify/summary")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifySumary(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		Integer id = sessionService.currentUserId(request);
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String summary = mfoyouMap.get("summary");
		String pics = mfoyouMap.get("pics");
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		mfoyouStoreInfo.setStoreId(id);
		mfoyouStoreInfo.setStoreSummary(summary);
		mfoyouStoreInfo.setStorePics(pics);
		int updateStoreInfoById = storeService.updateStoreInfoById(id, mfoyouStoreInfo);
		return JsonRet.buildRet(updateStoreInfoById - 1);
	}
//
//	//
	@POST
	@Path(value = "modify/openinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifyInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer effect = mfoyouMap.getInteger("isEffect");
		Integer startTime = mfoyouMap.getInteger("startTime");
		Integer endTime = mfoyouMap.getInteger("endTime");
		Integer openId = mfoyouMap.getInteger("openId");
		if (startTime != null && endTime != null && startTime > endTime || openId == null) {
			return JsonRet.buildFailRet("-22");
		}
		String reg = "^([01][0-9]|2[0-3])[0-5][0-9]$";
		Pattern pattern = Pattern.compile(reg);
		if (!pattern.matcher(String.format("%04d", startTime)).matches()
				|| !pattern.matcher(String.format("%04d", endTime)).matches()) {
			return JsonRet.buildFailRet("-23");
		}
		Integer storeId = sessionService.currentUserId(request);
		MfoyouStoreOpen open = new MfoyouStoreOpen();
		open.setStoreId(storeId);
		open.setOpenStartTime(startTime);
		open.setOpenEndTime(endTime);
		open.setOpenId(openId);
		open.setOpenEffect(effect);
		int result = storeService.updateOpenInfoByStoreId(open);
		return result == -1 ? JsonRet.buildRet(-72) : result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1);
	}

	@POST
	@Path(value = "add/openinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addInfo(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer startTime = mfoyouMap.getInteger("startTime");
		Integer endTime = mfoyouMap.getInteger("endTime");
		if (startTime > endTime) {
			return JsonRet.buildFailRet("-23");
		}
		String reg = "^([01][0-9]|2[0-3])[0-5][0-9]$";
		Pattern pattern = Pattern.compile(reg);
		if (!pattern.matcher(String.format("%04d", startTime)).matches()
				|| !pattern.matcher(String.format("%04d", endTime)).matches()) {
			return JsonRet.buildFailRet("-23");
		}
		Integer storeId = sessionService.currentUserId(request);
		int result = storeService.addStoreOpenInfo(storeId, startTime, endTime);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1);
	}
//
	@POST
	@Path(value = "del/openinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> deleteOpenInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer openId = mfoyouMap.getInteger("openId");
		if (openId == null) {
			return JsonRet.buildFailRet("-96");
		}
		Integer storeId = sessionService.currentUserId(request);
		int result = storeService.delOpenInfo(storeId, openId);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1);
	}
//
	@POST
	@Path(value = "modifybaseprice")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifyBaseFreightInfo(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer basePrice = mfoyouMap.getInteger("basePrice");
		Integer freePrice = mfoyouMap.getInteger("freePrice");
		if (basePrice == null || freePrice == null) {
			return JsonRet.buildFailRet("-96");
		}
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo mfoyouStoreInfo = new HuawuStoreInfo();
		mfoyouStoreInfo.setStoreFreeFreightAmount(freePrice);
		mfoyouStoreInfo.setStoreMinGoodsAmount(basePrice);
		int result = storeService.updateStoreInfoById(storeId, mfoyouStoreInfo);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-1);
	}
//
	@GET
	@Path(value = "get/type/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> getTypeById(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("id") Integer id) {
		StoreTypeV1 storeType = storeService.getTypeByid(id);
		return JsonRet.buildSuccRet(storeType);
	}

	@GET
	@Path(value = "get/typeList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> getTypeList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("type") Integer type, @QueryParam("agentStr") String agentStr,@QueryParam("agentId")Integer agentid) {
		if(agentid==null){
			agentid = MfoyouEncrypt.decode(agentStr);
		}
		if (agentid != null) {
			String json = storeAgentService.getAgentTypeInfo(agentid);
			if (json != null && !json.equals("null")) {
				return JsonRet.buildSuccRet(json);
			}
		}
		return JsonRet.buildSuccRet(storeService.getStoreTypeList(type));
	}

	@GET
	@Path(value = "get/freightList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getfreightList(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeId = sessionService.currentUserId(request);
		List<MfoyouStoreFreight> freights = storeService.getfreightList(storeId);
		return JsonRet.buildSuccRet(freights);
	}

	@GET
	@Path(value = "del/freightList/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> deletefreight(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("id") Integer frightid) {
		Integer storeId = sessionService.currentUserId(request);
		int result = storeService.deletefreight(frightid, storeId);
		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
	}

	@POST
	@Path(value = "update/freightList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> updatefreight(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer maxdistance = mfoyouMap.getInteger("maxdistance");
		Integer mindistance = mfoyouMap.getInteger("mindistance");
		Integer price = mfoyouMap.getInteger("price");
		Integer freightId = mfoyouMap.getInteger("freightId");
		if (price == null || maxdistance == null || freightId == null) {
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		MfoyouStoreFreight fright = new MfoyouStoreFreight();
		fright.setFreightMaxDistance(maxdistance);
		fright.setFreightMinDistance(mindistance);
		fright.setFreightPrice(price);
		fright.setFreightId(freightId);
		fright.setStoreId(storeId);
		int result = storeService.updateFreight(fright);
		return result == 1 ? JsonRet.buildSuccRet(null) : JsonRet.buildRet(-50);
	}

	@POST
	@Path(value = "add/freightList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addfreight(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer maxdistance = mfoyouMap.getInteger("maxdistance");
		Integer mindistance = mfoyouMap.getInteger("mindistance");
		Integer price = mfoyouMap.getInteger("price");
		if (price == null || maxdistance == null) {
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		MfoyouStoreFreight fright = new MfoyouStoreFreight();
		fright.setFreightMaxDistance(maxdistance);
		fright.setFreightMinDistance(mindistance);
		fright.setFreightPrice(price);
		fright.setStoreId(storeId);
		int result = storeService.addFright(fright);
		fright.setFreightId(result);
		return result == -1 ? JsonRet.buildRet(-50) : JsonRet.buildSuccRet(fright);
	}
	/**
	 * 更新新版的配送规则
	 * @param request
	 * @param json
	 * @return
	 */
	@POST
	@Path(value = "update/dispatchInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.STOREACCESS,UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> updateDispatchInfo(@Context HttpServletRequest request,String json) {
		MfoyouStoreDispatch mfoyouStoreDispatch = JSON.parseObject(json, MfoyouStoreDispatch.class);
		if(mfoyouStoreDispatch==null || mfoyouStoreDispatch.getCurrentType()==null){
			return JsonRet.buildRet(-96);
		}
		if(sessionService.currentUserType(request)==UserRight.AGENTACCESS.getValue()){
			if(mfoyouStoreDispatch.getStoreId()==null){
				return JsonRet.buildRet(-96);
			}
		}else if(sessionService.currentUserType(request)==UserRight.STATIONMASTER.getValue()){
			if(mfoyouStoreDispatch.getStoreId()==null){
				return JsonRet.buildRet(-96);
			}
		}else{
			Integer storeId = sessionService.currentUserId(request);
			mfoyouStoreDispatch.setStoreId(storeId);
		}
		return JsonRet.buildRet(storeService.updateDispatch(mfoyouStoreDispatch)-1);
	}
	/**
	 * 获取新版的配送规则
	 * @param request
	 * @return
	 */
	@GET
	@Path(value = "get/dispatchInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({UserRight.STOREACCESS,UserRight.AGENTACCESS,UserRight.STATIONMASTER})
	public JsonRet<?> getDispatchInfo(@Context HttpServletRequest request,@QueryParam("storeId")Integer storeId) {
		if(sessionService.currentUserType(request)==UserRight.STOREACCESS.getValue()){
			storeId = sessionService.currentUserId(request);
		}else{
			if(storeId==null){
				return JsonRet.buildRet(-96);
			}
		}
		MfoyouStoreDispatch dispatch = storeService.getDispatch(storeId);
		if(dispatch!=null){
			HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
			if(storeInfo.getStoreStationId()!=null){
				dispatch.setStationName(iIdentity.getStationMasterByUserId(storeInfo.getStoreStationId()).getStationName());
			}
		}
		return JsonRet.buildSuccRet(dispatch);
	}
	@POST
	@Path(value = "delay/{second}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> delayClose(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("second") Integer second) {
		Integer storeId = sessionService.currentUserId(request);
		Long timeStamp = System.currentTimeMillis() + second * 1000;
		Map<String, Number> map = new HashMap<>();
		map.put("storeId", storeId);
		map.put("timeStamp", timeStamp);
		String json = JSON.toJSONString(map);
		redisCacheManger.pushRList(STORE_CLOSE, json);
		return JsonRet.buildRet(0);
	}

//	@POST
//	@Path(value = "auth/company")
//	@Produces("application/json;charset=UTF-8")
//	@UrlRight(UserRight.STOREACCESS)
//	public JsonRet<?> companyAuto(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			String json) {
//		MfoyouStoreEnterpriseAuth enterpriseAuth = JSON.parseObject(json, MfoyouStoreEnterpriseAuth.class);
//		enterpriseAuth.setAuthId(null);
//		enterpriseAuth.setAuthState(null);
//		enterpriseAuth.setStoreId(sessionService.currentUserId(request));
//		int result = storeService.authCompany(enterpriseAuth);
//		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
//	}
//
//	@POST
//	@Path(value = "auth/person")
//	@Produces("application/json;charset=UTF-8")
//	@UrlRight(UserRight.STOREACCESS)
//	public JsonRet<?> personAuth(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			String json) {
//		Integer storeId = sessionService.currentUserId(request);
//		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
//		String name = mfoyouMap.get("name");
//		String idCard = mfoyouMap.get("idcard");
//		String face = mfoyouMap.get("face");
//		String back = mfoyouMap.get("back");
//		String handle = mfoyouMap.get("handle");
//		MfoyouStorePersonAuth personAuth = new MfoyouStorePersonAuth();
//		personAuth.setName(name);
//		personAuth.setStoreId(storeId);
//		personAuth.setIdCardNumber(idCard);
//		personAuth.setFacePhoto(face);
//		personAuth.setBackPhoto(back);
//		personAuth.setHandlePhoto(handle);
//		int result = storeService.authPerson(personAuth);
//		return result == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
//	}
//
	@GET
	@Path(value = "gettaxByTypeId/{typeid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> gettaxByTypeId(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("typeid") Integer typeid) {
		MfoyouStoreType type = storeService.gettaxByTypeId(typeid);
		return JsonRet.buildSuccRet(type);
	}

//	@GET
//	@Path(value = "stick/{typeid}")
//	@Produces("application/json;charset=UTF-8")
//	@UrlRight(UserRight.STOREACCESS)
//	public JsonRet<?> sticktype(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			@PathParam("typeid") Integer typeid) {
//		Integer storeId = sessionService.currentUserId(request);
//		MfoyouGoodsType mfoyouGoodsType = new MfoyouGoodsType();
//		mfoyouGoodsType.setTypeTop(1);
//		mfoyouGoodsType.setTypeSortValue(System.currentTimeMillis());
//		int updateType = goodsSvc.updateType(mfoyouGoodsType, storeId, typeid);
//		return updateType == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
//	}

//	@GET
//	@Path(value = "unstick/{typeid}")
//	@Produces("application/json;charset=UTF-8")
//	@UrlRight(UserRight.STOREACCESS)
//	public JsonRet<?> unsticktype(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			@PathParam("typeid") Integer typeid) {
//		Integer storeId = sessionService.currentUserId(request);
//		MfoyouGoodsType mfoyouGoodsType = new MfoyouGoodsType();
//		mfoyouGoodsType.setTypeTop(0);
//		int updateType = goodsSvc.updateType(mfoyouGoodsType, storeId, typeid);
//		return updateType == 1 ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
//	}
//
//	@GET
//	@Path(value = "taxClose")
//	@Produces("application/json;charset=UTF-8")
//	@UrlRight(UserRight.ALLACCESS)
//	public JsonRet<?> taxClose(@Context HttpServletRequest request) {
//		String taxIsClose = redisCacheManger.getValue("taxIsclose");
//		taxIsClose = taxIsClose == null ? "0" : taxIsClose;
//		HashMap<String, String> taxmap = new HashMap<>();
//		taxmap.put("taxIsclose", taxIsClose);
//		return JsonRet.buildSuccRet(taxmap);
//	}
//
	@GET
	@Path(value = "activity")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getActivity(@Context HttpServletRequest request) {
		Integer storeId = sessionService.currentUserId(request);
		MfoyouStoreActive storeActive = storeActiveService.getMfoyouStoreActive(storeId);
		return JsonRet.buildSuccRet(storeActive);
	}

	@POST
	@Path(value = "modifyactivity")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifyActivity(@Context HttpServletRequest request, String json) {
		Integer storeId = sessionService.currentUserId(request);
		JSONObject parseObject = JSONObject.parseObject(json);
		StoreActiveInfo mfoyouStoreActive = new StoreActiveInfo();
		mfoyouStoreActive.setStoreId(storeId);
		Integer isReduceFirst = parseObject.getInteger("isReduceFirst");
		if (isReduceFirst != null) {
			mfoyouStoreActive.setNewUserActiveState(isReduceFirst);
		}
		Integer reduceMoney = parseObject.getInteger("reduceMoney");
		if (reduceMoney != null) {
			mfoyouStoreActive.setNewUserReductionAmount(reduceMoney);
		}
		Integer fullReduce = parseObject.getInteger("fullreduce");
		if (fullReduce != null) {
			mfoyouStoreActive.setFullcutActiveState(fullReduce);
		}
		JSONArray fullreducecontent = parseObject.getJSONArray("fullreduceList");
		if (fullreducecontent != null) {
			ArrayList<FullcutActiveInfo> arrayList = new ArrayList<>();
			for (int i = 0; i < fullreducecontent.size(); i++) {
				FullcutActiveInfo fullcutActiveInfo = fullreducecontent.getJSONObject(i)
						.toJavaObject(FullcutActiveInfo.class);
				arrayList.add(fullcutActiveInfo);
			}
			mfoyouStoreActive.setFullcutAmountDescribe(JSON.toJSONString(arrayList));
		}
		Boolean mdfStoreActive = storeActiveService.mdfStoreActive(mfoyouStoreActive);
		return mdfStoreActive ? JsonRet.buildRet(0) : JsonRet.buildRet(-50);
	}

}
