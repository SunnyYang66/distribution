package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.utils.common.SerializableObject;

public class PersonCount extends SerializableObject{
	private Integer todayCount;
	private Integer monthCount;
	private Integer totalCount;
	public Integer getTodayCount() {
		return todayCount;
	}
	public void setTodayCount(Integer todayCount) {
		this.todayCount = todayCount;
	}
	public Integer getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(Integer monthCount) {
		this.monthCount = monthCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
}
