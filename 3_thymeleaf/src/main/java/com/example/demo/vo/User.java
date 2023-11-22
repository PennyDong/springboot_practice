package com.example.demo.vo;

import lombok.Data;

@Data
public class User {

	private Integer Id;
	private String name;
	private Integer age;

	public User(Integer id, String name, Integer age) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
