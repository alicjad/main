package sdju.library.model;

public class Librarian {

    private int librarianId;
    private String librarianName;
    private int libraryId;

    public Librarian(int librarianId, String librarianName, int libraryId) {
        this.librarianId = librarianId;
        this.librarianName = librarianName;
        this.libraryId = libraryId;
    }

    public int getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(int librarianId) {
        this.librarianId = librarianId;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "librarianId=" + librarianId +
                ", librarianName='" + librarianName + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }
}
