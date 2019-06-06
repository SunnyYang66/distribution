package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouServiceOrderStatic extends SerializableObject{
	private int totalAmount;
	private int returnAmount;
	private int payAmount;
	private int agentAdmount;
	private String date;
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getReturnAmount() {
		return returnAmount;
	}
	public void setReturnAmount(int returnAmount) {
		this.returnAmount = returnAmount;
	}
	public int getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(int payAmount) {
		this.payAmount = payAmount;
	}
	public int getAgentAdmount() {
		return agentAdmount;
	}
	public void setAgentAdmount(int agentAdmount) {
		this.agentAdmount = agentAdmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
