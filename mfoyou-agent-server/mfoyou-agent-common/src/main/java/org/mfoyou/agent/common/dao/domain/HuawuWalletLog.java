package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuWalletLog extends SerializableObject {
    private Integer walletLogId;

    private Integer userId;

    private Integer userRoleType;

    private Integer walletLogDirection;

    private Integer walletLogAmount;

    private Date walletLogTime;

    private Integer walletLogAgentId;

    private Integer walletLogType;

    private String walletLogOrderId;

    private String walletLogOpItem;

    private Integer walletLogOldValue;

    private Integer walletLogNewValue;

    private Integer walletLogResult;

    private String walletLogRemark;

    public Integer getWalletLogId() {
        return walletLogId;
    }

    public void setWalletLogId(Integer walletLogId) {
        this.walletLogId = walletLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserRoleType() {
        return userRoleType;
    }

    public void setUserRoleType(Integer userRoleType) {
        this.userRoleType = userRoleType;
    }

    public Integer getWalletLogDirection() {
        return walletLogDirection;
    }

    public void setWalletLogDirection(Integer walletLogDirection) {
        this.walletLogDirection = walletLogDirection;
    }

    public Integer getWalletLogAmount() {
        return walletLogAmount;
    }

    public void setWalletLogAmount(Integer walletLogAmount) {
        this.walletLogAmount = walletLogAmount;
    }

    public Date getWalletLogTime() {
        return walletLogTime;
    }

    public void setWalletLogTime(Date walletLogTime) {
        this.walletLogTime = walletLogTime;
    }

    public Integer getWalletLogAgentId() {
        return walletLogAgentId;
    }

    public void setWalletLogAgentId(Integer walletLogAgentId) {
        this.walletLogAgentId = walletLogAgentId;
    }

    public Integer getWalletLogType() {
        return walletLogType;
    }

    public void setWalletLogType(Integer walletLogType) {
        this.walletLogType = walletLogType;
    }

    public String getWalletLogOrderId() {
        return walletLogOrderId;
    }

    public void setWalletLogOrderId(String walletLogOrderId) {
        this.walletLogOrderId = walletLogOrderId == null ? null : walletLogOrderId.trim();
    }

    public String getWalletLogOpItem() {
        return walletLogOpItem;
    }

    public void setWalletLogOpItem(String walletLogOpItem) {
        this.walletLogOpItem = walletLogOpItem == null ? null : walletLogOpItem.trim();
    }

    public Integer getWalletLogOldValue() {
        return walletLogOldValue;
    }

    public void setWalletLogOldValue(Integer walletLogOldValue) {
        this.walletLogOldValue = walletLogOldValue;
    }

    public Integer getWalletLogNewValue() {
        return walletLogNewValue;
    }

    public void setWalletLogNewValue(Integer walletLogNewValue) {
        this.walletLogNewValue = walletLogNewValue;
    }

    public Integer getWalletLogResult() {
        return walletLogResult;
    }

    public void setWalletLogResult(Integer walletLogResult) {
        this.walletLogResult = walletLogResult;
    }

    public String getWalletLogRemark() {
        return walletLogRemark;
    }

    public void setWalletLogRemark(String walletLogRemark) {
        this.walletLogRemark = walletLogRemark == null ? null : walletLogRemark.trim();
    }
}