package sdju.library.model;

import java.util.List;

public class BookDescription {

    private int descriptionId;
    private String title;
    private BookCategory category;
    private List<Author> authors;

    public BookDescription(int descriptionId, String title, BookCategory category, List<Author>authors) {
        this.descriptionId = descriptionId;
        this.title = title;
        this.category = category;
        this.authors = authors;
    }

    public BookDescription(){

    }

    //this method is used by thymeleaf in html
    public String getAuthorsAsOneString() {
        if(getAuthors().size() != 0){
            String authors = getAuthors().get(0).getAuthorName();
            for (int i=1; i<getAuthors().size(); i++) {
                authors = authors + ", " + getAuthors().get(i).getAuthorName();
            }
            return authors;
        }else {
            return "";
        }
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(int descriptionId) {
        this.descriptionId = descriptionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "BookDescription{" +
                "descriptionId=" + descriptionId +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", authors=" + authors +
                '}';
    }
}
