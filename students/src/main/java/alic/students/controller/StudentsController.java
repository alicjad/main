package alic.students.controller;

import alic.students.model.Student;
import alic.students.repositories.IStudentsRepository;
import alic.students.repositories.util.StudentsDbRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentsController {

    private StudentsDbRepository studentsDbRepository;

    public StudentsController() {

       this.studentsDbRepository = new StudentsDbRepository();
    }


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("stu", studentsDbRepository.readAll());
        return "index";
    }

    @GetMapping("/create")
    public String create() {

        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Student student) {
        studentsDbRepository.create(student);
        return "redirect:/";

    }

    @GetMapping("/details")
    public String details(@RequestParam("id") int id, Model model) {

        Student student = studentsDbRepository.read(id);
        model.addAttribute("student", student);
        System.out.println(student);
        return "details";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {

        Student student = studentsDbRepository.read(id);
        model.addAttribute("student", student);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Student student, BindingResult result) {

        if(result.hasErrors()){
            System.out.println(student);
        }
        studentsDbRepository.update(student);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model) {

        Student student = studentsDbRepository.read(id);
        model.addAttribute("student", student);

        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Student student) {

        studentsDbRepository.delete(student.getId());
        return "redirect:/";
    }

}