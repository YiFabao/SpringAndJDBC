package com.yifabao.bean;

public class Person {
	private Integer id;
	private String name;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Person(String name){
		this.name=name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
