package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	//create
	
	
	//read
	
	@Query(value="select * from user where username=?1 and password=?2",nativeQuery=true)
	User queryUser(String username,String password);
	
	
	
	
	//update
	
	
	

}
