package com.example.baked.Repositories;

import com.example.baked.Model.Item;
import com.example.baked.Model.Post;

import java.util.ArrayList;

public interface IPostsRepository {

    Post read(int id);
    void update(Post post);
    void delete(int id);
    ArrayList<Post> readAll();
}
