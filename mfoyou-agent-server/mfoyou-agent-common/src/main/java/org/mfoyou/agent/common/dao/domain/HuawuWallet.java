package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuWallet extends SerializableObject {
    private Integer userId;

    private Integer walletExtractAmount;

    private Integer walletUseAmount;

    private Integer walletFreezeAmount;

    private Integer walletRunerAmount;

    private Integer walletAgentAmount;

    private Integer walletStoreAmount;

    private Integer walletStoreAgentAmount;

    private Integer walletIntegral;

    private String walletAlipayAccount;

    private String walletWechatAccount;

    private String walletUserIdcode;

    private String walletUserName;

    private Date walletCreateTime;

    private Date walletModfiyTime;

    private Integer walletFreightAccount;

    private Integer agentId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWalletExtractAmount() {
        return walletExtractAmount;
    }

    public void setWalletExtractAmount(Integer walletExtractAmount) {
        this.walletExtractAmount = walletExtractAmount;
    }

    public Integer getWalletUseAmount() {
        return walletUseAmount;
    }

    public void setWalletUseAmount(Integer walletUseAmount) {
        this.walletUseAmount = walletUseAmount;
    }

    public Integer getWalletFreezeAmount() {
        return walletFreezeAmount;
    }

    public void setWalletFreezeAmount(Integer walletFreezeAmount) {
        this.walletFreezeAmount = walletFreezeAmount;
    }

    public Integer getWalletRunerAmount() {
        return walletRunerAmount;
    }

    public void setWalletRunerAmount(Integer walletRunerAmount) {
        this.walletRunerAmount = walletRunerAmount;
    }

    public Integer getWalletAgentAmount() {
        return walletAgentAmount;
    }

    public void setWalletAgentAmount(Integer walletAgentAmount) {
        this.walletAgentAmount = walletAgentAmount;
    }

    public Integer getWalletStoreAmount() {
        return walletStoreAmount;
    }

    public void setWalletStoreAmount(Integer walletStoreAmount) {
        this.walletStoreAmount = walletStoreAmount;
    }

    public Integer getWalletStoreAgentAmount() {
        return walletStoreAgentAmount;
    }

    public void setWalletStoreAgentAmount(Integer walletStoreAgentAmount) {
        this.walletStoreAgentAmount = walletStoreAgentAmount;
    }

    public Integer getWalletIntegral() {
        return walletIntegral;
    }

    public void setWalletIntegral(Integer walletIntegral) {
        this.walletIntegral = walletIntegral;
    }

    public String getWalletAlipayAccount() {
        return walletAlipayAccount;
    }

    public void setWalletAlipayAccount(String walletAlipayAccount) {
        this.walletAlipayAccount = walletAlipayAccount == null ? null : walletAlipayAccount.trim();
    }

    public String getWalletWechatAccount() {
        return walletWechatAccount;
    }

    public void setWalletWechatAccount(String walletWechatAccount) {
        this.walletWechatAccount = walletWechatAccount == null ? null : walletWechatAccount.trim();
    }

    public String getWalletUserIdcode() {
        return walletUserIdcode;
    }

    public void setWalletUserIdcode(String walletUserIdcode) {
        this.walletUserIdcode = walletUserIdcode == null ? null : walletUserIdcode.trim();
    }

    public String getWalletUserName() {
        return walletUserName;
    }

    public void setWalletUserName(String walletUserName) {
        this.walletUserName = walletUserName == null ? null : walletUserName.trim();
    }

    public Date getWalletCreateTime() {
        return walletCreateTime;
    }

    public void setWalletCreateTime(Date walletCreateTime) {
        this.walletCreateTime = walletCreateTime;
    }

    public Date getWalletModfiyTime() {
        return walletModfiyTime;
    }

    public void setWalletModfiyTime(Date walletModfiyTime) {
        this.walletModfiyTime = walletModfiyTime;
    }

    public Integer getWalletFreightAccount() {
        return walletFreightAccount;
    }

    public void setWalletFreightAccount(Integer walletFreightAccount) {
        this.walletFreightAccount = walletFreightAccount;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
}