package com.example.baked.Controller;

import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/aboutPage")
    public String aboutPage(){
        return "aboutPage";
    }

    @GetMapping("/cakes")
    public String cakesPage(){
        return "cakes";
    }

    @GetMapping("/contactPage")
    public String contactPage(){
        return "contactPage";
    }
}
