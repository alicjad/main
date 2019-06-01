package sdju.library.model;

public class Book {

    private int bookId;
    private int library_id;
    private BookDescription bookDescription;
    private BookStatus bookStatus;

    public Book(){

    }

    public Book(int bookId, int library_id, BookDescription bookDescription) {
        this.bookId = bookId;
        this.library_id = library_id;
        this.bookDescription = bookDescription;
        this.bookStatus = BookStatus.available;
    }

    public String getStatus(){
        return bookStatus.toString();
    }
    public void setBookStatus(int enamValue){
        this.bookStatus = BookStatus.valueOf(enamValue);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLibrary_id() {
        return library_id;
    }

    public void setLibrary_id(int library_id) {
        this.library_id = library_id;
    }

    public BookDescription getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(BookDescription bookDescription) {
        this.bookDescription = bookDescription;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", library_id=" + library_id +
                ", bookDescription=" + bookDescription +
                '}';
    }
}
