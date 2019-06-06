package org.mfoyou.agent.common.entity;

import java.io.Serializable;
import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;


public class SearchStoreInfo implements Serializable {

    private Integer               storeId;
    private String 			  storeStr;
    private HuawuStoreInfo       storeInfo;
    private List<MfoyouGoodsInfo> goodsList;
	public Integer getStoreId() {
		return storeId;
	}
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	public String getStoreStr() {
		return storeStr;
	}
	public void setStoreStr(String storeStr) {
		this.storeStr = storeStr;
	}
	public HuawuStoreInfo getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(HuawuStoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	public List<MfoyouGoodsInfo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<MfoyouGoodsInfo> goodsList) {
		this.goodsList = goodsList;
	}
    
}
