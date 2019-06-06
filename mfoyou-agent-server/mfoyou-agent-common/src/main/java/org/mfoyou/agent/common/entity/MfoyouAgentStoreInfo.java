package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.common.dao.domain.HuawuStoreInfo;


/**
 * the store info  show in agent 
 * so this info must contain data in yesterday.
 * @author Administrator
 *
 */
public class MfoyouAgentStoreInfo extends HuawuStoreInfo{
	private int orderCountYesterDay;
	private int streamYesterday;
	private int moneyYesterday;
	private String typeName;
	private String stationName;
	public int getOrderCountYesterDay() {
		return orderCountYesterDay;
	}
	public void setOrderCountYesterDay(int orderCountYesterDay) {
		this.orderCountYesterDay = orderCountYesterDay;
	}
	public int getStreamYesterday() {
		return streamYesterday;
	}
	public void setStreamYesterday(int streamYesterday) {
		this.streamYesterday = streamYesterday;
	}
	public int getMoneyYesterday() {
		return moneyYesterday;
	}
	public void setMoneyYesterday(int moneyYesterday) {
		this.moneyYesterday = moneyYesterday;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
}
