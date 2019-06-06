package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuIdcardInfo extends SerializableObject {
    private Integer userId;

    private Integer userType;

    private String userTrueName;

    private String userIdCode;

    private String userHandleIdcard;

    private String userFactIdcard;

    private String userReverseIdcard;

    private Date createTime;

    private Date modifyTime;

    private Integer state;

    private Integer agentid;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUserTrueName() {
        return userTrueName;
    }

    public void setUserTrueName(String userTrueName) {
        this.userTrueName = userTrueName == null ? null : userTrueName.trim();
    }

    public String getUserIdCode() {
        return userIdCode;
    }

    public void setUserIdCode(String userIdCode) {
        this.userIdCode = userIdCode == null ? null : userIdCode.trim();
    }

    public String getUserHandleIdcard() {
        return userHandleIdcard;
    }

    public void setUserHandleIdcard(String userHandleIdcard) {
        this.userHandleIdcard = userHandleIdcard == null ? null : userHandleIdcard.trim();
    }

    public String getUserFactIdcard() {
        return userFactIdcard;
    }

    public void setUserFactIdcard(String userFactIdcard) {
        this.userFactIdcard = userFactIdcard == null ? null : userFactIdcard.trim();
    }

    public String getUserReverseIdcard() {
        return userReverseIdcard;
    }

    public void setUserReverseIdcard(String userReverseIdcard) {
        this.userReverseIdcard = userReverseIdcard == null ? null : userReverseIdcard.trim();
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAgentid() {
        return agentid;
    }

    public void setAgentid(Integer agentid) {
        this.agentid = agentid;
    }
}