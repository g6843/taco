package com.taco.tacoEntity;

public class TacoUserIdAndCourse {
	private String userId;

    private String courseName;

    public String getUserId ()
    {
        return userId;
    }

    public void setUserId (String userId)
    {
        this.userId = userId;
    }

    public String getCourseName ()
    {
        return courseName;
    }

    public void setCourseName (String courseName)
    {
        this.courseName = courseName;
    }

    public TacoUserIdAndCourse() {
		super();
	}

	@Override
    public String toString()
    {
        return "ClassPojo [userId = "+userId+", courseName = "+courseName+"]";
    }

}
