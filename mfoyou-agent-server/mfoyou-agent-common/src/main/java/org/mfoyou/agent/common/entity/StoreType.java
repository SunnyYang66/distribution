package org.mfoyou.agent.common.entity;

import java.util.List;

import org.mfoyou.agent.utils.common.SerializableObject;


public class StoreType extends SerializableObject{
	private String typeName;
	private int typeId;
	private String typePic;
	private Integer typePercent;
	private List<StoreType> storeTypes;
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public List<StoreType> getStoreTypes() {
		return storeTypes;
	}
	public void setStoreTypes(List<StoreType> storeTypes) {
		this.storeTypes = storeTypes;
	}
	public String getTypePic() {
		return typePic;
	}
	public void setTypePic(String typePic) {
		this.typePic = typePic;
	}
	public Integer getTypePercent() {
		return typePercent;
	}
	public void setTypePercent(Integer typePercent) {
		this.typePercent = typePercent;
	}
}
