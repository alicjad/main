package alic.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRepository implements IPersonsRepository{

    ArrayList<Person> persons;

    private Connection conn;
    private PreparedStatement preparedStatement;

    //a list sort of like an ArrayList
    private ResultSet result;

    public UserRepository(){
        this.conn = DBConnection.getConnection();
        this.persons = new ArrayList<>();
    }

    @Override
    public boolean create(Person p) {
        boolean r = false;

        try {

            preparedStatement = conn.prepareStatement("INSERT INTO users(user_name, email, password) VALUES (?,?,?)");

            preparedStatement.setString(1, p.getUserName());
            preparedStatement.setString(2, p.getEmail());
            preparedStatement.setString(3, p.getPassword());

            r = preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return r;
    }

    @Override
    public ArrayList<Person> readAll(){

        try {

            preparedStatement = conn.prepareStatement("select * from users");
            result = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            while (result.next()){

                    persons.add(new Person(result.getInt("id"),
                            result.getString("user_name"),
                            result.getString("email"),
                            result.getString("password")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public Person read(int id) {
        return null;
    }

}
