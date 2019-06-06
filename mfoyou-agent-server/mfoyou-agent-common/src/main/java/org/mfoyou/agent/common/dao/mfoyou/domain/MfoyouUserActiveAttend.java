package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouUserActiveAttend extends SerializableObject {
    private Integer attendId;

    private Integer attendUserId;

    private Integer attendStoreId;

    private Integer attendActiveId;

    private Integer attendOrderId;

    private Integer attendOrderAmount;

    private String attendActiveContent;

    private Date attendTime;

    private Date attengGmt;

    private Integer attendOrderState;

    public Integer getAttendId() {
        return attendId;
    }

    public void setAttendId(Integer attendId) {
        this.attendId = attendId;
    }

    public Integer getAttendUserId() {
        return attendUserId;
    }

    public void setAttendUserId(Integer attendUserId) {
        this.attendUserId = attendUserId;
    }

    public Integer getAttendStoreId() {
        return attendStoreId;
    }

    public void setAttendStoreId(Integer attendStoreId) {
        this.attendStoreId = attendStoreId;
    }

    public Integer getAttendActiveId() {
        return attendActiveId;
    }

    public void setAttendActiveId(Integer attendActiveId) {
        this.attendActiveId = attendActiveId;
    }

    public Integer getAttendOrderId() {
        return attendOrderId;
    }

    public void setAttendOrderId(Integer attendOrderId) {
        this.attendOrderId = attendOrderId;
    }

    public Integer getAttendOrderAmount() {
        return attendOrderAmount;
    }

    public void setAttendOrderAmount(Integer attendOrderAmount) {
        this.attendOrderAmount = attendOrderAmount;
    }

    public String getAttendActiveContent() {
        return attendActiveContent;
    }

    public void setAttendActiveContent(String attendActiveContent) {
        this.attendActiveContent = attendActiveContent == null ? null : attendActiveContent.trim();
    }

    public Date getAttendTime() {
        return attendTime;
    }

    public void setAttendTime(Date attendTime) {
        this.attendTime = attendTime;
    }

    public Date getAttengGmt() {
        return attengGmt;
    }

    public void setAttengGmt(Date attengGmt) {
        this.attengGmt = attengGmt;
    }

    public Integer getAttendOrderState() {
        return attendOrderState;
    }

    public void setAttendOrderState(Integer attendOrderState) {
        this.attendOrderState = attendOrderState;
    }
}