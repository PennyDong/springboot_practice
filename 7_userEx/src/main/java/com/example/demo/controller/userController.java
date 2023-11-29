package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.impl.userDaoImpl;

@RestController
public class userController {
	
	@Autowired
	userDaoImpl udimpl;
	
	@PostMapping("add")
	public String add(String name,Integer age) {
		
		User u = new User();
		udimpl.add(u);
		
		return "add success";
	}
	
	@GetMapping("all")
	public List<User> get(){
		return udimpl.queryAll();
	}
	
}
