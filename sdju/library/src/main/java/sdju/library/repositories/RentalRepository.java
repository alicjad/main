package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Rental;
import sdju.library.model.RentalPaymentStatus;
import sdju.library.util.DbConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRepository {

    private PreparedStatement statement;
    private ResultSet resultSet;
    private DbConnector connector;


    public RentalRepository() throws SQLException {
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        //System.out.println("Rentals: OK");
        this.connector = connector;
    }

    public void getAvailableBookIds(LocalDate startDate, LocalDate endDate, List<Integer> allBookIds) throws SQLException {

        statement = connector.getConnection().prepareStatement("SELECT book_id from rental " +
                "where end_date != '1900-01-01'" +
                "AND (end_date > ? OR end_date = ?)");
        statement.setDate(1, Date.valueOf(endDate));
        statement.setDate(2, Date.valueOf(startDate));
        statement.setDate(3, Date.valueOf(endDate));
        statement.setDate(4, Date.valueOf(endDate));
        resultSet = statement.executeQuery();

        while (resultSet.next()){
            allBookIds.remove((Integer) resultSet.getInt("book_id"));
        }
        statement = null;
        resultSet = null;

    }

    /**
     * This method creates new row in the database with: start_date, end_date, book_id and customer_id
     * @return ID of created rental or -1 if there was an error
     */
    public int create (Rental rental) throws SQLException {
        statement = connector.getConnection().prepareStatement("INSERT INTO rental (customer_id, start_date, book_id) VALUES (?,?,?)");
        statement.setInt(1, rental.getCustomerId());
        statement.setDate(2, Date.valueOf(rental.getStartDate()));
        statement.setInt(3, rental.getBookId());
        statement.execute();
        statement = connector.getConnection().prepareStatement("SELECT rental_id FROM rental WHERE start_date = ? AND book_id = ?");
        statement.setDate(1, Date.valueOf(rental.getStartDate()));
        statement.setInt(2, rental.getBookId());
        resultSet = statement.executeQuery();
        int rentalId = -1;
        if (resultSet.next()) {
            rentalId = resultSet.getInt("rental_id");
        }
        statement = null;
        resultSet = null;
        return rentalId;
    }

    /**
     * This method update: end_date and payment status of the rental
     */
    public void update (Rental rental) throws SQLException {
        statement = connector.getConnection().prepareStatement("UPDATE rental SET end_date=?, payment_status=? WHERE rental_id=?;");
        statement.setDate(1, Date.valueOf(rental.getEndDate()));
        statement.setInt(2, rental.getPaymentStatus().getValue());
        statement.setInt(3, rental.getRentalId());
        statement.execute();
        statement = null;
    }

    public List<Rental> readAll() throws SQLException {
        List<Rental> rentals = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT * FROM rental");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Rental rental = new Rental();
            rental.setRentalId(resultSet.getInt("rental_id"));
            rental.setStartDate(resultSet.getDate("start_date").toLocalDate());
            rental.setEndDate(resultSet.getDate("end_date").toLocalDate());
            rental.setPaymentStatus(RentalPaymentStatus.valueOf(resultSet.getInt("payment_status")));
            rental.setBookId(resultSet.getInt("book_id"));
            rental.setCustomerId(resultSet.getInt("customer_id"));
            rentals.add(rental);
        }
        return rentals;
    }

    public Rental read(int rentalId) throws SQLException {
        statement = connector.getConnection().prepareStatement("SELECT * FROM rental WHERE rental_id=?");
        statement.setInt(1, rentalId);
        resultSet = statement.executeQuery();
        Rental rental = null;
        if (resultSet.next()) {
            rental = new Rental();
            rental.setRentalId(resultSet.getInt("rental_id"));
            rental.setStartDate(resultSet.getDate("start_date").toLocalDate());
            rental.setEndDate(resultSet.getDate("end_date").toLocalDate());
            rental.setPaymentStatus(RentalPaymentStatus.valueOf(resultSet.getInt("payment_status")));
            rental.setBookId(resultSet.getInt("book_id"));
            rental.setCustomerId(resultSet.getInt("customer_id"));
        }
        return rental;
    }

    public void delete (int rentalId) throws SQLException {
        statement = connector.getConnection().prepareStatement("DELETE FROM rental WHERE rental_id=?");
        statement.setInt(1, rentalId);
        statement.execute();
        statement = null;
    }

    /**
     * This method sets all references to the given book ID to null
     * @param bookId ID of book that should be nullified
     */
    public void nullifyBook(int bookId) throws SQLException {
        statement = connector.getConnection().prepareStatement("UPDATE rental SET book_id=null where book_id=?");
        statement.setInt(1, bookId);
        statement.execute();
        statement = null;

    }

    /**
     * This method sets all references to the given customer ID to null
     * @param customerId ID of customer that should be nullified
     */
    public void nullifyCustomer(int customerId) throws SQLException {
        statement = connector.getConnection().prepareStatement("UPDATE rental SET customer_id=null where customer_id=?");
        statement.setInt(1, customerId);
        statement.execute();
        statement = null;

    }

}
