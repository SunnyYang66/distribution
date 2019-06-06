package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuWorker extends SerializableObject {
    private Integer userId;

    private Integer agentId;

    private String workerPhone;

    private String workerAddress;

    private String workerStar;

    private Integer workerOrderCount;

    private Integer workerServiceDistance;

    private Integer workerState;

    private Integer workerOpenState;

    private Double workerLong;

    private Double workerLat;

    private Date createTime;

    private Date modifyTime;

    private Integer workerThirdAuth;

    private Integer workerFee;
    
    private Integer workerAuth;
    
    private String workerIdcardHand;
    
    private String workerIdcardFact;
    
    private String workerIdcardNumber;
    
    private String workerIdcardReverse;
    
    private String workerName;
    
    private String headUrl;
    
    private Date joinTime;
    
    private Integer stationId;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone == null ? null : workerPhone.trim();
    }

    public String getWorkerAddress() {
        return workerAddress;
    }

    public void setWorkerAddress(String workerAddress) {
        this.workerAddress = workerAddress == null ? null : workerAddress.trim();
    }

    public String getWorkerStar() {
        return workerStar;
    }

    public void setWorkerStar(String workerStar) {
        this.workerStar = workerStar == null ? null : workerStar.trim();
    }

    public Integer getWorkerOrderCount() {
        return workerOrderCount;
    }

    public void setWorkerOrderCount(Integer workerOrderCount) {
        this.workerOrderCount = workerOrderCount;
    }

    public Integer getWorkerServiceDistance() {
        return workerServiceDistance;
    }

    public void setWorkerServiceDistance(Integer workerServiceDistance) {
        this.workerServiceDistance = workerServiceDistance;
    }

    public Integer getWorkerState() {
        return workerState;
    }

    public void setWorkerState(Integer workerState) {
        this.workerState = workerState;
    }

    public Integer getWorkerOpenState() {
        return workerOpenState;
    }

    public void setWorkerOpenState(Integer workerOpenState) {
        this.workerOpenState = workerOpenState;
    }

    public Double getWorkerLong() {
        return workerLong;
    }

    public void setWorkerLong(Double workerLong) {
        this.workerLong = workerLong;
    }

    public Double getWorkerLat() {
        return workerLat;
    }

    public void setWorkerLat(Double workerLat) {
        this.workerLat = workerLat;
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

    public Integer getWorkerThirdAuth() {
        return workerThirdAuth;
    }

    public void setWorkerThirdAuth(Integer workerThirdAuth) {
        this.workerThirdAuth = workerThirdAuth;
    }

    public Integer getWorkerFee() {
        return workerFee;
    }

    public void setWorkerFee(Integer workerFee) {
        this.workerFee = workerFee;
    }

	public Integer getWorkerAuth() {
		return workerAuth;
	}

	public void setWorkerAuth(Integer workerAuth) {
		this.workerAuth = workerAuth;
	}

	public String getWorkerIdcardHand() {
		return workerIdcardHand;
	}

	public void setWorkerIdcardHand(String workerIdcardHand) {
		this.workerIdcardHand = workerIdcardHand;
	}

	public String getWorkerIdcardFact() {
		return workerIdcardFact;
	}

	public void setWorkerIdcardFact(String workerIdcardFact) {
		this.workerIdcardFact = workerIdcardFact;
	}

	public String getWorkerIdcardNumber() {
		return workerIdcardNumber;
	}

	public void setWorkerIdcardNumber(String workerIdcardNumber) {
		this.workerIdcardNumber = workerIdcardNumber;
	}

	public String getWorkerIdcardReverse() {
		return workerIdcardReverse;
	}

	public void setWorkerIdcardReverse(String workerIdcardReverse) {
		this.workerIdcardReverse = workerIdcardReverse;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
}