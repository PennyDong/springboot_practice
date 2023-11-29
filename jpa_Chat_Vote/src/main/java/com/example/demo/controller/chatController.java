package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Chat;
import com.example.demo.repository.chatRepository;

@RestController
@RequestMapping("chat")
public class chatController {

	@Autowired
	private chatRepository chatrepository;
	
	@RequestMapping("queryAll")
	public List<Chat> chatList(){
		
		return chatrepository.findAll();
		
	}
	
	@RequestMapping("chat")
	public ModelAndView chat() {
		
		List<Chat> chatList = chatrepository.findAll();
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("chat");
		
		mv.addObject("chatList", chatList);
		
		return mv;
	}
	
	@RequestMapping("addChat")
	public ModelAndView addChat(String name,String subject,String content) {
		
		
		
		ModelAndView mv = new ModelAndView();
		

		
		
		if(name==null||subject==null||content==null) {
			
//			mv.addObject("error","請重新輸入，不能有空白使用者或空白回覆");
			
			mv.setViewName("redirect:chat");
			
		}else {
			
			Chat c = new Chat();
			
			c.setName(name);
			c.setSubject(subject);
			c.setContent(content);
			
			chatrepository.save(c);
			mv.setViewName("redirect:chat");
		}
		
		
		return mv;
	}
}
