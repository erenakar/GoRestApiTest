package in.co.gorest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    private int id;
    private int postId;
    private String name;
    private String email;
    private String body;

    public Comment() {
    }

    @JsonCreator
    public Comment(@JsonProperty("id") int id, @JsonProperty("post_id") int postId, @JsonProperty("name") String name,
                   @JsonProperty("email") String email, @JsonProperty("body") String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public Comment setId(int id) {
        this.id = id;
        return this;
    }

    public int getPostId() {
        return postId;
    }

    public Comment setPostId(int postId) {
        this.postId = postId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Comment setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Comment setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Comment setBody(String body) {
        this.body = body;
        return this;
    }
}
