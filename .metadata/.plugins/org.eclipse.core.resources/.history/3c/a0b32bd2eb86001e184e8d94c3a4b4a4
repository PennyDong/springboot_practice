package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.pojo.chat;

@Mapper
public interface chatMapper {
	
	//create
	
	@Insert("insert into chat(name,subject,content)"
			+"values(#{name},#{subject},#{content})")
	void chatAdd(chat c);
	
	
	
	//read
	@Select("select * from chat order by id desc")
	List<chat> getChatList();
	
	@Select("select * from chat where id=#{id}")
	chat queryMember(int id);
	
	//update
	
	
	
	//delete
}
