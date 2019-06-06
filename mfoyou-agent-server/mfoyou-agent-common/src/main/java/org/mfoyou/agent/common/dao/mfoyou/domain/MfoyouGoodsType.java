package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsType extends SerializableObject {
    private Integer typeId;

    private Integer storeId;

    private String typeName;

    private Integer typeParent;

    private Integer typeLeve;

    private Long typeSortValue;

    private Integer typeTop;

    private Integer typeVisible;

    private Date typeGct;

    private Date typeGmt;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeParent() {
        return typeParent;
    }

    public void setTypeParent(Integer typeParent) {
        this.typeParent = typeParent;
    }

    public Integer getTypeLeve() {
        return typeLeve;
    }

    public void setTypeLeve(Integer typeLeve) {
        this.typeLeve = typeLeve;
    }

    public Long getTypeSortValue() {
        return typeSortValue;
    }

    public void setTypeSortValue(Long typeSortValue) {
        this.typeSortValue = typeSortValue;
    }

    public Integer getTypeTop() {
        return typeTop;
    }

    public void setTypeTop(Integer typeTop) {
        this.typeTop = typeTop;
    }

    public Integer getTypeVisible() {
        return typeVisible;
    }

    public void setTypeVisible(Integer typeVisible) {
        this.typeVisible = typeVisible;
    }

    public Date getTypeGct() {
        return typeGct;
    }

    public void setTypeGct(Date typeGct) {
        this.typeGct = typeGct;
    }

    public Date getTypeGmt() {
        return typeGmt;
    }

    public void setTypeGmt(Date typeGmt) {
        this.typeGmt = typeGmt;
    }
}