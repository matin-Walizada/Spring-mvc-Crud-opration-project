package com.spring.mvc.products.entity;

public class UserInfo {

	private String username;
	private String password;

	// no argument constructor
	public UserInfo() {

	}

	// parametrized constructor
	public UserInfo(String username, String password) {

		this.username = username;
		this.password = password;
	}

	// getter and setters of username and password
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString method for printing data in console
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password + "]";
	}

}
