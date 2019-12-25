package sdju.library.model;

public class Book {

    private int bookId;
    private int library_id;
    private BookDescription bookDescription;
    private BookStatus bookStatus;

    public Book(){

    }

    public Book(int bookId, int library_id, BookDescription bookDescription, BookStatus bookStatus) {
        this.bookId = bookId;
        this.library_id = library_id;
        this.bookDescription = bookDescription;
        this.bookStatus = bookStatus;
    }

    //this method is used in books.html, gets book status for UI
    public String getStatus(){
        return this.bookStatus.toString();
    }
    public void setBookStatus(int enumValue){
        this.bookStatus = BookStatus.valueOf(enumValue);
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
