package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.mapper.memberMapper;
import com.example.demo.vo.User;
import com.example.demo.vo.member;

import jakarta.servlet.http.HttpSession;

@RestController
public class test2Controller {
	
	@Autowired
	private memberMapper membermapper;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("e1")
	public String gettoExma1() {
		return "exam1";
	}
	
	
	
	@RequestMapping("login")
	public ModelAndView login(String username,String password) {
		
		member m = membermapper.queryMember(username,password);
		
		ModelAndView mv=null;
		
		if(m!=null) {
			session.setAttribute("M", m);
			 mv = new ModelAndView("loginSuccess");
		}else {
			session.setAttribute("M", m);
			 mv = new ModelAndView("loginError");
		}
		
		return mv;
	}
	
	@RequestMapping("e2")
	public ModelAndView gettoExma2() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("exam2");
		
		return mv;
	}
	
	@RequestMapping("exam3")
	public ModelAndView getoExam3(Model model) {
		
		String companyname="computer_class";
		model.addAttribute("Name",companyname);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("exam3");
		
		User u = new User(1,"penny",28);
		
		mav.addObject("USER", u);
		
		return mav;
	}
	
	
	@RequestMapping("exam4")
	public ModelAndView gotoEx4() {
		
		List<User> userList = new ArrayList();
		userList.add(new User(1,"A",28));
		userList.add(new User(2,"b",18));
		userList.add(new User(3,"C",8));
		userList.add(new User(4,"d",16));
		
		ModelAndView mv = new ModelAndView("exam4");
		
		mv.addObject("userList", userList);
		
		return mv;
	}
	
	@RequestMapping("exam5")
	public ModelAndView getToMember(Model model) {
		
		
		
		model.addAttribute("memberData", "會員基本資料");
		
		List<member> memberList = membermapper.query();
				
		ModelAndView mv = new ModelAndView("exam5");
		
		mv.addObject("memberList",memberList);
		
		return mv;
	}
	
}
