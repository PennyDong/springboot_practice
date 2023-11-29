package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.User;
import com.example.demo.repository.userRepository;

public class userDaoImpl implements userDao {
	
	@Autowired
	userRepository ur;
	
	@Override
	public void add(User u) {
		// TODO Auto-generated method stub
		ur.save(u);
	}

	@Override
	public List<User> queryAll() {
		// TODO Auto-generated method stub
		return ur.findAll();
	}
	
	
	
}
