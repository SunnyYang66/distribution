package org.mfoyou.agent.common.entity.enums;

public enum MfoyouUserType {
    
    customer(1), runer(4),agent(2), store(8),station(32),admin(128);

    private Integer value;

    private MfoyouUserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
