package com.interview.carftDemo.controller;

import java.util.List;

import com.interview.craftDemo.repository.Post;
import com.interview.craftDemo.repository.User;
import com.interview.craftDemo.service.PostService;

public class PostController {
	
		private static PostService postService = new PostService();
	
	//create post
		public void createPost(String post , User client) {
			postService.createPost(post, client);
		}
		
		public void likePost(int postId, User user) {
			postService.likePost(postId, user);
		}
		
		public void disLikePost(int postId, User user) {
			postService.disLikePost(postId, user);
		}
		
		public List<Post> getPosts(int offset, int n){
			return postService.getPosts(offset, n);
		}
		
		public List<User> getPostLikesUsers(int postId){
			return postService.getPostLikesUsers(postId);
			
		}
		public List<User> getPostDisLikesUsers(int postId){
			return postService.getPostDisLikesUsers(postId);
			
		}
		
		

}
