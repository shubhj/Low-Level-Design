package com.interview.craftDemo.repository;

public class User {
	
	private String name;
	private int id;
	private String email;
	private static int userCount=1;
	
	public User(String name, String email){
		this.name= name;
		this.email=email;
		this.id=userCount++;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

}
