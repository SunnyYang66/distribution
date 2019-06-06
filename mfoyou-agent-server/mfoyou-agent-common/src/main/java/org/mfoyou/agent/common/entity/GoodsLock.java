package org.mfoyou.agent.common.entity;

import java.io.Serializable;

public class GoodsLock implements Serializable {
    
    private Integer goodsId;
    private Integer packageId;
    private Integer curCount;
    private Integer subCount;
    private Integer saleCount;
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
    public Integer getCurCount() {
        return curCount;
    }
    public void setCurCount(Integer curCount) {
        this.curCount = curCount;
    }
    public Integer getSubCount() {
        return subCount;
    }
    public void setSubCount(Integer subCount) {
        this.subCount = subCount;
    }
    public Integer getSaleCount() {
        return saleCount;
    }
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
    
}
