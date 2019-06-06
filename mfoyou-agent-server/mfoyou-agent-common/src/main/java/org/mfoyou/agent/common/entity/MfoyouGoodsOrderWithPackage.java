package org.mfoyou.agent.common.entity;

import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuUser;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrderItme;

//带包的订单
public class MfoyouGoodsOrderWithPackage extends MfoyouGoodsOrder{
	
	private List<MfoyouGoodsOrderItme> goodsOrderItmes;
	private HuawuServiceOrder serviceOrder;
	private HuawuWorker mfoyouWorker;
	private HuawuUser mfoyouUser;
	private HuawuStoreInfo storeInfo;
	private String storeStr;
	public List<MfoyouGoodsOrderItme> getGoodsOrderItmes() {
		return goodsOrderItmes;
	}
	public void setGoodsOrderItmes(List<MfoyouGoodsOrderItme> goodsOrderItmes) {
		this.goodsOrderItmes = goodsOrderItmes;
	}
	public HuawuServiceOrder getServiceOrder() {
		return serviceOrder;
	}
	public void setServiceOrder(HuawuServiceOrder serviceOrder) {
		this.serviceOrder = serviceOrder;
	}
	public HuawuWorker getMfoyouWorker() {
		return mfoyouWorker;
	}
	public void setMfoyouWorker(HuawuWorker mfoyouWorker) {
		this.mfoyouWorker = mfoyouWorker;
	}
	public HuawuUser getMfoyouUser() {
		return mfoyouUser;
	}
	public void setMfoyouUser(HuawuUser mfoyouUser) {
		this.mfoyouUser = mfoyouUser;
	}
	public HuawuStoreInfo getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(HuawuStoreInfo storeInfo) {
		this.storeInfo = storeInfo;
	}
	public String getStoreStr() {
		return storeStr;
	}
	public void setStoreStr(String storeStr) {
		this.storeStr = storeStr;
	}
	
}	
