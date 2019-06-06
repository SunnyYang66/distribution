package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuAddress extends SerializableObject {
    private Integer addressId;

    private Integer userId;

    private String addressProvince;

    private String addressCity;

    private String addressCounty;

    private String addressArea;

    private String addressText;

    private String addressDetailed;

    private String addressLocation;

    private Double addressGisLong;

    private Double addressGisLat;

    private String addressName;

    private Integer addressSex;

    private String addressPhone;

    private String addressSparePhone;

    private Integer addressIsDel;

    private Date addressCreateTime;

    private Integer addressDefalut;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty == null ? null : addressCounty.trim();
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea == null ? null : addressArea.trim();
    }

    public String getAddressText() {
        return addressText;
    }

    public void setAddressText(String addressText) {
        this.addressText = addressText == null ? null : addressText.trim();
    }

    public String getAddressDetailed() {
        return addressDetailed;
    }

    public void setAddressDetailed(String addressDetailed) {
        this.addressDetailed = addressDetailed == null ? null : addressDetailed.trim();
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation == null ? null : addressLocation.trim();
    }

    public Double getAddressGisLong() {
        return addressGisLong;
    }

    public void setAddressGisLong(Double addressGisLong) {
        this.addressGisLong = addressGisLong;
    }

    public Double getAddressGisLat() {
        return addressGisLat;
    }

    public void setAddressGisLat(Double addressGisLat) {
        this.addressGisLat = addressGisLat;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public Integer getAddressSex() {
        return addressSex;
    }

    public void setAddressSex(Integer addressSex) {
        this.addressSex = addressSex;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone == null ? null : addressPhone.trim();
    }

    public String getAddressSparePhone() {
        return addressSparePhone;
    }

    public void setAddressSparePhone(String addressSparePhone) {
        this.addressSparePhone = addressSparePhone == null ? null : addressSparePhone.trim();
    }

    public Integer getAddressIsDel() {
        return addressIsDel;
    }

    public void setAddressIsDel(Integer addressIsDel) {
        this.addressIsDel = addressIsDel;
    }

    public Date getAddressCreateTime() {
        return addressCreateTime;
    }

    public void setAddressCreateTime(Date addressCreateTime) {
        this.addressCreateTime = addressCreateTime;
    }

    public Integer getAddressDefalut() {
        return addressDefalut;
    }

    public void setAddressDefalut(Integer addressDefalut) {
        this.addressDefalut = addressDefalut;
    }
}