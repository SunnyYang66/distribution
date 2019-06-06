package org.mfoyou.agent.common.entity.enums;

public enum XingAppointState {
	
    appointStart(1),
    appintUsing(3),
    appintComplet(5),
    appintRevoke(7);
	
    private int value;

    private XingAppointState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
