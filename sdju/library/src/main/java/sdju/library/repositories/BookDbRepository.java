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

    private DbConnector connector;
    private BookDescriptionDbRepository bookDescriptionDbRepository;

    public BookDbRepository(BookDescriptionDbRepository bookDescriptionDbRepository){
        this.bookDescriptionDbRepository = bookDescriptionDbRepository;
    }

    @Autowired
    public void setConnector(DbConnector connector) {
        System.out.println("BOOKS: OK");
        this.connector = connector;
    }

    public List<Book> readAll() throws SQLException {

        ArrayList<Book> books = new ArrayList<>();
        PreparedStatement statement = connector.getConnection().prepareStatement("SELECT book_id FROM book");
        ResultSet result = statement.executeQuery();
        while (result.next()){
            books.add(this.read(result.getInt("book_id")));
        }
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

    public List<Integer> readAllAvailableBookIDs() throws SQLException {
        List<Integer> bookIDs = new ArrayList<>();
        PreparedStatement statement = connector.getConnection().prepareStatement("select * from book\n" +
                "where not exists(select 1 from rental where book.book_id=rental.book_id and rental.end_date = '1900-01-01');");
        ResultSet result = statement.executeQuery();
        while (result.next()){
            bookIDs.add(result.getInt("book_id"));
        }
        return bookIDs;
    }

    /**
     * This method creates new row in the books table with: library_id, description_id
     */
    public void create(Book book) throws SQLException {
        PreparedStatement statement = connector.getConnection().prepareStatement("INSERT INTO book(library_id, description_id) VALUES (?,?)");
        statement.setInt(1, book.getLibrary_id());
        statement.setInt(2, book.getBookDescription().getDescriptionId());
        statement.execute();
        statement = null;
    }

    public Book read(int bookId) throws SQLException {

        PreparedStatement statement = connector.getConnection().prepareStatement("SELECT *, IF( (select 1 from rental " +
                "where rental.book_id = book.book_id and  end_date = '1900-01-01') is NULL, 'available', 'rented')" +
                " as status FROM book WHERE book_id=?");
        statement.setInt(1, bookId);
        ResultSet result = statement.executeQuery();
        Book book = null;

        if (result.next()){
            String status = result.getString("status");
            book = new Book(result.getInt("book_id"),
                    result.getInt("library_id"),
                    bookDescriptionDbRepository.read(result.getInt("description_id")),
                    status.equals("rented")? BookStatus.borrowed: BookStatus.available
                    );
        }
        return book;
    }

    /**
     * This method updates: book_status and description_id
     */
    public void update(Book book) throws SQLException {

        PreparedStatement statement = connector.getConnection().prepareStatement("UPDATE book SET description_id=? WHERE book_id=?");
        statement.setInt(1, book.getBookDescription().getDescriptionId());
        statement.setInt(2, book.getBookId());
        statement.execute();
    }

    public void delete(int bookId) throws SQLException {

        PreparedStatement statement = connector.getConnection().prepareStatement("DELETE FROM book WHERE book_id=?");
        statement.setInt(1, bookId);
        statement.execute();
    }

}
