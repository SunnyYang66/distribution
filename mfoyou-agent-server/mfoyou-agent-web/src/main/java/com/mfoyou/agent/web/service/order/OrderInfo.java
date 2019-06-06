package com.mfoyou.agent.web.service.order;

import org.mfoyou.agent.common.dao.domain.HuawuServiceOrder;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouGoodsOrder;
import org.mfoyou.agent.common.entity.enums.OrderType;

public class OrderInfo {

	private Integer orderId;
	private Integer orderType;
	private String orderTitle;
	private String orderNumber;
	private Integer orderUserId;

	private Integer storeId;
	private Integer agentId;
	private Integer orderState;
	private Integer orderAmount;
	private Integer orderPaidAmount;
	private String  payRemark;
	private Integer subItemCount=0;
	private Integer couponReduceMoney;
	public OrderInfo(HuawuServiceOrder mfoyouServiceOrder){
		orderId = mfoyouServiceOrder.getServiceOrderId();
		orderType = 1;
		orderTitle = mfoyouServiceOrder.getServiceOrderTitle();
		orderNumber = mfoyouServiceOrder.getServiceOrderNumber();
		agentId = mfoyouServiceOrder.getAgentId();
		orderState = mfoyouServiceOrder.getServiceOrderState();
		orderAmount = mfoyouServiceOrder.getServiceOrderAmount() + mfoyouServiceOrder.getServiceOrderGoodAmount();
		orderPaidAmount = mfoyouServiceOrder.getServiceOrderPayAmount();
		orderUserId = mfoyouServiceOrder.getServiceOrderSendUser();
		payRemark = mfoyouServiceOrder.getServicePayType();
		storeId = mfoyouServiceOrder.getServiceOrderSource();
		couponReduceMoney=0;
	}
	
	public OrderInfo(MfoyouGoodsOrder mfoyouGoodsOrder){
        orderId = mfoyouGoodsOrder.getOrderId();
        orderType = OrderType.goodsOrder.getValue();
        orderTitle = mfoyouGoodsOrder.getOrderTitle();
        orderNumber = mfoyouGoodsOrder.getOrderNumber();
        agentId = mfoyouGoodsOrder.getAreaAgentId();
        orderState = mfoyouGoodsOrder.getOrderState();
        orderAmount =mfoyouGoodsOrder.getOrderTotalAmount();
        orderPaidAmount = mfoyouGoodsOrder.getOrderPayAmount();
        orderUserId = mfoyouGoodsOrder.getUserId();
        payRemark = mfoyouGoodsOrder.getOrderPayRemark();
        storeId = mfoyouGoodsOrder.getStoreId();
        subItemCount = mfoyouGoodsOrder.getOrderGoodsCount();
        couponReduceMoney=mfoyouGoodsOrder.getCouponReduceMoney()==null?0:mfoyouGoodsOrder.getCouponReduceMoney();
    }
	
	public OrderInfo(){
		
	}

	public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getOrderPaidAmount() {
		return orderPaidAmount;
	}

	public void setOrderPaidAmount(Integer orderPaidAmount) {
		this.orderPaidAmount = orderPaidAmount;
	}

	public Integer getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(Integer orderUserId) {
		this.orderUserId = orderUserId;
	}

	public String getPayRemark() {
		return payRemark;
	}

	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

    public Integer getSubItemCount() {
        return subItemCount;
    }

    public void setSubItemCount(Integer subItemCount) {
        this.subItemCount = subItemCount;
    }

	public Integer getCouponReduceMoney() {
		return couponReduceMoney;
	}

	public void setCouponReduceMoney(Integer couponReduceMoney) {
		this.couponReduceMoney = couponReduceMoney;
	}
	
}
