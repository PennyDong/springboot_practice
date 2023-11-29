package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.user;

@RestController
public class testController {
	
	@GetMapping("test1")
	public String get1(@RequestParam String name) {
		System.out.println("name="+name);
		
		return "test1";
	}
	
	@GetMapping("test2")
	public String get2(@RequestParam("name") String abc) {
		
		System.out.println("name="+abc);
		
		return "test2";
	}
	
	@GetMapping("test2_2")
	public String get2_2(@RequestParam(value="name",required=false) String abc) {
		
		System.out.println("name="+abc);
		
		return "test2";
	}
	
	
	@GetMapping("test3")
	public String get3(@RequestParam(value="name",defaultValue = "0000") String abc) {
		
		System.out.println("name="+abc);
		
		return "test3";
	}
	
	@PostMapping("test4")
	public String get4(@RequestParam(value="name",defaultValue = "0000") String abc,
						@RequestParam(value="age",defaultValue="20") Integer age) {
		
		System.out.println("name="+abc+"\tage"+age);
		
		return "test4";
	}
	
	@GetMapping("test5/{id}")
	public String get5(@PathVariable("id") Integer id) {
		
		System.out.println("id="+id);
		
		return "test5";
		
	}
	
	@GetMapping("test6/{name}/{age}")
	public String get6(@PathVariable("name") String abc,@PathVariable("age") Integer aaa){
		
		System.out.println(abc+"\tage"+aaa);
		
		return "test6";
	}
	
	@GetMapping("test7")
	public String get7(@RequestBody user u) {
		
		System.out.println("Id="+u.getId()+"name="+u.getName());
		
		return "test7";
	}
}
