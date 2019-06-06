package org.mfoyou.agent.common.entity;

import org.mfoyou.agent.utils.common.SerializableObject;

public class StoreTypeV1 extends SerializableObject{
	private String childName;
	private String parentName;
	private int childId;
	private int parentId;
	public String getChildName() {
		return childName;
	}
	public void setChildName(String childName) {
		this.childName = childName;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getChildId() {
		return childId;
	}
	public void setChildId(int childId) {
		this.childId = childId;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
