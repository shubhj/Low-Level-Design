package com.interview.craftDemo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post extends Entity{
	
	private static int postCount=1;
	private int id;
	private String postText;
	

	List<Comment> comments ; 

	public Post(String postText, User user ){
		this.id=postCount++;
		this.setUser(user);
		this.setLikes(0);
		this.setDisLikes(0);
		this.setCreatedDate((new Date()));
		this.postText=postText;
		this.comments=new ArrayList<Comment>();
		
		PostCommentRepo.getPosts().add(this);
		
		System.out.println("New Post Created : "+ this.getId()+"  , Total Posts :  "+PostCommentRepo.getPosts().size());
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	

}
