package sdju.library.applicationLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sdju.library.model.Library;
import sdju.library.repositories.LibraryDbRepository;

import java.sql.SQLException;
import java.util.List;

@Component
public class LibraryManager {

    private LibraryDbRepository libraryDbRepository;

    @Autowired
    public LibraryManager (LibraryDbRepository libraryDbRepository) {
        this.libraryDbRepository = libraryDbRepository;
    }

    public List<Library> getLibraries(){
        try {
            List<Library> libraries = libraryDbRepository.readAll();
            return libraries;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
