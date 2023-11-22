package com.example.demo.pojo;

import lombok.Data;

@Data
public class vote {

	private Integer id;
	private String name;
	private String quantity;

	public vote() {
		super();
	}

	public vote(String name, String quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public vote(Integer id, String name, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
	}

}
