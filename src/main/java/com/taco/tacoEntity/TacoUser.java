package com.taco.tacoEntity;

public class TacoUser {
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String image;

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String role;

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public TacoUser() {
		super();
	}

	@Override
	public String toString() {
		return "TacoUser [name=" + name + ", email=" + email + ", image=" + image + ", role=" + role + "]";
	}

	public TacoUser(String name, String email, String image, String role) {
		super();
		this.name = name;
		this.email = email;
		this.image = image;
		this.role = role;
	}
}
