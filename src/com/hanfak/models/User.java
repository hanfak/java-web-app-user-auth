package com.hanfak.models;

public class User {
	private int id;
	private String username;
	private String email;
	private String mobile;
	private String password;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile + ", password="
				+ password + "]";
	}
	
	public boolean allFieldsNotNull() {
		return getUsername() != "" && getEmail() != "" && getMobile() != "" && getPassword() != "";
	}
}
