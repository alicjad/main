package com.example.baked.Model;

public class Post {

    private int postId;
    private String postTitle;
    private String text;

    public Post(){

    }

    public Post(int postId, String postTitle, String text){
        this.postId = postId;
        this.postTitle = postTitle;
        this.text = text;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
