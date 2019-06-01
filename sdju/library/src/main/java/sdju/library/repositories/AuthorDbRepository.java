package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Author;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;

    @Autowired
    public void setConnector(DbConnector connector) {
        //System.out.println("Authors: OK");
        this.connector = connector;
    }

    public AuthorDbRepository(){

    }

    public ArrayList<Author> readAll() throws SQLException {
        ArrayList<Author> authors = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT  * FROM author");
        result = statement.executeQuery();
        while (result.next()){
            authors.add(new Author(result.getInt("author_id"),
                                   result.getString("author_name")));
        }
        statement = null;
        result = null;
        return authors;
    }

    public ArrayList<Author> readAll(List<Integer> authorIds) throws SQLException {
        ArrayList<Author> authors = new ArrayList<>();

        for (int authorId: authorIds) {
            authors.add(read(authorId));
        }

        return authors;
    }

    public void create(Author author) throws SQLException {
        statement = connector.getConnection().prepareStatement("INSERT  INTO author(author_name) VALUES (?)");
        statement.setString(1, author.getAuthorName());
        statement.execute();
        statement = null;
    }

    public Author read(int authorId) throws SQLException {

        statement = connector.getConnection().prepareStatement("SELECT * FROM author WHERE author_id = ?");
        statement.setInt(1, authorId);
        result = statement.executeQuery();
        Author author = null;

        if (result.next()){
            author = new Author(result.getInt("author_id"), result.getString("author_name"));
        }
        statement = null;
        result = null;
        return author;
    }

    public void update(Author author) throws SQLException {

        statement = connector.getConnection().prepareStatement("UPDATE author SET author_name=? WHERE author_id=?");
        statement.setString(1, author.getAuthorName());
        statement.setInt(2, author.getAuthorId());
        statement.execute();
        statement = null;
    }

    public void delete(int authorId) throws SQLException {

        statement = connector.getConnection().prepareStatement("DELETE FROM author WHERE author_id=? ");
        statement.setInt(1, authorId);
        statement.execute();
        statement = null;
    }
}
