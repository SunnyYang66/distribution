package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuAgentWxInfo extends SerializableObject {
    private String xcxId;

    private String xcxSecret;

    private Integer agentId;

    private Integer xcxType;

    private String xcxMchid;

    private String xcxPayRediPath;

    private Date createTime;

    private Date modifyTime;

    private String xcxPaySecret;

    public String getXcxId() {
        return xcxId;
    }

    public void setXcxId(String xcxId) {
        this.xcxId = xcxId == null ? null : xcxId.trim();
    }

    public String getXcxSecret() {
        return xcxSecret;
    }

    public void setXcxSecret(String xcxSecret) {
        this.xcxSecret = xcxSecret == null ? null : xcxSecret.trim();
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getXcxType() {
        return xcxType;
    }

    public void setXcxType(Integer xcxType) {
        this.xcxType = xcxType;
    }

    public String getXcxMchid() {
        return xcxMchid;
    }

    public void setXcxMchid(String xcxMchid) {
        this.xcxMchid = xcxMchid == null ? null : xcxMchid.trim();
    }

    public String getXcxPayRediPath() {
        return xcxPayRediPath;
    }

    public void setXcxPayRediPath(String xcxPayRediPath) {
        this.xcxPayRediPath = xcxPayRediPath == null ? null : xcxPayRediPath.trim();
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

    public String getXcxPaySecret() {
        return xcxPaySecret;
    }

    public void setXcxPaySecret(String xcxPaySecret) {
        this.xcxPaySecret = xcxPaySecret == null ? null : xcxPaySecret.trim();
    }
}