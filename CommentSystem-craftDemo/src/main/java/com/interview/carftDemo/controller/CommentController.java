package com.interview.carftDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.interview.craftDemo.repository.Comment;
import com.interview.craftDemo.repository.User;
import com.interview.craftDemo.service.CommentService;

@RestController
@RequestMapping("/v1/comment")
public class CommentController {
	
	private static CommentService commentService = new CommentService();
		
	// adding comment to post
	@RequestMapping("/addCommetToPost")
	public void addComment(int postId, int clientId, String comment) {
		commentService.addComment(postId, clientId, comment);
	}
	
	//adding comment to comment
	@RequestMapping("/addCommentToComment")
	public void addComment(int postId, int clientId, String comment, int parentCommentId) {
		commentService.addComment(postId, clientId, comment, parentCommentId);
	}
	
	@PostMapping("/likeComment")
	public void likeComment( int commentId,  int userId) {
		commentService.likeComment(commentId, userId);
	}
	
	@RequestMapping("/disLikeComment")
	public void disLikeComment(int commentId, int userId) {
		commentService.disLikeComment(commentId, userId);
	}
		
	@GetMapping(value="/getComments", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> getComments(int postId, int commentId, int offset, int n){
		List<Comment> comments = commentService.getComments(postId, commentId, offset, n);
		List<String> ans = new ArrayList<>();
		for(Comment c : comments)
			ans.add(c.toString());
		return 	ans;
	}
	
	@RequestMapping("/getCommentLikesUsers")
	public @ResponseBody List<User> getCommentLikesUsers(int commentId){
		return commentService.getCommentLikesUsers(commentId);
		
	}
	
	@RequestMapping("/getCommentDisLikesUsers")
	public List<User> getCommentDisLikesUsers(int commentId){
		return commentService.getCommentDisLikesUsers(commentId);
		
	}
	

}
