package com.example.baked.Controller;

import com.example.baked.Repositories.ItemRepository;
import com.example.baked.Repositories.PostRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;


@org.springframework.stereotype.Controller
public class Controller {

    private PostRepository postRepository;
    private ItemRepository itemRepository;

    public Controller(){
        postRepository = new PostRepository();
        itemRepository = new ItemRepository();
    }

    @GetMapping("/")
    public String homePage(){
        return "homePage";
    }

    @GetMapping("/aboutPage")
    public String aboutPage(){
        return "aboutPage";
    }

    @GetMapping("/cakes")
    public String cakesPage(Model model) throws SQLException{
        model.addAttribute("items", itemRepository.readAll());
        return "cakes";
    }

    @GetMapping("/contactPage")
    public String contactPage(){
        return "contactPage";
    }

    @GetMapping("/postsPage")
    public String postsPage(Model model) throws SQLException{
        model.addAttribute("posts", postRepository.readAll());
        return "postsPage";
    }
}
