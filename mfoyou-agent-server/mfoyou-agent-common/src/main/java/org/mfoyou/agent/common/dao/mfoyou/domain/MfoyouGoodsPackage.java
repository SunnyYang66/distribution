package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsPackage extends SerializableObject {
	
    private Integer packageId;

    private Integer goodsId;

    private Integer packageCostPrice;

    private Integer packageDiscountPrice;

    private Integer packageNumber;

    private String packageName;

    private String packageContent;

    private Date packageGct;

    private Date packageGmt;

    private Double packageSortLeve;
    
    private Integer packagePackageFee;
    
    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getPackageCostPrice() {
        return packageCostPrice;
    }

    public void setPackageCostPrice(Integer packageCostPrice) {
        this.packageCostPrice = packageCostPrice;
    }

    public Integer getPackageDiscountPrice() {
        return packageDiscountPrice;
    }

    public void setPackageDiscountPrice(Integer packageDiscountPrice) {
        this.packageDiscountPrice = packageDiscountPrice;
    }

    public Integer getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(Integer packageNumber) {
        this.packageNumber = packageNumber;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getPackageContent() {
        return packageContent;
    }

    public void setPackageContent(String packageContent) {
        this.packageContent = packageContent == null ? null : packageContent.trim();
    }

    public Date getPackageGct() {
        return packageGct;
    }

    public void setPackageGct(Date packageGct) {
        this.packageGct = packageGct;
    }

    public Date getPackageGmt() {
        return packageGmt;
    }

    public void setPackageGmt(Date packageGmt) {
        this.packageGmt = packageGmt;
    }

    public Double getPackageSortLeve() {
        return packageSortLeve;
    }

    public void setPackageSortLeve(Double packageSortLeve) {
        this.packageSortLeve = packageSortLeve;
    }

	public Integer getPackagePackageFee() {
		return packagePackageFee;
	}

	public void setPackagePackageFee(Integer packagePackageFee) {
		this.packagePackageFee = packagePackageFee;
	}
}