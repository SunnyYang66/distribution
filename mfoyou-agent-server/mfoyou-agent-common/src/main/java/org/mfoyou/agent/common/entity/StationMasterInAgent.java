package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.common.dao.domain.MfoyouStationMaster;

public class StationMasterInAgent extends MfoyouStationMaster{
	private Integer stationAmount;
	private Integer payAmount;
	private Integer orderCount;
	public Integer getStationAmount() {
		return stationAmount;
	}
	public void setStationAmount(Integer stationAmount) {
		this.stationAmount = stationAmount;
	}
	public Integer getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	

}
