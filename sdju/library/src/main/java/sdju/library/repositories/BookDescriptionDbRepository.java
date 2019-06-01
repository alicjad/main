package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Author;
import sdju.library.model.BookCategory;
import sdju.library.model.BookDescription;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Repository
public class BookDescriptionDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;
    private DescriptionAuthorRepository descriptionAuthorRepository;

    @Autowired
    public void setConnector(DbConnector connector) {
        this.connector = connector;
    }

    @Autowired
    public BookDescriptionDbRepository(DescriptionAuthorRepository descriptionAuthorRepository){
        this.descriptionAuthorRepository = descriptionAuthorRepository;
    }

    public List<BookDescription> readAll() throws SQLException {
        List<BookDescription> bookDescriptions = new ArrayList<>();

        statement = connector.getConnection().prepareStatement("SELECT * FROM description");
        result = statement.executeQuery();

        while (result.next()){
            bookDescriptions.add(new BookDescription(result.getInt("description_id"),
                    result.getString("title"), (BookCategory.valueOf( result.getInt("category"))),
                    descriptionAuthorRepository.readAll(result.getInt("description_id"))));
        }
        statement = null;
        result = null;
        return bookDescriptions;
    }

    /**
     * @param bookDescription BookDescription object with all data
     * @return ID of the created row (description)
     */
    public int create(BookDescription bookDescription) throws SQLException {

        System.out.println(bookDescription);
        statement = connector.getConnection().prepareStatement("INSERT INTO description(title, category) VALUES (?,?)");
        statement.setString(1, bookDescription.getTitle());
        statement.setInt(2, bookDescription.getCategory().getValue());
        statement.execute();
        statement = connector.getConnection().prepareStatement("SELECT description_id FROM description WHERE title=? AND category=?;");
        statement.setString(1, bookDescription.getTitle());
        statement.setInt(2, bookDescription.getCategory().getValue());
        result = statement.executeQuery();
        int id = -1;
        if (result.next()) {
            id = result.getInt("description_id");
        }
        statement = null;
        result = null;
        return id;
    }

    public BookDescription read(int bookDescriptionId) throws SQLException {

        statement = connector.getConnection().prepareStatement("SELECT * FROM description WHERE description_id = ?");
        statement.setInt(1, bookDescriptionId);
        result = statement.executeQuery();
        BookDescription bookDescription = null;
        List<Author> authorList = descriptionAuthorRepository.readAll(bookDescriptionId);

        if (result.next()){
            bookDescription = new BookDescription(result.getInt("description_id"),
                    result.getString("title"), BookCategory.valueOf(result.getInt("category")), authorList);
        }
        statement = null;
        result = null;
        return bookDescription;
    }

    public void update(BookDescription bookDescription) throws SQLException {

        statement = connector.getConnection().prepareStatement("UPDATE description SET title=?,category=? WHERE description_id = ?");
        statement.setString(1, bookDescription.getTitle());
        statement.setInt(2, bookDescription.getCategory().getValue());
        statement.setInt(3, bookDescription.getDescriptionId());
        statement.execute();
        statement = null;
    }

    public void delete(int bookDescriptionId) throws SQLException {

        statement = connector.getConnection().prepareStatement("DELETE FROM description WHERE description_id=?");
        statement.setInt(1, bookDescriptionId);
        statement.execute();
        statement = null;
    }
}
