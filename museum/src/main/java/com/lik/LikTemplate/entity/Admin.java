package com.lik.LikTemplate.entity;

import lombok.Data;

@Data
public class Admin {
	private String name;  //用户名
	private String pwd;   //密码
	private String address;  //地址
	private String email;  //用户邮箱
	private String phone;  //电话
	
	public Admin() {
		
	}
	public Admin(String name, String pwd, String address, String email, String phone) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	
	

}
