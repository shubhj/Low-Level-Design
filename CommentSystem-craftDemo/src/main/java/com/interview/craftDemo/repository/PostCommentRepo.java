package com.interview.craftDemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostCommentRepo {
	
	private static List<Post> posts;
	private static List<User> users;
	private static Map<Integer, Post> idPostMap;
	private static Map<Integer, Comment> idCommentMap;
	
	private static Map<Integer, List<User>> userLikedPostMap;
	private static Map<Integer, List<User>> userDisLikedPostMap;
	private static Map<Integer, List<User>> userLikedCommentMap;
	private static Map<Integer, List<User>> userDisLikedCommentMap;
	//private static Map<Integer, List<Integer>> userPostMap;
	
	private static PostCommentRepo repo = null;
	
	
	private PostCommentRepo(){
		posts = new ArrayList<Post>();
		users = new ArrayList<User>();
		idPostMap = new HashMap<Integer, Post>();
		idCommentMap = new HashMap<Integer, Comment>();
		userLikedPostMap = new HashMap<Integer, List<User>>();
		userDisLikedPostMap = new HashMap<Integer, List<User>>();
		userLikedCommentMap = new HashMap<Integer, List<User>>();
		userDisLikedCommentMap = new HashMap<Integer, List<User>>();	
		//userPostMap = new HashMap<Integer, List<Integer>>();
	}
	
	public static synchronized PostCommentRepo getInstance(){
        if (repo == null)
            repo = new PostCommentRepo();
        return repo;
    }

	public static List<Post> getPosts() {
		return posts;
	}

	public static void setPosts(List<Post> posts) {
		PostCommentRepo.posts = posts;
	}

	public static List<User> getUsers() {
		return users;
	}

	public static void setUsers(List<User> users) {
		PostCommentRepo.users = users;
	}

	public static Map<Integer, Post> getIdPostMap() {
		return idPostMap;
	}

	public static void setIdPostMap(Map<Integer, Post> idPostMap) {
		PostCommentRepo.idPostMap = idPostMap;
	}

	public static Map<Integer, Comment> getIdCommentMap() {
		return idCommentMap;
	}

	public static void setIdCommentMap(Map<Integer, Comment> idCommentMap) {
		PostCommentRepo.idCommentMap = idCommentMap;
	}

	public static Map<Integer, List<User>> getUserLikedPostMap() {
		return userLikedPostMap;
	}

	public static void setUserLikedPostMap(Map<Integer, List<User>> userLikedPostMap) {
		PostCommentRepo.userLikedPostMap = userLikedPostMap;
	}

	public static Map<Integer, List<User>> getUserDisLikedPostMap() {
		return userDisLikedPostMap;
	}

	public static void setUserDisLikedPostMap(Map<Integer, List<User>> userDisLikedPostMap) {
		PostCommentRepo.userDisLikedPostMap = userDisLikedPostMap;
	}

	public static Map<Integer, List<User>> getUserLikedCommentMap() {
		return userLikedCommentMap;
	}

	public static void setUserLikedCommentMap(Map<Integer, List<User>> userLikedCommentMap) {
		PostCommentRepo.userLikedCommentMap = userLikedCommentMap;
	}

	public static Map<Integer, List<User>> getUserDisLikedCommentMap() {
		return userDisLikedCommentMap;
	}

	public static void setUserDisLikedCommentMap(Map<Integer, List<User>> userDisLikedCommentMap) {
		PostCommentRepo.userDisLikedCommentMap = userDisLikedCommentMap;
	}

	
	
	
	
	
	
}
