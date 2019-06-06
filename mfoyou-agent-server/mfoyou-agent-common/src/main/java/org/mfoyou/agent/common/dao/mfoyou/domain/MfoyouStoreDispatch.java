package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;


public class MfoyouStoreDispatch extends SerializableObject {
    private Integer storeId;

    private String areaFrightInfo;

    private String distanceFrightInfo;

    private Integer currentType;

    private Date creatTime;

    private Date modifyTime;
    
    private double store_lon;
    
    private double store_lat;
    
    private String stationName;
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getAreaFrightInfo() {
        return areaFrightInfo;
    }

    public void setAreaFrightInfo(String areaFrightInfo) {
        this.areaFrightInfo = areaFrightInfo == null ? null : areaFrightInfo.trim();
    }

    public String getDistanceFrightInfo() {
        return distanceFrightInfo;
    }

    public void setDistanceFrightInfo(String distanceFrightInfo) {
        this.distanceFrightInfo = distanceFrightInfo == null ? null : distanceFrightInfo.trim();
    }

    public Integer getCurrentType() {
        return currentType;
    }

    public void setCurrentType(Integer currentType) {
        this.currentType = currentType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
    public double getStore_lon() {
		return store_lon;
	}

	public void setStore_lon(double store_lon) {
		this.store_lon = store_lon;
	}

	public double getStore_lat() {
		return store_lat;
	}

	public void setStore_lat(double store_lat) {
		this.store_lat = store_lat;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
}