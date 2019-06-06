package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuServicePrice extends SerializableObject {
    private Integer agentId;

    private String serviceTake;

    private String serviceGive;

    private String serviceBuy;

    private String serviceDo;

    private Date createTime;

    private Date modifyTime;

    private Integer state;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getServiceTake() {
        return serviceTake;
    }

    public void setServiceTake(String serviceTake) {
        this.serviceTake = serviceTake == null ? null : serviceTake.trim();
    }

    public String getServiceGive() {
        return serviceGive;
    }

    public void setServiceGive(String serviceGive) {
        this.serviceGive = serviceGive == null ? null : serviceGive.trim();
    }

    public String getServiceBuy() {
        return serviceBuy;
    }

    public void setServiceBuy(String serviceBuy) {
        this.serviceBuy = serviceBuy == null ? null : serviceBuy.trim();
    }

    public String getServiceDo() {
        return serviceDo;
    }

    public void setServiceDo(String serviceDo) {
        this.serviceDo = serviceDo == null ? null : serviceDo.trim();
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}