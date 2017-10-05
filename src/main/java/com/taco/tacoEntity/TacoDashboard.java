package com.taco.tacoEntity;

public class TacoDashboard {
	private TacoDashboardCourses[] courses;

	public TacoDashboard() {
		super();
	}

	public TacoDashboard(TacoDashboardCourses[] courses) {
		super();
		this.courses = courses;
	}

	public TacoDashboardCourses[] getCourses() {
		return courses;
	}

	public void setCourses(TacoDashboardCourses[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "ClassPojo [courses = " + courses + "]";
	}
}
