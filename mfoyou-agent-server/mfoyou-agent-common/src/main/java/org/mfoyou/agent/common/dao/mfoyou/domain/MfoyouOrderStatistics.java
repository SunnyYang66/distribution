package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouOrderStatistics extends SerializableObject {
    private Integer countId;

    private Integer storeId;

    private Integer dayId;

    private Integer orderCount;

    private Integer totalAmount;

    private Integer payAmount;

    private Integer goodsCount;

    private Integer goodsAmount;

    private Integer freightAmount;

    private Integer attachAmount;

    private Date countGct;

    private Date countGmt;

    private Integer weight;

    private Integer storeAmount;

    private Integer agentAdmount;

    private Integer adminAmount;

    private Integer returnAmount;

    private Integer transpoetAmount;
    
    private Integer isIntoAccount;
    
    private String  date;
    public Integer getCountId() {
        return countId;
    }

    public void setCountId(Integer countId) {
        this.countId = countId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(Integer goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public Integer getFreightAmount() {
        return freightAmount;
    }

    public void setFreightAmount(Integer freightAmount) {
        this.freightAmount = freightAmount;
    }

    public Integer getAttachAmount() {
        return attachAmount;
    }

    public void setAttachAmount(Integer attachAmount) {
        this.attachAmount = attachAmount;
    }

    public Date getCountGct() {
        return countGct;
    }

    public void setCountGct(Date countGct) {
        this.countGct = countGct;
    }

    public Date getCountGmt() {
        return countGmt;
    }

    public void setCountGmt(Date countGmt) {
        this.countGmt = countGmt;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(Integer storeAmount) {
        this.storeAmount = storeAmount;
    }

    public Integer getAgentAdmount() {
        return agentAdmount;
    }

    public void setAgentAdmount(Integer agentAdmount) {
        this.agentAdmount = agentAdmount;
    }

    public Integer getAdminAmount() {
        return adminAmount;
    }

    public void setAdminAmount(Integer adminAmount) {
        this.adminAmount = adminAmount;
    }

    public Integer getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(Integer returnAmount) {
        this.returnAmount = returnAmount;
    }

    public Integer getTranspoetAmount() {
        return transpoetAmount;
    }

    public void setTranspoetAmount(Integer transpoetAmount) {
        this.transpoetAmount = transpoetAmount;
    }

	public Integer getIsIntoAccount() {
		return isIntoAccount;
	}

	public void setIsIntoAccount(Integer isIntoAccount) {
		this.isIntoAccount = isIntoAccount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}