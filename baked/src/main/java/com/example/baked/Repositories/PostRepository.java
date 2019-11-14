package com.example.baked.Repositories;

import com.example.baked.Model.Post;
import com.example.baked.Repositories.util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostRepository implements IPostsRepository {

    private PreparedStatement preparedStatement;
    private ResultSet result;

    @Override
    public Post read(int id) {
        try {
            Connection conn = DbConnection.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM posts where post_id=?");
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                return new Post(
                        result.getInt("post_id"),
                        result.getString("title"),
                        result.getString("text")
                );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    @Override
    public void update(Post post) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public ArrayList<Post> readAll() {
        ArrayList<Post> posts = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DbConnection.getConnection();
            preparedStatement = conn.prepareStatement("SELECT * FROM posts");
            result = preparedStatement.executeQuery();

            while(result.next()){

                posts.add(new Post(result.getInt("post_id"),
                        result.getString("title"),
                        this.format(result.getString("text"))
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

        return posts;
    }

    public String format(String before){
        String after = before.replaceAll("\\[important\\]", "<b>");
        after = after.replaceAll("\\[/important\\]", "</b>");
        return after;
    }
}
