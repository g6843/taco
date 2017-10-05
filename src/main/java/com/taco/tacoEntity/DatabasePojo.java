package com.taco.tacoEntity;

import org.springframework.data.annotation.Id;

public class DatabasePojo {
	@Id
	public String id;

	public String key;
	public Object myObj;

	public DatabasePojo() {
	}

	public DatabasePojo(String id, String key, Object myObj) {
		super();
		this.id = id;
		this.key = key;
		this.myObj = myObj;
	}

	public DatabasePojo(String key, Object myObj) {
		super();
		this.key = key;
		this.myObj = myObj;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getMyObj() {
		return myObj;
	}

	public void setMyObj(Object myObj) {
		this.myObj = myObj;
	}

	@Override
	public String toString() {
		return "DatabasePojo [id=" + id + ", key=" + key + ", myObj=" + myObj + "]";
	}

}
