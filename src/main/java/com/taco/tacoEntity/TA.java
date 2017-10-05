package com.taco.tacoEntity;

public class TA {

	String taId;
	String taName;

	public String getTaId() {
		return taId;
	}

	public void setTaId(String taId) {
		this.taId = taId;
	}

	public String getTaName() {
		return taName;
	}

	public void setTaName(String taName) {
		this.taName = taName;
	}

	public TA(String taId, String taName) {
		super();
		this.taId = taId;
		this.taName = taName;
	}

	public TA() {
		super();
	}

	
}
