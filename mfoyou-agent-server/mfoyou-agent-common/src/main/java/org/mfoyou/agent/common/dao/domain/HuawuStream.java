package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuStream extends SerializableObject {
    private Integer streamId;

    private Date streamTime;

    private Integer streamOrderId;

    private Integer streamOrderType;

    private Integer streamDirection;

    private Integer streamAmount;

    private String streamRemark;

    private Integer streamState;

    private Integer streamSource;

    private Integer streamTarget;

    private Integer streamUserId;

    private Integer streamUserType;

    public Integer getStreamId() {
        return streamId;
    }

    public void setStreamId(Integer streamId) {
        this.streamId = streamId;
    }

    public Date getStreamTime() {
        return streamTime;
    }

    public void setStreamTime(Date streamTime) {
        this.streamTime = streamTime;
    }

    public Integer getStreamOrderId() {
        return streamOrderId;
    }

    public void setStreamOrderId(Integer streamOrderId) {
        this.streamOrderId = streamOrderId;
    }

    public Integer getStreamOrderType() {
        return streamOrderType;
    }

    public void setStreamOrderType(Integer streamOrderType) {
        this.streamOrderType = streamOrderType;
    }

    public Integer getStreamDirection() {
        return streamDirection;
    }

    public void setStreamDirection(Integer streamDirection) {
        this.streamDirection = streamDirection;
    }

    public Integer getStreamAmount() {
        return streamAmount;
    }

    public void setStreamAmount(Integer streamAmount) {
        this.streamAmount = streamAmount;
    }

    public String getStreamRemark() {
        return streamRemark;
    }

    public void setStreamRemark(String streamRemark) {
        this.streamRemark = streamRemark == null ? null : streamRemark.trim();
    }

    public Integer getStreamState() {
        return streamState;
    }

    public void setStreamState(Integer streamState) {
        this.streamState = streamState;
    }

    public Integer getStreamSource() {
        return streamSource;
    }

    public void setStreamSource(Integer streamSource) {
        this.streamSource = streamSource;
    }

    public Integer getStreamTarget() {
        return streamTarget;
    }

    public void setStreamTarget(Integer streamTarget) {
        this.streamTarget = streamTarget;
    }

    public Integer getStreamUserId() {
        return streamUserId;
    }

    public void setStreamUserId(Integer streamUserId) {
        this.streamUserId = streamUserId;
    }

    public Integer getStreamUserType() {
        return streamUserType;
    }

    public void setStreamUserType(Integer streamUserType) {
        this.streamUserType = streamUserType;
    }
}