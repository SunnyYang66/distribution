package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouAgentTypeInfo extends SerializableObject {
    private Integer storeAgentId;

    private String typeContent;

    private Date typeCreatTime;

    private Date typeModifyTime;

    public Integer getStoreAgentId() {
        return storeAgentId;
    }

    public void setStoreAgentId(Integer storeAgentId) {
        this.storeAgentId = storeAgentId;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent == null ? null : typeContent.trim();
    }

    public Date getTypeCreatTime() {
        return typeCreatTime;
    }

    public void setTypeCreatTime(Date typeCreatTime) {
        this.typeCreatTime = typeCreatTime;
    }

    public Date getTypeModifyTime() {
        return typeModifyTime;
    }

    public void setTypeModifyTime(Date typeModifyTime) {
        this.typeModifyTime = typeModifyTime;
    }
}