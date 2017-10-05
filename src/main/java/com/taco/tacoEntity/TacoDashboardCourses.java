package com.taco.tacoEntity;

public class TacoDashboardCourses {
	private TacoDashboardChart1 chart1;

	private TacoDashboardChart2 chart2;

	private String[] names;

	private String[] tasks;

	private String courseId;

	public TacoDashboardCourses(TacoDashboardChart1 chart1, TacoDashboardChart2 chart2, String[] names,
			String courseId) {
		super();
		this.chart1 = chart1;
		this.chart2 = chart2;
		this.names = names;
		this.courseId = courseId;
	}

	public TacoDashboardCourses(TacoDashboardChart1 chart1, TacoDashboardChart2 chart2, String courseId) {
		super();
		this.chart1 = chart1;
		this.chart2 = chart2;
		this.courseId = courseId;
	}

	public TacoDashboardCourses() {
		super();
	}

	public String[] getTasks() {
		return tasks;
	}

	public void setTasks(String[] tasks) {
		this.tasks = tasks;
	}

	public TacoDashboardChart1 getChart1() {
		return chart1;
	}

	public void setChart1(TacoDashboardChart1 chart1) {
		this.chart1 = chart1;
	}

	public TacoDashboardChart2 getChart2() {
		return chart2;
	}

	public void setChart2(TacoDashboardChart2 chart2) {
		this.chart2 = chart2;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "ClassPojo [chart1 = " + chart1 + ", chart2 = " + chart2 + ", names = " + names + ", courseId = "
				+ courseId + "]";
	}
}