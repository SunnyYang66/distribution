package org.mfoyou.agent.common.entity.enums;

public enum OrderType {
     serviceOrder(1), goodsOrder(2),rechargeOrder(3), extractOrder(4),
     extractFailOrder(5),extractRefuseOrder(6),nativeOrder(7),nativeExeOrder(8),payOrder(9),dadaOrder(10)
     ,vipRecharge(11),scoreOrder(12),couponRecharge(13),couponReturn(14);
	
    private Integer value;

    private OrderType(int value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
