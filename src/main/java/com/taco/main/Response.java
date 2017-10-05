package com.taco.main;

import java.util.Date;

public class Response {

    public Response(String message, Date time) {
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

	private String message;
    private Date time;

    public Response() {
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

   

}