package org.mfoyou.agent.common.dao.mfoyou.domain;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouGdCity extends SerializableObject {
    private Integer cityAdcode;

    private String cityName;

    private String cityCitycode;

    private String cityPy;

    private Integer cityLeve;

    private String cityParent;

    private Integer cityParentAdcode;

    private Integer cityVisble;

    public Integer getCityAdcode() {
        return cityAdcode;
    }

    public void setCityAdcode(Integer cityAdcode) {
        this.cityAdcode = cityAdcode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getCityCitycode() {
        return cityCitycode;
    }

    public void setCityCitycode(String cityCitycode) {
        this.cityCitycode = cityCitycode == null ? null : cityCitycode.trim();
    }

    public String getCityPy() {
        return cityPy;
    }

    public void setCityPy(String cityPy) {
        this.cityPy = cityPy == null ? null : cityPy.trim();
    }

    public Integer getCityLeve() {
        return cityLeve;
    }

    public void setCityLeve(Integer cityLeve) {
        this.cityLeve = cityLeve;
    }

    public String getCityParent() {
        return cityParent;
    }

    public void setCityParent(String cityParent) {
        this.cityParent = cityParent == null ? null : cityParent.trim();
    }

    public Integer getCityParentAdcode() {
        return cityParentAdcode;
    }

    public void setCityParentAdcode(Integer cityParentAdcode) {
        this.cityParentAdcode = cityParentAdcode;
    }

    public Integer getCityVisble() {
        return cityVisble;
    }

    public void setCityVisble(Integer cityVisble) {
        this.cityVisble = cityVisble;
    }
}