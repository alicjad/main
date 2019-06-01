package sdju.library.applicationLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdju.library.model.Customer;
import sdju.library.repositories.CustomerDbRepository;
import sdju.library.repositories.RentalRepository;

import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerManager {

    private CustomerDbRepository customerDbRepository;
    private RentalRepository rentalRepository;

    @Autowired
    public CustomerManager (CustomerDbRepository customerDbRepository, RentalRepository rentalRepository) {
        this.customerDbRepository = customerDbRepository;
        this.rentalRepository = rentalRepository;
    }

    public List<Customer> getCustomers(){
        try {
            List<Customer> customers = customerDbRepository.readAll();
            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createCustomer( Customer customer){
        try {
            customerDbRepository.create(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomer(int customerId) {
        try {
            Customer customer = customerDbRepository.read(customerId);
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateCustomer(Customer customer){
        try {
            customerDbRepository.update(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId){
        try {
            rentalRepository.nullifyCustomer(customerId);
            customerDbRepository.delete(customerId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
