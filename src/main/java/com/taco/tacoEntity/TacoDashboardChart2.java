package com.taco.tacoEntity;

public class TacoDashboardChart2 {
	private String[] series;

	private String[][] data;

	public String[] getSeries() {
		return series;
	}

	public void setSeries(String[] series) {
		this.series = series;
	}

	public String[][] getData() {
		return data;
	}

	public void setData(String[][] data) {
		this.data = data;
	}

	public TacoDashboardChart2() {
		super();
	}

	public TacoDashboardChart2(String[] series, String[][] data) {
		super();
		this.series = series;
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassPojo [series = " + series + ", data = " + data + "]";
	}
}
