package com.taco.main;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Sample")
public class Sample {

	String name;
	String value;

	NestedSample NestedSample;

	public String getName() {
		return name;
	}

	@XmlAttribute(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	@XmlAttribute(name = "value")
	public void setValue(String value) {
		this.value = value;
	}

	public NestedSample getNestedSample() {
		return NestedSample;
	}

	@XmlElement(name = "nestedSample")
	public void setNestedSample(NestedSample nestedSample) {
		NestedSample = nestedSample;
	}

	public Sample(String name, String value, com.taco.main.NestedSample nestedSample) {
		super();
		this.name = name;
		this.value = value;
		NestedSample = nestedSample;
	}

	public Sample() {
		super();
	}

}
