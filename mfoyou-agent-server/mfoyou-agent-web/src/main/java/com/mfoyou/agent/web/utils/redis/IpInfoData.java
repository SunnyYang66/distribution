package com.mfoyou.agent.web.utils.redis;

public class IpInfoData {
	
	private String ip = "";
	private Integer smsCount = 0;
	private Long lastSmstime = 0L;
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Long getLastSmstime() {
		return lastSmstime;
	}
	public void setLastSmstime(Long lastSmstime) {
		this.lastSmstime = lastSmstime;
	}
	public Integer getSmsCount() {
		return smsCount;
	}
	public void setSmsCount(Integer smsCount) {
		this.smsCount = smsCount;
	}
}
