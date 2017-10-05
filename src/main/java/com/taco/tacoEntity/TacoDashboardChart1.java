package com.taco.tacoEntity;

public class TacoDashboardChart1 {
	private String[] hours;

	public String[] getHours() {
		return hours;
	}

	public void setHours(String[] hours) {
		this.hours = hours;
	}

	public TacoDashboardChart1() {
		super();
	}

	public TacoDashboardChart1(String[] hours) {
		super();
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "ClassPojo [hours = " + hours + "]";
	}
}
