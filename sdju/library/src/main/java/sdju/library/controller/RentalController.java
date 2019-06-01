package sdju.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sdju.library.applicationLogic.RentalManager;
import sdju.library.model.Rental;

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
    public String endRental(Model model, @RequestParam("rentalId") int rentalId){
        model.addAttribute("rental_id", rentalId);
        return "rental/end_rental";
    }

    @PostMapping("/end_rental")
    public String confirmEndRental(@RequestParam("rentalId") int rentalId){
        rentalManager.endRental(rentalId);
        return "redirect:/rentals";
    }

    @GetMapping("/delete_rental")
    public String deleteRental(@RequestParam("rental_id") int rental_id, Model model) {
        model.addAttribute("rental_id", rentalManager.getRental(rental_id));
        return "rental/delete_rental";
    }

    @PostMapping("/delete_rental")
    public String confirmDelete(@RequestParam("rental_id") int rental_id) {
        rentalManager.deleteRental(rental_id);
        return "redirect:/rentals";
    }


}
