package org.mfoyou.agent.common.dao.mfoyou.domain;


import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsSearch extends SerializableObject {
    private Integer searchId;

    private String searchName;

    private Integer searchTimes;

    private Date searchGct;

    private Integer searchTop;

    private Date searchGmt;

    private Integer searchWeight;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName == null ? null : searchName.trim();
    }

    public Integer getSearchTimes() {
        return searchTimes;
    }

    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }

    public Date getSearchGct() {
        return searchGct;
    }

    public void setSearchGct(Date searchGct) {
        this.searchGct = searchGct;
    }

    public Integer getSearchTop() {
        return searchTop;
    }

    public void setSearchTop(Integer searchTop) {
        this.searchTop = searchTop;
    }

    public Date getSearchGmt() {
        return searchGmt;
    }

    public void setSearchGmt(Date searchGmt) {
        this.searchGmt = searchGmt;
    }

    public Integer getSearchWeight() {
        return searchWeight;
    }

    public void setSearchWeight(Integer searchWeight) {
        this.searchWeight = searchWeight;
    }
}