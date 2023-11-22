package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.pojo.vote;

@Mapper
public interface voteMapper {
	
	
	//create
	
	
	//read
	@Select("select * from vote")
	List<vote> getVoteList();
	
	@Select("select * from vote where id=#{id}")
	vote voteId(Integer id);
	
	//update
	
	@Update("update vote set quantity=quantity+1 where id=#{id}")
	void updateQuantity(Integer id);
	
	
	//delete
}
