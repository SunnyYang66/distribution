package com.mfoyou.agent.web.controller.others;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.entity.MfoyouGoodsOrderWithPackage;
import org.mfoyou.agent.utils.common.JsonRet;
import org.mfoyou.agent.utils.common.Logger;
import org.mfoyou.agent.utils.common.MfoyouMap;
import org.mfoyou.agent.utils.json.Json2Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.account.StoreService;
import com.mfoyou.agent.web.service.order.GoodOrderService;
import com.mfoyou.agent.web.service.session.SessionService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;
import com.mfoyou.agent.web.utils.yinianyun.YinianyunUtils;


@Path("printer")
@Service
public class PrinterController {

	@Autowired
	SessionService sessionService;
	@Autowired
	StoreService storeService;
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	GoodOrderService goodOrderService;
//	@Autowired
//	BlePrinterService blePrinterService;

	private static Logger logger = Logger.getLogger(PrinterController.class);
	// 打印 token
	public static final String TOKEN = "printer:token";
	public static final String PRINTER_PRE = "printer:machine:";
	@POST
	@Path(value = "printerinfo")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> printerinfo(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String printerInfo = YinianyunUtils.getPrinterInfo(storeInfo.getStorePrinterNumber(), token);
		JSONObject parseObject = JSONObject.parseObject(printerInfo);
		String error = parseObject.getString("error");
		JSONObject jsonObject = parseObject.getJSONObject("body");
		if (error.equals("0")) {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("body",jsonObject);
			Map<String, String> mapValue = redisCacheManger.getMapValue(PRINTER_PRE+storeInfo.getStorePrinterNumber());
			String online = mapValue.get("online");
			online = online == null ? "0" : online;
			hashMap.put("online", online);
			String autoprint = mapValue.get("autoprint");
			autoprint = autoprint == null ? "1" : autoprint;
			hashMap.put("autoprint", autoprint);
			String isCloseVoice = mapValue.get("isCloseVoice");
			isCloseVoice = isCloseVoice == null ? "0" : isCloseVoice;
			hashMap.put("isCloseVoice", isCloseVoice);
			hashMap.put("number", storeInfo.getStorePrinterNumber());
			return JsonRet.buildSuccRet(hashMap);
		}else if(error.equals("8")){
			HuawuStoreInfo info = new HuawuStoreInfo();
			info.setStorePrinterNumber("-1");
			storeService.updateStoreInfoById(storeId, info);
			return JsonRet.buildRet(-1100);
		}
		return JsonRet.buildFailRet(error, jsonObject);
	}
	
	@GET
	@Path(value = "printagain/{orderid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> printagain(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("orderid") Integer orderid) {
		Integer storeId = sessionService.currentUserId(request);
		MfoyouGoodsOrderWithPackage goodsOrderWith = goodOrderService.getGoodsOrderWith(orderid);
		if (goodsOrderWith == null) {
			return JsonRet.buildRet(-1101);
		}
		if (!goodsOrderWith.getStoreId().equals(storeId)) {
			return JsonRet.buildRet(-1102);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String printNumber = goodsOrderWith.getStoreInfo().getStorePrinterNumber();
		if(printNumber == null){
			return JsonRet.buildRet(-1100);
		}
		String hget = redisCacheManger.hget(PRINTER_PRE+printNumber, "isCloseVoice");
		if(hget == null){
			hget = "0";
		}
		int model = Integer.parseInt(hget);
		String printerInfo = YinianyunUtils.print(goodsOrderWith, token,model);
		logger.info(printerInfo);
		return translate(printerInfo);
	}
	
	@GET
	@Path(value = "shutdownrestart/{type}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> shutdownrestart(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("type") String type) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		if(!(type.equals("restart") || type.equals("shutdown"))){
			return JsonRet.buildRet(-1103);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String shutdownrestart = YinianyunUtils.shutdownrestart(storeInfo.getStorePrinterNumber(), token, type);
		logger.info(shutdownrestart);
		return translate(shutdownrestart);
	}
	@POST
	@Path(value = "setVoice/{voice}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> setsound(@Context HttpServletRequest request, @Context HttpServletResponse response
			,@PathParam("voice")Integer voice) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		if(voice!=1 && voice !=0){
			return JsonRet.buildRet(-1103);
		}
		redisCacheManger.hset(PRINTER_PRE+storeInfo.getStorePrinterNumber(), "isCloseVoice", voice+"");
		return JsonRet.buildRet(0);
	}
	@POST
	@Path(value = "setsound")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> setsound(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String type = mfoyouMap.get("type");
		String voice = mfoyouMap.get("voice");
		if(type == null || voice == null){
			return JsonRet.buildRet(-1104);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String result = YinianyunUtils.setsound(storeInfo.getStorePrinterNumber(), type, voice, token);
		return translate(result);
	}
	@POST
	@Path(value = "addPrinter")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> addPrinter(@Context HttpServletRequest request, @Context HttpServletResponse response,
			String json) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() != null && !storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1105);
		}
		MfoyouMap mfoyouMap = Json2Object.json2MfoyouMap(json);
		String machineCode = mfoyouMap.get("machineCode");
		String pass = mfoyouMap.get("pass");
		if(machineCode == null || pass == null){
			return JsonRet.buildRet(-1104);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String addprinter = YinianyunUtils.addprinter(machineCode, pass, token);
		JSONObject parseObject = JSONObject.parseObject(addprinter);
		String error = parseObject.getString("error");
		if (error.equals("0")) {
			HuawuStoreInfo info = new HuawuStoreInfo();
			info.setStoreId(storeInfo.getStoreId());
			info.setStorePrinterNumber(machineCode);
			int updateStoreInfoById = storeService.updateStoreInfoById(storeId, info);
			redisCacheManger.hset(PRINTER_PRE+machineCode, "pass", pass);
			if(updateStoreInfoById ==1){
				return JsonRet.buildSuccRet(parseObject.get("body"));
			}
			return JsonRet.buildRet(-100);
		}
		logger.info(addprinter);
		return JsonRet.buildFailRet(parseObject.getString("error_description"));
	}
	@GET
	@Path(value = "deleteprinter")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> deleteprinter(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String result = YinianyunUtils.deleteprinter(storeInfo.getStorePrinterNumber(), token);
		JSONObject parseObject = JSONObject.parseObject(result);
		String error = parseObject.getString("error");
		if (error.equals("0")) {
			HuawuStoreInfo info = new HuawuStoreInfo();
			info.setStorePrinterNumber("-1");
			int updateStoreInfoById = storeService.updateStoreInfoById(storeId, info);
			if(updateStoreInfoById ==1){
				return JsonRet.buildSuccRet(parseObject.get("body"));
			}
			return JsonRet.buildRet(-100);
		}
		return JsonRet.buildRet(Integer.parseInt(error));
	}
	//未完成取消打印一个订单
	@GET
	@Path(value = "cancelone/{orderId}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> cancelone(@Context HttpServletRequest request, @Context HttpServletResponse response,@PathParam("orderId")Integer orderid) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String result = YinianyunUtils.cancelone(storeInfo.getStorePrinterNumber(), token, "");
		return translate(result);
	}
	@GET
	@Path(value = "cancelall")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> cancelall(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		String token = redisCacheManger.getValue(TOKEN);
		String result = YinianyunUtils.cancelAll(storeInfo.getStorePrinterNumber(), token);
		return translate(result);
	}
	@POST
	@Path(value = "btnprint/{pathid}")
	@Produces("application/json;charset=UTF-8")
	@UrlRight(UserRight.STOREACCESS)
	public JsonRet<?> btnprint(@Context HttpServletRequest request, @Context HttpServletResponse response,
			@PathParam("pathid")Integer path) {
		Integer storeId = sessionService.currentUserId(request);
		HuawuStoreInfo storeInfo = storeService.getStoreInfo(storeId);
		if (storeInfo.getStorePrinterNumber() == null || storeInfo.getStorePrinterNumber().equals("-1")) {
			return JsonRet.buildRet(-1100);
		}
		redisCacheManger.hset(PRINTER_PRE+storeInfo.getStorePrinterNumber(), "autoprint", path+"");
//		String token = redisCacheManger.getValue(TOKEN);
//		String response_type = path == 1 ? "btnopen" : "btnclose";
//		String result = YinianyunUtils.btnprint(storeInfo.getStorePrinterNumber(), response_type, token);
//		JSONObject parseObject = JSONObject.parseObject(result);
//		String error = parseObject.getString("error");
//		if (error.equals("0")) {
//			redisCacheManger.hset(PRINTER_PRE+storeInfo.getStorePrinterNumber(), "autoprint", path+"");
//			return JsonRet.buildSuccRet(parseObject.get("body"));
//		}
		return JsonRet.buildRet(0);
	}
	public JsonRet<?> translate(String json) {
		JSONObject parseObject = JSONObject.parseObject(json);
		String error = parseObject.getString("error");
		if (error.equals("0")) {
			return JsonRet.buildSuccRet(parseObject.get("body"));
		}else if(error.equals("8")){
			return JsonRet.buildRet(-1100);
		}
		return JsonRet.buildFailRet("打印机未绑定");
	}
//	@GET
//	@Path(value = "bulePrint/{orderId}")
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	@UrlRight(UserRight.ALLACCESS)
//	public byte[] bulePrint(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			@PathParam("orderId")Integer orderid) throws UnsupportedEncodingException {
////		Integer storeId = sessionService.currentUserId(request);
//		MfoyouGoodsOrderWithPackage goodsOrderWith = goodOrderService.getGoodsOrderWith(orderid);
////		if (goodsOrderWith == null) {
////			return new byte[]{10,10};
////		}
////		if (!goodsOrderWith.getStoreId().equals(storeId)) {
////			return new byte[]{10,10};
////		}
//		return blePrinterService.sendReceiptWithResponse(goodsOrderWith);
//	}
//	@GET
//	@Path(value = "bulePrint/{orderId}")
//	@Produces(MediaType.APPLICATION_OCTET_STREAM)
//	@UrlRight(UserRight.ALLACCESS)
//	public byte[] addPrinterList(@Context HttpServletRequest request, @Context HttpServletResponse response,
//			@PathParam("orderId")Integer orderid) throws UnsupportedEncodingException {
//		MfoyouGoodsOrderWithPackage goodsOrderWith = goodOrderService.getGoodsOrderWith(orderid);
//		return blePrinterService.sendReceiptWithResponse(goodsOrderWith);
//	}
}
