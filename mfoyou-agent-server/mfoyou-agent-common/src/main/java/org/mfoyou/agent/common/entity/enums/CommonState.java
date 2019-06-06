package org.mfoyou.agent.common.entity.enums;

public enum CommonState {

	emsave(1), emauit(2), emauitfail(3), emauitSucess(4),
	emeffect(5),emlast(6);

	private int value;

	private CommonState(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
