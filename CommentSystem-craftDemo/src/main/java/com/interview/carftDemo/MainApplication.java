package com.interview.carftDemo;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.interview.carftDemo.controller.CommentController;
import com.interview.carftDemo.controller.PostController;
import com.interview.craftDemo.repository.Client;
import com.interview.craftDemo.repository.Comment;
import com.interview.craftDemo.repository.PostCommentRepo;
import com.interview.craftDemo.repository.User;

@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
			
		SpringApplication.run(MainApplication.class, args);
		
		CommentController commentController = new CommentController();
		PostController postController = new PostController();
		PostCommentRepo repo = PostCommentRepo.getInstance();
		
		User client1 = new Client("client1", "client1@gmail.com");
		User client2 = new Client("client2", "client2@gmail.com");
		User client3 = new Client("client3", "client3@gmail.com");
		User client4 = new Client("client4", "client4@gmail.com");
		User client5 = new Client("client5", "client5@gmail.com");

		
		postController.createPost("Post 1" , client1);
		postController.createPost("Post 2" , client3);
				 
		//post, user, comment
		commentController.addComment(1, 1, "new Comment, post 1");//1
		commentController.addComment(1, 1, "new Comment, post 1");//2
		commentController.addComment(2, 1, "new Comment, post 2");//3
		
		//post, user, comment, parentComment
		commentController.addComment(1, 5, "second level comment, post 1",1);//4
		commentController.addComment(1, 3, "third level comment, post 1", 4);//5
		commentController.addComment(1, 2, "third level comment, post 1", 4);//6
		commentController.addComment(1, 5, "second level comment, post 1",1);//7
		commentController.addComment(1, 3, "fourth level comment, post 1", 5);//8
		commentController.addComment(1, 2, "fourth level comment, post 1", 5);//9
		commentController.addComment(1, 1, "fourth level comment, post 1", 5);//10
		
		//postid, user
		postController.likePost(1, client5);
		postController.likePost(1, client3);
		postController.likePost(1, client2);
		postController.disLikePost(1, client5);
		
		//commentId, user
		commentController.likeComment(1, 5);
		commentController.likeComment(1, 3);
		commentController.likeComment(1, 2);
		commentController.disLikeComment(1, 5);
		commentController.likeComment(1, 3);
		commentController.likeComment(1, 4);
		
		//get like dislike users 
		List<User> users  = commentController.getCommentLikesUsers(1);
		for(User user : users)
		System.out.println(user.getName());
		
		
		List<String> comments = commentController.getComments(1, -1, 0, 10);
		printComments(comments);
		List<String> nested_comments  = commentController.getComments(1, 5, 0, 10);
		printComments(nested_comments);			
		

	}

	private static void printComments(List<String> comments) {
		for(String comment : comments) {
			System.out.println(comment.toString());
		}
		
	}

}
