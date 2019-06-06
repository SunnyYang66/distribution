package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.common.dao.domain.HuawuIdcardInfo;
import org.mfoyou.agent.common.dao.domain.HuawuWorker;


public class HuawuAgentWokerInfo extends HuawuWorker {
	private int orderCountYesterDay;
	private int streamYesterday;
	private int moneyYesterday;
	private int getAmount;
	private int percent;
	private String  stationName;
	private HuawuIdcardInfo mfoyouIdcardInfo;
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
	public int getGetAmount() {
		return getAmount;
	}
	public void setGetAmount(int getAmount) {
		this.getAmount = getAmount;
	}
	public int getPercent() {
		return percent;
	}
	public void setPercent(int percent) {
		this.percent = percent;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public HuawuIdcardInfo getMfoyouIdcardInfo() {
		return mfoyouIdcardInfo;
	}
	public void setMfoyouIdcardInfo(HuawuIdcardInfo mfoyouIdcardInfo) {
		this.mfoyouIdcardInfo = mfoyouIdcardInfo;
	}
	
}
