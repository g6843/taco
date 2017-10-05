package com.taco.tacoEntity;

public class CourseHours
{
    private String course;

    private String hours;

    public String getCourse ()
    {
        return course;
    }

    public void setCourse (String course)
    {
        this.course = course;
    }

    public String getHours ()
    {
        return hours;
    }

    public void setHours (String hours)
    {
        this.hours = hours;
    }

    public CourseHours(String course, String hours) {
		super();
		this.course = course;
		this.hours = hours;
	}

	public CourseHours() {
		super();
	}

	@Override
    public String toString()
    {
        return "ClassPojo [course = "+course+", hours = "+hours+"]";
    }
}

