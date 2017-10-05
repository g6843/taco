package com.taco.tacoEntity;

import java.util.Arrays;

public class TacoCourseTAInformation {
	private String id;

	private String[] skills;

	private String email;

	private String availableHours;

	private String name;

	private CourseHours[] courseHours;

	private String role;

	private Experience experience;

	private String workHours;

	private String[] tacourses;

	private Availability[] availability;

	
	public TacoCourseTAInformation(String id, String[] skills, String email,
			String availableHours, String name, CourseHours[] courseHours, String role, Experience experience,
			String workHours, String[] tacourses, Availability[] availability) {
		super();
		this.id = id;
		this.skills = skills;
		this.email = email;
		this.availableHours = availableHours;
		this.name = name;
		this.courseHours = courseHours;
		this.role = role;
		this.experience = experience;
		this.workHours = workHours;
		this.tacourses = tacourses;
		this.availability = availability;
	}

	
	public TacoCourseTAInformation() {
		super();
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public CourseHours[] getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(CourseHours[] courseHours) {
		this.courseHours = courseHours;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String[] getTacourses() {
		return tacourses;
	}

	public void setTacourses(String[] tacourses) {
		this.tacourses = tacourses;
	}

	public Availability[] getAvailability() {
		return availability;
	}

	public void setAvailability(Availability[] availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "TacoCourseTAInformation [id=" + id + ", skills=" + Arrays.toString(skills) + ", email=" + email
				+ ", availableHours=" + availableHours + ", name=" + name + ", courseHours="
				+ Arrays.toString(courseHours) + ", role=" + role + ", experience=" + experience + ", workHours="
				+ workHours + ", tacourses=" + Arrays.toString(tacourses) + ", availability="
				+ Arrays.toString(availability) + "]";
	}


}