package com.taco.tacoEntity;

public class Experience
{
    private String[] projects;

    private PreviousTA[] previousTA;

    public String[] getProjects ()
    {
        return projects;
    }

    public void setProjects (String[] projects)
    {
        this.projects = projects;
    }

    public PreviousTA[] getPreviousTA ()
    {
        return previousTA;
    }

    public Experience(String[] projects, PreviousTA[] previousTA) {
		super();
		this.projects = projects;
		this.previousTA = previousTA;
	}

	public void setPreviousTA (PreviousTA[] previousTA)
    {
        this.previousTA = previousTA;
    }

	
    public Experience() {
		super();
	}

	@Override
    public String toString()
    {
        return "ClassPojo [projects = "+projects+", previousTA = "+previousTA+"]";
    }
}
