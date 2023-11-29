package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("User")
public class userController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("queryUser")
	public User queryUser(String username,String passoword) {
		return userRepository.queryUser(username, passoword);
	}
	
	
	
	@PostMapping("login")
	public ModelAndView login(String username,String password)throws Exception {
		
		User user = userRepository.queryUser(username, password);
		
		ModelAndView mv;
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				
				
				mv = new ModelAndView();
				mv.setViewName("loginSuccess");
				mv.addObject("success","Hello\t"+user.getName());
				
			}else {
				
				mv = new ModelAndView();
				mv.setViewName("loginError");
				mv.addObject("error","密碼錯誤");
			}
			
		}else {
			
			 mv = new ModelAndView();
			 mv.setViewName("loginError");
			 mv.addObject("error","無此使用者");
		}
		return mv;
	}
}
