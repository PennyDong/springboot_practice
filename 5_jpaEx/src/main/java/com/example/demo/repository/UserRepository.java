package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;


//CRUD
public interface UserRepository extends JpaRepository<User,Integer> {
	
	//JPQL
	@Query("select u from User u where u.username=?1 and u.password=?2")
	User queryUser(String username,String password);
	
	@Query(value="select * from user where username=?1 and password=?2",nativeQuery=true)
	User queryUser_SQL(String username,String password);

	
	User findByUsername(String username);

	
	
}
