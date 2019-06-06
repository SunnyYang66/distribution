package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuAgentInfo extends SerializableObject {
    private Integer agentId;

    private String agentName;

    private String agentUserContacts;

    private String agentPhone;

    private Integer agentAuditState;

    private String agentUserName;

    private Date agentStartTime;

    private Date agentEndTime;

    private Date createTime;

    private Date modifyTime;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName == null ? null : agentName.trim();
    }

    public String getAgentUserContacts() {
        return agentUserContacts;
    }

    public void setAgentUserContacts(String agentUserContacts) {
        this.agentUserContacts = agentUserContacts == null ? null : agentUserContacts.trim();
    }

    public String getAgentPhone() {
        return agentPhone;
    }

    public void setAgentPhone(String agentPhone) {
        this.agentPhone = agentPhone == null ? null : agentPhone.trim();
    }

    public Integer getAgentAuditState() {
        return agentAuditState;
    }

    public void setAgentAuditState(Integer agentAuditState) {
        this.agentAuditState = agentAuditState;
    }

    public String getAgentUserName() {
        return agentUserName;
    }

    public void setAgentUserName(String agentUserName) {
        this.agentUserName = agentUserName == null ? null : agentUserName.trim();
    }

    public Date getAgentStartTime() {
        return agentStartTime;
    }

    public void setAgentStartTime(Date agentStartTime) {
        this.agentStartTime = agentStartTime;
    }

    public Date getAgentEndTime() {
        return agentEndTime;
    }

    public void setAgentEndTime(Date agentEndTime) {
        this.agentEndTime = agentEndTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}