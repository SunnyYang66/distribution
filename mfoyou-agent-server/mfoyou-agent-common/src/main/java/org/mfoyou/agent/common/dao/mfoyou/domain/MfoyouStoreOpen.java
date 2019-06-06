package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouStoreOpen extends SerializableObject {
    private Integer openId;

    private Integer openStartTime;

    private Integer openEndTime;

    private Integer storeId;

    private Integer openEffect;

    private Date openGct;

    private Date openGmt;

    public Integer getOpenId() {
        return openId;
    }

    public void setOpenId(Integer openId) {
        this.openId = openId;
    }

    public Integer getOpenStartTime() {
        return openStartTime;
    }

    public void setOpenStartTime(Integer openStartTime) {
        this.openStartTime = openStartTime;
    }

    public Integer getOpenEndTime() {
        return openEndTime;
    }

    public void setOpenEndTime(Integer openEndTime) {
        this.openEndTime = openEndTime;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getOpenEffect() {
        return openEffect;
    }

    public void setOpenEffect(Integer openEffect) {
        this.openEffect = openEffect;
    }

    public Date getOpenGct() {
        return openGct;
    }

    public void setOpenGct(Date openGct) {
        this.openGct = openGct;
    }

    public Date getOpenGmt() {
        return openGmt;
    }

    public void setOpenGmt(Date openGmt) {
        this.openGmt = openGmt;
    }
}