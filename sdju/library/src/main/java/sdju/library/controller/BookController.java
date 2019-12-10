package sdju.library.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sdju.library.applicationLogic.BookManager;
import sdju.library.model.Author;
import sdju.library.model.Book;
import sdju.library.model.BookDescription;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    private BookManager bookManager;


    @Autowired
    public BookController(BookManager bookManager) throws SQLException{
        this.bookManager = bookManager;
    }

    @GetMapping("/booksPage")
    public String getBookCollectionForGuest(Model model){
        List<BookDescription> bookDescriptions = bookManager.getExistingBookDescriptions();
        model.addAttribute("bookDescriptions", bookDescriptions);
        return "booksPage";
    }

    @GetMapping("/bookInfo")
    public String bookInfoPage(@RequestParam("id") int descriptionId, Model model) {
        BookDescription bookDescription = bookManager.getBookDescription(descriptionId);
        model.addAttribute("bookDescription", bookDescription);
        return "bookInfo";
    }

    @GetMapping("/books")
    public String getAllBooks(Model model){
        List<Book> books = bookManager.getAllBooks();
        model.addAttribute("books", books);
        return "book/books";
    }

    @GetMapping("/add_book")
    public String addNewBook(){
        return "book/create/add_book";
    }

    @PostMapping("/add_book")
    public String addNewBook(@RequestParam("library_id") int library_id, HttpSession session,
                             Model model){
        Book book = bookManager.addNewBook(library_id);
        session.setAttribute("book", book);
        session.setAttribute("library_id",bookManager.addNewBook(library_id));
        //load list of existing descriptions here
        List<BookDescription> bookDescriptions;
        bookDescriptions = bookManager.getExistingBookDescriptions();
        model.addAttribute("bookDescriptions", bookDescriptions);
        return "book/create/choose_description";
    }

    @GetMapping("/choose_description")
    public String chooseDescription(@RequestParam("descriptionId") int bookDescriptionId,
                                    HttpSession session){
        session.setAttribute("description", bookManager.getBookDescription(bookDescriptionId));
        return "redirect:/confirm_new_book";
    }

    @GetMapping("/choose_authors")
    public String getListOfAuthors(Model model){
        //loading all existing authors
        List<Author> authors;
        authors = bookManager.getExistingAuthors();
        model.addAttribute("authors", authors);
        //new list added for authors from the user selection
        //BookDescription description = new BookDescription();
        //List<Author> chosenAuthors = new ArrayList<>();
        //description.setAuthors(chosenAuthors);
        //model.addAttribute("description", description);
        //model.addAttribute("chosenAuthors", chosenAuthors);
        return "book/create/choose_authors";
    }

    @PostMapping("/choose_authors")
    public String saveAuthorsFromCheckbox(HttpSession session,@RequestParam(value = "chosenAuthors") List<String> chosenAuthors){
        BookDescription description = (BookDescription)session.getAttribute("description");
        description.setAuthors(bookManager.getAuthorsFromIDs(chosenAuthors));
        //move to another step
        return "redirect:/confirm_new_book";
    }

    @GetMapping("/add_author")
    public String newAuthor(){
        return "book/create/add_author";
    }

    @PostMapping("/add_author")
    public String addNewAuthor(HttpSession session, @ModelAttribute Author author,
              @RequestParam(value = "authorName")String authorName){
        //add name so that new author can be added to the authors list
        session.setAttribute("author", bookManager.addNewAuthor(authorName));
        //then redirect to the page with updated list of authors
        return "redirect:/choose_authors";
    }

    @GetMapping("/add_description")
    public String addDescription(){
        return "book/create/add_description";
    }

    @PostMapping("/add_description")
    public String addNewDescription(HttpSession session,
            @RequestParam(value = "title") String title, @RequestParam(value = "category") int category,
            @RequestParam(value = "location") String location,
            @RequestParam(value = "image") String image,
            @RequestParam(value = "specs") String specs){
        session.setAttribute("description", bookManager.addDescriptionInfo(title, category,
                location, image, specs));
        return "redirect:/choose_authors";
    }

    @GetMapping("/save_bookDescription")
    public String saveBookDescription(@RequestParam("descriptionId") int bookDescriptionId, HttpSession session){
        session.setAttribute("description", bookManager.getBookDescription(bookDescriptionId));
        return "redirect:/confirm_new_book";
    }

    @GetMapping("/confirm_new_book")
    public String confirm(HttpSession session) {
        Book book = (Book)session.getAttribute("book");
        bookManager.saveNewBook(book, (BookDescription)session.getAttribute("description"));
        session.removeAttribute("book");
        session.removeAttribute("description");

        return "redirect:/books";
    }

    //currently not in use
    @GetMapping("/update_book")
    public String updateBook(Model model,
                             @RequestParam("book_id") int book_id){
        Book book = bookManager.getChosenBook(book_id);
        model.addAttribute("book", book);
        //possible scope of update up to customer's wishes
        return "book/update_book";
    }
    //save changes
    @PostMapping("/update_book")
    public String saveUpdateBook(@RequestParam("book_id") int book_id){
        Book book = bookManager.getChosenBook(book_id);
        bookManager.updateBook(book);

        return "redirect:/books";
    }


    @GetMapping("/delete_book")
    public String deleteBook(@RequestParam("book_id") int book_id, Model model) {
        model.addAttribute("book", bookManager.getChosenBook(book_id));
        return "book/delete_book";
    }

    @PostMapping("/delete_book")
    public String confirmDelete(@RequestParam("book_id") int book_id) {
        bookManager.deleteBook(book_id);
        return "redirect:/books";
    }

}
