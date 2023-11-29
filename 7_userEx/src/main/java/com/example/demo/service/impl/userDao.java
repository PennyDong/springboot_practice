package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.entity.User;

public interface userDao {
	
	void add(User u);
	List<User> queryAll();
}
