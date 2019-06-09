package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Library;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class LibraryDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;

    public LibraryDbRepository(){
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        System.out.println("Libraries: OK");
        this.connector = connector;
    }

    public ArrayList<Library> readAll() throws SQLException {
        ArrayList<Library> libraries = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT * FROM library");
        result = statement.executeQuery();
        while (result.next()){
            libraries.add(new Library(result.getInt("library_id"), result.getString("address")));
        }
        statement = null;
        result = null;
        return libraries;
    }

}
