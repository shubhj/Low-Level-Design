package com.interview.craftDemo.service;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interview.craftDemo.repository.Comment;
import com.interview.craftDemo.repository.Post;
import com.interview.craftDemo.repository.PostCommentRepo;
import com.interview.craftDemo.repository.User;


@Service
public class CommentService {
	
	
	//adding comment to post
	public void addComment(int postId, int userId, String commentText) {

		Post post=PostCommentRepo.getIdPostMap().get(postId);
		User user = PostCommentRepo.getUsers().get(userId-1);
		
		Comment comment = new Comment(user, commentText, postId);
		post.getComments().add(comment);
		PostCommentRepo.getIdCommentMap().put(comment.getId(), comment);
		
		System.out.println("POST ID : "+ post.getId() +" CHILD COMMENT "+post.getComments().get(post.getComments().size()-1).getId());
	}
	

	//adding comment to comment
	public void addComment(int postId, int userId, String commentText, int parentCommentId) {
		
		Comment parentComment=PostCommentRepo.getIdCommentMap().get(parentCommentId);
		Post post=PostCommentRepo.getIdPostMap().get(postId);
		User user = PostCommentRepo.getUsers().get(userId-1);
		
		Comment comment = new Comment(user, commentText, postId, parentComment);
		PostCommentRepo.getIdCommentMap().put(comment.getId(), comment);
		parentComment.getChildComments().add(comment);
		
		System.out.println("POST ID: "+ post.getId() +"  PARENT COMMENT "+parentComment.getComment()+" CHILD COMMENT "+parentComment.getChildComments().get(parentComment.getChildComments().size()-1).getId());

	}
	

	public void likeComment(int commentId, int userId) {
		
		User user = PostCommentRepo.getUsers().get(userId-1);
		Comment comment=PostCommentRepo.getIdCommentMap().get(commentId);
		
		if(PostCommentRepo.getUserDisLikedCommentMap().containsKey(comment.getId()) && PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).contains(user)){
			comment.setDisLikes(comment.getDisLikes()-1);
			PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).remove(user);	
		}

		
		if(!PostCommentRepo.getUserLikedCommentMap().containsKey(comment.getId()))
			PostCommentRepo.getUserLikedCommentMap().put(comment.getId(), new ArrayList<User>());
		
		if(!PostCommentRepo.getUserLikedCommentMap().get(comment.getId()).contains(user)) {
			
			PostCommentRepo.getUserLikedCommentMap().get(comment.getId()).add(user);
			comment.setLikes(comment.getLikes()+1);
			
			System.out.println(PostCommentRepo.getUserLikedCommentMap().get(comment.getId()).size());
			System.out.println("User : "+ user.getName()+"  liked Comment : "+comment.getId());
			System.out.println("Now Comment  : "+comment.getId()+"  total likes are "+comment.getLikes()+"   and dislikes are  "+comment.getDisLikes());

		}else {
			System.out.println("User : "+ user.getName()+" already liked comment : "+comment.getId());
		}
		
		
		
		

	}

	public void disLikeComment(int commentId, int userId) {
		User user = PostCommentRepo.getUsers().get(userId-1);
		Comment comment=PostCommentRepo.getIdCommentMap().get(commentId);

		if(PostCommentRepo.getUserLikedCommentMap().containsKey(comment.getId()) && PostCommentRepo.getUserLikedCommentMap().get(comment.getId()).contains(user)){
			comment.setLikes(comment.getLikes()-1);
			PostCommentRepo.getUserLikedCommentMap().get(comment.getId()).remove(user);	
		}

		
		
		if(!PostCommentRepo.getUserDisLikedCommentMap().containsKey(comment.getId()))
			PostCommentRepo.getUserDisLikedCommentMap().put(comment.getId(), new ArrayList<User>());
		
		if(!PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).contains(user)) {
			PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).add(user);
			comment.setDisLikes(comment.getDisLikes()+1);

			System.out.println(PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).size());
			System.out.println(Arrays.toString(PostCommentRepo.getUserDisLikedCommentMap().get(comment.getId()).toArray()));
			System.out.println("User : "+ user.getName()+"  disliked post : "+comment.getId());
			System.out.println("Now Comment : "+comment.getId()+"  total likes are "+comment.getLikes()+"   and dislikes are  "+comment.getDisLikes());

		}else {
			System.out.println("User : "+ user.getName()+" already disliked comment : "+comment.getId());
		}
		
	}

	public List<Comment> getComments(int postId, int commentId, int offset, int n) {
		List<Comment> comments ;
		
		if(commentId<0)
			comments = PostCommentRepo.getIdPostMap().get(postId).getComments();
		else
			comments = PostCommentRepo.getIdCommentMap().get(commentId).getChildComments();
		
			
		
		return comments.subList(offset, offset + n <=comments.size() ? offset+n : comments.size());
	}


	public List<User> getCommentLikesUsers(int commentId) {
		return PostCommentRepo.getUserLikedCommentMap().get(commentId);
	}


	public List<User> getCommentDisLikesUsers(int commentId) {
		return PostCommentRepo.getUserDisLikedCommentMap().get(commentId);
	}

}
