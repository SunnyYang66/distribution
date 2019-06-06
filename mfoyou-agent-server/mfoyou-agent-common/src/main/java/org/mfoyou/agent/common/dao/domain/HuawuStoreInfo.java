package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import java.util.List;

import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreActive;
import org.mfoyou.agent.common.dao.mfoyou.domain.MfoyouStoreOpen;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuStoreInfo extends SerializableObject {
    private Integer storeId;

    private Integer storeType;
    
    private String storeTypeName;
    private Integer storeSubjectType;

    private Integer storePersonalAuth;

    private Integer storeEnterpriseAuth;

    private Integer storeLeve;

    private String storeSubjectInfo;

    private String storeName;

    private String storeSummary;

    private String storeLogo;

    private String storeProvince;

    private String storeCity;

    private String storeCounty;

    private String storeAddress;

    private String storeContacts;

    private String storePhone;

    private Double storeLocalLon;

    private Double storeLocalLat;

    private Integer storeAutoReceipt;

    private Integer storeAuditState;

    private Date storeOverdueTime;

    private Date storeOpenTime;

    private Integer storeOpenState;

    private Integer storeCurrentOpenState;

    private Integer storeWeightScore;

    private Integer storeAutoDispatch;

    private Integer storeDefaultDispatchTearm;

    private Integer storeSaleCount;

    private Integer storeAgentId;

    private Date storeGct;

    private Date storeGmt;

    private Integer storeSettlementDelay;

    private Integer storeSettlementType;

    private String storeSettlementAccountNumber;

    private String storeSettlementAccountName;

    private String storeSettlementAccountBank;

    private Integer storeTotalScore;

    private Integer storeTotalCommentCount;

    private Integer storeTotalOrderCount;

    private Integer storeBasicFreight;

    private Integer storeMaxDeliveryDistance;

    private Integer storePercentage;

    private String storePrinterNumber;

    private String storeLoginNumber;

    private Date storeInvitedTime;

    private Integer storeReject;

    private Integer storeMinGoodsAmount;

    private Integer storeFreeFreightAmount;

    private Integer storeStationId;

    private String storePics;

    private String storeNotice;

    private Integer storeIsKillOpen;

    private Date storeKillEndtime;

    private String storeBanner;
    private String storestr;
    private Long distance;
    private MfoyouStoreActive mfoyouStoreActive;

    private List<MfoyouStoreOpen> opens;
    
    private String stationName;
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Integer getStoreSubjectType() {
        return storeSubjectType;
    }

    public void setStoreSubjectType(Integer storeSubjectType) {
        this.storeSubjectType = storeSubjectType;
    }

    public Integer getStorePersonalAuth() {
        return storePersonalAuth;
    }

    public void setStorePersonalAuth(Integer storePersonalAuth) {
        this.storePersonalAuth = storePersonalAuth;
    }

    public Integer getStoreEnterpriseAuth() {
        return storeEnterpriseAuth;
    }

    public void setStoreEnterpriseAuth(Integer storeEnterpriseAuth) {
        this.storeEnterpriseAuth = storeEnterpriseAuth;
    }

    public Integer getStoreLeve() {
        return storeLeve;
    }

    public void setStoreLeve(Integer storeLeve) {
        this.storeLeve = storeLeve;
    }

    public String getStoreSubjectInfo() {
        return storeSubjectInfo;
    }

    public void setStoreSubjectInfo(String storeSubjectInfo) {
        this.storeSubjectInfo = storeSubjectInfo == null ? null : storeSubjectInfo.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreSummary() {
        return storeSummary;
    }

    public void setStoreSummary(String storeSummary) {
        this.storeSummary = storeSummary == null ? null : storeSummary.trim();
    }

    public String getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(String storeLogo) {
        this.storeLogo = storeLogo == null ? null : storeLogo.trim();
    }

    public String getStoreProvince() {
        return storeProvince;
    }

    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince == null ? null : storeProvince.trim();
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity == null ? null : storeCity.trim();
    }

    public String getStoreCounty() {
        return storeCounty;
    }

    public void setStoreCounty(String storeCounty) {
        this.storeCounty = storeCounty == null ? null : storeCounty.trim();
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public String getStoreContacts() {
        return storeContacts;
    }

    public void setStoreContacts(String storeContacts) {
        this.storeContacts = storeContacts == null ? null : storeContacts.trim();
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }

    public Double getStoreLocalLon() {
        return storeLocalLon;
    }

    public void setStoreLocalLon(Double storeLocalLon) {
        this.storeLocalLon = storeLocalLon;
    }

    public Double getStoreLocalLat() {
        return storeLocalLat;
    }

    public void setStoreLocalLat(Double storeLocalLat) {
        this.storeLocalLat = storeLocalLat;
    }

    public Integer getStoreAutoReceipt() {
        return storeAutoReceipt;
    }

    public void setStoreAutoReceipt(Integer storeAutoReceipt) {
        this.storeAutoReceipt = storeAutoReceipt;
    }

    public Integer getStoreAuditState() {
        return storeAuditState;
    }

    public void setStoreAuditState(Integer storeAuditState) {
        this.storeAuditState = storeAuditState;
    }

    public Date getStoreOverdueTime() {
        return storeOverdueTime;
    }

    public void setStoreOverdueTime(Date storeOverdueTime) {
        this.storeOverdueTime = storeOverdueTime;
    }

    public Date getStoreOpenTime() {
        return storeOpenTime;
    }

    public void setStoreOpenTime(Date storeOpenTime) {
        this.storeOpenTime = storeOpenTime;
    }

    public Integer getStoreOpenState() {
        return storeOpenState;
    }

    public void setStoreOpenState(Integer storeOpenState) {
        this.storeOpenState = storeOpenState;
    }

    public Integer getStoreCurrentOpenState() {
        return storeCurrentOpenState;
    }

    public void setStoreCurrentOpenState(Integer storeCurrentOpenState) {
        this.storeCurrentOpenState = storeCurrentOpenState;
    }

    public Integer getStoreWeightScore() {
        return storeWeightScore;
    }

    public void setStoreWeightScore(Integer storeWeightScore) {
        this.storeWeightScore = storeWeightScore;
    }

    public Integer getStoreAutoDispatch() {
        return storeAutoDispatch;
    }

    public void setStoreAutoDispatch(Integer storeAutoDispatch) {
        this.storeAutoDispatch = storeAutoDispatch;
    }

    public Integer getStoreDefaultDispatchTearm() {
        return storeDefaultDispatchTearm;
    }

    public void setStoreDefaultDispatchTearm(Integer storeDefaultDispatchTearm) {
        this.storeDefaultDispatchTearm = storeDefaultDispatchTearm;
    }

    public Integer getStoreSaleCount() {
        return storeSaleCount;
    }

    public void setStoreSaleCount(Integer storeSaleCount) {
        this.storeSaleCount = storeSaleCount;
    }

    public Integer getStoreAgentId() {
        return storeAgentId;
    }

    public void setStoreAgentId(Integer storeAgentId) {
        this.storeAgentId = storeAgentId;
    }

    public Date getStoreGct() {
        return storeGct;
    }

    public void setStoreGct(Date storeGct) {
        this.storeGct = storeGct;
    }

    public Date getStoreGmt() {
        return storeGmt;
    }

    public void setStoreGmt(Date storeGmt) {
        this.storeGmt = storeGmt;
    }

    public Integer getStoreSettlementDelay() {
        return storeSettlementDelay;
    }

    public void setStoreSettlementDelay(Integer storeSettlementDelay) {
        this.storeSettlementDelay = storeSettlementDelay;
    }

    public Integer getStoreSettlementType() {
        return storeSettlementType;
    }

    public void setStoreSettlementType(Integer storeSettlementType) {
        this.storeSettlementType = storeSettlementType;
    }

    public String getStoreSettlementAccountNumber() {
        return storeSettlementAccountNumber;
    }

    public void setStoreSettlementAccountNumber(String storeSettlementAccountNumber) {
        this.storeSettlementAccountNumber = storeSettlementAccountNumber == null ? null : storeSettlementAccountNumber.trim();
    }

    public String getStoreSettlementAccountName() {
        return storeSettlementAccountName;
    }

    public void setStoreSettlementAccountName(String storeSettlementAccountName) {
        this.storeSettlementAccountName = storeSettlementAccountName == null ? null : storeSettlementAccountName.trim();
    }

    public String getStoreSettlementAccountBank() {
        return storeSettlementAccountBank;
    }

    public void setStoreSettlementAccountBank(String storeSettlementAccountBank) {
        this.storeSettlementAccountBank = storeSettlementAccountBank == null ? null : storeSettlementAccountBank.trim();
    }

    public Integer getStoreTotalScore() {
        return storeTotalScore;
    }

    public void setStoreTotalScore(Integer storeTotalScore) {
        this.storeTotalScore = storeTotalScore;
    }

    public Integer getStoreTotalCommentCount() {
        return storeTotalCommentCount;
    }

    public void setStoreTotalCommentCount(Integer storeTotalCommentCount) {
        this.storeTotalCommentCount = storeTotalCommentCount;
    }

    public Integer getStoreTotalOrderCount() {
        return storeTotalOrderCount;
    }

    public void setStoreTotalOrderCount(Integer storeTotalOrderCount) {
        this.storeTotalOrderCount = storeTotalOrderCount;
    }

    public Integer getStoreBasicFreight() {
        return storeBasicFreight;
    }

    public void setStoreBasicFreight(Integer storeBasicFreight) {
        this.storeBasicFreight = storeBasicFreight;
    }

    public Integer getStoreMaxDeliveryDistance() {
        return storeMaxDeliveryDistance;
    }

    public void setStoreMaxDeliveryDistance(Integer storeMaxDeliveryDistance) {
        this.storeMaxDeliveryDistance = storeMaxDeliveryDistance;
    }

    public Integer getStorePercentage() {
        return storePercentage;
    }

    public void setStorePercentage(Integer storePercentage) {
        this.storePercentage = storePercentage;
    }

    public String getStorePrinterNumber() {
        return storePrinterNumber;
    }

    public void setStorePrinterNumber(String storePrinterNumber) {
        this.storePrinterNumber = storePrinterNumber == null ? null : storePrinterNumber.trim();
    }

    public String getStoreLoginNumber() {
        return storeLoginNumber;
    }

    public void setStoreLoginNumber(String storeLoginNumber) {
        this.storeLoginNumber = storeLoginNumber == null ? null : storeLoginNumber.trim();
    }

    public Date getStoreInvitedTime() {
        return storeInvitedTime;
    }

    public void setStoreInvitedTime(Date storeInvitedTime) {
        this.storeInvitedTime = storeInvitedTime;
    }

    public Integer getStoreReject() {
        return storeReject;
    }

    public void setStoreReject(Integer storeReject) {
        this.storeReject = storeReject;
    }

    public Integer getStoreMinGoodsAmount() {
        return storeMinGoodsAmount;
    }

    public void setStoreMinGoodsAmount(Integer storeMinGoodsAmount) {
        this.storeMinGoodsAmount = storeMinGoodsAmount;
    }

    public Integer getStoreFreeFreightAmount() {
        return storeFreeFreightAmount;
    }

    public void setStoreFreeFreightAmount(Integer storeFreeFreightAmount) {
        this.storeFreeFreightAmount = storeFreeFreightAmount;
    }

    public Integer getStoreStationId() {
        return storeStationId;
    }

    public void setStoreStationId(Integer storeStationId) {
        this.storeStationId = storeStationId;
    }

    public String getStorePics() {
        return storePics;
    }

    public void setStorePics(String storePics) {
        this.storePics = storePics == null ? null : storePics.trim();
    }

    public String getStoreNotice() {
        return storeNotice;
    }

    public void setStoreNotice(String storeNotice) {
        this.storeNotice = storeNotice == null ? null : storeNotice.trim();
    }

    public Integer getStoreIsKillOpen() {
        return storeIsKillOpen;
    }

    public void setStoreIsKillOpen(Integer storeIsKillOpen) {
        this.storeIsKillOpen = storeIsKillOpen;
    }

    public Date getStoreKillEndtime() {
        return storeKillEndtime;
    }

    public void setStoreKillEndtime(Date storeKillEndtime) {
        this.storeKillEndtime = storeKillEndtime;
    }

    public String getStoreBanner() {
        return storeBanner;
    }

    public void setStoreBanner(String storeBanner) {
        this.storeBanner = storeBanner == null ? null : storeBanner.trim();
    }

	public List<MfoyouStoreOpen> getOpens() {
		return opens;
	}

	public void setOpens(List<MfoyouStoreOpen> opens) {
		this.opens = opens;
	}

	public MfoyouStoreActive getMfoyouStoreActive() {
		return mfoyouStoreActive;
	}

	public void setMfoyouStoreActive(MfoyouStoreActive mfoyouStoreActive) {
		this.mfoyouStoreActive = mfoyouStoreActive;
	}

	public String getStorestr() {
		return storestr;
	}

	public void setStorestr(String storestr) {
		this.storestr = storestr;
	}

	public Long getDistance() {
		return distance;
	}

	public void setDistance(Long distance) {
		this.distance = distance;
	}

	public String getStoreTypeName() {
		return storeTypeName;
	}

	public void setStoreTypeName(String storeTypeName) {
		this.storeTypeName = storeTypeName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}


}