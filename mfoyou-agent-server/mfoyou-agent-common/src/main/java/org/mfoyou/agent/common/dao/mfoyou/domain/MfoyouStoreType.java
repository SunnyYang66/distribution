package org.mfoyou.agent.common.dao.mfoyou.domain;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouStoreType extends SerializableObject {
    private Integer storeTypeId;

    private String storeTypeName;

    private Integer storeTypeLeve;

    private Integer storeTypeParent;

    private Integer storePercent;

    public Integer getStoreTypeId() {
        return storeTypeId;
    }

    public void setStoreTypeId(Integer storeTypeId) {
        this.storeTypeId = storeTypeId;
    }

    public String getStoreTypeName() {
        return storeTypeName;
    }

    public void setStoreTypeName(String storeTypeName) {
        this.storeTypeName = storeTypeName == null ? null : storeTypeName.trim();
    }

    public Integer getStoreTypeLeve() {
        return storeTypeLeve;
    }

    public void setStoreTypeLeve(Integer storeTypeLeve) {
        this.storeTypeLeve = storeTypeLeve;
    }

    public Integer getStoreTypeParent() {
        return storeTypeParent;
    }

    public void setStoreTypeParent(Integer storeTypeParent) {
        this.storeTypeParent = storeTypeParent;
    }

    public Integer getStorePercent() {
        return storePercent;
    }

    public void setStorePercent(Integer storePercent) {
        this.storePercent = storePercent;
    }
}