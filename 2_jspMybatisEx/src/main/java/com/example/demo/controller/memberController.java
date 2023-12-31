package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.memberMapper;
import com.example.demo.vo.member;

@Controller
public class memberController {

	@Autowired
	private memberMapper memberMapper;
	
	@RequestMapping("addMember")
	public String getToAddMember(){
		return "addMember";
	}
	
	
	@RequestMapping("add")
	public String add(String username,String password,String name,String address,String phone,String mobile) {
		
		member m = memberMapper.queryUsername(username);
		
		if(m!=null) {
			
			return "addMemberError";
			
		}else {
			member m2 = new member(username,password,name,address,phone,mobile);
			memberMapper.add(m2);
			
		return "addMemberSuccess";
		}
	}
	
	@RequestMapping("login")
	public String login(String username,String password) {
		
		member m = memberMapper.queryMember(username, password);
		
		if(m!=null) {
			return "loginSuccess";
		}else {
			return "loginError";
		}
	}
	
	
}
