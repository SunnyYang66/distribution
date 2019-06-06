package com.mfoyou.agent.web.utils.common;

public class PriceData {

	private Integer serviceOrderStartAmount;

	private Integer serviceOrderDistanceAmount;

	private Integer serviceOrderWeightAmount;

	private Integer serviceOrderAmount;

	private Integer serviceOrderGoodAmount;

	public void makeOrderAmount() {
		serviceOrderAmount = serviceOrderStartAmount + serviceOrderDistanceAmount + serviceOrderWeightAmount;
	}

	public Integer getServiceOrderStartAmount() {
		return serviceOrderStartAmount;
	}

	public void setServiceOrderStartAmount(Integer serviceOrderStartAmount) {
		this.serviceOrderStartAmount = serviceOrderStartAmount;
	}

	public Integer getServiceOrderDistanceAmount() {
		return serviceOrderDistanceAmount;
	}

	public void setServiceOrderDistanceAmount(Integer serviceOrderDistanceAmount) {
		this.serviceOrderDistanceAmount = serviceOrderDistanceAmount;
	}

	public Integer getServiceOrderWeightAmount() {
		return serviceOrderWeightAmount;
	}

	public void setServiceOrderWeightAmount(Integer serviceOrderWeightAmount) {
		this.serviceOrderWeightAmount = serviceOrderWeightAmount;
	}


	public Integer getServiceOrderAmount() {
		return serviceOrderAmount;
	}

	public void setServiceOrderAmount(Integer serviceOrderAmount) {
		this.serviceOrderAmount = serviceOrderAmount;
	}

	public Integer getServiceOrderGoodAmount() {
		return serviceOrderGoodAmount;
	}

	public void setServiceOrderGoodAmount(Integer serviceOrderGoodAmount) {
		this.serviceOrderGoodAmount = serviceOrderGoodAmount;
	}

}
