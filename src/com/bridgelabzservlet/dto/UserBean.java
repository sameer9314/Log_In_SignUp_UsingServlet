package com.bridgelabzservlet.dto;

import java.io.Serializable;

/**
 * Purpose : User poso Class to store user details.
 * @author Sameer Saurabh
 * @version : 1.0
 * @since : 29/06/2018
 */
public class UserBean implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String user_name;
	private String email;
	private String phoneNumber;
	private String password;
	
	public UserBean() {	}
	
	public UserBean(int id) 
	{
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", user_name=" + user_name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", password=" + password + "]";
	}
}
