package com.vt.Vc.enumerate;

public enum BidStatus {

	INTERMIDIATE("INTERMEDIATE"),
	CURRENT("CURRENT"),
	INITIAL("INITIAL"),
	LUCKY("LUCKY"),
	FINAL("FINAL");
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private BidStatus(String value) {
		this.value = value;
	}
	
}
