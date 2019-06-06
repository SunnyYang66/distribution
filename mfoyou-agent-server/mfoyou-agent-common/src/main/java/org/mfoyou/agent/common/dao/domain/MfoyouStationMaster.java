package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouStationMaster extends SerializableObject {
    private Integer stationId;

    private Integer agentId;

    private String agentCoordinateArea;

    private String stationAreaName;

    private Integer powerState;

    private Integer storeShareFee;

    private Integer runnerShareFee;

    private String stationLoginNumber;

    private Date createTime;

    private Date modifyTime;

    private String stationName;
    
    private String agentName;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentCoordinateArea() {
        return agentCoordinateArea;
    }

    public void setAgentCoordinateArea(String agentCoordinateArea) {
        this.agentCoordinateArea = agentCoordinateArea == null ? null : agentCoordinateArea.trim();
    }

    public String getStationAreaName() {
        return stationAreaName;
    }

    public void setStationAreaName(String stationAreaName) {
        this.stationAreaName = stationAreaName == null ? null : stationAreaName.trim();
    }

    public Integer getPowerState() {
        return powerState;
    }

    public void setPowerState(Integer powerState) {
        this.powerState = powerState;
    }

    public Integer getStoreShareFee() {
        return storeShareFee;
    }

    public void setStoreShareFee(Integer storeShareFee) {
        this.storeShareFee = storeShareFee;
    }

    public Integer getRunnerShareFee() {
        return runnerShareFee;
    }

    public void setRunnerShareFee(Integer runnerShareFee) {
        this.runnerShareFee = runnerShareFee;
    }

    public String getStationLoginNumber() {
        return stationLoginNumber;
    }

    public void setStationLoginNumber(String stationLoginNumber) {
        this.stationLoginNumber = stationLoginNumber == null ? null : stationLoginNumber.trim();
    }

   

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName == null ? null : stationName.trim();
    }

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}