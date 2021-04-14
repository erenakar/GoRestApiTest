package in.co.gorest;

import in.co.gorest.dto.GoRestDTO;
import in.co.gorest.model.*;
import in.co.gorest.service.GoRestService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class EndToEndTest extends BaseTest {

    @Test(priority = 1)
    public static void endToEndTest() {
        //Create user and verify
        User user = GoRestDTO.user();
        UserResponse expectedUserResponse = GoRestDTO.userResponse(user);
        UserResponse actualUserResponse = GoRestService.createUser(user);
        int userId = actualUserResponse.getData().getId();

        assertEquals(actualUserResponse.getCode(), 201);
        assertNotEquals(userId, 0);
        assertEquals(actualUserResponse.getData().getName(), expectedUserResponse.getData().getName());
        assertEquals(actualUserResponse.getData().getEmail(), expectedUserResponse.getData().getEmail());
        assertEquals(actualUserResponse.getData().getGender(), expectedUserResponse.getData().getGender());
        assertEquals(actualUserResponse.getData().getStatus(), expectedUserResponse.getData().getStatus());

        //Update user name and verify
        expectedUserResponse.getData().setName(GoRestDTO.updatedUser().getName());
        actualUserResponse = GoRestService.updateUser(userId, GoRestDTO.updatedUser());

        assertEquals(actualUserResponse.getCode(), 200);
        assertEquals(actualUserResponse.getData().getName(), expectedUserResponse.getData().getName());

        //Create user post and verify
        Post post = GoRestDTO.userPost(userId);
        PostResponse expectedPostResponse = GoRestDTO.userPostResponse(post);
        PostResponse actualPostResponse = GoRestService.createPost(userId, post);
        int postId = actualPostResponse.getData().getId();

        assertEquals(actualPostResponse.getCode(), 201);
        assertNotEquals(postId, 0);
        assertEquals(actualPostResponse.getData().getUserId(), userId);
        assertEquals(actualPostResponse.getData().getTitle(), expectedPostResponse.getData().getTitle());
        assertEquals(actualPostResponse.getData().getBody(), expectedPostResponse.getData().getBody());

        //Create post comment and verify
        Comment comment = GoRestDTO.userComment(postId);
        CommentResponse expectedCommentResponse = GoRestDTO.userCommentResponse(comment);
        CommentResponse actualCommentResponse = GoRestService.createComment(postId, comment);
        int commentId = actualCommentResponse.getData().getId();

        assertEquals(actualPostResponse.getCode(), 201);
        assertNotEquals(commentId, 0);
        assertEquals(actualCommentResponse.getData().getPostId(), postId);
        assertEquals(actualCommentResponse.getData().getName(), expectedCommentResponse.getData().getName());
        assertEquals(actualCommentResponse.getData().getEmail(), expectedCommentResponse.getData().getEmail());
        assertEquals(actualCommentResponse.getData().getBody(), expectedCommentResponse.getData().getBody());

        //Delete user and verify
        actualUserResponse = GoRestService.deleteUser(actualUserResponse.getData().getId());
        assertEquals(actualUserResponse.getCode(), 204);

        actualUserResponse = GoRestService.getUser(userId);
        assertEquals(actualUserResponse.getCode(), 404);
        actualPostResponse = GoRestService.getPost(postId);
        assertEquals(actualPostResponse.getCode(), 404);
        actualCommentResponse = GoRestService.getComment(postId);
        assertEquals(actualCommentResponse.getCode(), 404);
    }
}
