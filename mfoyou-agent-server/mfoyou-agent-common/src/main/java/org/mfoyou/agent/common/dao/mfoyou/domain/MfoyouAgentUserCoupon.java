package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouAgentUserCoupon extends SerializableObject {
    private Integer touchId;

    private Integer couponId;

    private String couponText;

    private Integer touchState;

    private Integer userId;

    private Date createTime;
    
    private Integer orderId;
    
    private Integer reduceAmount;
    public Integer getTouchId() {
        return touchId;
    }

    public void setTouchId(Integer touchId) {
        this.touchId = touchId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getCouponText() {
        return couponText;
    }

    public void setCouponText(String couponText) {
        this.couponText = couponText == null ? null : couponText.trim();
    }

    public Integer getTouchState() {
        return touchState;
    }

    public void setTouchState(Integer touchState) {
        this.touchState = touchState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getReduceAmount() {
		return reduceAmount;
	}

	public void setReduceAmount(Integer reduceAmount) {
		this.reduceAmount = reduceAmount;
	}
}