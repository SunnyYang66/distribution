package org.mfoyou.agent.common.dao.mfoyou.domain;

import java.util.Date;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGoodsOrder extends SerializableObject {
    private Integer orderId;

    private Integer storeId;

    private String storeName;

    private Integer userId;

    private Integer areaAgentId;

    private Integer orderState;

    private String orderNumber;

    private String orderTitle;

    private String orderNote;

    private Integer orderGoodsCount;

    private Integer orderTotalAmount;

    private Integer orderPayAmount;

    private Integer orderGoodsAmount;

    private Integer orderFreightAmount;

    private Integer orderAttachAmount;

    private Integer orderGoodsCostAmount;

    private String orderActiveContent;

    private Integer orderActiveAmount;

    private Integer orderActiveId;

    private Integer orderPayDiscostAmount;

    private Integer orderTransportType;

    private Integer orderTransportId;

    private String orderTransportRunerName;

    private String orderTransportRunerPhone;

    private Integer orderTransportState;

    private String orderUserAddress;

    private String orderUserName;

    private String orderUserPhone;

    private Integer orderUserSex;

    private Double orderUserLat;

    private Double orderUserLon;

    private Integer orderUserUrge;

    private Date orderUserExpectTime;

    private Date orderGct;

    private Date orderGmt;

    private Date orderFinshTime;

    private Integer orderExceptionState;

    private Integer orderDistance;

    private Integer orderWeight;

    private Integer orderRefundState;

    private String orderPayRemark;

    private Date orderPayTime;

    private Integer orderTranspoetAmount;

    private Integer orderStoreAmount;

    private Integer orderAgentAdmount;

    private Integer orderAdminAmount;

    private Date orderSettlementDate;
    private Integer orderExpressId;

    private String orderExpressNo;
    
    private Integer orderStationAmount;
    
    private Integer stationId;
    
    private Date expectTime;
    
    private String orderMark;
    
    private Integer orderBespeak;
    
    private Integer orderIsEvaluate;
    
    private Integer orderIsNative;
    
    private Integer touchId;
    
    private Integer packageFee;
    
    private Integer couponReduceMoney;
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAreaAgentId() {
        return areaAgentId;
    }

    public void setAreaAgentId(Integer areaAgentId) {
        this.areaAgentId = areaAgentId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle == null ? null : orderTitle.trim();
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote == null ? null : orderNote.trim();
    }

    public Integer getOrderGoodsCount() {
        return orderGoodsCount;
    }

    public void setOrderGoodsCount(Integer orderGoodsCount) {
        this.orderGoodsCount = orderGoodsCount;
    }

    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Integer getOrderPayAmount() {
        return orderPayAmount;
    }

    public void setOrderPayAmount(Integer orderPayAmount) {
        this.orderPayAmount = orderPayAmount;
    }

    public Integer getOrderGoodsAmount() {
        return orderGoodsAmount;
    }

    public void setOrderGoodsAmount(Integer orderGoodsAmount) {
        this.orderGoodsAmount = orderGoodsAmount;
    }

    public Integer getOrderFreightAmount() {
        return orderFreightAmount;
    }

    public void setOrderFreightAmount(Integer orderFreightAmount) {
        this.orderFreightAmount = orderFreightAmount;
    }

    public Integer getOrderAttachAmount() {
        return orderAttachAmount;
    }

    public void setOrderAttachAmount(Integer orderAttachAmount) {
        this.orderAttachAmount = orderAttachAmount;
    }

    public Integer getOrderGoodsCostAmount() {
        return orderGoodsCostAmount;
    }

    public void setOrderGoodsCostAmount(Integer orderGoodsCostAmount) {
        this.orderGoodsCostAmount = orderGoodsCostAmount;
    }

    public String getOrderActiveContent() {
        return orderActiveContent;
    }

    public void setOrderActiveContent(String orderActiveContent) {
        this.orderActiveContent = orderActiveContent == null ? null : orderActiveContent.trim();
    }

    public Integer getOrderActiveAmount() {
        return orderActiveAmount;
    }

    public void setOrderActiveAmount(Integer orderActiveAmount) {
        this.orderActiveAmount = orderActiveAmount;
    }

    public Integer getOrderActiveId() {
        return orderActiveId;
    }

    public void setOrderActiveId(Integer orderActiveId) {
        this.orderActiveId = orderActiveId;
    }

    public Integer getOrderPayDiscostAmount() {
        return orderPayDiscostAmount;
    }

    public void setOrderPayDiscostAmount(Integer orderPayDiscostAmount) {
        this.orderPayDiscostAmount = orderPayDiscostAmount;
    }

    public Integer getOrderTransportType() {
        return orderTransportType;
    }

    public void setOrderTransportType(Integer orderTransportType) {
        this.orderTransportType = orderTransportType;
    }

    public Integer getOrderTransportId() {
        return orderTransportId;
    }

    public void setOrderTransportId(Integer orderTransportId) {
        this.orderTransportId = orderTransportId;
    }

    public String getOrderTransportRunerName() {
        return orderTransportRunerName;
    }

    public void setOrderTransportRunerName(String orderTransportRunerName) {
        this.orderTransportRunerName = orderTransportRunerName == null ? null : orderTransportRunerName.trim();
    }

    public String getOrderTransportRunerPhone() {
        return orderTransportRunerPhone;
    }

    public void setOrderTransportRunerPhone(String orderTransportRunerPhone) {
        this.orderTransportRunerPhone = orderTransportRunerPhone == null ? null : orderTransportRunerPhone.trim();
    }

    public Integer getOrderTransportState() {
        return orderTransportState;
    }

    public void setOrderTransportState(Integer orderTransportState) {
        this.orderTransportState = orderTransportState;
    }

    public String getOrderUserAddress() {
        return orderUserAddress;
    }

    public void setOrderUserAddress(String orderUserAddress) {
        this.orderUserAddress = orderUserAddress == null ? null : orderUserAddress.trim();
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName == null ? null : orderUserName.trim();
    }

    public String getOrderUserPhone() {
        return orderUserPhone;
    }

    public void setOrderUserPhone(String orderUserPhone) {
        this.orderUserPhone = orderUserPhone == null ? null : orderUserPhone.trim();
    }

    public Integer getOrderUserSex() {
        return orderUserSex;
    }

    public void setOrderUserSex(Integer orderUserSex) {
        this.orderUserSex = orderUserSex;
    }

    public Double getOrderUserLat() {
        return orderUserLat;
    }

    public void setOrderUserLat(Double orderUserLat) {
        this.orderUserLat = orderUserLat;
    }

    public Double getOrderUserLon() {
        return orderUserLon;
    }

    public void setOrderUserLon(Double orderUserLon) {
        this.orderUserLon = orderUserLon;
    }

    public Integer getOrderUserUrge() {
        return orderUserUrge;
    }

    public void setOrderUserUrge(Integer orderUserUrge) {
        this.orderUserUrge = orderUserUrge;
    }

    public Date getOrderUserExpectTime() {
        return orderUserExpectTime;
    }

    public void setOrderUserExpectTime(Date orderUserExpectTime) {
        this.orderUserExpectTime = orderUserExpectTime;
    }

    public Date getOrderGct() {
        return orderGct;
    }

    public void setOrderGct(Date orderGct) {
        this.orderGct = orderGct;
    }

    public Date getOrderGmt() {
        return orderGmt;
    }

    public void setOrderGmt(Date orderGmt) {
        this.orderGmt = orderGmt;
    }

    public Date getOrderFinshTime() {
        return orderFinshTime;
    }

    public void setOrderFinshTime(Date orderFinshTime) {
        this.orderFinshTime = orderFinshTime;
    }

    public Integer getOrderExceptionState() {
        return orderExceptionState;
    }

    public void setOrderExceptionState(Integer orderExceptionState) {
        this.orderExceptionState = orderExceptionState;
    }

    public Integer getOrderDistance() {
        return orderDistance;
    }

    public void setOrderDistance(Integer orderDistance) {
        this.orderDistance = orderDistance;
    }

    public Integer getOrderWeight() {
        return orderWeight;
    }

    public void setOrderWeight(Integer orderWeight) {
        this.orderWeight = orderWeight;
    }

    public Integer getOrderRefundState() {
        return orderRefundState;
    }

    public void setOrderRefundState(Integer orderRefundState) {
        this.orderRefundState = orderRefundState;
    }

    public String getOrderPayRemark() {
        return orderPayRemark;
    }

    public void setOrderPayRemark(String orderPayRemark) {
        this.orderPayRemark = orderPayRemark == null ? null : orderPayRemark.trim();
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Integer getOrderTranspoetAmount() {
        return orderTranspoetAmount;
    }

    public void setOrderTranspoetAmount(Integer orderTranspoetAmount) {
        this.orderTranspoetAmount = orderTranspoetAmount;
    }

    public Integer getOrderStoreAmount() {
        return orderStoreAmount;
    }

    public void setOrderStoreAmount(Integer orderStoreAmount) {
        this.orderStoreAmount = orderStoreAmount;
    }

    public Integer getOrderAgentAdmount() {
        return orderAgentAdmount;
    }

    public void setOrderAgentAdmount(Integer orderAgentAdmount) {
        this.orderAgentAdmount = orderAgentAdmount;
    }

    public Integer getOrderAdminAmount() {
        return orderAdminAmount;
    }

    public void setOrderAdminAmount(Integer orderAdminAmount) {
        this.orderAdminAmount = orderAdminAmount;
    }

    public Date getOrderSettlementDate() {
        return orderSettlementDate;
    }

    public void setOrderSettlementDate(Date orderSettlementDate) {
        this.orderSettlementDate = orderSettlementDate;
    }

	public Integer getOrderExpressId() {
		return orderExpressId;
	}

	public void setOrderExpressId(Integer orderExpressId) {
		this.orderExpressId = orderExpressId;
	}

	public String getOrderExpressNo() {
		return orderExpressNo;
	}

	public void setOrderExpressNo(String orderExpressNo) {
		this.orderExpressNo = orderExpressNo;
	}

	public Integer getOrderStationAmount() {
		return orderStationAmount;
	}

	public void setOrderStationAmount(Integer orderStationAmount) {
		this.orderStationAmount = orderStationAmount;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public String getOrderMark() {
		return orderMark;
	}

	public void setOrderMark(String orderMark) {
		this.orderMark = orderMark;
	}

	public Date getExpectTime() {
		return expectTime;
	}

	public void setExpectTime(Date expectTime) {
		this.expectTime = expectTime;
	}

	public Integer getOrderBespeak() {
		return orderBespeak;
	}

	public void setOrderBespeak(Integer orderBespeak) {
		this.orderBespeak = orderBespeak;
	}

	public Integer getOrderIsEvaluate() {
		return orderIsEvaluate;
	}

	public void setOrderIsEvaluate(Integer orderIsEvaluate) {
		this.orderIsEvaluate = orderIsEvaluate;
	}

	public Integer getOrderIsNative() {
		return orderIsNative;
	}

	public void setOrderIsNative(Integer orderIsNative) {
		this.orderIsNative = orderIsNative;
	}

	public Integer getTouchId() {
		return touchId;
	}

	public void setTouchId(Integer touchId) {
		this.touchId = touchId;
	}

	public Integer getPackageFee() {
		return packageFee;
	}

	public void setPackageFee(Integer packageFee) {
		this.packageFee = packageFee;
	}

	public Integer getCouponReduceMoney() {
		return couponReduceMoney;
	}

	public void setCouponReduceMoney(Integer couponReduceMoney) {
		this.couponReduceMoney = couponReduceMoney;
	}

}