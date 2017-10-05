package com.taco.tacoEntity;

public class PreviousTA
{
    private String course;

    private String years;

    public PreviousTA(String course, String years) {
		super();
		this.course = course;
		this.years = years;
	}

	public String getCourse ()
    {
        return course;
    }

    public void setCourse (String course)
    {
        this.course = course;
    }

    public String getYears ()
    {
        return years;
    }

    public void setYears (String years)
    {
        this.years = years;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [course = "+course+", years = "+years+"]";
    }

	public PreviousTA() {
		super();
	}
    
    
}
	