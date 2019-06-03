package sdju.library.applicationLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdju.library.model.*;
import sdju.library.repositories.BookDbRepository;
import sdju.library.repositories.CustomerDbRepository;
import sdju.library.repositories.RentalRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Component
public class RentalManager {

    private CustomerDbRepository customerDbRepository;
    private RentalRepository rentalRepository;
    private BookDbRepository bookDbRepository;


    @Autowired
    public RentalManager(CustomerDbRepository customerRepository, RentalRepository rentalRepository,
                         BookDbRepository bookDbRepository) {

        this.customerDbRepository = customerRepository;
        this.rentalRepository = rentalRepository;
        this.bookDbRepository = bookDbRepository;
    }

    public List<Rental> getRentals() {
        try {
            List<Rental> rentals = rentalRepository.readAll();
            return rentals;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Rental startRental(LocalDate startDate) {
        Rental rental = new Rental();
        rental.setStartDate(startDate);
        return rental;
    }

    public List<Book> getAvailableBooks(Rental rental) {
        try {
            List<Integer> availableBookIds = bookDbRepository.readAllIDs();
            return bookDbRepository.readAll(availableBookIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveBook(Rental rental, int bookId) {
        try{
            Book book = bookDbRepository.read(bookId);
            book.setBookStatus(2);
        }catch (SQLException e){
            e.printStackTrace();
        }
        rental.setBookId(bookId);
        return true;
    }

    public boolean saveCustomer(Rental rental, int customerId){
        rental.setCustomerId(customerId);
        return true;
    }

    public List<Customer> getEligibleCustomers(Rental rental) {
        try {
            List<Integer> eligibleCustomersIds = customerDbRepository.readAllIDs();
            return customerDbRepository.readAll(eligibleCustomersIds);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean saveRental(Rental rental) {

        rental.setEndDate(LocalDate.parse("1900-01-02"));
        try{
            int rentalId = rentalRepository.create(rental);
            rental.setRentalId(rentalId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(!this.uploadRental(rental)) return false;
        return true;
    }

    private boolean saveCustomer(Rental rental, Customer customer) {
        try {
            Customer savedCustomer = customerDbRepository.read(customer.getPhoneNumber());
            if (savedCustomer == null) {
                customerDbRepository.create(customer);
                savedCustomer = customerDbRepository.read(customer.getPhoneNumber());
            }
            rental.setCustomerId(savedCustomer.getCustomerId());
            int rentalId = rentalRepository.create(rental);
            rental.setRentalId(rentalId);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean uploadRental(Rental rental) {
        try {
            rentalRepository.update(rental);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public double calculatePenalty (Rental rental) {
        double penalty = 0;
        int rentalLength = Period.between(rental.getStartDate(), rental.getEndDate()).getDays();
        if (rentalLength>14) {
           penalty = 0.5*rentalLength;
        }
        return penalty;

    }

    public boolean endRental(int rentalId) {
        Rental rental = this.getRental(rentalId);
        if (rental != null) {
            double penalty = this.calculatePenalty(rental);
            rental.setPenalty(penalty);
            rental.setEndDate(LocalDate.now());
            //change book status here?
            return this.uploadRental(rental);
        }
        return false;
    }

    public Rental getRental(int rentalId) {
        try {
            Rental rental = rentalRepository.read(rentalId);
            return rental;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Rental not found!");
            return null;
        }
    }

    public Customer getCustomer (int customerId) {
        try {
            return customerDbRepository.read(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBook (int bookId) {
        try {
            return bookDbRepository.read(bookId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteRental(int rentalId){
        try {
            Rental rental = this.getRental(rentalId);
            Book book = bookDbRepository.read(rental.getBookId());
            rentalRepository.nullifyBook(rental.getBookId());
            book.setBookStatus(1);
            rentalRepository.nullifyCustomer(rental.getCustomerId());
            rentalRepository.delete(rentalId);

        }catch (SQLException e){
            System.out.println("Error occurred! Rental not deleted");
            e.printStackTrace();
        }
    }

}
