package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouOrderStatic extends SerializableObject{
	private Integer payAmount;
	private Integer orderCount;
	private Integer agentAdmount;
	private Integer dayId;
	private String dayStr;
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
	public Integer getAgentAdmount() {
		return agentAdmount;
	}
	public void setAgentAdmount(Integer agentAdmount) {
		this.agentAdmount = agentAdmount;
	}
	public Integer getDayId() {
		return dayId;
	}
	public void setDayId(Integer dayId) {
		this.dayId = dayId;
	}
	public String getDayStr() {
		return dayStr;
	}
	public void setDayStr(String dayStr) {
		this.dayStr = dayStr;
	}
	
	
}
