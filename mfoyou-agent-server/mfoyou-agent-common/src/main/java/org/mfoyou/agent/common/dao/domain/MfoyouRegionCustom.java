package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouRegionCustom extends SerializableObject {
    private Integer regionCustomId;

    private Integer agentId;

    private String agentCoordinateArea;

    private Double regionCustomLon;

    private Double regionCustomLat;

    private String regionCustomName;

    private Integer regionCustomValid;

    private Date regionCustomCreateTime;

    private Date regionCustomModfiyTime;

    public Integer getRegionCustomId() {
        return regionCustomId;
    }

    public void setRegionCustomId(Integer regionCustomId) {
        this.regionCustomId = regionCustomId;
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

    public Double getRegionCustomLon() {
        return regionCustomLon;
    }

    public void setRegionCustomLon(Double regionCustomLon) {
        this.regionCustomLon = regionCustomLon;
    }

    public Double getRegionCustomLat() {
        return regionCustomLat;
    }

    public void setRegionCustomLat(Double regionCustomLat) {
        this.regionCustomLat = regionCustomLat;
    }

    public String getRegionCustomName() {
        return regionCustomName;
    }

    public void setRegionCustomName(String regionCustomName) {
        this.regionCustomName = regionCustomName == null ? null : regionCustomName.trim();
    }

    public Integer getRegionCustomValid() {
        return regionCustomValid;
    }

    public void setRegionCustomValid(Integer regionCustomValid) {
        this.regionCustomValid = regionCustomValid;
    }

    public Date getRegionCustomCreateTime() {
        return regionCustomCreateTime;
    }

    public void setRegionCustomCreateTime(Date regionCustomCreateTime) {
        this.regionCustomCreateTime = regionCustomCreateTime;
    }

    public Date getRegionCustomModfiyTime() {
        return regionCustomModfiyTime;
    }

    public void setRegionCustomModfiyTime(Date regionCustomModfiyTime) {
        this.regionCustomModfiyTime = regionCustomModfiyTime;
    }
}