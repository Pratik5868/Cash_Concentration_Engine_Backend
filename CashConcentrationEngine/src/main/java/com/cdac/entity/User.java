package com.cdac.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
//User Entity Class
@Entity
@Table(name = "User_Table")
public class User {
	
	@Id
	@NotEmpty(message="UserID should not be empty.")
	@Column(name = "User_ID")
	private String userId;
	
	@Column(name="User_Name")
	@NotEmpty(message="Username should not be empty.")
	private String userName;
	
	@Column(name="Password")
	@NotEmpty(message="Passowrd should not be empty.")
	private String password;
	
	@Column(name="Role")
	@NotEmpty(message="Role should not be empty.")
	private String role;

	public User() {
		super();

	}

	public User(String userId, String userName, String password, String role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}

}
