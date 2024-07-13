package com.interview.craftDemo.repository;

import java.util.Date;
import java.util.List;

public class Entity {
	
	private User user;	
	private Date createdDate;
	private int likes;
	private int disLikes;
	private List<User> usersLiked;
	private List<User> usersDisliked;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDisLikes() {
		return disLikes;
	}
	public void setDisLikes(int disLikes) {
		this.disLikes = disLikes;
	}
	public List<User> getUsersLiked() {
		return usersLiked;
	}
	public void setUsersLiked(List<User> usersLiked) {
		this.usersLiked = usersLiked;
	}
	public List<User> getUsersDisliked() {
		return usersDisliked;
	}
	public void setUsersDisliked(List<User> usersDisliked) {
		this.usersDisliked = usersDisliked;
	}
	
	
	
	

}
