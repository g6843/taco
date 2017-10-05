package com.taco.tacoEntity;

public class TacoCourseTask {
	private String id;

	private String doneHours;

	private String status;

	private String priority;

	private String hours;

	private String taId; 
	
	public String getTaId() {
		return taId;
	}

	public void setTaId(String taId) {
		this.taId = taId;
	}

	private String name;

	private String ta;
	
	public TacoCourseTask(){
		//
	}
	
	public TacoCourseTask(String id, String doneHours, String status, String priority, String hours, String ta,
			String name, String taId) {
		super();
		this.id = id;
		this.doneHours = doneHours;
		this.status = status;
		this.priority = priority;
		this.hours = hours;
		this.ta = ta;
		this.name = name;
		this.taId = taId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDoneHours() {
		return doneHours;
	}

	public void setDoneHours(String doneHours) {
		this.doneHours = doneHours;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTa() {
		return ta;
	}

	public void setTa(String ta) {
		this.ta = ta;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", doneHours = " + doneHours + ", status = " + status + ", priority = "
				+ priority + ", hours = " + hours + ", ta = " + ta + ", name = " + name + "]";
	}
}
