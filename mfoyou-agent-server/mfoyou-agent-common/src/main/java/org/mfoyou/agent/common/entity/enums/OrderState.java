package org.mfoyou.agent.common.entity.enums;

public enum OrderState {

	//下单
	emOpenOrder(1), 
	//正在支付
	emPayingOrder(20), 
	//支付失败
	emPayfaile(30),
	//支付成功
	emPaySucess(40),
	//正在等待接单
	emSeekRuner(50),
	//骑手已接单
	emRunerAccept(60),
	//开始服务
	emServiceStart(70),
	//已取货
	emServiceFinshPick(80),
	//送达目的地
	emServiceFinshTake(90)
	//骑手完成
	,emServiceRunerFinsh(500),
	//用户确认完成
	emServiceUserFinsh(600),
	//系统确认完成
	emServiceSystemFinsh(610),
	//订单已撤销
	emServiceRevoke(700),
    //订单被拒绝
    emServiceRefuse(800);

	private int value;

	private OrderState(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
