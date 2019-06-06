package org.mfoyou.agent.common.dao.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.mfoyou.agent.utils.common.SerializableObject;

public class HuawuAgentStoreSetting extends SerializableObject {
    private Integer agentId;

    private String storeUrl;

    private String storeName;

    private String storeLogoUrl;

    private Integer storeModelType;

    private Date creatTime;

    private Date modifyTime;

    private String serviceUrl;

    private String serviceName;

    private String serviceLogo;

    private String phone;
    
    private String storePhone;
    
    private List<Map<String, Object>> appid;
    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl == null ? null : storeUrl.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreLogoUrl() {
        return storeLogoUrl;
    }

    public void setStoreLogoUrl(String storeLogoUrl) {
        this.storeLogoUrl = storeLogoUrl == null ? null : storeLogoUrl.trim();
    }

    public Integer getStoreModelType() {
        return storeModelType;
    }

    public void setStoreModelType(Integer storeModelType) {
        this.storeModelType = storeModelType;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl == null ? null : serviceUrl.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceLogo() {
        return serviceLogo;
    }

    public void setServiceLogo(String serviceLogo) {
        this.serviceLogo = serviceLogo == null ? null : serviceLogo.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

	public List<Map<String, Object>> getAppid() {
		return appid;
	}

	public void setAppid(List<Map<String, Object>> list) {
		this.appid = list;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
}