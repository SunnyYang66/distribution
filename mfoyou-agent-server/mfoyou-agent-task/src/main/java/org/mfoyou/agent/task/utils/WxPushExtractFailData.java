package org.mfoyou.agent.task.utils;

public class WxPushExtractFailData extends WxPushData{
	
	public class Data{
		private ValueData first;
		private ValueData money;
		private ValueData time;
		private ValueData remark;
		public ValueData getFirst() {
			return first;
		}
		public void setFirst(ValueData first) {
			this.first = first;
		}
		public ValueData getRemark() {
			return remark;
		}
		public void setRemark(ValueData remark) {
			this.remark = remark;
		}
		public ValueData getTime() {
			return time;
		}
		public void setTime(ValueData time) {
			this.time = time;
		}
		public ValueData getMoney() {
			return money;
		}
		public void setMoney(ValueData money) {
			this.money = money;
		}
	}
}
