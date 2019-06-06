package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuOrderLog extends SerializableObject {
    private Integer orderLogId;

    private Integer serviceOrderId;

    private Integer orderType;

    private Integer orderLogState;

    private Integer orderLogUserId;

    private Date orderLogTime;

    private String orderLogRemark;

    private Integer orderAgentid;

    public Integer getOrderLogId() {
        return orderLogId;
    }

    public void setOrderLogId(Integer orderLogId) {
        this.orderLogId = orderLogId;
    }

    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderLogState() {
        return orderLogState;
    }

    public void setOrderLogState(Integer orderLogState) {
        this.orderLogState = orderLogState;
    }

    public Integer getOrderLogUserId() {
        return orderLogUserId;
    }

    public void setOrderLogUserId(Integer orderLogUserId) {
        this.orderLogUserId = orderLogUserId;
    }

    public Date getOrderLogTime() {
        return orderLogTime;
    }

    public void setOrderLogTime(Date orderLogTime) {
        this.orderLogTime = orderLogTime;
    }

    public String getOrderLogRemark() {
        return orderLogRemark;
    }

    public void setOrderLogRemark(String orderLogRemark) {
        this.orderLogRemark = orderLogRemark == null ? null : orderLogRemark.trim();
    }

    public Integer getOrderAgentid() {
        return orderAgentid;
    }

    public void setOrderAgentid(Integer orderAgentid) {
        this.orderAgentid = orderAgentid;
    }
}