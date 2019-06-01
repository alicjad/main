package sdju.library.repositories.arrays;

import java.util.ArrayList;

public interface ICrudRepository<T> {

    ArrayList<T> readAll() throws Exception;
    boolean create(T object) throws Exception;
    T read(int id) throws Exception;
    void update(T object) throws Exception;
    void delete(int id) throws Exception;

}
