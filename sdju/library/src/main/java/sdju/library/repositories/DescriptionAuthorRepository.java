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
public class DescriptionAuthorRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;

    public DescriptionAuthorRepository(){

    }

    @Autowired
    public void setConnector(DbConnector connector) {
        System.out.println("Description_Author: OK");
        this.connector = connector;
    }

    /**
     * This method retrieves all authors for a given description
     * @param descriptionId ID of description for which authors should be returned
     * @return List of authors that are assigned for chosen description
     * @throws SQLException if there was an error while getting the data
     */
    public List<Author> readAll (int descriptionId) throws SQLException {
        statement = connector.getConnection().prepareStatement("SELECT * FROM author \n" +
                "WHERE EXISTS (SELECT 1 FROM description_author WHERE description_id=? AND author.author_id=description_author.author_id);");
        statement.setInt(1, descriptionId);
        result = statement.executeQuery();
        List<Author> authorsForDescriptionId = new ArrayList<>();
        while (result.next()) {
            authorsForDescriptionId.add(new Author(result.getInt("author_id"), result.getString("author_name")));
        }
        statement = null;
        result = null;
        return authorsForDescriptionId;
    }


    public void create (int descriptionId, int authorId) throws SQLException {
        statement = connector.getConnection().prepareStatement("INSERT INTO description_author (description_id, author_id) VALUES (?,?);");
        statement.setInt(1, descriptionId);
        statement.setInt(2, authorId);
        statement.execute();
    }

    public void delete (int descriptionId, int authorId) throws SQLException {
        statement = connector.getConnection().prepareStatement("DELETE FROM description_author WHERE description_id = ? AND author_id=?;");
        statement.setInt(1, descriptionId);
        statement.setInt(2, authorId);
        statement.execute();
    }

}
