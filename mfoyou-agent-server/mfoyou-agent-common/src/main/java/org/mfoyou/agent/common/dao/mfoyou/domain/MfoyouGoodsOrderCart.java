package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsOrderCart extends SerializableObject {
    private Integer cartItmeId;

    private Integer storeId;

    private Integer goodsId;

    private Integer packageId;
    
    private String storeStr;
    
    private Integer userId;

    private Integer itemNumber;

    private String itemUserNonte;

    private Integer itemSelect;

    private Date itemGct;

    private Date itemGmt;

    public Integer getCartItmeId() {
        return cartItmeId;
    }

    public void setCartItmeId(Integer cartItmeId) {
        this.cartItmeId = cartItmeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getItemUserNonte() {
        return itemUserNonte;
    }

    public void setItemUserNonte(String itemUserNonte) {
        this.itemUserNonte = itemUserNonte == null ? null : itemUserNonte.trim();
    }

    public Integer getItemSelect() {
        return itemSelect;
    }

    public void setItemSelect(Integer itemSelect) {
        this.itemSelect = itemSelect;
    }

    public Date getItemGct() {
        return itemGct;
    }

    public void setItemGct(Date itemGct) {
        this.itemGct = itemGct;
    }

    public Date getItemGmt() {
        return itemGmt;
    }

    public void setItemGmt(Date itemGmt) {
        this.itemGmt = itemGmt;
    }

	public String getStoreStr() {
		return storeStr;
	}

	public void setStoreStr(String  storeStr) {
		this.storeStr = storeStr;
	}
}