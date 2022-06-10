package com.lik.LikTemplate.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value="t_user")
public class User {
	private String userName;
	private String userPwd;
	private String userSex;
	private String userPhone;
	private String userEmail;
	private String creation;
	
	public User() {
		super();
	}
	public User(String userName, String userPwd, String userSex, String userPhone, String userEmail, String creation) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.creation = creation;
	}
	
	
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + ", userSex=" + userSex + ", userPhone="
				+ userPhone + ", userEmail=" + userEmail + ", creation=" + creation + "]";
	}
	

}
