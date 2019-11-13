package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Book;
import sdju.library.model.Customer;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;

    public CustomerDbRepository(){
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        System.out.println("Customers: OK");
        this.connector = connector;
    }

    public ArrayList<Customer> readAll() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT * FROM customer");
        result = statement.executeQuery();
        while (result.next()){
            customers.add(new Customer(result.getInt("customer_id"), result.getString("name"),
                    result.getString("email"), result.getString("phone_number")));
        }
        statement = null;
        result = null;
        return customers;
    }

    public List<Customer> readAll(List<Integer> customersIDs) throws SQLException {

        ArrayList<Customer> customers = new ArrayList<>();
        for (int customersId: customersIDs) {
            customers.add(this.read(customersId));
        }
        return customers;
    }

    public List<Integer> readAllIDs() throws SQLException {
        List<Integer> customersIDs = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("select * from customer\n" +
                "where (select count(*) from rental " +
                "where customer.customer_id=rental.customer_id and !(rental.end_date='1900-01-01'))<5;");
        result = statement.executeQuery();
        while (result.next()){
            customersIDs.add(result.getInt("customer_id"));
        }
        return customersIDs;
    }

    public void create(Customer customer) throws SQLException {
        System.out.println(customer);
        statement = connector.getConnection().prepareStatement("INSERT INTO customer(name, email, phone_number) VALUES (?,?,?)");
        statement.setString(1, customer.getCustomerName());
        statement.setString(2, customer.getEmailAddress());
        statement.setString(3, customer.getPhoneNumber());
        statement.execute();
        statement = null;
    }

    public Customer read(String phoneNr) throws SQLException {
        statement = connector.getConnection().prepareStatement("SELECT * FROM customer WHERE phone_number = ?");
        statement.setString(1, phoneNr);
        result = statement.executeQuery();
        Customer customer = null;
        if (result.next()){
            customer = new Customer(result.getInt("customer_id"), result.getString("name"),
                    result.getString("email"), result.getString("phone_number"));
        }
        statement = null;
        result = null;
        return customer;
    }

    public Customer read(int customerId) throws SQLException {
        statement = connector.getConnection().prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
        statement.setInt(1, customerId);
        result = statement.executeQuery();
        Customer customer = null;
        if (result.next()){
            customer = new Customer(result.getInt("customer_id"), result.getString("name"),
                    result.getString("email"), result.getString("phone_number"));
        }
        statement = null;
        result = null;
        return customer;
    }

    public void update(Customer customer) throws SQLException {
        statement = connector.getConnection().prepareStatement("UPDATE customer SET name=?, email=?, phone_number=? WHERE customer_id=?");
        statement.setString(1, customer.getCustomerName());
        statement.setString(2, customer.getEmailAddress());
        statement.setString(3, customer.getPhoneNumber());
        statement.setInt(4, customer.getCustomerId());
        statement.execute();
        statement = null;
    }

    public void delete(int customerId) throws SQLException {
        statement = connector.getConnection().prepareStatement("DELETE FROM customer WHERE customer_id=?");
        statement.setInt(1, customerId);
        statement.execute();
        statement = null;
    }

}
