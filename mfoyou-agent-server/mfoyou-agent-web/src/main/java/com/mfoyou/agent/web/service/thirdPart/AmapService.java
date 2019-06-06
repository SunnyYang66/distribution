package com.mfoyou.agent.web.service.thirdPart;

import org.mfoyou.agent.utils.common.HttpsUtils;
import org.mfoyou.agent.utils.common.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mfoyou.agent.web.utils.redis.RedisCacheManger;

@Service
public class AmapService {

	@Autowired
	RedisCacheManger redisCacheManger;

	private static String regeokey = "regeo:";
	private static String distancekey = "distance:";
	private static String cityGiskey = "cg:";

	private String makeKey3(Double lat, Double lon) {
		return String.format("%.3f,%.3f", lon, lat);
	}

	private String makeKey4(Double lat, Double lon) {
		return String.format("%.4f,%.4f", lon, lat);
	}

	private String makeKey6(Double lat, Double lon) {
		return String.format("%.6f,%.6f", lon, lat);
	}

	private String makeUrl(String key1, String key2, int type) {
		if (type == 1) {
			// 坐标转地址
			return "http://restapi.amap.com/v3/geocode/regeo?output=json&location=" + key1
					+ "&key=bc3606d232e4b41392edf996c540e658&radius=0&poitype=村组级地名";
		} else if (type == 2) {
			return "http://restapi.amap.com/v3/distance?origins=" + key1 + "&destination=" + key2
					+ "&output=json&key=bc3606d232e4b41392edf996c540e658";

		} else if (type == 3) {
			return "http://restapi.amap.com/v3/config/district?key=bc3606d232e4b41392edf996c540e658&" + "keywords="
					+ key1 + "&subdistrict=0&extensions=base";
		}
		return null;
	}

	public String city2gis(String cityName) {
		String response = redisCacheManger.getValue(cityGiskey + cityName);
		Boolean bCache = false;
		if (response == null) {
			String url = makeUrl(cityName, null, 3);
			response = HttpsUtils.get(url);
			bCache = true;
		}
		if (response == null)
			return null;
		JSONObject regeoEntity = JSON.parseObject(response);
		if ("1".equals(regeoEntity.get("status"))) {
			if (bCache)
				redisCacheManger.setValue(cityGiskey + cityName, response, 3600 * 24);
			JSONArray citys = regeoEntity.getJSONArray("districts");
			if (citys == null || citys.size() < 1)
				return null;
			return citys.getJSONObject(0).getString("center");
		}
		return null;
	}

	public String getCityCode(Double lat, Double lon) {
		String key = makeKey3(lat, lon);
		String response = redisCacheManger.getValue(regeokey + key);
		Boolean bCache = false;
		if (response == null) {
			String url = makeUrl(makeKey6(lat, lon), null, 1);
			response = HttpsUtils.get(url);
			bCache = true;
		}
		if (response == null)
			return null;
		JSONObject regeoEntity = JSON.parseObject(response);
		if ("1".equals(regeoEntity.get("status"))) {
			if (bCache)
				redisCacheManger.setValue(regeokey + key, response, 3600 * 24);
			String code = regeoEntity.getJSONObject("regeocode").getJSONObject("addressComponent").getString("adcode");
			if (StrUtil.isInteger(code)) {
				return code;
			} else {
				return null;
			}
		}
		return null;

	}

	public Integer getDistance(Double srcLat, Double srcLon, Double desLat, Double desLon) {
		if (srcLat == null || srcLon == null || desLat == null || desLon == null)
			return 0;
		String key1 = makeKey4(srcLat, srcLon);
		String key2 = makeKey4(desLat, desLon);
		String response = redisCacheManger.getValue(distancekey + key1 + key2);
		Boolean bCache = false;
		if (response == null) {
			String url = makeUrl(makeKey6(srcLat, srcLon), makeKey6(desLat, desLon), 2);
			response = HttpsUtils.get(url);
			bCache = true;
		}
		if (response == null)
			return null;
		JSONObject regeoEntity = JSON.parseObject(response);
		if ("1".equals(regeoEntity.get("status"))) {
			if (bCache)
				redisCacheManger.setValue(distancekey + key1 + key2, response, 3600 * 24);
			JSONArray arrary = regeoEntity.getJSONArray("results");
			if (arrary != null && arrary.size() > 0) {
				return arrary.getJSONObject(0).getInteger("distance");
			}
		}
		return null;

	}
	public String[] getCityByPos(Double lat, Double lon){
		String url = makeUrl(makeKey6(lat, lon), null, 1);
		String response = HttpsUtils.get(url);
		if(response == null){
			return null;
		}
		String[] strings = {null,null,null};
		JSONObject jsonObject = JSONObject.parseObject(response);
		if("1".equals(jsonObject.getString("state"))){
			JSONObject addressComponent = jsonObject.getJSONObject("regeocode").getJSONObject("addressComponent");
			strings[0] = addressComponent.getString("province");
			strings[1] = addressComponent.getString("city");
			strings[2] = addressComponent.getString("district");
		}
		return strings;
	}

}
