package com.example.demo.pojo;

import lombok.Data;

@Data
public class chat {

	private Integer id;
	private String name;
	private String subject;
	private String content;

	public chat() {
		super();
	}

	public chat(String name, String subject, String content) {
		super();
		this.name = name;
		this.subject = subject;
		this.content = content;
	}

}
