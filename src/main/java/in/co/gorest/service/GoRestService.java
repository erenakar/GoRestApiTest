package in.co.gorest.service;

import in.co.gorest.dto.GoRestDTO;
import in.co.gorest.model.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GoRestService {

    private static final String url = "https://gorest.co.in";

    public static Response createUserResponse(User user) {
        Response response = RestAssured.given()
                .when().headers("Authorization", "Bearer " + GoRestDTO.bearerToken,
                        "Content-Type", "application/json").body(user)
                .post(url + "/public-api/users");

        System.out.println("CreateUser response: " + response.getBody().asString());

        return response;
    }

    public static UserResponse createUser(User user) {
        return createUserResponse(user)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(UserResponse.class);
    }

    public static Response updateUserResponse(int id, User user) {
        Response response = RestAssured.given()
                .when().headers("Authorization", "Bearer " + GoRestDTO.bearerToken,
                        "Content-Type", "application/json").body(user)
                .patch(url + "/public-api/users/{id}", id);

        System.out.println("UpdateUser response: " + response.getBody().asString());

        return response;
    }

    public static UserResponse updateUser(int id, User user) {
        return updateUserResponse(id, user)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(UserResponse.class);
    }

    public static Response createPostResponse(int userId, Post post) {
        Response response = RestAssured.given()
                .when().headers("Authorization", "Bearer " + GoRestDTO.bearerToken,
                        "Content-Type", "application/json").body(post)
                .post(url + "/public-api/users/{id}/posts", userId);

        System.out.println("CreatePost response: " + response.getBody().asString());

        return response;
    }

    public static PostResponse createPost(int userId, Post post) {
        return createPostResponse(userId, post)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(PostResponse.class);
    }

    public static Response createCommentResponse(int postId, Comment comment) {
        Response response = RestAssured.given()
                .when().headers("Authorization", "Bearer " + GoRestDTO.bearerToken,
                        "Content-Type", "application/json").body(comment)
                .post(url + "/public-api/posts/{id}/comments", postId);

        System.out.println("CreateComment response: " + response.getBody().asString());

        return response;
    }

    public static CommentResponse createComment(int postId, Comment comment) {
        return createCommentResponse(postId, comment)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(CommentResponse.class);
    }

    public static Response deleteUserResponse(int id) {
        Response response = RestAssured.given()
                .when().headers("Authorization", "Bearer " + GoRestDTO.bearerToken,
                        "Content-Type", "application/json")
                .delete(url + "/public-api/users/{id}", id);

        System.out.println("DeleteUser response: " + response.getBody().asString());

        return response;
    }

    public static UserResponse deleteUser(int id) {
        return deleteUserResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(UserResponse.class);
    }

    public static Response getUserResponse(int id) {
        Response response = RestAssured.given()
                .when().header("Content-Type", "application/json")
                .get(url + "/public-api/users/{id}", id);

        System.out.println("GetUser response: " + response.getBody().asString());

        return response;
    }

    public static UserResponse getUser(int id) {
        return getUserResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(UserResponse.class);
    }

    public static Response getPostResponse(int id) {
        Response response = RestAssured.given()
                .when().header("Content-Type", "application/json")
                .get(url + "/public-api/posts/{id}", id);

        System.out.println("GetPost response: " + response.getBody().asString());

        return response;
    }

    public static PostResponse getPost(int id) {
        return getPostResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(PostResponse.class);
    }

    public static Response getCommentResponse(int id) {
        Response response = RestAssured.given()
                .when().header("Content-Type", "application/json")
                .get(url + "/public-api/comments/{id}", id);

        System.out.println("GetComment response: " + response.getBody().asString());

        return response;
    }

    public static CommentResponse getComment(int id) {
        return getCommentResponse(id)
                .then().log().ifValidationFails()
                .statusCode(200)
                .extract().as(CommentResponse.class);
    }
}
