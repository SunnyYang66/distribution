package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsOrderItme extends SerializableObject {
	
    private Integer orderItmeId;

    private Integer orderId;

    private Integer goodsId;

    private String goodsName;

    private String goodsPic;

    private Integer packageId;

    private String packageName;

    private Integer itemNumber;

    private Integer goodsOriginalPrice;

    private Integer goodsDealPrice;

    private Integer itemTotalAmount;

    private String itemUserNote;

    private Date itemGct;

    private Date itemGmt;
    
    private Integer killDetailId;
    
    private Integer packageFee;
    
    public Integer getOrderItmeId() {
        return orderItmeId;
    }

    public void setOrderItmeId(Integer orderItmeId) {
        this.orderItmeId = orderItmeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public Integer getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(Integer itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Integer getGoodsOriginalPrice() {
        return goodsOriginalPrice;
    }

    public void setGoodsOriginalPrice(Integer goodsOriginalPrice) {
        this.goodsOriginalPrice = goodsOriginalPrice;
    }

    public Integer getGoodsDealPrice() {
        return goodsDealPrice;
    }

    public void setGoodsDealPrice(Integer goodsDealPrice) {
        this.goodsDealPrice = goodsDealPrice;
    }

    public Integer getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Integer itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    public String getItemUserNote() {
        return itemUserNote;
    }

    public void setItemUserNote(String itemUserNote) {
        this.itemUserNote = itemUserNote == null ? null : itemUserNote.trim();
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

	public Integer getKillDetailId() {
		return killDetailId;
	}

	public void setKillDetailId(Integer killDetailId) {
		this.killDetailId = killDetailId;
	}

	public Integer getPackageFee() {
		return packageFee;
	}

	public void setPackageFee(Integer packageFee) {
		this.packageFee = packageFee;
	}
}