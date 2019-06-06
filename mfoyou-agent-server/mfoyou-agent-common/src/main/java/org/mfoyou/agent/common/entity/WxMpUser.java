package org.mfoyou.agent.common.entity;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 微信用户信息
 * @author chanjarster
 *
 */
public class WxMpUser implements Serializable {

  private static final long serialVersionUID = 5788154322646488738L;
  private Boolean subscribe;
  private String openId;
  private String nickname;
  private String sex;
  private String language;
  private String city;
  private String province;
  private String country;
  private String headimgurl;
  private Long subscribeTime;
  private String unionId;
  private Integer sexId;
  private String remark;
  private Integer groupId;
  private Long[] tagIds;
  private String openid;
  private List<Integer> privilege;

  public String getOpenid() {
	return openid==null?openId:openid;
}

public void setOpenid(String openid) {
	this.openid = openid;
}

public List<Integer> getPrivilege() {
	return privilege;
}

public void setPrivilege(List<Integer> privilege) {
	this.privilege = privilege;
}

public Boolean getSubscribe() {
    return this.subscribe;
  }

  public void setSubscribe(Boolean subscribe) {
    this.subscribe = subscribe;
  }

  public String getOpenId() {
    return this.openId==null?openid:openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getNickname() {
    return this.nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getLanguage() {
    return this.language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return this.province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  /**
   *只有在将公众号绑定到微信开放平台帐号后，才会出现该字段。
   */
  public String getUnionId() {
    return this.unionId;
  }

  public void setUnionId(String unionId) {
    this.unionId = unionId;
  }

  public Integer getSexId() {

    return this.sexId;
  }

  public void setSexId(Integer sexId) {
    this.sexId = sexId;
  }

  public String getRemark() {
    return this.remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Integer getGroupId() {
    return this.groupId;
  }

  public void setGroupId(Integer groupId) {
    this.groupId = groupId;
  }

  public Long[] getTagIds() {
    return this.tagIds;
  }

  public void setTagIds(Long[] tagIds) {
    this.tagIds = tagIds;
  }

  @Override
  public String toString() {
    return JSON.toJSONString(this);
  }

public Long getSubscribeTime() {
	return subscribeTime;
}

public void setSubscribeTime(Long subscribeTime) {
	this.subscribeTime = subscribeTime;
}



public String getHeadimgurl() {
	return headimgurl;
}

public void setHeadimgurl(String headimgurl) {
	this.headimgurl = headimgurl;
}


}