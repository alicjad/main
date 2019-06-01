package sdju.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sdju.library.applicationLogic.CustomerManager;
import sdju.library.model.Customer;

import java.sql.SQLException;
import java.util.List;

@Controller
public class CustomerController {

    private CustomerManager customerManager;

    @Autowired
    public CustomerController(CustomerManager customerManager) throws SQLException {
        this.customerManager = customerManager;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model){
        List<Customer> customers = customerManager.getCustomers();
        model.addAttribute("customers", customers);
        return "customer/customers";
    }

    @GetMapping ("/new_customer")
    public String newCustomer(){
        return "customer/add_customer";
    }

    @PostMapping("/new_customer")
    public String newCustomer(@ModelAttribute Customer customer){
        customerManager.createCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update_customer")
    public String updateCustomer(@RequestParam("customerId") int customerId, Model model){
        Customer customer = customerManager.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return"customer/update_customer";
    }

    @PostMapping("/update_customer")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerManager.updateCustomer(customer);
        return "redirect:/customers";

    }

    @GetMapping("/delete_customer")
    public String deleteCustomer(@RequestParam("customerId") int customerId, Model model){
        Customer customer = customerManager.getCustomer(customerId);
        model.addAttribute("customer", customer);
        return"customer/delete_customer";
    }

    @PostMapping("/delete_customer")
    public String deleteCustomer(@ModelAttribute Customer customer){
        customerManager.deleteCustomer(customer.getCustomerId());
        return"redirect:/customers";
    }

}
