package org.mfoyou.agent.common.entity.enums;

public enum GoodsOrderState {

    //下单
    emOpenOrder(1),
    //正在支付
    emPayingOrder(20),
    //支付失败
    emPayfaile(30),
    //支付成功
    emPaySucess(40),
    //现金支付
    emPayCashPaySucess(41),
    //正在等待商家
    emWaitingAccept(50),
    //商家已接单
    emStoreAccept(60),
    //等待配送团队接单
    emSeekRuner(70),
    //配送团队已接单
    emAccect(75),
    //已取货，已发货
    emBeginDelivery(80),
    //送达目的地
    emFinshDelivery(90)
    //商家确认完成
    , emStoreFinsh(500),
    //用户确认完成
    emCustomerFinsh(600),
    //系统确认完成
    emSystemFinsh(610),
    //订单已撤销
    emOrderRevoke(700),
    //订单被拒绝
    emOrderRefuse(800),
	//订单退款成功
    emReturnMoney(900);
	
    private int value;

    private GoodsOrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
