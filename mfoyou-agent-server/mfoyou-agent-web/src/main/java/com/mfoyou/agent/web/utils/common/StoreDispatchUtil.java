package com.mfoyou.agent.web.utils.common;

import java.awt.Polygon;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreDispatch;
import org.mfoyou.agent.utils.common.GisUtils;
import org.mfoyou.agent.utils.common.PolygonArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class StoreDispatchUtil {

	static Logger logger = LoggerFactory.getLogger(StoreDispatchUtil.class);
	/**
	 * 获取最低配送价格
	 * @param lat
	 * @param lon
	 * @param mfoyouStoreDispatch
	 * @param store_lat
	 * @param store_lon
	 * @return
	 */
	public static int getMinprice(double lat, double lon, MfoyouStoreDispatch mfoyouStoreDispatch, double store_lat,
			double store_lon) {
		if(mfoyouStoreDispatch==null) return -1;
		int distance = -1;
		if (mfoyouStoreDispatch.getCurrentType() == 0) {
			JSONObject areaInfo = JSON.parseObject(mfoyouStoreDispatch.getAreaFrightInfo());
			JSONArray jsonArray = areaInfo.getJSONArray("data");
			int lowret = -1;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject priceInfo = jsonArray.getJSONObject(i);
				if (priceInfo.getIntValue("regionType") == 0) {
					distance = distance == -1
							? (int) Math.round((1000 * GisUtils.distVincenty(lat, lon, store_lat, store_lon)))
							: distance;
					int fanwei = priceInfo.getIntValue("distance");
					if (fanwei > distance && (lowret > priceInfo.getIntValue("dispatchPrice") || lowret == -1)) {
						lowret = priceInfo.getIntValue("dispatchPrice");
					}
				} else if (priceInfo.getIntValue("regionType") == 1) {
					PolygonArea polygonArea = priceInfo.getObject("pointInfo", PolygonArea.class);
					if (polygonArea == null) {
						logger.error("no polygonArea");
						continue;
					}
					Polygon polygon = polygonArea.makePolygon(1000000);
					if (polygon.contains(lat * 1000000, lon * 1000000)
							&& (lowret > priceInfo.getIntValue("dispatchPrice") || lowret == -1)) {
						lowret = priceInfo.getIntValue("dispatchPrice");
					}
				}
			}
			return lowret;
		} else {
			distance = (int) Math.round((1000 * GisUtils.distVincenty(lat, lon, store_lat, store_lon)));
			JSONObject distanceInfo = JSON.parseObject(mfoyouStoreDispatch.getDistanceFrightInfo());
			int baseDistance = distanceInfo.getIntValue("baseDistance");
			int basePrice = distanceInfo.getIntValue("basePrice");
			if (distance < baseDistance) {
				return basePrice;
			}
			Integer addDistance = distanceInfo.getInteger("addDistance");
			if(addDistance==null){
				return -1;
			}
			int addPrice = distanceInfo.getIntValue("addPrice");
			return basePrice+(distance - baseDistance - 1 + addDistance) / addDistance * addPrice;
		}
	}

	/**
	 * 获取起送价
	 * 
	 * @param lat
	 * @param lon
	 * @param mfoyouStoreDispatch
	 * @param store_lat
	 * @param store_lon
	 * @return
	 */
	public static int getStartPrice(double lat, double lon, MfoyouStoreDispatch mfoyouStoreDispatch, double store_lat,
			double store_lon) {
		if(mfoyouStoreDispatch==null) return -1;
		int distance = -1;
		JSONObject areaInfo = JSON.parseObject(mfoyouStoreDispatch.getAreaFrightInfo());
		JSONArray jsonArray = areaInfo.getJSONArray("data");
		int lowret = -1;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject priceInfo = jsonArray.getJSONObject(i);
			if (priceInfo.getIntValue("regionType") == 0) {
				distance = distance == -1
						? (int) Math.round((1000 * GisUtils.distVincenty(lat, lon, store_lat, store_lon))) : distance;
				int fanwei = priceInfo.getIntValue("distance");
				if (fanwei > distance && (lowret > priceInfo.getIntValue("startPrice") || lowret == -1)) {
					lowret = priceInfo.getIntValue("startPrice");
				}
			} else if (priceInfo.getIntValue("regionType") == 1) {
				PolygonArea polygonArea = priceInfo.getObject("pointInfo", PolygonArea.class);
				if (polygonArea == null) {
					logger.error("no polygonArea");
					continue;
				}
				Polygon polygon = polygonArea.makePolygon(1000000);
				if (polygon.contains(lat * 1000000, lon * 1000000)
						&& (lowret > priceInfo.getIntValue("dispatchPrice") || lowret == -1)) {
					lowret = priceInfo.getIntValue("startPrice");
				}
			}
		}
		return lowret;
	}
	public static int getMinStartPrice(MfoyouStoreDispatch mfoyouStoreDispatch) {
		if(mfoyouStoreDispatch==null || mfoyouStoreDispatch.getAreaFrightInfo()==null){
			return 0;
		}
		JSONObject areaInfo = JSON.parseObject(mfoyouStoreDispatch.getAreaFrightInfo());
		JSONArray jsonArray = areaInfo.getJSONArray("data");
		int lowret = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject priceInfo = jsonArray.getJSONObject(i);
			if (lowret < priceInfo.getIntValue("startPrice") || lowret==-1) 
				lowret = priceInfo.getIntValue("startPrice");
		}
		return lowret;
	}

	public static int getMinFee(MfoyouStoreDispatch mfoyouStoreDispatch) {
		if(mfoyouStoreDispatch==null){
			return 0;
		}
		JSONObject areaInfo = JSON.parseObject(mfoyouStoreDispatch.getAreaFrightInfo());
		JSONArray jsonArray = areaInfo.getJSONArray("data");
		int lowret = 0;
		if(mfoyouStoreDispatch.getCurrentType()==0){
			if(mfoyouStoreDispatch.getAreaFrightInfo()==null){
				return 0;
			}
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject priceInfo = jsonArray.getJSONObject(i);
				if (lowret < priceInfo.getIntValue("dispatchPrice") || lowret==-1) 
				lowret = priceInfo.getIntValue("dispatchPrice");
			}
		}else {
			if(mfoyouStoreDispatch.getDistanceFrightInfo()==null) return -1;
			JSONObject distanceInfo = JSON.parseObject(mfoyouStoreDispatch.getDistanceFrightInfo());
			lowret = distanceInfo.getIntValue("basePrice");
		}
		return lowret;
	}
}
