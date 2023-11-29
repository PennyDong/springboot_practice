package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("User")
public class UserController {
	
	@Autowired
	private UserRepository  UserRepository;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("add")
	public String add(String name,String username,String password) {
		
		User user = new User();
		
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		
		UserRepository.save(user);
		
		return "add Member";
	}
	
	
	@GetMapping("addMember")
	public ModelAndView addMember() {
		
		return new ModelAndView("addMember");
	}
	
	@GetMapping("member/memberCRUD")
	public ModelAndView memberCRUD() {
		return new ModelAndView("member/memberCRUD");
	}
	
	@RequestMapping("addUser")
	public ModelAndView addUser(String name,String username,String password) {
		
		ModelAndView mv=null;
		User user = UserRepository.findByUsername(username);
		if(user!=null) {
			
			mv = new ModelAndView("addMemberError");
			
			
		}else {
			
			User newUser = new User(name,username,password);
			UserRepository.save(newUser);
			
			mv = new ModelAndView("addMemberSuccess");
			mv.addObject("user",newUser);
		}
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView login(String username,String password) {
		
		
		User user = UserRepository.queryUser_SQL(username, password);
		ModelAndView mv ;
		
		if(user!=null) {
			
			List<User> userList = UserRepository.findAll();
			
			mv = new ModelAndView();
			
			session.setAttribute("userList",userList);
			session.setAttribute("User",user);
			
			mv.setViewName("loginSuccess");
			
			return mv;
		}else {
			
			mv = new ModelAndView();
			
			mv.setViewName("loginError");
			
			return mv;
		}
		
	}
	
	@GetMapping("/index")
	public ModelAndView logout() {
	    ModelAndView mv = new ModelAndView();
	    
	    // 清除 session 中的用戶數具
	    session.removeAttribute("userList");
	    session.removeAttribute("User");
	    
	    mv.setViewName("../index"); 
	    
	    return mv;
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
