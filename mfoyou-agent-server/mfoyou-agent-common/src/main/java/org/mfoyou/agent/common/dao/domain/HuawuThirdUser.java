package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuThirdUser extends SerializableObject {
    private Integer thirdUserId;

    private Integer userId;

    private String openId;

    private Integer appTypeId;

    private String thirdUserInfo;

    private Date wxRegistTime;

    private Date wxModifyTime;

    private Integer agentId;

    public Integer getThirdUserId() {
        return thirdUserId;
    }

    public void setThirdUserId(Integer thirdUserId) {
        this.thirdUserId = thirdUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public Integer getAppTypeId() {
        return appTypeId;
    }

    public void setAppTypeId(Integer appTypeId) {
        this.appTypeId = appTypeId;
    }

    public String getThirdUserInfo() {
        return thirdUserInfo;
    }

    public void setThirdUserInfo(String thirdUserInfo) {
        this.thirdUserInfo = thirdUserInfo == null ? null : thirdUserInfo.trim();
    }

    public Date getWxRegistTime() {
        return wxRegistTime;
    }

    public void setWxRegistTime(Date wxRegistTime) {
        this.wxRegistTime = wxRegistTime;
    }

    public Date getWxModifyTime() {
        return wxModifyTime;
    }

    public void setWxModifyTime(Date wxModifyTime) {
        this.wxModifyTime = wxModifyTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
}