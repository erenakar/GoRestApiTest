package in.co.gorest.dto;

import in.co.gorest.model.*;

public class GoRestDTO {

    public static final String bearerToken = "57381a570e65e42ba1f672a9e769680d4aa60d038e59fb237fc07c9ed8816b08";

    public static User user() {
        return new User()
                .setName("User Name")
                .setEmail("user.email@mailinator.com")
                .setGender("Male")
                .setStatus("Active");
    }

    public static User updatedUser() {
        return new User().setName("New User Name");
    }

    public static UserResponse userResponse(User user) {
        return new UserResponse()
                .setCode(200)
                .setData(user);
    }

    public static Post userPost() {
        return new Post()
                .setTitle("Post title")
                .setBody("Post body");
    }

    public static Post userPost(int userId) {
        return userPost().setUserId(userId);
    }

    public static PostResponse userPostResponse(Post post) {
        return new PostResponse()
                .setCode(201)
                .setData(post);
    }

    public static Comment userComment() {
        return new Comment()
                .setName("Comment Name")
                .setEmail("comment.email@mailinator.com")
                .setBody("Comment body");
    }

    public static Comment userComment(int postId) {
        return userComment().setPostId(postId);
    }

    public static CommentResponse userCommentResponse(Comment comment) {
        return new CommentResponse()
                .setCode(201)
                .setData(comment);
    }
}
