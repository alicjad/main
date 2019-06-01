package sdju.library.model;

import java.util.Map;

public class Library {

    private int libraryId;
    private String libraryAddress;
    //librarian id and name
    private Map <Integer, String> librarian;


    public Library(int libraryId, String libraryAddress) {
        this.libraryId = libraryId;
        this.libraryAddress = libraryAddress;
    }

    public Map<Integer, String> getLibrarians() {
        return librarian;
    }

    public void setLibrarian(Map<Integer, String> librarians) {
        this.librarian = librarian;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public String getLibraryAddress() {
        return libraryAddress;
    }

    public void setLibraryAddress(String libraryAddress) {
        this.libraryAddress = libraryAddress;
    }

    public String getLibraryAddressByItsId(int libraryId){
        this.setLibraryAddress("Jagiellońska 20a, Szczecin, Poland");
        return this.libraryAddress;
    }

    @Override
    public String toString() {
        return "Library{" +
                "libraryId=" + libraryId +
                ", libraryAddress='" + libraryAddress + '\'' +
                ", librarians=" + librarian +
                '}';
    }
}
