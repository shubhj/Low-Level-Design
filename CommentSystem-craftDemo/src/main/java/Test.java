import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assert;

import com.interview.carftDemo.controller.CommentController;
import com.interview.carftDemo.controller.PostController;
import com.interview.craftDemo.repository.Client;
import com.interview.craftDemo.repository.PostCommentRepo;
import com.interview.craftDemo.repository.User;

public class Test {

	@org.junit.Test
	public void test() {
//		fail("Not yet implemented");
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
		
		
		assertEquals(commentController.getComments(1,-1,0, 10).size(), 2);
		assertEquals(commentController.getComments(2, -1,0, 10).size(), 1);
		
		
		assertEquals(commentController.getComments(1,2,0, 10).size(), 0);
		assertEquals(commentController.getComments(1,4,0, 10).size(), 2);
		
		assertEquals(commentController.getComments(1,5,0, 2).size(), 2);// comment Id 5 has 3 replies, but the n=2, so should return 2 replies only
		assertEquals(commentController.getComments(1,5,2, 2).size(), 1);
		
		assertEquals(commentController.getCommentLikesUsers(1).size(), 3);
		assertEquals(commentController.getCommentDisLikesUsers(1).size(), 1);
		
		 		
		assertNull(commentController.getCommentLikesUsers(2));
		assertNull(commentController.getCommentDisLikesUsers(2));
		
		commentController.disLikeComment(2, 5);
		
		assertEquals(commentController.getCommentDisLikesUsers(2).size(), 1);
		
		
		
		
	}
	
	

}
