package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.memberMapper;
import com.example.demo.pojo.member;

@Controller
public class memberController {
	
	@Autowired
	private memberMapper membermapper;
	
	
	//登入驗證
	@RequestMapping("login")
	public String login(String username,String password) {
		
		member m = membermapper.queryMember(username, password);
		
		if(m!=null) {
			return "loginSuccess";
			
		}else {
			
			return "loginError";
		}	
	}
	
	@RequestMapping("add")
	public String add() {
		return "";
	}
}
