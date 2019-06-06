package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.common.dao.domain.HuawuWorker;


public class HuawuAgentWorkerData extends HuawuWorker{
	private Integer todayOrderCount;
	private Integer currentOrderCount;
	private Integer money;
	private String userHeadUrl;
	private String nickName;
	public Integer getTodayOrderCount() {
		return todayOrderCount;
	}
	public void setTodayOrderCount(Integer todayOrderCount) {
		this.todayOrderCount = todayOrderCount;
	}
	public Integer getCurrentOrderCount() {
		return currentOrderCount;
	}
	public void setCurrentOrderCount(Integer currentOrderCount) {
		this.currentOrderCount = currentOrderCount;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getUserHeadUrl() {
		return userHeadUrl;
	}
	public void setUserHeadUrl(String userHeadUrl) {
		this.userHeadUrl = userHeadUrl;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
}
