package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouStoreActive extends SerializableObject {
    private Integer storeId;

    private Integer newUserActiveState;

    private Integer newUserReductionAmount;

    private Integer fullcutActiveState;

    private String fullcutAmountDescribe;

    private Date activeGct;

    private Date activeGmt;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getNewUserActiveState() {
        return newUserActiveState;
    }

    public void setNewUserActiveState(Integer newUserActiveState) {
        this.newUserActiveState = newUserActiveState;
    }

    public Integer getNewUserReductionAmount() {
        return newUserReductionAmount;
    }

    public void setNewUserReductionAmount(Integer newUserReductionAmount) {
        this.newUserReductionAmount = newUserReductionAmount;
    }

    public Integer getFullcutActiveState() {
        return fullcutActiveState;
    }

    public void setFullcutActiveState(Integer fullcutActiveState) {
        this.fullcutActiveState = fullcutActiveState;
    }

    public String getFullcutAmountDescribe() {
        return fullcutAmountDescribe;
    }

    public void setFullcutAmountDescribe(String fullcutAmountDescribe) {
        this.fullcutAmountDescribe = fullcutAmountDescribe == null ? null : fullcutAmountDescribe.trim();
    }

    public Date getActiveGct() {
        return activeGct;
    }

    public void setActiveGct(Date activeGct) {
        this.activeGct = activeGct;
    }

    public Date getActiveGmt() {
        return activeGmt;
    }

    public void setActiveGmt(Date activeGmt) {
        this.activeGmt = activeGmt;
    }
}