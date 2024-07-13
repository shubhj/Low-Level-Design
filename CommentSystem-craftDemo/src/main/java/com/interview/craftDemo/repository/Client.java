package com.interview.craftDemo.repository;

public class Client extends User {
	
	//private static int userCount=0;
	
	
	
	public Client(String name, String email){
		super(name, email);
		PostCommentRepo.getUsers().add(this);
		System.out.println("New Client Created : "+ this.getId()+"  , Total Clients :  "+PostCommentRepo.getUsers().size());
	}
	

}
