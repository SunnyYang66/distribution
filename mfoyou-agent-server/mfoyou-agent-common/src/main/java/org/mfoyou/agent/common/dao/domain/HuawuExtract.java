package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuExtract extends SerializableObject {
    private Integer extractId;

    private Integer userId;

    private Integer extractAmount;

    private Date extractTime;

    private Integer extractType;

    private String extractAccount;

    private String extractAccountName;

    private Integer extractUserType;

    private Integer extractUserBalance;

    private String extractUserPhone;

    private Integer adminId;

    private Date extractAuditTime;

    private Integer extractAuditResult;

    private Integer extractState;

    private Date extractPayTime;

    private String extractPayCode;

    private String extractRemark;

    private Date extractCreateTime;

    private Date extractModifyTime;

    private Integer agentId;

    private String extractPayResult;

    public Integer getExtractId() {
        return extractId;
    }

    public void setExtractId(Integer extractId) {
        this.extractId = extractId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getExtractAmount() {
        return extractAmount;
    }

    public void setExtractAmount(Integer extractAmount) {
        this.extractAmount = extractAmount;
    }

    public Date getExtractTime() {
        return extractTime;
    }

    public void setExtractTime(Date extractTime) {
        this.extractTime = extractTime;
    }

    public Integer getExtractType() {
        return extractType;
    }

    public void setExtractType(Integer extractType) {
        this.extractType = extractType;
    }

    public String getExtractAccount() {
        return extractAccount;
    }

    public void setExtractAccount(String extractAccount) {
        this.extractAccount = extractAccount == null ? null : extractAccount.trim();
    }

    public String getExtractAccountName() {
        return extractAccountName;
    }

    public void setExtractAccountName(String extractAccountName) {
        this.extractAccountName = extractAccountName == null ? null : extractAccountName.trim();
    }

    public Integer getExtractUserType() {
        return extractUserType;
    }

    public void setExtractUserType(Integer extractUserType) {
        this.extractUserType = extractUserType;
    }

    public Integer getExtractUserBalance() {
        return extractUserBalance;
    }

    public void setExtractUserBalance(Integer extractUserBalance) {
        this.extractUserBalance = extractUserBalance;
    }

    public String getExtractUserPhone() {
        return extractUserPhone;
    }

    public void setExtractUserPhone(String extractUserPhone) {
        this.extractUserPhone = extractUserPhone == null ? null : extractUserPhone.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getExtractAuditTime() {
        return extractAuditTime;
    }

    public void setExtractAuditTime(Date extractAuditTime) {
        this.extractAuditTime = extractAuditTime;
    }

    public Integer getExtractAuditResult() {
        return extractAuditResult;
    }

    public void setExtractAuditResult(Integer extractAuditResult) {
        this.extractAuditResult = extractAuditResult;
    }

    public Integer getExtractState() {
        return extractState;
    }

    public void setExtractState(Integer extractState) {
        this.extractState = extractState;
    }

    public Date getExtractPayTime() {
        return extractPayTime;
    }

    public void setExtractPayTime(Date extractPayTime) {
        this.extractPayTime = extractPayTime;
    }

    public String getExtractPayCode() {
        return extractPayCode;
    }

    public void setExtractPayCode(String extractPayCode) {
        this.extractPayCode = extractPayCode == null ? null : extractPayCode.trim();
    }

    public String getExtractRemark() {
        return extractRemark;
    }

    public void setExtractRemark(String extractRemark) {
        this.extractRemark = extractRemark == null ? null : extractRemark.trim();
    }

    public Date getExtractCreateTime() {
        return extractCreateTime;
    }

    public void setExtractCreateTime(Date extractCreateTime) {
        this.extractCreateTime = extractCreateTime;
    }

    public Date getExtractModifyTime() {
        return extractModifyTime;
    }

    public void setExtractModifyTime(Date extractModifyTime) {
        this.extractModifyTime = extractModifyTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getExtractPayResult() {
        return extractPayResult;
    }

    public void setExtractPayResult(String extractPayResult) {
        this.extractPayResult = extractPayResult == null ? null : extractPayResult.trim();
    }
}