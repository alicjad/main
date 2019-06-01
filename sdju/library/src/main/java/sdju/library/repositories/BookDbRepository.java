package sdju.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sdju.library.model.Book;
import sdju.library.model.BookStatus;
import sdju.library.util.DbConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDbRepository {

    private PreparedStatement statement;
    private ResultSet result;
    private DbConnector connector;
    private BookDescriptionDbRepository bookDescriptionDbRepository;

    public BookDbRepository(BookDescriptionDbRepository bookDescriptionDbRepository){
        this.bookDescriptionDbRepository = bookDescriptionDbRepository;
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        this.connector = connector;
    }

    public List<Book> readAll() throws SQLException {

        ArrayList<Book> books = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT * FROM book");
        result = statement.executeQuery();
        while (result.next()){
            books.add(new Book(
                    result.getInt("book_id"),
                    result.getInt("library_id"),
                    bookDescriptionDbRepository.read(result.getInt("description_id"))));
        }
        statement = null;
        result = null;
        return books;
    }

    /**
     * This method returns a list of books with indexes from given List object
     */
    public List<Book> readAll(List<Integer> bookIDs) throws SQLException {

        ArrayList<Book> books = new ArrayList<>();
        for (int booksId: bookIDs) {
            books.add(this.read(booksId));
        }
        return books;
    }

    public List<Integer> readAllIDs() throws SQLException {
        List<Integer> bookIDs = new ArrayList<>();
        statement = connector.getConnection().prepareStatement("SELECT book_id from book");
        result = statement.executeQuery();
        while (result.next()){
            bookIDs.add(result.getInt("book_id"));
        }
        return bookIDs;
    }

    /**
     * This method creates new row in the books table with: library_id, description_id
     */
    public void create(Book book) throws SQLException {
        statement = connector.getConnection().prepareStatement("INSERT INTO book(library_id, description_id) VALUES (?,?)");
        statement.setInt(1, book.getLibrary_id());
        statement.setInt(2, book.getBookDescription().getDescriptionId());
        statement.execute();
        statement = null;
    }

    public Book read(int bookId) throws SQLException {

        statement = connector.getConnection().prepareStatement("SELECT * FROM book WHERE book_id=?");
        statement.setInt(1, bookId);
        result = statement.executeQuery();
        Book book = null;

        if (result.next()){
            book = new Book(result.getInt("book_id"),
                    result.getInt("library_id"),
                    bookDescriptionDbRepository.read(result.getInt("description_id")));
        }
        statement = null;
        result = null;
        return book;
    }

    /**
     * This method updates: book_status and description_id
     */
    public void update(Book book) throws SQLException {

        statement = connector.getConnection().prepareStatement("UPDATE book SET description_id=? WHERE book_id=?");
        statement.setInt(1, book.getBookDescription().getDescriptionId());
        statement.setInt(2, book.getBookId());
        statement.execute();
        statement = null;
    }

    public void delete(int bookId) throws SQLException {

        statement = connector.getConnection().prepareStatement("DELETE FROM book WHERE book_id=?");
        statement.setInt(1, bookId);
        statement.execute();
        statement = null;
    }

}
