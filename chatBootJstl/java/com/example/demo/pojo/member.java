package com.example.demo.pojo;

import lombok.Data;

@Data
public class member {

	private Integer id;
	private String username;
	private String password;
	private String name;
	private String phone;
	private String mobile;

	public member() {
		super();
	}

	public member(String username, String password, String name, String phone, String mobile) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
	}

}
