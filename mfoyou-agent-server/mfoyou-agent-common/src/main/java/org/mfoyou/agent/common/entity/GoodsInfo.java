package org.mfoyou.agent.common.entity;

import java.util.ArrayList;
import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsInfo;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsPackage;
import org.mfoyou.agent.utils.common.SerializableObject;

public class GoodsInfo extends SerializableObject{
	private Integer goodsId;
	private String goodsIdStr;
	private MfoyouGoodsInfo mfoyouGoodsInfo;
	private List<MfoyouGoodsPackage> packages;
	private String phoneNum;
	public MfoyouGoodsInfo getMfoyouGoodsInfo() {
		return mfoyouGoodsInfo;
	}
	public void setMfoyouGoodsInfo(MfoyouGoodsInfo mfoyouGoodsInfo) {
		this.mfoyouGoodsInfo = mfoyouGoodsInfo;
	}
	public List<MfoyouGoodsPackage> getPackages() {
		return packages;
	}
	public void setPackages(List<MfoyouGoodsPackage> packages) {
		this.packages = packages;
	}
	public void addPackage(MfoyouGoodsPackage packagev) {
        if(this.packages==null){
            this.packages = new ArrayList<>();
        }
        packages.add(packagev);
    }
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGoodsIdStr() {
		return goodsIdStr;
	}
	public void setGoodsIdStr(String goodsIdStr) {
		this.goodsIdStr = goodsIdStr;
	}
}
