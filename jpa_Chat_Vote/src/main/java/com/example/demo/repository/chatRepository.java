package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Chat;

public interface chatRepository extends JpaRepository<Chat, Integer>{

}
