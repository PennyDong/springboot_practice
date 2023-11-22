package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//如果使用jsp網頁必須使用@Controller 不能用@RestController
@Controller
public class memberController {
	
	@RequestMapping("hello")
	public String hello() {
		return "hello";
	}
	
}
