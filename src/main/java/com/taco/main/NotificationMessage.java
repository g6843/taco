package com.taco.main;

import java.util.Date;

public class NotificationMessage {

	private String message;
	private Date time;

	public NotificationMessage() {
	}

	public String getMessage() {
		return message;
	}

	public NotificationMessage(String message, Date time) {
		super();
		this.message = message;
		this.time = time;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}