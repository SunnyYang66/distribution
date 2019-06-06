package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuServiceTag extends SerializableObject {
    private Integer serviceTagId;

    private Integer serviceTagType;

    private Integer serviceTagMode;

    private String serviceTagName;

    private Integer serviceTagAmount;

    private Integer serviceTagPrefab;

    private Integer serviceTagUseTimes;

    private Date serviceTagCreateTime;

    private Integer serviceTagDelFlag;

    private String serviceTagPrice;

    public Integer getServiceTagId() {
        return serviceTagId;
    }

    public void setServiceTagId(Integer serviceTagId) {
        this.serviceTagId = serviceTagId;
    }

    public Integer getServiceTagType() {
        return serviceTagType;
    }

    public void setServiceTagType(Integer serviceTagType) {
        this.serviceTagType = serviceTagType;
    }

    public Integer getServiceTagMode() {
        return serviceTagMode;
    }

    public void setServiceTagMode(Integer serviceTagMode) {
        this.serviceTagMode = serviceTagMode;
    }

    public String getServiceTagName() {
        return serviceTagName;
    }

    public void setServiceTagName(String serviceTagName) {
        this.serviceTagName = serviceTagName == null ? null : serviceTagName.trim();
    }

    public Integer getServiceTagAmount() {
        return serviceTagAmount;
    }

    public void setServiceTagAmount(Integer serviceTagAmount) {
        this.serviceTagAmount = serviceTagAmount;
    }

    public Integer getServiceTagPrefab() {
        return serviceTagPrefab;
    }

    public void setServiceTagPrefab(Integer serviceTagPrefab) {
        this.serviceTagPrefab = serviceTagPrefab;
    }

    public Integer getServiceTagUseTimes() {
        return serviceTagUseTimes;
    }

    public void setServiceTagUseTimes(Integer serviceTagUseTimes) {
        this.serviceTagUseTimes = serviceTagUseTimes;
    }

    public Date getServiceTagCreateTime() {
        return serviceTagCreateTime;
    }

    public void setServiceTagCreateTime(Date serviceTagCreateTime) {
        this.serviceTagCreateTime = serviceTagCreateTime;
    }

    public Integer getServiceTagDelFlag() {
        return serviceTagDelFlag;
    }

    public void setServiceTagDelFlag(Integer serviceTagDelFlag) {
        this.serviceTagDelFlag = serviceTagDelFlag;
    }

    public String getServiceTagPrice() {
        return serviceTagPrice;
    }

    public void setServiceTagPrice(String serviceTagPrice) {
        this.serviceTagPrice = serviceTagPrice == null ? null : serviceTagPrice.trim();
    }
}