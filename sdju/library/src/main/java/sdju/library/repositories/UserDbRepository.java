package sdju.library.repositories;

import sdju.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;


    public UserDbRepository(){
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        System.out.println("USERS: OK");
        this.connector = connector;
    }

    /**
     * @param username username of User who is searched for
     * @return User instance with username and password or null if no user was found
     */
    public User read(String username) throws SQLException {
        statement = connector.getConnection().prepareStatement("SELECT user_id, password FROM user WHERE username=?;");
        statement.setString(1, username);
        result = statement.executeQuery();

        User savedUser = null;
        if (result.next()) {
            savedUser = new User(result.getInt("user_id"), username, result.getString("password"));
        }
        statement = null;
        result = null;
        return savedUser;
    }

    /**
     * @param user User object with username and password which should be saved in the database
     */
    public void create(User user) throws SQLException{

        statement = connector.getConnection().prepareStatement("INSERT INTO user(username, password) VALUE (?,?);");
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.execute();

        statement = null;
        result = null;
    }

}
