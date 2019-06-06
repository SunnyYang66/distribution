package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.utils.common.SerializableObject;

public class MfoyouWorkStatistics extends SerializableObject {
	Integer userId;
	Integer orderCount;
	Integer orderAoument;
	Integer key;

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public Integer getOrderAoument() {
		return orderAoument;
	}

	public void setOrderAoument(Integer orderAoument) {
		this.orderAoument = orderAoument;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}
	

}
