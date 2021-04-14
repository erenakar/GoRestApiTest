package in.co.gorest.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    private int id;
    private int userId;
    private String title;
    private String body;

    public Post() {
    }

    @JsonCreator
    public Post(@JsonProperty("id") int id, @JsonProperty("user_id") int userId,
                @JsonProperty("title") String title, @JsonProperty("body") String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public Post setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public Post setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBody() {
        return body;
    }

    public Post setBody(String body) {
        this.body = body;
        return this;
    }
}
