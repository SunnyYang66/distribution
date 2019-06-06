package com.mfoyou.agent.web.controller.others;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.mfoyou.agent.utils.common.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.intercepter.UrlRight;
import com.mfoyou.agent.web.intercepter.UserRight;
import com.mfoyou.agent.web.service.thirdPart.KdniaoQueryService;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

/**
 * 快递鸟
 * @author Administrator
 *
 */
@Path("kdn")
@Service
public class KdnController {
	
	@Autowired
	RedisCacheManger redisCacheManger;
	@Autowired
	KdniaoQueryService kdniaoQueryService;
//	private static Logger logger = Logger.getLogger(KdnController.class);
	
	private static final String KDN_PRR = "kdn:";
	
	private static final int  time1 = 60*60*24*3;
	private static final int  time2 = 60*60;
	@POST
	@Path(value = "/callback")
	@Produces("application/json;charset=UTF-8")
	@UrlRight({ UserRight.ALLACCESS})
	public Map<String, Object> translate(@Context HttpServletRequest request,String json) {
		JSONObject parseObject = JSON.parseObject(json);
		String data = parseObject.getJSONArray("RequestData").getString(0);
		JSONObject json2Object = JSON.parseObject(data);
		String EBusinessID = json2Object.getString("EBusinessID");
		JSONArray jsonArray = json2Object.getJSONArray("Data");
		for(int i = 0 ; i< jsonArray.size();i++){
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			redisCacheManger.setValue(KDN_PRR+jsonObject.getString("LogisticCode"), jsonObject.toJSONString(), time1);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("EBusinessID", EBusinessID);
		hashMap.put("UpdateTime", simpleDateFormat.format(new Date()));
		hashMap.put("Success", true);
		hashMap.put("Reason", "111111");
		return hashMap;
	}
	@GET
    @Path(value = "kdniaoQuery/{code}/{no}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> kdniaoQuery(@PathParam("code")String code,@PathParam("no")String no) throws Exception {
		JSONObject parseObject = null;
		String value = redisCacheManger.getValue(KDN_PRR+no);
		if(value == null){
			parseObject = JSON.parseObject(kdniaoQueryService.getOrderTracesByJson(code, no));
			redisCacheManger.setValue(KDN_PRR+parseObject.getString("LogisticCode"), parseObject.toJSONString(), time2);
		}else{
			parseObject = JSON.parseObject(value);
		}
		return JsonRet.buildSuccRet(parseObject);
    }
	@GET
    @Path(value = "refresh/{code}/{no}")
    @Produces("application/json;charset=UTF-8")
    @UrlRight(UserRight.ALLACCESS)
    public JsonRet<?> refresh(@PathParam("code")String code,@PathParam("no")String no) throws Exception {
		JSONObject parseObject = JSON.parseObject(kdniaoQueryService.getOrderTracesByJson(code, no));
		redisCacheManger.setValue(KDN_PRR+parseObject.getString("LogisticCode"), parseObject.toJSONString(), time2);
		return JsonRet.buildSuccRet(parseObject);
    }
}
