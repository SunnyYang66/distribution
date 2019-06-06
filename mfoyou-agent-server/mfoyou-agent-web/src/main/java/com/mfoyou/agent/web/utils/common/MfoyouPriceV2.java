package com.mfoyou.agent.web.utils.common;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MfoyouPriceV2 {
	private Integer baseAmount;
	private Integer containDistance;
	private Integer containWeight;
	private Integer addMoney;
	private Integer endTime;
	private Integer startTime;
	private Integer incDistanceAmount;
	private Integer incDistance;
	private Integer incWeight;
	private Integer incWeightAmount;
	private List<SpacialTime>  spacialTimes;
	public Integer getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(Integer baseAmount) {
		this.baseAmount = baseAmount;
	}
	public Integer getContainDistance() {
		return containDistance;
	}
	public void setContainDistance(Integer containDistance) {
		this.containDistance = containDistance;
	}
	public Integer getContainWeight() {
		return containWeight;
	}
	public void setContainWeight(Integer containWeight) {
		this.containWeight = containWeight;
	}
	public Integer getAddMoney() {
		return addMoney;
	}
	public void setAddMoney(Integer addMoney) {
		this.addMoney = addMoney;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getIncDistanceAmount() {
		return incDistanceAmount;
	}
	public void setIncDistanceAmount(Integer incDistanceAmount) {
		this.incDistanceAmount = incDistanceAmount;
	}
	public Integer getIncDistance() {
		return incDistance;
	}
	public void setIncDistance(Integer incDistance) {
		this.incDistance = incDistance;
	}
	public Integer getIncWeight() {
		return incWeight;
	}
	public void setIncWeight(Integer incWeight) {
		this.incWeight = incWeight;
	}
	public Integer getIncWeightAmount() {
		return incWeightAmount;
	}
	public void setIncWeightAmount(Integer incWeightAmount) {
		this.incWeightAmount = incWeightAmount;
	}
	class SpacialTime{
		private Integer startTime;
		private Integer endTime;
		private Integer addMoney;
		public Integer getAddMoney() {
			return addMoney;
		}
		public void setAddMoney(Integer addMoney) {
			this.addMoney = addMoney;
		}
		public Integer getEndTime() {
			return endTime;
		}
		public void setEndTime(Integer endTime) {
			this.endTime = endTime;
		}
		public Integer getStartTime() {
			return startTime;
		}
		public void setStartTime(Integer startTime) {
			this.startTime = startTime;
		}
	}
	public PriceData calPriceData(Integer weight, Integer distance, Date dt,int type) {
		PriceData priceData = new PriceData();
		priceData.setServiceOrderGoodAmount(0);
		if(type == 4 ){
			priceData.setServiceOrderStartAmount(getBaseAmountByTime(dt));
			priceData.setServiceOrderDistanceAmount(0);
			priceData.setServiceOrderWeightAmount(0);
		}else{
			priceData.setServiceOrderStartAmount(getBaseAmountByTime(dt));
			priceData.setServiceOrderDistanceAmount(getdistanceAmount(distance==null?0:distance));
			priceData.setServiceOrderWeightAmount(getWeightAmount(weight==null?0:weight));
		}
		priceData.makeOrderAmount();
		return priceData;
	}
	//计算重量价格
	private Integer getdistanceAmount(Integer distance){
		if(distance>containDistance){
			return (distance-containDistance-1+incDistance)/incDistance*incDistanceAmount;
		}
		return 0;
	}
	//根据重量判断重量价格
	private Integer getWeightAmount(Integer weight){
		if(weight>containWeight && incDistance!=null && incWeight>0 && incWeightAmount!=null && incWeightAmount>0){
			return (weight-containWeight-1+incWeight)/incWeight*incWeightAmount;
		}
		return 0;
	}
	//根据是假判断初始价格
	private Integer getBaseAmountByTime(Date dt){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dt);
		int time = calendar.get(Calendar.HOUR_OF_DAY) *100 + calendar.get(Calendar.MINUTE);
		if(startTime!=null && endTime!=null){  //兼容老版本价格计算
			if(startTime<endTime)
				return time<endTime && time>startTime ? baseAmount + addMoney : baseAmount;
			else 
				return time < endTime || time >startTime ? baseAmount + addMoney : baseAmount;
		}else if(spacialTimes!=null && spacialTimes.size()>0){
			for(SpacialTime spacialTime:spacialTimes){
				if((spacialTime.getStartTime()<spacialTime.getEndTime() && time>spacialTime.getStartTime()&& time<spacialTime.getEndTime())
			||(spacialTime.getStartTime()>spacialTime.getEndTime() && time<spacialTime.getStartTime()&& time>spacialTime.getEndTime())){
					return baseAmount+spacialTime.getAddMoney();
				}
			}
		}
		return baseAmount;
	}
}
