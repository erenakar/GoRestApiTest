package in.co.gorest.model;

public class UserResponse {
    private int code;
    private String meta;
    private User data;

    public int getCode() {
        return code;
    }

    public UserResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMeta() {
        return meta;
    }

    public UserResponse setMeta(String meta) {
        this.meta = meta;
        return this;
    }

    public User getData() {
        return data;
    }

    public UserResponse setData(User user) {
        this.data = user;
        return this;
    }
}
