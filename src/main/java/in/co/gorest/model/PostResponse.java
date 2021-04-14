package in.co.gorest.model;

public class PostResponse {
    private int code;
    private String meta;
    private Post data;

    public int getCode() {
        return code;
    }

    public PostResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMeta() {
        return meta;
    }

    public PostResponse setMeta(String meta) {
        this.meta = meta;
        return this;
    }

    public Post getData() {
        return data;
    }

    public PostResponse setData(Post data) {
        this.data = data;
        return this;
    }
}
