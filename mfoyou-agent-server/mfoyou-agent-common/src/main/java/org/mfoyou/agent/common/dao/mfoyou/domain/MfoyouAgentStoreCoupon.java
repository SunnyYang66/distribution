package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouAgentStoreCoupon extends SerializableObject {
	
    private Integer couponId;

    private Integer agentId;

    private String couponName;

    private Integer couponCount;

    private Integer couponSold;

    private String couponText;

    private Date couponCreateTime;

    private Date couponModifyTime;

    private Date couponStartTime;

    private Date couponLimitTime;

    private Integer useType;

    private Integer couponState;

    private String storeList;

    private Integer reducetype;

    private Integer reducevalue;

    private Integer limitmoney;
    
    private Integer touchId;
    
    private Integer hasUsed;
    
    private String  typeNameValue;
    
    
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public Integer getCouponSold() {
        return couponSold;
    }

    public void setCouponSold(Integer couponSold) {
        this.couponSold = couponSold;
    }

    public String getCouponText() {
        return couponText;
    }

    public void setCouponText(String couponText) {
        this.couponText = couponText == null ? null : couponText.trim();
    }

    public Date getCouponCreateTime() {
        return couponCreateTime;
    }

    public void setCouponCreateTime(Date couponCreateTime) {
        this.couponCreateTime = couponCreateTime;
    }

    public Date getCouponModifyTime() {
        return couponModifyTime;
    }

    public void setCouponModifyTime(Date couponModifyTime) {
        this.couponModifyTime = couponModifyTime;
    }

    public Date getCouponStartTime() {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponLimitTime() {
        return couponLimitTime;
    }

    public void setCouponLimitTime(Date couponLimitTime) {
        this.couponLimitTime = couponLimitTime;
    }

    public Integer getUseType() {
        return useType;
    }

    public void setUseType(Integer useType) {
        this.useType = useType;
    }

    public Integer getCouponState() {
        return couponState;
    }

    public void setCouponState(Integer couponState) {
        this.couponState = couponState;
    }

    public String getStoreList() {
        return storeList;
    }

    public void setStoreList(String storeList) {
        this.storeList = storeList == null ? null : storeList.trim();
    }

    public Integer getReducetype() {
        return reducetype;
    }

    public void setReducetype(Integer reducetype) {
        this.reducetype = reducetype;
    }

    public Integer getReducevalue() {
        return reducevalue;
    }

    public void setReducevalue(Integer reducevalue) {
        this.reducevalue = reducevalue;
    }

    public Integer getLimitmoney() {
        return limitmoney;
    }

    public void setLimitmoney(Integer limitmoney) {
        this.limitmoney = limitmoney;
    }

	public Integer getTouchId() {
		return touchId;
	}

	public void setTouchId(Integer touchId) {
		this.touchId = touchId;
	}

	public Integer getHasUsed() {
		return hasUsed;
	}

	public void setHasUsed(Integer hasUsed) {
		this.hasUsed = hasUsed;
	}

	public String getTypeNameValue() {
		return typeNameValue;
	}

	public void setTypeNameValue(String typeNameValue) {
		this.typeNameValue = typeNameValue;
	}
}