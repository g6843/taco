package com.taco.tacoEntity;

public class TacoCourseTAAvailability {

	private String id;

	private String availableHours;

	private String name;

	private String courseHours;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAvailableHours() {
		return availableHours;
	}

	public void setAvailableHours(String availableHours) {
		this.availableHours = availableHours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(String courseHours) {
		this.courseHours = courseHours;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", availableHours = " + availableHours + ", name = " + name
				+ ", courseHours = " + courseHours + "]";
	}

	public TacoCourseTAAvailability(String id, String availableHours, String name, String courseHours) {
		super();
		this.id = id;
		this.availableHours = availableHours;
		this.name = name;
		this.courseHours = courseHours;
	}

	public TacoCourseTAAvailability() {
		super();
	}
}
