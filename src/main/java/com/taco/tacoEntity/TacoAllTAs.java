package com.taco.tacoEntity;

public class TacoAllTAs {
	
	private String[] skills;

	private String[] interests;

	private String[] tacourses;

	private String workHours;

	private String id;

	private String email;

	private String program;

	private String name;

	private String availableHours;

	private CourseHours[] courseHours;

	private Experience experience;

	private String major;

	private Availability[] availability;

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public String[] getInterests() {
		return interests;
	}

	public void setInterests(String[] interests) {
		this.interests = interests;
	}

	public String[] getTacourses() {
		return tacourses;
	}

	public void setTacourses(String[] tacourses) {
		this.tacourses = tacourses;
	}

	public String getWorkHours() {
		return workHours;
	}

	public void setWorkHours(String workHours) {
		this.workHours = workHours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailableHours() {
		return availableHours;
	}

	public void setAvailableHours(String availableHours) {
		this.availableHours = availableHours;
	}

	public CourseHours[] getCourseHours() {
		return courseHours;
	}

	public void setCourseHours(CourseHours[] courseHours) {
		this.courseHours = courseHours;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Availability[] getAvailability() {
		return availability;
	}

	public void setAvailability(Availability[] availability) {
		this.availability = availability;
	}

	public TacoAllTAs() {
		super();
	}

	@Override
	public String toString() {
		return "ClassPojo [skills = " + skills + ", interests = " + interests + ", tacourses = " + tacourses
				+ ", workHours = " + workHours + ", id = " + id + ", email = " + email + ", program = " + program
				+ ", name = " + name + ", availableHours = " + availableHours + ", courseHours = " + courseHours
				+ ", experience = " + experience + ", major = " + major + ", availability = " + availability + "]";
	}

	public TacoAllTAs(String[] skills, String[] interests, String[] tacourses, String workHours, String id,
			String email, String program, String name, String availableHours, CourseHours[] courseHours,
			Experience experience, String major, Availability[] availability) {
		super();
		this.skills = skills;
		this.interests = interests;
		this.tacourses = tacourses;
		this.workHours = workHours;
		this.id = id;
		this.email = email;
		this.program = program;
		this.name = name;
		this.availableHours = availableHours;
		this.courseHours = courseHours;
		this.experience = experience;
		this.major = major;
		this.availability = availability;
	}
	
	
}
