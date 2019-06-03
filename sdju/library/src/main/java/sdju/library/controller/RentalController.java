package sdju.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sdju.library.applicationLogic.RentalManager;
import sdju.library.model.Book;
import sdju.library.model.Customer;
import sdju.library.model.Rental;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class RentalController {

    private RentalManager rentalManager;

    @Autowired
    public RentalController(RentalManager rentalManager){
        this.rentalManager = rentalManager;
    }

    @GetMapping("/rentals")
    public String getRentals(Model model) {
        List<Rental> rentals = rentalManager.getRentals();
        model.addAttribute("rentals", rentals);
        return "rental/rentals";
    }

    @GetMapping("/end_rental")
    public String endRental(@RequestParam("rentalId") int rentalId, Model model){
        Rental rental = rentalManager.getRental(rentalId);
        model.addAttribute("rental", rental);
        return "rental/end_rental";
    }

    @PostMapping("/end_rental")
    public String confirmEndRental(@ModelAttribute Rental rental){
        rentalManager.endRental(rental.getRentalId());
        return "redirect:/rentals";
    }

    @GetMapping("/delete_rental")
    public String deleteRental(@RequestParam("rentalId") int rentalId, Model model) {
        Rental rental = rentalManager.getRental(rentalId);
        model.addAttribute("rental", rental);
        return "rental/delete_rental";
    }

    @PostMapping("/delete_rental")
    public String deleteRental(@ModelAttribute Rental rental) {
        rentalManager.deleteRental(rental.getRentalId());
        return "redirect:/rentals";
    }

    @GetMapping("/choose_book")
    public String chooseBook(HttpSession session, Model model){
        Rental rental = rentalManager.startRental(LocalDate.now());
        session.setAttribute("rental", rental);
        List<Book> availableBooks;
        availableBooks = rentalManager.getAvailableBooks(rental);
        model.addAttribute("books", availableBooks);
        return "rental/create/choose_book";
    }

    @GetMapping("/save_chosenBook")
    public String saveChosenBook(@RequestParam("bookId") int bookId,
                             HttpSession session, Model model){
        Rental rental = (Rental)session.getAttribute("rental");
        rentalManager.saveBook(rental, bookId);
        List<Customer> eligibleCustomers;
        eligibleCustomers = rentalManager.getEligibleCustomers(rental);
        model.addAttribute("customers", eligibleCustomers);
        return "rental/create/choose_customer";
    }

    @GetMapping("/save_customer")
    public String saveCustomer(@RequestParam("customerId")int customerId,
                               HttpSession session){
        Rental rental = (Rental)session.getAttribute("rental");
        rentalManager.saveCustomer(rental, customerId);
        rentalManager.saveRental(rental);
        return "redirect:/rentals";
    }

}
