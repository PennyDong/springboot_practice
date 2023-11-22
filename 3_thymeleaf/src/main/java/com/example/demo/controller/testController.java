package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class testController {
	
	@RequestMapping("exam1")
	public String goToExam1(Model model1) {
		
		String companyname="tea";
		model1.addAttribute("Name",companyname);
		
		return "exam1";
	}
	
	@RequestMapping("exam2")
	public ModelAndView gotoE2(){
		
		//ModelAndView mv = new ModelAndView("exam1");
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("exam2");
		
		return mv;
		
	}
}
