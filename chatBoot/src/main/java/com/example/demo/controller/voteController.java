package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.voteMapper;
import com.example.demo.pojo.vote;

import jakarta.servlet.http.HttpSession;

@Controller
public class voteController {

	@Autowired
	private voteMapper votemapper;
	
	@RequestMapping("vote")
	public String getToVote(HttpSession session) {
		
		List<vote> voteList = votemapper.getVoteList();
		
		session.setAttribute("voteList",voteList);
		
		
		return "vote";
	}
	
	
	@RequestMapping("updateVote")
	public String updateVote(Integer id) {
		
		//增加指定id的票數
		votemapper.updateQuantity(id);
		
		return "redirect:/vote";
	}
	
	
}
