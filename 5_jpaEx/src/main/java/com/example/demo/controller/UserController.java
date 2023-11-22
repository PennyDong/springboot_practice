package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("User")
public class UserController {
	
	@Autowired
	private UserRepository  UserRepository;
	
	@RequestMapping("add")
	public String add(String name,String username,String password) {
		
		User user = new User();
		
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		
		UserRepository.save(user);
		
		return "add Success";
	}
	
	@RequestMapping("queryall")
	public List<User> queryall() {
		
		return UserRepository.findAll();
	}
	
	@RequestMapping("queryId")
	public User queryId(int id) {
		
		Optional<User> userOption = UserRepository.findById(id);
		
		User user = null;
		
		//System.out.println(usrOption.isEmpty()+"\t"+userOption.isPresent());
		if(userOption.isPresent()) {
			user = userOption.get();
		}
		return user;
	}
	
	@RequestMapping("update")
	public String update(Integer id,String name,String password) {
		
		User user = queryId(id);
		
		user.setName(name);
		user.setPassword(password);
		
		UserRepository.save(user);
		
		return "update Success";
	}
	
	@RequestMapping("delete")
	public String delete(Integer id) {
		
		
		UserRepository.deleteById(id);
		
		return "delete Success";
	}
	
	@RequestMapping("queryUser")
	public User queryUser(String username,String password) {
		
		return UserRepository.queryUser(username, password);
		
	}
	
	@RequestMapping("queryUser_SQL")
	public User queryUser_SQL(String username,String password) {
		
		return UserRepository.queryUser(username, password);
		
	}
}
