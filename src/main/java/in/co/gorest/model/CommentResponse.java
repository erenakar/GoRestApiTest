package in.co.gorest.model;

public class CommentResponse {
    private int code;
    private String meta;
    private Comment data;

    public int getCode() {
        return code;
    }

    public CommentResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMeta() {
        return meta;
    }

    public CommentResponse setMeta(String meta) {
        this.meta = meta;
        return this;
    }

    public Comment getData() {
        return data;
    }

    public CommentResponse setData(Comment data) {
        this.data = data;
        return this;
    }
}
