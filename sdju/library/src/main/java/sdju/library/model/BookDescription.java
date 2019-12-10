package sdju.library.model;

import java.util.List;

public class BookDescription {

    private int descriptionId;
    private String title;
    private BookCategory category;
    private String location;
    private String image;
    private String specs;
    private List<Author> authors;

    public BookDescription(int descriptionId, String title, BookCategory category,
                           String location, String image, String specs, List<Author>authors) {
        this.descriptionId = descriptionId;
        this.title = title;
        this.category = category;
        this.location = location;
        this.image = image;
        this.specs = specs;
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
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Author> getChosenAuthors() {
        return authors;
    }
    public void setChosenAuthors(List<Author> authors) {
        this.authors = authors;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    @Override
    public String toString() {
        return "BookDescription{" +
                "descriptionId=" + descriptionId +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", location='" + location + '\'' +
                ", image='" + image + '\'' +
                ", specs='" + specs + '\'' +
                ", authors=" + authors +
                '}';
    }
}
