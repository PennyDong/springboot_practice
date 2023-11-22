package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.member;

@Mapper
public interface memberMapper {

	//create
	
	//read
	@Select("select * from member where username=#{username} and password=#{password}")
	member queryMember(String username,String password);
	
	@Select("select * from member")
	List<member> memberList(member m);
	//update
	
	
	//delete
	
}
