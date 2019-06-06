package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsInfo extends SerializableObject {
    private Integer goodsId;

    private Integer storeId;

    private String goodsMainPic;

    private String goodsShowPic;

    private Date goodsGct;

    private Date goodsGmt;

    private Integer goodsShelvesState;

    private String goodsTitle;

    private Integer goodsType;

    private Integer goodsPromotionType;

    private Integer goodsSortTop;

    private Double goodsSortLeve;

    private Integer goodsPackageType;

    private Integer goodsCostPrice;

    private Integer goodsDiscountPrice;

    private Integer goodsNumber;

    private Integer goodsTotalScore;

    private Integer goodsTotalComment;

    private Integer goodsTotalSale;

    private String goodsText;
    
    private String goodStr;
    
    private Integer goodsPackageFee;
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getGoodsMainPic() {
        return goodsMainPic;
    }

    public void setGoodsMainPic(String goodsMainPic) {
        this.goodsMainPic = goodsMainPic == null ? null : goodsMainPic.trim();
    }

    public String getGoodsShowPic() {
        return goodsShowPic;
    }

    public void setGoodsShowPic(String goodsShowPic) {
        this.goodsShowPic = goodsShowPic == null ? null : goodsShowPic.trim();
    }

    public Date getGoodsGct() {
        return goodsGct;
    }

    public void setGoodsGct(Date goodsGct) {
        this.goodsGct = goodsGct;
    }

    public Date getGoodsGmt() {
        return goodsGmt;
    }

    public void setGoodsGmt(Date goodsGmt) {
        this.goodsGmt = goodsGmt;
    }

    public Integer getGoodsShelvesState() {
        return goodsShelvesState;
    }

    public void setGoodsShelvesState(Integer goodsShelvesState) {
        this.goodsShelvesState = goodsShelvesState;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle == null ? null : goodsTitle.trim();
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsPromotionType() {
        return goodsPromotionType;
    }

    public void setGoodsPromotionType(Integer goodsPromotionType) {
        this.goodsPromotionType = goodsPromotionType;
    }

    public Integer getGoodsSortTop() {
        return goodsSortTop;
    }

    public void setGoodsSortTop(Integer goodsSortTop) {
        this.goodsSortTop = goodsSortTop;
    }

    public Double getGoodsSortLeve() {
        return goodsSortLeve;
    }

    public void setGoodsSortLeve(Double goodsSortLeve) {
        this.goodsSortLeve = goodsSortLeve;
    }

    public Integer getGoodsPackageType() {
        return goodsPackageType;
    }

    public void setGoodsPackageType(Integer goodsPackageType) {
        this.goodsPackageType = goodsPackageType;
    }

    public Integer getGoodsCostPrice() {
        return goodsCostPrice;
    }

    public void setGoodsCostPrice(Integer goodsCostPrice) {
        this.goodsCostPrice = goodsCostPrice;
    }

    public Integer getGoodsDiscountPrice() {
        return goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(Integer goodsDiscountPrice) {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getGoodsTotalScore() {
        return goodsTotalScore;
    }

    public void setGoodsTotalScore(Integer goodsTotalScore) {
        this.goodsTotalScore = goodsTotalScore;
    }

    public Integer getGoodsTotalComment() {
        return goodsTotalComment;
    }

    public void setGoodsTotalComment(Integer goodsTotalComment) {
        this.goodsTotalComment = goodsTotalComment;
    }

    public Integer getGoodsTotalSale() {
        return goodsTotalSale;
    }

    public void setGoodsTotalSale(Integer goodsTotalSale) {
        this.goodsTotalSale = goodsTotalSale;
    }

    public String getGoodsText() {
        return goodsText;
    }

    public void setGoodsText(String goodsText) {
        this.goodsText = goodsText == null ? null : goodsText.trim();
    }

	public String getGoodStr() {
		return goodStr;
	}

	public void setGoodStr(String goodStr) {
		this.goodStr = goodStr;
	}

	public Integer getGoodsPackageFee() {
		return goodsPackageFee;
	}

	public void setGoodsPackageFee(Integer goodsPackageFee) {
		this.goodsPackageFee = goodsPackageFee;
	}
}