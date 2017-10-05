package com.taco.main;

import javax.xml.bind.annotation.XmlAttribute;

public class NestedSample {
	String id;

	public String getId() {
		return id;
	}

	@XmlAttribute(name = "id")
	public void setId(String id) {
		this.id = id;
	}

	public NestedSample(String id) {
		super();
		this.id = id;
	}

	public NestedSample() {
		super();
	}
	
	
	
}
