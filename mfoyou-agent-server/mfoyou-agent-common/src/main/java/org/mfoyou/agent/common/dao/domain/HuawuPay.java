package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuPay extends SerializableObject {
    private Integer payId;

    private Integer userId;

    private String payNumber;

    private Integer payOrderType;

    private Integer payOrderId;

    private Integer payType;

    private String payPreId;

    private String payPreText;

    private Integer payAmount;

    private String payCallbackText;

    private Integer payState;

    private Date payCreateTime;

    private Date payModifyTime;

    private Integer payAppId;

    private Integer payStoreId;

    private String userName;
    
    private Integer agentId;
    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber == null ? null : payNumber.trim();
    }

    public Integer getPayOrderType() {
        return payOrderType;
    }

    public void setPayOrderType(Integer payOrderType) {
        this.payOrderType = payOrderType;
    }

    public Integer getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Integer payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayPreId() {
        return payPreId;
    }

    public void setPayPreId(String payPreId) {
        this.payPreId = payPreId == null ? null : payPreId.trim();
    }

    public String getPayPreText() {
        return payPreText;
    }

    public void setPayPreText(String payPreText) {
        this.payPreText = payPreText == null ? null : payPreText.trim();
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayCallbackText() {
        return payCallbackText;
    }

    public void setPayCallbackText(String payCallbackText) {
        this.payCallbackText = payCallbackText == null ? null : payCallbackText.trim();
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Date getPayCreateTime() {
        return payCreateTime;
    }

    public void setPayCreateTime(Date payCreateTime) {
        this.payCreateTime = payCreateTime;
    }

    public Date getPayModifyTime() {
        return payModifyTime;
    }

    public void setPayModifyTime(Date payModifyTime) {
        this.payModifyTime = payModifyTime;
    }

    public Integer getPayAppId() {
        return payAppId;
    }

    public void setPayAppId(Integer payAppId) {
        this.payAppId = payAppId;
    }

    public Integer getPayStoreId() {
        return payStoreId;
    }

    public void setPayStoreId(Integer payStoreId) {
        this.payStoreId = payStoreId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

	public Integer getAgentId() {
		return agentId;
	}

	public void setAgentId(Integer agentId) {
		this.agentId = agentId;
	}
}