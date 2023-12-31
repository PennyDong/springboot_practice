package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.chatMapper;
import com.example.demo.pojo.chat;

import jakarta.servlet.http.HttpSession;

@Controller
public class chatController {
	
	@Autowired
	private chatMapper chatmapper;
	
	//設置連結名稱
//	@RequestMapping("chat")
//	public String chatModel(HttpSession session) throws IOException {
//		
//		List<chat> chatList = chatmapper.getChatList();
//		
//		//讓資料生命週期可以沿用到下一個頁面
//		session.setAttribute("chatList",chatList);		
//			
//		return "chat";
//	}
	
	
	
	@RequestMapping("addChat")
	public String addChat(String name,String subject,String content) throws IOException {
		
		chat c = new chat(name,subject,content);
		
		chatmapper.chatAdd(c);
		
		//重新定向路徑
		return "redirect:/chat";
	}
	
	@RequestMapping("chat")
	public ModelAndView getToChat(HttpSession session) {
		
		List<chat> chatList = chatmapper.getChatList();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("chat");
		mv.addObject("chatList",chatList);
		
		return mv;
	}
}
//	@RequestMapping
//	public String index() {
//		return "index";
	

