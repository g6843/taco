package com.taco.tacoEntity;

public class Availability
{
    private String hours;

    private String day;

    public String getHours ()
    {
        return hours;
    }

    public void setHours (String hours)
    {
        this.hours = hours;
    }

    public String getDay ()
    {
        return day;
    }

    public void setDay (String day)
    {
        this.day = day;
    }

    public Availability(String hours, String day) {
		super();
		this.hours = hours;
		this.day = day;
	}

    
	public Availability() {
		super();
	}

	@Override
    public String toString()
    {
        return "ClassPojo [hours = "+hours+", day = "+day+"]";
    }
}
