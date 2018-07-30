package alic.students.controller;

import alic.students.model.Course;
import alic.students.repositories.util.CoursesDbRepository;
import alic.students.repositories.util.ICoursesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class CoursesController {

    private ICoursesRepository coursesRepository;

    public CoursesController(){
        coursesRepository = new CoursesDbRepository();
    }

    @GetMapping("/courses")
    public String index(Model model){

        model.addAttribute("cou", coursesRepository.readAll());
        return "courses/index";
    }

    @GetMapping("/courses/create")
    public String create(){

        return "courses/create";
    }

    @PostMapping("/courses/create")
    public String create(@ModelAttribute Course course){
        coursesRepository.create(course);

        return "redirect:/courses/index";
    }

    /*@GetMapping("/courses/details")public String details(@RequestParam("id") int id, Model model) {

        Course course = coursesRepository.read(id);
        model.addAttribute("cou", courses);
        System.out.println(course);
        return "courses/details";
    }
    */

}