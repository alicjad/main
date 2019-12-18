package sdju.library.applicationLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdju.library.model.Author;
import sdju.library.model.Book;
import sdju.library.model.BookCategory;
import sdju.library.model.BookDescription;
import sdju.library.repositories.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class BookManager {

    private BookDbRepository bookDbRepository;
    private BookDescriptionDbRepository bookDescriptionDbRepository;
    private DescriptionAuthorRepository descriptionAuthorRepository;
    private AuthorDbRepository authorDbRepository;
    private RentalRepository rentalRepository;

    @Autowired
    public BookManager (BookDbRepository bookDbRepository, BookDescriptionDbRepository bookDescriptionDbRepository,
                        DescriptionAuthorRepository descriptionAuthorRepository, AuthorDbRepository authorDbRepository,
                        RentalRepository rentalRepository){
        this.bookDbRepository = bookDbRepository;
        this.bookDescriptionDbRepository = bookDescriptionDbRepository;
        this.descriptionAuthorRepository = descriptionAuthorRepository;
        this.authorDbRepository = authorDbRepository;
        this.rentalRepository = rentalRepository;
    }

    public List<Book> getAllBooks(){
        try{
            return bookDbRepository.readAll();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Error occurred while reading book list");
        }
        return null;
    }

    public Book getChosenBook(int bookId){
        try {
            return bookDbRepository.read(bookId);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Book not found!");
        }
        return null;
    }

    public BookDescription getBookDescription(int descriptionId) {
        try {
            return bookDescriptionDbRepository.read(descriptionId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book addNewBook(int libraryId){
        Book book = new Book();
        book.setLibrary_id(libraryId);
        return book;
    }


    public boolean saveBookDescription(Book book, BookDescription bookDescription){
        if (bookDescription.getDescriptionId() > 0){
            book.setBookDescription(bookDescription);
        }else {
            try {
                bookDescription.setDescriptionId(bookDescriptionDbRepository.create(bookDescription));
                book.setBookDescription(bookDescription);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public List<BookDescription> getExistingBookDescriptions (int categoryNumber){
        try{
            return bookDescriptionDbRepository.readAll(categoryNumber);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<BookDescription> getExistingBookDescriptions(){
        try{
            return bookDescriptionDbRepository.readAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public BookDescription addDescriptionInfo(String title, int category,
                                              String location, String image, String specs){
        BookDescription bookDescription = new BookDescription();
        bookDescription.setTitle(title);
        bookDescription.setCategory(BookCategory.valueOf(category));
        bookDescription.setLocation(location);
        bookDescription.setImage(image);
        bookDescription.setSpecs(specs);
        return bookDescription;
    }


    public boolean saveNewBook(Book book, BookDescription bookDescription){
        if (!this.saveBookDescription(book, bookDescription)) return false;
        try {
            bookDbRepository.create(book);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Author> getAuthorsFromIDs(List<String> authorsIDList){
        List<Author>chosenAuthors = new LinkedList<>();
        if (authorsIDList.size() != 0){
            try {
                for (int i = 0; i < authorsIDList.size(); i++) {
                    int id = parseInt(authorsIDList.get(i));
                    Author author = authorDbRepository.read(id);
                    chosenAuthors.add(author);
                }
            }catch (SQLException e){
                e.printStackTrace();
                return null;
            }
        }
        return chosenAuthors;
    }

    public void updateBook(Book book){
        try {
            bookDbRepository.update(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId){
        try {
            rentalRepository.nullifyBook(bookId);
            bookDbRepository.delete(bookId);

        }catch (SQLException e){
            System.out.println("Error occurred! Book not deleted");
            e.printStackTrace();
        }
    }

    public List<Author> getAuthorsForChosenDescription(int descriptionId){
        try{
            return descriptionAuthorRepository.readAll(descriptionId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Author> getExistingAuthors(){
        try{
            return authorDbRepository.readAll();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Author addNewAuthor(String authorName){
        Author author = new Author();
        author.setAuthorName(authorName);
        try{
            authorDbRepository.create(author);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.getExistingAuthors().add(author);
        return author;
    }

}
