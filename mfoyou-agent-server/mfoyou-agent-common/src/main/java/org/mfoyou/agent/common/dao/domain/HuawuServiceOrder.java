package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuServiceOrder extends SerializableObject {
    private Integer serviceOrderId;

    private Integer agentId;

    private Integer serviceTagId;

    private Double serviceUserLat;

    private Double serviceUserLon;

    private String serviceTagName;

    private String serviceOrderNumber;

    private Integer serviceOrderBespeak;

    private Date serviceOrderEffectTime;

    private Integer serviceOrderSendUser;

    private Integer serviceOrderReceiveUser;

    private Integer serviceOrderType;

    private Integer serviceOrderSmallType;

    private String serviceOrderTitle;

    private String serviceOrderContent;

    private Integer serviceOrderStartAmount;

    private Integer serviceOrderDistanceAmount;

    private Integer serviceOrderWeightAmount;

    private Integer serviceOrderAttachAmount;

    private Integer serviceOrderAmount;

    private Integer serviceOrderGoodAmount;

    private Integer serviceOrderPayAmount;

    private Integer serviceOrderState;

    private String serviceOrderRemark;

    private String serviceOrderDeliveryContactName;

    private String serviceOrderDeliveryAddress;

    private String serviceOrderDeliveryContactNumber;

    private Double serviceOrderDeliveryAddressLon;

    private Double serviceOrderDeliveryAddressLat;

    private String serviceOrderPickupAddress;

    private Double serviceOrderPickupAddressLon;

    private Double serviceOrderPickupAddressLat;

    private String serviceOrderPickupContactNumber;

    private String serviceOrderPickupContactName;

    private Integer serviceOrderWeight;

    private Integer serviceOrderDistance;

    private Date serviceOrderCreateTime;

    private Date serviceOrderModifyTime;

    private Date serviceOrderAllSeeTime;

    private Date serviceOrderFinshTime;

    private Integer serviceOrderIsComment;

    private Integer serviceOrderNightAmount;

    private Integer serviceOrderPriceCoeffcient;

    private String serviceOrderAttachment;

    private String servicePayType;

    private Integer serviceAgentAmount;

    private Integer serviceAdminAmount;

    private Integer serviceOrderSource;

    private Integer serviceOrderSourceId;

    private Integer serviceOrderUrge;

    private Integer serviceOrderAbnormal;

    private Integer stationId;
    
    private Integer serviceStationAmount;
    public Integer getServiceOrderId() {
        return serviceOrderId;
    }

    public void setServiceOrderId(Integer serviceOrderId) {
        this.serviceOrderId = serviceOrderId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getServiceTagId() {
        return serviceTagId;
    }

    public void setServiceTagId(Integer serviceTagId) {
        this.serviceTagId = serviceTagId;
    }

    public Double getServiceUserLat() {
        return serviceUserLat;
    }

    public void setServiceUserLat(Double serviceUserLat) {
        this.serviceUserLat = serviceUserLat;
    }

    public Double getServiceUserLon() {
        return serviceUserLon;
    }

    public void setServiceUserLon(Double serviceUserLon) {
        this.serviceUserLon = serviceUserLon;
    }

    public String getServiceTagName() {
        return serviceTagName;
    }

    public void setServiceTagName(String serviceTagName) {
        this.serviceTagName = serviceTagName == null ? null : serviceTagName.trim();
    }

    public String getServiceOrderNumber() {
        return serviceOrderNumber;
    }

    public void setServiceOrderNumber(String serviceOrderNumber) {
        this.serviceOrderNumber = serviceOrderNumber == null ? null : serviceOrderNumber.trim();
    }

    public Integer getServiceOrderBespeak() {
        return serviceOrderBespeak;
    }

    public void setServiceOrderBespeak(Integer serviceOrderBespeak) {
        this.serviceOrderBespeak = serviceOrderBespeak;
    }

    public Date getServiceOrderEffectTime() {
        return serviceOrderEffectTime;
    }

    public void setServiceOrderEffectTime(Date serviceOrderEffectTime) {
        this.serviceOrderEffectTime = serviceOrderEffectTime;
    }

    public Integer getServiceOrderSendUser() {
        return serviceOrderSendUser;
    }

    public void setServiceOrderSendUser(Integer serviceOrderSendUser) {
        this.serviceOrderSendUser = serviceOrderSendUser;
    }

    public Integer getServiceOrderReceiveUser() {
        return serviceOrderReceiveUser;
    }

    public void setServiceOrderReceiveUser(Integer serviceOrderReceiveUser) {
        this.serviceOrderReceiveUser = serviceOrderReceiveUser;
    }

    public Integer getServiceOrderType() {
        return serviceOrderType;
    }

    public void setServiceOrderType(Integer serviceOrderType) {
        this.serviceOrderType = serviceOrderType;
    }

    public Integer getServiceOrderSmallType() {
        return serviceOrderSmallType;
    }

    public void setServiceOrderSmallType(Integer serviceOrderSmallType) {
        this.serviceOrderSmallType = serviceOrderSmallType;
    }

    public String getServiceOrderTitle() {
        return serviceOrderTitle;
    }

    public void setServiceOrderTitle(String serviceOrderTitle) {
        this.serviceOrderTitle = serviceOrderTitle == null ? null : serviceOrderTitle.trim();
    }

    public String getServiceOrderContent() {
        return serviceOrderContent;
    }

    public void setServiceOrderContent(String serviceOrderContent) {
        this.serviceOrderContent = serviceOrderContent == null ? null : serviceOrderContent.trim();
    }

    public Integer getServiceOrderStartAmount() {
        return serviceOrderStartAmount;
    }

    public void setServiceOrderStartAmount(Integer serviceOrderStartAmount) {
        this.serviceOrderStartAmount = serviceOrderStartAmount;
    }

    public Integer getServiceOrderDistanceAmount() {
        return serviceOrderDistanceAmount;
    }

    public void setServiceOrderDistanceAmount(Integer serviceOrderDistanceAmount) {
        this.serviceOrderDistanceAmount = serviceOrderDistanceAmount;
    }

    public Integer getServiceOrderWeightAmount() {
        return serviceOrderWeightAmount;
    }

    public void setServiceOrderWeightAmount(Integer serviceOrderWeightAmount) {
        this.serviceOrderWeightAmount = serviceOrderWeightAmount;
    }

    public Integer getServiceOrderAttachAmount() {
        return serviceOrderAttachAmount;
    }

    public void setServiceOrderAttachAmount(Integer serviceOrderAttachAmount) {
        this.serviceOrderAttachAmount = serviceOrderAttachAmount;
    }

    public Integer getServiceOrderAmount() {
        return serviceOrderAmount;
    }

    public void setServiceOrderAmount(Integer serviceOrderAmount) {
        this.serviceOrderAmount = serviceOrderAmount;
    }

    public Integer getServiceOrderGoodAmount() {
        return serviceOrderGoodAmount;
    }

    public void setServiceOrderGoodAmount(Integer serviceOrderGoodAmount) {
        this.serviceOrderGoodAmount = serviceOrderGoodAmount;
    }

    public Integer getServiceOrderPayAmount() {
        return serviceOrderPayAmount;
    }

    public void setServiceOrderPayAmount(Integer serviceOrderPayAmount) {
        this.serviceOrderPayAmount = serviceOrderPayAmount;
    }

    public Integer getServiceOrderState() {
        return serviceOrderState;
    }

    public void setServiceOrderState(Integer serviceOrderState) {
        this.serviceOrderState = serviceOrderState;
    }

    public String getServiceOrderRemark() {
        return serviceOrderRemark;
    }

    public void setServiceOrderRemark(String serviceOrderRemark) {
        this.serviceOrderRemark = serviceOrderRemark == null ? null : serviceOrderRemark.trim();
    }

    public String getServiceOrderDeliveryContactName() {
        return serviceOrderDeliveryContactName;
    }

    public void setServiceOrderDeliveryContactName(String serviceOrderDeliveryContactName) {
        this.serviceOrderDeliveryContactName = serviceOrderDeliveryContactName == null ? null : serviceOrderDeliveryContactName.trim();
    }

    public String getServiceOrderDeliveryAddress() {
        return serviceOrderDeliveryAddress;
    }

    public void setServiceOrderDeliveryAddress(String serviceOrderDeliveryAddress) {
        this.serviceOrderDeliveryAddress = serviceOrderDeliveryAddress == null ? null : serviceOrderDeliveryAddress.trim();
    }

    public String getServiceOrderDeliveryContactNumber() {
        return serviceOrderDeliveryContactNumber;
    }

    public void setServiceOrderDeliveryContactNumber(String serviceOrderDeliveryContactNumber) {
        this.serviceOrderDeliveryContactNumber = serviceOrderDeliveryContactNumber == null ? null : serviceOrderDeliveryContactNumber.trim();
    }

    public Double getServiceOrderDeliveryAddressLon() {
        return serviceOrderDeliveryAddressLon;
    }

    public void setServiceOrderDeliveryAddressLon(Double serviceOrderDeliveryAddressLon) {
        this.serviceOrderDeliveryAddressLon = serviceOrderDeliveryAddressLon;
    }

    public Double getServiceOrderDeliveryAddressLat() {
        return serviceOrderDeliveryAddressLat;
    }

    public void setServiceOrderDeliveryAddressLat(Double serviceOrderDeliveryAddressLat) {
        this.serviceOrderDeliveryAddressLat = serviceOrderDeliveryAddressLat;
    }

    public String getServiceOrderPickupAddress() {
        return serviceOrderPickupAddress;
    }

    public void setServiceOrderPickupAddress(String serviceOrderPickupAddress) {
        this.serviceOrderPickupAddress = serviceOrderPickupAddress == null ? null : serviceOrderPickupAddress.trim();
    }

    public Double getServiceOrderPickupAddressLon() {
        return serviceOrderPickupAddressLon;
    }

    public void setServiceOrderPickupAddressLon(Double serviceOrderPickupAddressLon) {
        this.serviceOrderPickupAddressLon = serviceOrderPickupAddressLon;
    }

    public Double getServiceOrderPickupAddressLat() {
        return serviceOrderPickupAddressLat;
    }

    public void setServiceOrderPickupAddressLat(Double serviceOrderPickupAddressLat) {
        this.serviceOrderPickupAddressLat = serviceOrderPickupAddressLat;
    }

    public String getServiceOrderPickupContactNumber() {
        return serviceOrderPickupContactNumber;
    }

    public void setServiceOrderPickupContactNumber(String serviceOrderPickupContactNumber) {
        this.serviceOrderPickupContactNumber = serviceOrderPickupContactNumber == null ? null : serviceOrderPickupContactNumber.trim();
    }

    public String getServiceOrderPickupContactName() {
        return serviceOrderPickupContactName;
    }

    public void setServiceOrderPickupContactName(String serviceOrderPickupContactName) {
        this.serviceOrderPickupContactName = serviceOrderPickupContactName == null ? null : serviceOrderPickupContactName.trim();
    }

    public Integer getServiceOrderWeight() {
        return serviceOrderWeight;
    }

    public void setServiceOrderWeight(Integer serviceOrderWeight) {
        this.serviceOrderWeight = serviceOrderWeight;
    }

    public Integer getServiceOrderDistance() {
        return serviceOrderDistance;
    }

    public void setServiceOrderDistance(Integer serviceOrderDistance) {
        this.serviceOrderDistance = serviceOrderDistance;
    }

    public Date getServiceOrderCreateTime() {
        return serviceOrderCreateTime;
    }

    public void setServiceOrderCreateTime(Date serviceOrderCreateTime) {
        this.serviceOrderCreateTime = serviceOrderCreateTime;
    }

    public Date getServiceOrderModifyTime() {
        return serviceOrderModifyTime;
    }

    public void setServiceOrderModifyTime(Date serviceOrderModifyTime) {
        this.serviceOrderModifyTime = serviceOrderModifyTime;
    }

    public Date getServiceOrderAllSeeTime() {
        return serviceOrderAllSeeTime;
    }

    public void setServiceOrderAllSeeTime(Date serviceOrderAllSeeTime) {
        this.serviceOrderAllSeeTime = serviceOrderAllSeeTime;
    }

    public Date getServiceOrderFinshTime() {
        return serviceOrderFinshTime;
    }

    public void setServiceOrderFinshTime(Date serviceOrderFinshTime) {
        this.serviceOrderFinshTime = serviceOrderFinshTime;
    }

    public Integer getServiceOrderIsComment() {
        return serviceOrderIsComment;
    }

    public void setServiceOrderIsComment(Integer serviceOrderIsComment) {
        this.serviceOrderIsComment = serviceOrderIsComment;
    }

    public Integer getServiceOrderNightAmount() {
        return serviceOrderNightAmount;
    }

    public void setServiceOrderNightAmount(Integer serviceOrderNightAmount) {
        this.serviceOrderNightAmount = serviceOrderNightAmount;
    }

    public Integer getServiceOrderPriceCoeffcient() {
        return serviceOrderPriceCoeffcient;
    }

    public void setServiceOrderPriceCoeffcient(Integer serviceOrderPriceCoeffcient) {
        this.serviceOrderPriceCoeffcient = serviceOrderPriceCoeffcient;
    }

    public String getServiceOrderAttachment() {
        return serviceOrderAttachment;
    }

    public void setServiceOrderAttachment(String serviceOrderAttachment) {
        this.serviceOrderAttachment = serviceOrderAttachment == null ? null : serviceOrderAttachment.trim();
    }

    public String getServicePayType() {
        return servicePayType;
    }

    public void setServicePayType(String servicePayType) {
        this.servicePayType = servicePayType == null ? null : servicePayType.trim();
    }

    public Integer getServiceAgentAmount() {
        return serviceAgentAmount;
    }

    public void setServiceAgentAmount(Integer serviceAgentAmount) {
        this.serviceAgentAmount = serviceAgentAmount;
    }

    public Integer getServiceAdminAmount() {
        return serviceAdminAmount;
    }

    public void setServiceAdminAmount(Integer serviceAdminAmount) {
        this.serviceAdminAmount = serviceAdminAmount;
    }

    public Integer getServiceOrderSource() {
        return serviceOrderSource;
    }

    public void setServiceOrderSource(Integer serviceOrderSource) {
        this.serviceOrderSource = serviceOrderSource;
    }

    public Integer getServiceOrderSourceId() {
        return serviceOrderSourceId;
    }

    public void setServiceOrderSourceId(Integer serviceOrderSourceId) {
        this.serviceOrderSourceId = serviceOrderSourceId;
    }

    public Integer getServiceOrderUrge() {
        return serviceOrderUrge;
    }

    public void setServiceOrderUrge(Integer serviceOrderUrge) {
        this.serviceOrderUrge = serviceOrderUrge;
    }

    public Integer getServiceOrderAbnormal() {
        return serviceOrderAbnormal;
    }

    public void setServiceOrderAbnormal(Integer serviceOrderAbnormal) {
        this.serviceOrderAbnormal = serviceOrderAbnormal;
    }

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getServiceStationAmount() {
		return serviceStationAmount;
	}

	public void setServiceStationAmount(Integer serviceStationAmount) {
		this.serviceStationAmount = serviceStationAmount;
	}
}