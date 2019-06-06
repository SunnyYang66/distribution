package org.mfoyou.agent.task.utils;

public class WxPushPaySuccessData {
	private String touser;
	private String template_id;
	private String url;
	private Data data;
	private Miniprogram miniprogram;
	
	public String getTouser() {
		return touser;
	}
	public void setTouser(String touser) {
		this.touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public Miniprogram getMiniprogram() {
		return miniprogram;
	}
	public void setMiniprogram(Miniprogram miniprogram) {
		this.miniprogram = miniprogram;
	}
	public class Miniprogram{
		private String appid;
		private String pagepath;
		public String getAppid() {
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		public String getPagepath() {
			return pagepath;
		}
		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}
	}
	public class Data{
		private ValueData first;
		private ValueData orderProductPrice;
		private ValueData orderAddress;
		private ValueData orderProductName;
		private ValueData orderName;
		private ValueData remark;
		public ValueData getFirst() {
			return first;
		}
		public void setFirst(ValueData first) {
			this.first = first;
		}
		public ValueData getOrderProductPrice() {
			return orderProductPrice;
		}
		public void setOrderProductPrice(ValueData orderProductPrice) {
			this.orderProductPrice = orderProductPrice;
		}
		public ValueData getOrderAddress() {
			return orderAddress;
		}
		public void setOrderAddress(ValueData orderAddress) {
			this.orderAddress = orderAddress;
		}
		public ValueData getOrderProductName() {
			return orderProductName;
		}
		public void setOrderProductName(ValueData orderProductName) {
			this.orderProductName = orderProductName;
		}
		public ValueData getOrderName() {
			return orderName;
		}
		public void setOrderName(ValueData orderName) {
			this.orderName = orderName;
		}
		public ValueData getRemark() {
			return remark;
		}
		public void setRemark(ValueData remark) {
			this.remark = remark;
		}
		
	}
	public class ValueData{
		private String value;
		private String color;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
	}
}
