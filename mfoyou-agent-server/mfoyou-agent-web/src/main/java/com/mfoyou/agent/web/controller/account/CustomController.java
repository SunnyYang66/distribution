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

import org.mfoyou.agent.common.dao.domain.HuawuAgentStoreSetting;
import org.mfoyou.agent.common.dao.domain.HuawuEvaluate;
import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuServicePrice;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderCart;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.common.entity.enums.OrderState;
import org.mfoyou.agent.common.inf.IGoods;
import org.mfoyou.agent.common.inf.IStatistics;
import org.mfoyou.agent.common.inf.IStore;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.DateUtils;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.common.ObjectUtil;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.AgentService;
import com.mfoyou.agent.web.service.account.GoodsService;
import com.mfoyou.agent.web.service.common.CustomService;
import com.mfoyou.agent.web.service.order.ServiceOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.common.StoreDispatchUtil;
import com.mfoyou.agent.web.utils.network.WebUtils;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Path("customer")
@Service
public class CustomController {
	@Autowired
	SessionService sessionService;
	@Autowired
	ServiceOrderService orderService;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	AgentService agentService;
	@Autowired
	IGoods iGoods;
	@Autowired
	GoodsService goodsService;
	@Autowired
	IStore iStore;
	@Autowired
	IStatistics iStatistics;
	@Autowired
	CustomService customService;
	Logger logger = Logger.getLogger(CustomController.class);
    public static final String PIC_MAIN = "main:carousel:";
    public static final String LABEL_MAIN  = "agent:type:info:";
	@POST
	@Path("finsh/all/{orderId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> finshUpate(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("orderId") Integer orderId) throws ParseException {
		HuawuServiceOrder oldOrder = new HuawuServiceOrder();
		oldOrder.setServiceOrderId(orderId);
		oldOrder.setServiceOrderState(OrderState.emServiceRunerFinsh.getValue());
		oldOrder.setServiceOrderSendUser(sessionService.currentUserId(request));
		HuawuServiceOrder newOrder = new HuawuServiceOrder();
		newOrder.setServiceOrderState(OrderState.emServiceUserFinsh.getValue());
		Boolean bRet = orderService.updateServiceOrderState(oldOrder, newOrder, sessionService.currentUserId(request));
		if (bRet) {
			// finshOrder(orderService.getServiceOrderInfo(orderId));
			// OrderComonOp.finshOrderV1(orderService.getServiceOrderInfo(orderId),
			// iStaffUser, iOrder, iPayment);
			return JsonRet.buildRet(0, bRet);
		}
		return JsonRet.buildRet(-95);
	}

	@GET
	@Path("Evaluate/list")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> getOrderEvaluateList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
			@QueryParam("minScore") Integer minScore, @QueryParam("maxScore") Integer maxScore,
			@QueryParam("agentId") Integer agentId, @QueryParam("orderType") Integer orderType,
			@QueryParam("runerId") Integer runerId) {
		String start = request.getParameter("startDate");
		String end = request.getParameter("endDate");
		Date startDate = start == null ? null : DateUtils.parse(start);
		Date endDate = end == null ? null : DateUtils.parse(end);
		HuawuEvaluate mfoyouEvaluate = new HuawuEvaluate();
		mfoyouEvaluate.setAgentId(agentId);
		mfoyouEvaluate.setCustomerId(sessionService.currentUserId(request));
		mfoyouEvaluate.setOrderType(orderType);
		mfoyouEvaluate.setWorkerId(runerId);
		ArrayListObject<HuawuEvaluate> listObject = orderService.getEvaluate(mfoyouEvaluate, pageId, pageSize,
				startDate, endDate, minScore, maxScore);
		if (listObject != null) {
			return JsonRet.buildSuccRet(listObject);
		}
		return JsonRet.buildRet(-97);
	}

	@GET
	@Path("runer/posInfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.LOGINACCESS)
	public JsonRet<?> getOrderEvaluateList(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("runerId") Integer runerId) {
		if (runerId == null) {
			return JsonRet.buildRet(-96);
		}
		Map<String, String> map = redisCacheManger.getMapValue("u:" + runerId);
		if (map != null && map.size() > 1) {
			return JsonRet.buildSuccRet(map);
		}
		return JsonRet.buildRet(-97);
	}
	@GET
    @Path("get/serviceTag")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getServiceTag(@Context HttpServletRequest request,@Context HttpServletResponse response,@QueryParam("agentstr")String agentstr) {
    	Integer agentId = MfoyouEncrypt.decode(agentstr);
    	if(agentId==null){
    		return JsonRet.buildRet(-96);
    	}
    	HuawuServicePrice configurePrice = agentService.getConfigurePrice(agentId,false);
    	return JsonRet.buildSuccRet(configurePrice);
    }
	
	@GET
    @Path("shopCart/goodsList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> shopCartList(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        return JsonRet.buildRet(0, iGoods.getMfoyouGoodsOrderCartList(sessionService.currentUserId(request)));
    }

    @GET
    @Path("shopCart/goodsMoreList")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> goodsMoreList(@Context HttpServletRequest request, @Context HttpServletResponse response, @QueryParam("lon") Double lon, @QueryParam("lat") Double lat) {
    	return JsonRet.buildRet(0, goodsService.getGoodsOrderCartDetailedInformation(sessionService.currentUserId(request), lon, lat));
    }

    @POST
    @Path("shopCart/addGoods")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> addGoods(@Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouGoodsOrderCart mfoyouGoodsOrderCart = Json2Object.json2Object(json, MfoyouGoodsOrderCart.class);
        mfoyouGoodsOrderCart.setCartItmeId(null);
        if(mfoyouGoodsOrderCart.getStoreStr()!=null){
        	 mfoyouGoodsOrderCart.setStoreId(MfoyouEncrypt.decode(mfoyouGoodsOrderCart.getStoreStr()));
        }
        ObjectUtil.checkInputValue(mfoyouGoodsOrderCart.getGoodsId(), mfoyouGoodsOrderCart.getStoreId());
        mfoyouGoodsOrderCart.setUserId(sessionService.currentUserId(request));
        Integer id = iGoods.addMfoyouGoodsOrderCartItem(mfoyouGoodsOrderCart);
        if (id == null) {
            return JsonRet.buildRet(-1);
        } else {
            return JsonRet.buildRet(0, id);
        }
    }

    @POST
    @Path("shopCart/delGoods/{itemId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> delGoods(@PathParam("itemId") Integer itemId, @Context HttpServletRequest request, @Context HttpServletResponse response) {
        Boolean ret = iGoods.delMfoyouGoodsOrderCartItme(itemId);
        if (ret) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }
    @POST
    @Path("shopCart/delAllGoods")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> delAllGoods( @Context HttpServletRequest request, @Context HttpServletResponse response) {

        Boolean ret = iGoods.delAllMfoyouGoodsOrderCart(sessionService.currentUserId(request),null);
        if (ret) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }

    }

    @POST
    @Path("shopCart/modifyGoods/{itemId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> modifyGoods(@PathParam("itemId") Integer itemId, @Context HttpServletRequest request, @Context HttpServletResponse response, String json) {
        MfoyouGoodsOrderCart mfoyouGoodsOrderCart = Json2Object.json2Object(json, MfoyouGoodsOrderCart.class);
        MfoyouGoodsOrderCart save = new MfoyouGoodsOrderCart();
        save.setCartItmeId(itemId);
        save.setItemNumber(mfoyouGoodsOrderCart.getItemNumber());
        save.setItemSelect(mfoyouGoodsOrderCart.getItemSelect());
        save.setItemUserNonte(mfoyouGoodsOrderCart.getItemUserNonte());
        Boolean ret = iGoods.ModeifyMfoyouGoodsOrderCartItme(save);
        if (ret) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @POST
    @Path("shopCart/store/{storeId}/{selectState}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.LOGINACCESS)
    public JsonRet<?> storeselectState(@PathParam("storeId") Integer storeId, @PathParam("selectState") Integer selectState, @Context HttpServletRequest request,
                                       @Context HttpServletResponse response) {
        Boolean ret = iGoods.selectMfoyouGoodsOrderCartStore(sessionService.currentUserId(request), storeId == 0 ? null : storeId, selectState);
        if (ret) {
            return JsonRet.buildRet(0);
        } else {
            return JsonRet.buildRet(-1);
        }
    }

    @GET
    @Path("search/storeGoods/{storeId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> searchStoreGoods(@QueryParam("key") String key, @PathParam("storeId") String  storeStr, @QueryParam("pageId") Integer pageId, @QueryParam("pageSize") Integer pageSize,
                                       @Context HttpServletRequest request, @Context HttpServletResponse response) {
       if(key == null || key.length() < 1){
           return JsonRet.buildRet(-96);
       }
       int storeId = MfoyouEncrypt.decode(storeStr);
       if(storeId < 0){
    	   return JsonRet.buildRet(-11);
       }
       return JsonRet.buildRet(0, goodsService.searchGoodsByStore(storeId, key, pageId, pageSize));
    }

    @GET
    @Path("search/store")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> searchStore(@QueryParam("key") String key, @QueryParam("pageId") Integer pageId, 
    		@QueryParam("pageSize") Integer pageSize, @Context HttpServletRequest request,
    		@QueryParam("lon") Double lon,@QueryParam("lat") Double lat, @QueryParam("agentStr")String agentStr,
    		 @Context HttpServletResponse response) {
        if(key == null || key.length() < 1){
            return JsonRet.buildRet(-96);
        }
        if(lon==null  || lat==null){
        	lon = sessionService.currentUserlon(request);
        	lat = sessionService.currentUserlat(request);
        }
        Integer agentid = null;
    	if(agentStr!=null){
    		agentid = MfoyouEncrypt.decode(agentStr);
    	}else{
    		agentid = sessionService.currentUserAgentId(request);
    	}
        return JsonRet.buildRet(0, goodsService.searchStore(key, pageId, pageSize,lat,lon,agentid));
    }
    @POST
    @Path("store/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> storeList(@Context HttpServletRequest request,
            @Context HttpServletResponse response,String json){
    	MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
    	HuawuStoreInfo storeInfo = new HuawuStoreInfo();
    	Double lon = mfoyouMap.getDouble("lon");
    	Double lat = mfoyouMap.getDouble("lat");
    	if(lon==null || lat == null){
    		lon=sessionService.currentUserlon(request);
    		lat=sessionService.currentUserlat(request);
    	}
    	storeInfo.setStoreLocalLon(lon);
    	storeInfo.setStoreLocalLat(lat);
    	String agentStr = mfoyouMap.get("agentStr");
    	if(agentStr==null || agentStr.trim().length()!=6){
    		return JsonRet.buildRet(-96);
    	}
    	Integer agentId = MfoyouEncrypt.decode(agentStr);
    	storeInfo.setStoreAgentId(agentId);
    	String typename = mfoyouMap.get("typeName");
    	ArrayList<String> types = null;
    	if(typename!=null){
    		types = agentService.getTypeList(typename,agentId);
        	logger.info(JSON.toJSONString(types));
    	}
    	String name = mfoyouMap.get("name");
    	storeInfo.setStoreName(name);
    	Integer pageId = mfoyouMap.getInteger("pageId");
    	Integer pageSize = mfoyouMap.getInteger("pageSize");
    	ArrayListObject<HuawuStoreInfo> infos = iStore.getnearStoreInfos(storeInfo,pageId,pageSize,types);
    	for(HuawuStoreInfo huawuStoreInfo : infos ){
    		huawuStoreInfo.setStorestr(MfoyouEncrypt.enCode(huawuStoreInfo.getStoreId()));
    	}
    	return JsonRet.buildRet(0, ListObject.BulidListObject(infos));
    }
    
    @GET
    @Path("main/list")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> mainList(@Context HttpServletRequest request,@Context HttpServletResponse response,@QueryParam("agentStr")String agentStr
    		,@QueryParam("lon")Double lon,@QueryParam("lat")Double lat) {
    	HashMap<String, Object>  map = new HashMap<>();
    	String carset = null;
    	Integer agentId = MfoyouEncrypt.decode(agentStr);
    	if(agentId==null){
    		return JsonRet.buildRet(1);
    	}
    	redisCacheManger.getIncr("visit:times:"+agentId);
    	if(agentId!=null){
    		map.put("agentStr", MfoyouEncrypt.enCode(agentId));
    		HuawuAgentStoreSetting specialSettingV1 = agentService.getAgentSetting(agentId);
    		specialSettingV1.setAppid(iStatistics.getWxinfo(agentId));
    		map.put("setting", specialSettingV1);
//        	if(specialSettingV1 != null && specialSettingV1.getStoreModelType() != null && (specialSettingV1.getStoreModelType() & 0x02) == 2){
        		carset = redisCacheManger.getValue(PIC_MAIN+agentId);
        		if(carset==null){
        			carset = redisCacheManger.getValue(PIC_MAIN+0);//代理商没设置
        		}
//        	}else {
//        		carset = redisCacheManger.getValue(PIC_MAIN+0);//代理商没权限
//			}
    	}
    	map.put("Carousel", carset);
    	if(agentId!=null){
    		String agentTypeInfo = redisCacheManger.getValue(LABEL_MAIN+agentId);
    		if(agentTypeInfo==null){
    			agentTypeInfo = agentService.getAgentTypeInfo(agentId);
    		}
    		if(agentTypeInfo==null || agentTypeInfo.equals("null")){
    			String labels = redisCacheManger.getValue(LABEL_MAIN+0);
            	map.put("labels", labels);
    		}else{
    			redisCacheManger.setValue(LABEL_MAIN+agentId,agentTypeInfo,60);
    			map.put("labels", agentTypeInfo);
    		}
    	}
//    	else{
//    		String labels = redisCacheManger.getValue(LABEL_MAIN+0);
//        	map.put("labels", labels);
//    	}
    	return JsonRet.buildSuccRet(map);
    }

    @GET
    @Path("getstoreInfo/{storeId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getStoreInfoByid(@Context HttpServletRequest request,@Context HttpServletResponse response,@PathParam("storeId")String storeChar
    		,@QueryParam("userlat")Double userlat,@QueryParam("userlon")Double userlon) {
    	HuawuStoreInfo info = new HuawuStoreInfo();
    	int storeId = MfoyouEncrypt.decode(storeChar);
    	if(storeId < 0){
    		return JsonRet.buildRet(-11);
    	}
    	info.setStoreId(storeId);
    	List<HuawuStoreInfo> storeInfo = iStore.getStoreInfo(1, info);
    	if(storeInfo == null || storeInfo.size() == 0){
    		return JsonRet.buildRet(-2222);
    	}
    	HuawuStoreInfo mfoyouStoreInfo = storeInfo.get(0);
    	MfoyouStoreDispatch mfoyouStoreDispatch = iStore.getDispatchInfo(storeId);
    	if(mfoyouStoreDispatch!=null){
    		mfoyouStoreInfo.setStoreMinGoodsAmount(StoreDispatchUtil.getMinStartPrice(mfoyouStoreDispatch));
        	mfoyouStoreInfo.setStoreBasicFreight(StoreDispatchUtil.getMinFee(mfoyouStoreDispatch));
    	}
    	mfoyouStoreInfo.setOpens(iStore.getMfoyouStoreOpenByStoreId(storeId));
    	customService.checkIpaddr(WebUtils.getIpAddr(request), storeId);
    	return JsonRet.buildSuccRet(mfoyouStoreInfo);
    }
    
    @GET
    @Path("getStoreGoodsTypeList/{storeId}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getStoreGoodsTypeList(@Context HttpServletRequest request,@Context HttpServletResponse response,@PathParam("storeId")String storeChar) {
    	int storeId = MfoyouEncrypt.decode(storeChar);
    	List<MfoyouGoodsTypeV2> typesV2 = goodsService.getTypesV2(storeId,1);
    	return JsonRet.buildSuccRet(typesV2);
    }
    @GET
    @Path("get/serviceTag")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> getServiceTag(@Context HttpServletRequest request,@Context HttpServletResponse response,@QueryParam("lat")Double lat,
    		@QueryParam("lon")Double lon,@QueryParam("agentstr")String agentstr) {
    	Integer agentId = sessionService.currentUserAgentId(request);
    	HuawuServicePrice configurePrice = agentService.getConfigurePrice(agentId,false);
    	return JsonRet.buildSuccRet(configurePrice);
    }
   
}
