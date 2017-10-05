package com.taco.tacoEntity;

import java.util.List;

public class TacoProfCoursesAndRapidTeams {
	private String id;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private List<String> courses;

	public List<String> getCourses() {
		return this.courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public TacoProfCoursesAndRapidTeams(String id, List<String> courses, List<String> rapidTeams) {
		super();
		this.id = id;
		this.courses = courses;
		this.rapidTeams = rapidTeams;
	}

	private List<String> rapidTeams;

	public List<String> getRapidTeams() {
		return this.rapidTeams;
	}

	public void setRapidTeams(List<String> rapidTeams) {
		this.rapidTeams = rapidTeams;
	}

	
	public TacoProfCoursesAndRapidTeams() {
		super();
	}

	@Override
	public String toString() {
		return "TacoProfCoursesAndRapidTeams [id=" + id + ", courses=" + courses + ", rapidTeams=" + rapidTeams + "]";
	}
}
