package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouStoreFreight extends SerializableObject {
    private Integer freightId;

    private Integer storeId;

    private Integer freightMinDistance;

    private Integer freightMaxDistance;

    private Integer freightPrice;

    private Date freightGct;

    private Date freightGmt;

    public Integer getFreightId() {
        return freightId;
    }

    public void setFreightId(Integer freightId) {
        this.freightId = freightId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getFreightMinDistance() {
        return freightMinDistance;
    }

    public void setFreightMinDistance(Integer freightMinDistance) {
        this.freightMinDistance = freightMinDistance;
    }

    public Integer getFreightMaxDistance() {
        return freightMaxDistance;
    }

    public void setFreightMaxDistance(Integer freightMaxDistance) {
        this.freightMaxDistance = freightMaxDistance;
    }

    public Integer getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(Integer freightPrice) {
        this.freightPrice = freightPrice;
    }

    public Date getFreightGct() {
        return freightGct;
    }

    public void setFreightGct(Date freightGct) {
        this.freightGct = freightGct;
    }

    public Date getFreightGmt() {
        return freightGmt;
    }

    public void setFreightGmt(Date freightGmt) {
        this.freightGmt = freightGmt;
    }
}