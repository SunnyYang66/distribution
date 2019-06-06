package org.mfoyou.agent.common.entity;

import java.io.Serializable;
import java.util.List;

public class MfoyouFileRet implements Serializable{

	private List<?> list;
	private String basUrl;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public String getBasUrl() {
		return basUrl;
	}

	public void setBasUrl(String basUrl) {
		this.basUrl = basUrl;
	}

}
