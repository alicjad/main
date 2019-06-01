package sdju.library.repositories.arrays;

import sdju.library.model.Book;

import java.util.ArrayList;

public class BookArrayRepository implements ICrudRepository<Book>{


    public ArrayList<Book> books = new ArrayList<Book>();

    public BookArrayRepository(){
        //add books here
    }

    @Override
    public ArrayList<Book> readAll() throws Exception {
        return books;
    }

    @Override
    public boolean create(Book book) throws Exception {
        books.add(book);
        book.setBookId(books.size());

        return true;
    }

    @Override
    public Book read(int id) throws Exception {
        return books.get(id - 1);
    }

    @Override
    public void update(Book book) throws Exception {
        for (Book b : books){
            if(b.getBookId() == book.getBookId()){
                books.remove(b);
                books.add(book);
            }
        }
    }

    @Override
    public void delete(int id) throws Exception {
        for(Book b : books){
            if(b.getBookId() == id){
                books.remove(id-1);
            }
        }
    }
}
