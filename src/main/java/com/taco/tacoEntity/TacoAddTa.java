package com.taco.tacoEntity;

public class TacoAddTa {

	private String taId;
	
	private String courseName;

	public String getTaId() {
		return taId;
	}

	public void setTaId(String taId) {
		this.taId = taId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public TacoAddTa(String taId, String courseName) {
		super();
		this.taId = taId;
		this.courseName = courseName;
	}

	public TacoAddTa() {
		super();
	}
	
	
}
