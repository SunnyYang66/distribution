package com.mfoyou.agent.web.utils.common;

import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouAgentStoreCoupon;

public class GoodsOrderAmount {

    private Integer discountAmount;
    private Integer costAmount;
    private Integer freightAmount;
    private Integer attachAmount;
    private Integer orderTotalAmount;
    //起送费用
    private Integer storeMinGoodsAmount;
    //免邮费用
    private Integer storeFreeFreightAmount;
    //已加活动
    private Integer storeActiveId;
    private String  storeActiveContent;
    //已抵扣金额
    private Integer storeActiveAmount;
    //活动描述
    private StoreActiveInfo storeActiveInfo;
    
    private Integer packageFee;
    
    private Integer touchId;
    
    private Integer couponReduceFee ; 
    
    private List<MfoyouAgentStoreCoupon> list;
    public Integer getStoreMinGoodsAmount() {
        return storeMinGoodsAmount;
    }

    public void setStoreMinGoodsAmount(Integer storeMinGoodsAmount) {
        this.storeMinGoodsAmount = storeMinGoodsAmount;
    }

    public Integer getStoreFreeFreightAmount() {
        return storeFreeFreightAmount;
    }

    public void setStoreFreeFreightAmount(Integer storeFreeFreightAmount) {
        this.storeFreeFreightAmount = storeFreeFreightAmount;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getCostAmount() {
        return costAmount;
    }

    public void setCostAmount(Integer costAmount) {
        this.costAmount = costAmount;
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

    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Integer getStoreActiveId() {
        return storeActiveId;
    }

    public void setStoreActiveId(Integer storeActiveId) {
        this.storeActiveId = storeActiveId;
    }

    public Integer getStoreActiveAmount() {
        return storeActiveAmount;
    }

    public void setStoreActiveAmount(Integer storeActiveAmount) {
        this.storeActiveAmount = storeActiveAmount;
    }

    public StoreActiveInfo getStoreActiveInfo() {
        return storeActiveInfo;
    }

    public void setStoreActiveInfo(StoreActiveInfo storeActiveInfo) {
        this.storeActiveInfo = storeActiveInfo;
    }

    public String getStoreActiveContent() {
        return storeActiveContent;
    }

    public void setStoreActiveContent(String storeActiveContent) {
        this.storeActiveContent = storeActiveContent;
    }

	public Integer getPackageFee() {
		return packageFee;
	}

	public void setPackageFee(Integer packageFee) {
		this.packageFee = packageFee;
	}

	public List<MfoyouAgentStoreCoupon> getList() {
		return list;
	}

	public void setList(List<MfoyouAgentStoreCoupon> list) {
		this.list = list;
	}

	public Integer getTouchId() {
		return touchId;
	}

	public void setTouchId(Integer touchId) {
		this.touchId = touchId;
	}

	public Integer getCouponReduceFee() {
		return couponReduceFee;
	}

	public void setCouponReduceFee(Integer couponReduceFee) {
		this.couponReduceFee = couponReduceFee;
	}
    
}
