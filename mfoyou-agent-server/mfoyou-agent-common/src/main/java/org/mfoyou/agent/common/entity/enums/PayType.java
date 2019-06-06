package org.mfoyou.agent.common.entity.enums;

public enum PayType {
    wallet(1),WeChat(2),alipay(3),vipWallet(4),
    serviceOrder(11), rechargeOrder(12), extractOrder(13), goodsOrder(14),thirdOrder(15),
    system(21);

    private int value;

    private PayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
