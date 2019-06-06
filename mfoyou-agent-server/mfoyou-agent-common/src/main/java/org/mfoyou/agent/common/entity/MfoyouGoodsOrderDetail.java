package org.mfoyou.agent.common.entity;

import java.util.List;

import org.mfoyou.agent.common.dao.domain.HuawuOrderLog;
import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsOrderDetail extends SerializableObject{
	private MfoyouGoodsOrder mfoyouGoodsOrder;
	private List<HuawuOrderLog> mfoyouOrderLogs ; 
	private HuawuStoreInfo mfoyouStoreInfo;
	private HuawuWorker mfoyouWorker;
	public MfoyouGoodsOrder getMfoyouGoodsOrder() {
		return mfoyouGoodsOrder;
	}
	public void setMfoyouGoodsOrder(MfoyouGoodsOrder mfoyouGoodsOrder) {
		this.mfoyouGoodsOrder = mfoyouGoodsOrder;
	}
	public List<HuawuOrderLog> getMfoyouOrderLogs() {
		return mfoyouOrderLogs;
	}
	public void setMfoyouOrderLogs(List<HuawuOrderLog> mfoyouOrderLogs) {
		this.mfoyouOrderLogs = mfoyouOrderLogs;
	}
	public HuawuStoreInfo getMfoyouStoreInfo() {
		return mfoyouStoreInfo;
	}
	public void setMfoyouStoreInfo(HuawuStoreInfo mfoyouStoreInfo) {
		this.mfoyouStoreInfo = mfoyouStoreInfo;
	}
	public HuawuWorker getMfoyouWorker() {
		return mfoyouWorker;
	}
	public void setMfoyouWorker(HuawuWorker mfoyouWorker) {
		this.mfoyouWorker = mfoyouWorker;
	}
	
}
