package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.member;

@RestController
public class memberController {
	
	@Autowired //Nen Object
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("add")
	public String add2(String name,String username,String password,String address,String phone,String mobile
)throws Exception{
	String SQL="insert into member(username,password,name,address,phone,mobile) values(?,?,?,?,?,?)";
			
	jdbcTemplate.update(SQL,username,password,name,address,phone,mobile);
	
		return "新增成功";
	
	}
	
	@RequestMapping("update")
	public String update(int id,String name)throws Exception {
		
		String SQL="update member set name=? where id=?";
		
		jdbcTemplate.update(SQL,name,id);
		
		return "update Success";
		
	}
	
	@RequestMapping("delete")
	public String delete(int id)throws Exception {
		
		String SQL="delete from member where id=?";
		
		jdbcTemplate.update(SQL,id);
		
		return "delete success";
	}
	
	@RequestMapping("queryAll")
	public List<member> queryAll()throws Exception{
		
		String SQL="select * from member";
		
		List<member> memberList = jdbcTemplate.query(SQL,new BeanPropertyRowMapper(member.class));
		
		return memberList;
	}
	
	@RequestMapping("queryMember")
	public List<member> queryMember(String username,String password)throws Exception{
		
		String SQL="select * from member where username=? and password=?";
		
		List<member> memberList = jdbcTemplate.query(SQL,new BeanPropertyRowMapper(member.class),username,password);
		
		return memberList;
		
	}
}
@Controller
class queryAll2{
	
	@Autowired //Nen Object
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("queryAll2")
	@ResponseBody
	public List<member> queryAll2()throws Exception{
		
		String SQL="select * from member";
		
		List<member> memberList = jdbcTemplate.query(SQL,new BeanPropertyRowMapper(member.class));
		
		return memberList;
	}
	
}