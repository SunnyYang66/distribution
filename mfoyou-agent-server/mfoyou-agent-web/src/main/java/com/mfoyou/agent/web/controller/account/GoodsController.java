package com.mfoyou.agent.web.controller.account;

import java.util.ArrayList;
import java.util.Collection;
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

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsSearch;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsType;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsTypeV2;
import org.mfoyou.agent.common.entity.GoodsInfo;
import org.mfoyou.agent.utils.common.ArrayListObject;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.ListObject;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouEncrypt;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.GoodsService;
import com.mfoyou.agent.web.service.session.SessionService;

@Path("goods")
@Service
public class GoodsController {
	
	@Autowired
	private SessionService sessionService;
	@Autowired
	private GoodsService goodsSvc;
	private Logger     logger = new Logger(GoodsController.class);
	@GET
	@Path(value = "get/goods/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> getGoodsByid(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("id")String idstr) {
		Integer id = MfoyouEncrypt.decode(idstr);
		if(id == null || id<0){
			return JsonRet.buildRet(-11);
		}
		GoodsInfo goodsinfo = goodsSvc.getGoods(id);
		return JsonRet.buildSuccRet(goodsinfo);
	}
	@GET
	@Path(value = "storeget/goods/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> storegetGoodsByid(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("id")Integer id) {
		GoodsInfo goodsinfo = goodsSvc.getGoods(id);
		return JsonRet.buildSuccRet(goodsinfo);
	}
	//查看上架后的商品
	@POST
	@Path(value = "list")
	@Produces("application/json;charset=UTF-8") 
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> list(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
		Integer type = mfoyouMap.getInteger("typeId");
		String goodsTitle = mfoyouMap.get("goodsTitle");
		mfoyouGoodsInfo.setGoodsType(type);
		String storestr = mfoyouMap.get("storeId");
		int storeId = MfoyouEncrypt.decode(storestr);	
		if(storeId<0){
			return JsonRet.buildRet(-11);
		}
		Integer pagesize = mfoyouMap.getInteger("pagesize");
		Integer pageId = mfoyouMap.getInteger("pageId");
		mfoyouGoodsInfo.setGoodsTitle(goodsTitle);
		mfoyouGoodsInfo.setStoreId(storeId);
		return JsonRet.buildRet(0, ListObject.BulidListObject(goodsSvc.listGoods(pagesize,pageId,mfoyouGoodsInfo)));
	}
	@POST 
	@Path(value = "get/mylist")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getlistStore(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
		Integer type = mfoyouMap.getInteger("typeid");
		String goodsTitle = mfoyouMap.get("goodsTitle");
		Integer storeId = sessionService.currentUserId(request);
		Integer pagesize = mfoyouMap.getInteger("pagesize");
		Integer pageId = mfoyouMap.getInteger("pageId");
		Integer isShelvesState = mfoyouMap.getInteger("isSeel");
		mfoyouGoodsInfo.setGoodsShelvesState(isShelvesState);
		mfoyouGoodsInfo.setGoodsType(type);
		mfoyouGoodsInfo.setGoodsTitle(goodsTitle);
		mfoyouGoodsInfo.setStoreId(storeId);
		return JsonRet.buildRet(0, ListObject.BulidListObject(goodsSvc.listGoodsStore(pagesize,pageId,mfoyouGoodsInfo)));
	}
	@GET
	@Path(value = "del/goods/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> delete(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("id")Integer id) {
		Integer storeId = sessionService.currentUserId(request);
		return JsonRet.buildRet(goodsSvc.deleteGoodsV2(id,storeId)-1);
	}
	@GET
	@Path(value = "stick/{goodsid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> stickGoods(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("goodsid")Integer goodsid) {
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
		mfoyouGoodsInfo.setStoreId(storeId);
		mfoyouGoodsInfo.setGoodsId(goodsid);
		mfoyouGoodsInfo.setGoodsSortTop(1);
		mfoyouGoodsInfo.setGoodsSortLeve((double) System.currentTimeMillis());
		MfoyouGoodsInfo updateGoods = goodsSvc.updateGoods(mfoyouGoodsInfo);
		return updateGoods == null ?JsonRet.buildRet(-50):JsonRet.buildSuccRet(updateGoods);
	}
	
	@GET
	@Path(value = "unstick/{goodsid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> unstickGoods(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("goodsid")Integer goodsid) {
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsInfo mfoyouGoodsInfo = new MfoyouGoodsInfo();
		mfoyouGoodsInfo.setStoreId(storeId);
		mfoyouGoodsInfo.setGoodsId(goodsid);
		mfoyouGoodsInfo.setGoodsSortTop(0);
		mfoyouGoodsInfo.setGoodsSortLeve((double)1);
		MfoyouGoodsInfo updateGoods = goodsSvc.updateGoods(mfoyouGoodsInfo);
		return updateGoods == null ?JsonRet.buildRet(-50):JsonRet.buildSuccRet(updateGoods);
	}
	@POST
	@Path(value = "add/goods")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addGoods(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		JSONObject json2JsonObject = Json2Object.json2JsonObject(json);
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsInfo info = new MfoyouGoodsInfo();
		String mainPic = json2JsonObject.getString("mainPic");
		List<MfoyouGoodsPackage> packages = new ArrayList<>();
		if(mainPic == null){
			return JsonRet.buildRet(-40);
		}
		info.setStoreId(storeId);
		info.setGoodsMainPic(mainPic);
		String goodsTitle = json2JsonObject.getString("goodsTitle");
		if(goodsTitle == null){
			return JsonRet.buildRet(-96);
		}
		info.setGoodsTitle(goodsTitle);
		String showPic = json2JsonObject.getString("showPic");
		info.setGoodsShowPic(showPic);
		Integer packetType = json2JsonObject.getInteger("packType");
		if(packetType == null){
			return JsonRet.buildRet(-96);
		}
		if(packetType == 0){
			Integer price = json2JsonObject.getInteger("packageCostPrice");
			if(price==null){
				return JsonRet.buildRet(-96);
			}
			if(price>1000000){
				return JsonRet.buildRet(-51);
			}
			info.setGoodsCostPrice(price);
			info.setGoodsPackageFee(json2JsonObject.getInteger("goodsPackageFee"));
		}else if(packetType ==1){
			JSONArray jsonArray = json2JsonObject.getJSONArray("packages");
			int size = jsonArray.size();
			for(int i = 0 ; i<size ; i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String name = jsonObject.getString("packageName");
				Integer number = jsonObject.getInteger("packageNumber");
				Integer price = jsonObject.getInteger("packageCostPrice");
				if(name == null || price ==null){
					JsonRet.buildRet(-96);
				}
				if(price>1000000){
					return JsonRet.buildRet(-51);
				}
				MfoyouGoodsPackage goodsPackage = new MfoyouGoodsPackage();
				goodsPackage.setPackageNumber(number);
				goodsPackage.setPackageName(name);
				goodsPackage.setPackageCostPrice(price);
				goodsPackage.setPackagePackageFee(jsonObject.getInteger("packagePackageFee"));
				packages.add(goodsPackage);
			}
		}else{
			return JsonRet.buildRet(-11);
		}
		info.setGoodsPackageType(packetType);
		String detail = json2JsonObject.getString("detail");
		info.setGoodsText(detail);
		Integer type = json2JsonObject.getInteger("type");
		if(type == null){
			return JsonRet.buildRet(-96);
		}
		info.setGoodsType(type);
		 int result = goodsSvc.addGoodsV2(info,packages);
		if(result == 0){
			return JsonRet.buildRet(-50);
		}
		return JsonRet.buildRet(0);
	}
	@POST
	@Path(value = "modify/goods")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> modifygoods(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		JSONObject gooosJson = Json2Object.json2JsonObject(json);
		Integer storeId = sessionService.currentUserId(request);
		Integer goodsid = gooosJson.getInteger("goodsid");
		if(goodsid == null){
			return JsonRet.buildRet(-96);
		}
		MfoyouGoodsInfo info = new MfoyouGoodsInfo();
		info.setGoodsId(goodsid);
		info.setStoreId(storeId);
		String mainPic = gooosJson.getString("mainPic");
		List<MfoyouGoodsPackage> packages = new ArrayList<>();
		if(mainPic != null){
			info.setGoodsMainPic(mainPic);
		}
		Integer sellState = gooosJson.getInteger("sellState");
		if(sellState!=null){
			info.setGoodsShelvesState(sellState);
		}
		String goodsTitle = gooosJson.getString("goodsTitle");
		if(goodsTitle != null){
			info.setGoodsTitle(goodsTitle);
		}
		String showPic = gooosJson.getString("showPic");
		if(showPic !=null ){
			info.setGoodsShowPic(showPic);
		}
		Integer packetType = gooosJson.getInteger("packType");
		if(packetType != null){
			if(packetType == 0){
				Integer price = gooosJson.getInteger("packageCostPrice");
				Integer number = gooosJson.getInteger("packageNumber");
				if(price == null){
					return JsonRet.buildRet(-96);
				}
				if(price>1000000){
					return JsonRet.buildRet(-51);
				}
				info.setGoodsCostPrice(price);
				if(number!=null){
					info.setGoodsNumber(number);
				}
				info.setGoodsPackageFee(gooosJson.getInteger("goodsPackageFee"));
			}else if(packetType ==1){
				JSONArray jsonArray = gooosJson.getJSONArray("packages");
				int size = jsonArray.size();
				if(size == 0){
					return JsonRet.buildRet(-96);
				}
				for(int i = 0 ; i<size ; i++){
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					String name = jsonObject.getString("packageName");
					Integer number = jsonObject.getInteger("packageNumber");
					Integer price = jsonObject.getInteger("packageCostPrice");
					if(name == null || price ==null){
						JsonRet.buildRet(-96);
					}
					if(price>1000000){
						return JsonRet.buildRet(-51);
					}
					MfoyouGoodsPackage goodsPackage = new MfoyouGoodsPackage();
					goodsPackage.setPackageName(name);
					goodsPackage.setPackageCostPrice(price);
					goodsPackage.setPackageNumber(number);
					goodsPackage.setGoodsId(goodsid);
					goodsPackage.setPackagePackageFee(jsonObject.getInteger("packagePackageFee"));
					packages.add(goodsPackage);
				}
			}else{
				return JsonRet.buildRet(-11);
			}
		}
		info.setGoodsPackageType(packetType);
		String detail = gooosJson.getString("detail");
		if(detail != null){
			info.setGoodsText(detail);
		}
		Integer type = gooosJson.getInteger("type");
		if(type != null){
			info.setGoodsType(type);
		}
		int result = goodsSvc.updateGoods(info,packages);
		if(result == 0){
			return JsonRet.buildRet(-50);
		}
		return JsonRet.buildRet(0);
	}
	@GET
	@Path(value = "get/typeList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getTypes(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeId = sessionService.currentUserId(request);
		Collection<MfoyouGoodsTypeV2> types = goodsSvc.getTypesV2(storeId,0);
		return JsonRet.buildSuccRet(types);
	}
	@POST
	@Path(value = "add/type")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addType(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String typeName = mfoyouMap.get("name");
		Integer storeId = sessionService.currentUserId(request);
		int typeId = goodsSvc.addTypeV2(storeId,typeName);
		if(typeId<0){
			return JsonRet.buildFailRet("已有该分类");
		}
		return JsonRet.buildRet(0);
	}
	@GET
	@Path(value = "delete/type/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> Type(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("id") Integer id) {
		Integer storeId = sessionService.currentUserId(request);
		int deleteTypeByid = goodsSvc.deleteTypeByid(id,storeId);
		return deleteTypeByid == 1 ? JsonRet.buildRet(0) : deleteTypeByid == -1?JsonRet.buildRet(-101):JsonRet.buildRet(-1);
	}
	@POST
	@Path(value = "update/type")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> updateType(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		Integer id = mfoyouMap.getInteger("typeid");
		String name = mfoyouMap.get("name");
		if(id==null || name == null){
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsType type = new MfoyouGoodsType();
		type.setStoreId(storeId);
		type.setTypeName(name);
		int result = goodsSvc.updateType(type,storeId,id);
		if(result<0){
			return JsonRet.buildFailRet("已有该分类");
		}
		return result==1?JsonRet.buildRet(0):JsonRet.buildRet(-50);
	}
	@GET
	@Path(value = "get/package/{id}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> getPackageByid(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("id") Integer id) {
		List<MfoyouGoodsPackage> mfopackage = goodsSvc.getPackageByid(id);
		return JsonRet.buildSuccRet(mfopackage);
	}
	
	@POST
	@Path(value = "add/package")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addPackage(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String name = mfoyouMap.get("name");
		Integer number = mfoyouMap.getInteger("number"); 
		Integer price = mfoyouMap.getInteger("price");
		Integer goodsId = mfoyouMap.getInteger("goodid");
		if(number == null || price == null || goodsId == null || name == null){
			JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsPackage mfoyouGoodsPackage = new MfoyouGoodsPackage();
		mfoyouGoodsPackage.setPackageCostPrice(price);
		mfoyouGoodsPackage.setGoodsId(goodsId);
		mfoyouGoodsPackage.setPackageName(name);
		mfoyouGoodsPackage.setPackageNumber(number);
		int result = goodsSvc.addPackage(mfoyouGoodsPackage,storeId);
		if(result==-1){
			logger.error("此人  userId="+storeId+"正在尝试修改不属于他的数据");
			return JsonRet.buildRet(-100);
		}else if(result == 0){
			return JsonRet.buildRet(-50);
		}
		mfoyouGoodsPackage.setPackageId(result);
		return JsonRet.buildSuccRet(mfoyouGoodsPackage);
	}
	@GET
	@Path(value = "del/package/{goodsid}/{packageid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> deletePackage(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("packageid") Integer packageid
			,@PathParam("goodsid")Integer goodsId) {
		Integer storeId = sessionService.currentUserId(request);
		int result = goodsSvc.deletePackage(storeId,packageid,goodsId);
		if(result == 1){
			return JsonRet.buildRet(0);
		}
		return JsonRet.buildRet(-50);
	}
	@POST
	@Path(value = "update/package")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> updatePackage(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String name = mfoyouMap.get("name");
		Integer number = mfoyouMap.getInteger("number"); 
		Integer price = mfoyouMap.getInteger("price");
		Integer goodsId = mfoyouMap.getInteger("goodid");
		Integer packetId = mfoyouMap.getInteger("packId");
		MfoyouGoodsPackage mfoyouGoodsPackage = new MfoyouGoodsPackage();
		if(name!=null){
			mfoyouGoodsPackage.setPackageName(name);
		}
		if(number!=null){
			mfoyouGoodsPackage.setPackageNumber(number);
		}
		if(price != null){
			mfoyouGoodsPackage.setPackageCostPrice(price);
		}
		if(goodsId == null || packetId == null){
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		mfoyouGoodsPackage.setGoodsId(goodsId);
		mfoyouGoodsPackage.setPackageId(packetId);
		int result = goodsSvc.updatePacket(mfoyouGoodsPackage,goodsId,storeId);
		if(result==-1){
			logger.error("此人  userId="+storeId+"正在尝试修改不属于他的数据");
			return JsonRet.buildRet(-100);
		}else if(result == 0){
			return JsonRet.buildRet(-50);
		}
		return JsonRet.buildSuccRet(mfoyouGoodsPackage);
	}
	
	@POST
	@Path(value = "draw/type")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> drawType(@Context HttpServletRequest request, @Context HttpServletResponse response,String json) {
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String idString = mfoyouMap.get("idString");
		String seq = mfoyouMap.get("seq");
		if(idString==null || seq==null){
			return JsonRet.buildRet(-96);
		}
		Integer storeId = sessionService.currentUserId(request);
		String[] ids = idString.split(",");
		String[] seqs = seq.split(",");
		if(ids.length!=seqs.length){
			return JsonRet.buildRet(-11);
		}
		int k = goodsSvc.modifyTypeOrder(storeId,ids,seqs,seq);
		return JsonRet.buildSuccRet(k);
	}
	@GET
	@Path(value = "store/seach/goods")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> seachGoods(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("key")String key,@QueryParam("state")Integer state,@QueryParam("goodsType")Integer type,
			@QueryParam("pageSize")Integer pageSize,@QueryParam("pageId")Integer pageId) {
		Integer storeId = sessionService.currentUserId(request);
		ArrayListObject<GoodsInfo> infos= goodsSvc.getGoodsByStoreid(storeId,key,state,type,pageId,pageSize);
		return JsonRet.buildSuccRet(ListObject.BulidListObject(infos));
	}
	@GET
	@Path(value = "delate/batch/goods")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> deleteGoods(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("ids")Integer[] goodsids) {
		Integer storeId = sessionService.currentUserId(request);
		int count = goodsSvc.deleteBatchGoods(goodsids, storeId);
		return JsonRet.buildSuccRet(count);
	}
	@GET
	@Path(value = "update/batch/shevelState")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> shevelState(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("ids")Integer[] ids,@QueryParam("state")Integer state) {
		Integer storeId = sessionService.currentUserId(request);
		int updateshevelState = goodsSvc.updateshevelState(ids,state,storeId);
		return JsonRet.buildSuccRet(updateshevelState);
	}
	@GET
	@Path(value = "update/batch/group")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> updateBatchGroup(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@QueryParam("ids")Integer[] ids,@QueryParam("typeId")Integer typeId) {
		Integer storeId = sessionService.currentUserId(request);
		int updateshevelState = goodsSvc.updateBatchGroup(ids,typeId,storeId);
		return JsonRet.buildSuccRet(updateshevelState);
	}
	@GET
	@Path(value = "get/searchList")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.ALLACCESS)
	public JsonRet<?> searchList(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		List<MfoyouGoodsSearch> searchs = goodsSvc.getSearchList();
		return JsonRet.buildSuccRet(searchs);
	}
	
}
