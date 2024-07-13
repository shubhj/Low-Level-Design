package com.interview.craftDemo.service;

import java.util.ArrayList;
import java.util.List;

import com.interview.craftDemo.repository.Post;
import com.interview.craftDemo.repository.PostCommentRepo;
import com.interview.craftDemo.repository.User;

public class PostService {
	
	public void createPost(String post , User client) {
		Post p1 = new Post(post, client);
		PostCommentRepo.getIdPostMap().put(p1.getId(), p1);
	}

	
	public void likePost(int postId, User user) {
		Post post=PostCommentRepo.getIdPostMap().get(postId);

		if(PostCommentRepo.getUserDisLikedPostMap().containsKey(post.getId()) && PostCommentRepo.getUserDisLikedPostMap().get(post.getId()).contains(user)){
			post.setDisLikes(post.getDisLikes()-1);
			PostCommentRepo.getUserDisLikedPostMap().get(post.getId()).remove(user);	
		}
		
		if(!PostCommentRepo.getUserLikedPostMap().containsKey(post.getId()))
			PostCommentRepo.getUserLikedPostMap().put(post.getId(), new ArrayList<User>());
		
		if(!PostCommentRepo.getUserLikedPostMap().get(post.getId()).contains(user)) {
			post.setLikes(post.getLikes()+1);
			PostCommentRepo.getUserLikedPostMap().get(post.getId()).add(user);
			
			
			System.out.println(PostCommentRepo.getUserLikedPostMap().get(post.getId()).size());
			System.out.println("User : "+ user.getName()+"  liked post : "+post.getId());
			System.out.println("Now post : "+post.getId()+"  total likes are "+post.getLikes()+"   and dislikes are  "+post.getDisLikes());
		}else {
			System.out.println("User : "+ user.getName()+" already liked post : "+post.getId());
		}	
		
	}
	
	
	
	public void disLikePost(int postId, User user) {
		Post post=PostCommentRepo.getIdPostMap().get(postId);
		
		if(PostCommentRepo.getUserLikedPostMap().containsKey(post.getId()) && PostCommentRepo.getUserLikedPostMap().get(post.getId()).contains(user)){
			post.setLikes(post.getLikes()-1);
			PostCommentRepo.getUserLikedPostMap().get(post.getId()).remove(user);	
		}
		
		if(!PostCommentRepo.getUserDisLikedPostMap().containsKey(post.getId()))
			PostCommentRepo.getUserDisLikedPostMap().put(post.getId(), new ArrayList<User>());
		
		if(!PostCommentRepo.getUserDisLikedPostMap().get(post.getId()).contains(user)) {
			PostCommentRepo.getUserDisLikedPostMap().get(post.getId()).add(user);
			post.setDisLikes(post.getDisLikes()+1);
			
			System.out.println("User : "+ user.getName()+"  disliked post : "+post.getId());
			System.out.println("Now post : "+post.getId()+"  total likes are "+post.getLikes()+"   and dislikes are  "+post.getDisLikes());
		}else {
			System.out.println("User : "+ user.getName()+" already disliked post : "+post.getId());
		}
			
	}
	
	
	
	public List<Post> getPosts(int offset, int n){
		List<Post> posts = PostCommentRepo.getPosts();
		return PostCommentRepo.getPosts().subList(offset, offset + n <=posts.size() ? offset+n : posts.size() );
	}


	public List<User> getPostLikesUsers(int postId) {
		return PostCommentRepo.getUserLikedPostMap().get(postId);
	}


	public List<User> getPostDisLikesUsers(int postId) {
		return PostCommentRepo.getUserDisLikedPostMap().get(postId);
	}

}
