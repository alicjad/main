package sdju.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sdju.library.applicationLogic.LibraryManager;
import sdju.library.model.Library;

import java.sql.SQLException;
import java.util.List;

@Controller
public class LibraryController {

    private LibraryManager libraryManager;

    @Autowired
    public LibraryController(LibraryManager libraryManager) throws SQLException {
        this.libraryManager = libraryManager;
    }

    @GetMapping("/librariesGuest")
    public String getAllLibrariesForGuest(Model model){
        List<Library> libraries = libraryManager.getLibraries();
        model.addAttribute("libraries", libraries);
        return "librariesGuest";
    }

    @GetMapping("/libraries")
    public String getAllLibraries(Model model){
        List<Library> libraries = libraryManager.getLibraries();
        model.addAttribute("libraries", libraries);
        return "libraries";
    }
}
