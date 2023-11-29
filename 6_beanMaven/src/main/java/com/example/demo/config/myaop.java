package com.example.demo.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class myaop {
	
	@Before("execution(* com.example.demo.controller.beanController.*(..))")//整個專案所有的方法
	public void before()
	{
		System.out.println("I am before");
		
	}
	
	@After("execution(* com.example.demo.controller.beanController.*(..))")
	public void after()
	{
		System.out.println("I am after");
	}
}
