package com.interview.craftDemo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment extends Entity {
	
	private static int commentCount=1;
	
	
	private int id;
	private String comment;
	
	private transient List<Comment> childComments;
	private Comment parentComment;
	private int postId;
	
	
	public Comment(User user, String comment, int postId) {
		this.setUser(user);
		this.setLikes(0);
		this.setDisLikes(0);
		this.setCreatedDate((new Date()));
		
		this.id=commentCount++;
		this.comment = comment;
		this.postId=postId;
		this.childComments= new ArrayList<Comment>();
		this.parentComment=null;
		
		
	}
	public Comment(User user, String comment, int postId, Comment parentComment) {
		this.setUser(user);
		this.setLikes(0);
		this.setDisLikes(0);
		this.setCreatedDate((new Date()));
		
		this.id=commentCount++;
		this.comment = comment;
		this.postId=postId;
		this.childComments= new ArrayList<Comment>();		
		this.parentComment=parentComment;
		
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<Comment> getChildComments() {
		return childComments;
	}
	public void setChildComments(List<Comment> childComments) {
		this.childComments = childComments;
	}
	public int getPostId() {
		return postId;
	}
	
	public int getId() {
		return id;
	}

	public Comment getParentCommentId() {
		return parentComment;
	}
	public void setParentCommentId(Comment parentCommentId) {
		this.parentComment = parentCommentId;
	}
	
	
	public String toString() {
		
		return  "userName "+this.getUser().getName()+" added reply to Comment Id "+(parentComment!=null?parentComment.getId():0)+" The Comment is \" "+this.id+",  "+this.comment+"\"  , Now childComments size of parent comment "+
				(parentComment!=null?parentComment.getChildComments().size():0)+" post Id "+postId;
		
	}
	
	


}
