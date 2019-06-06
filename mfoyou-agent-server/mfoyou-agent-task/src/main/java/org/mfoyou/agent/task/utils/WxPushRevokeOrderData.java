package org.mfoyou.agent.task.utils;


public class WxPushRevokeOrderData {
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
		private ValueData keyword1;
		private ValueData keyword2;
		private ValueData keyword3;
		private ValueData keyword4;
		private ValueData keyword5;
		private ValueData remark;
		public ValueData getFirst() {
			return first;
		}
		public void setFirst(ValueData first) {
			this.first = first;
		}
		public ValueData getKeyword1() {
			return keyword1;
		}
		public void setKeyword1(ValueData keyword1) {
			this.keyword1 = keyword1;
		}
		public ValueData getKeyword2() {
			return keyword2;
		}
		public void setKeyword2(ValueData keyword2) {
			this.keyword2 = keyword2;
		}
		public ValueData getKeyword3() {
			return keyword3;
		}
		public void setKeyword3(ValueData keyword3) {
			this.keyword3 = keyword3;
		}
		public ValueData getKeyword4() {
			return keyword4;
		}
		public void setKeyword4(ValueData keyword4) {
			this.keyword4 = keyword4;
		}
		public ValueData getKeyword5() {
			return keyword5;
		}
		public void setKeyword5(ValueData keyword5) {
			this.keyword5 = keyword5;
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
