package com.example.demo.entity;

import org.springframework.stereotype.Component;

import com.example.demo.util.abc;

@Component
public class user1 implements abc {

	private String name;


	public user1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public user1(String name) {
		super();
		name = "aaa";
	}


	@Override
	public void skill() {
		System.out.println("user1");
	}

}
