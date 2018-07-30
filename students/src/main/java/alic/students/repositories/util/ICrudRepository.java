package alic.students.repositories.util;

import java.util.ArrayList;

public interface ICrudRepository<T> {


    //An interface is a contract witch classes can implement.

    ArrayList<T> readAll();
    boolean create(T object);
    T read(int id);
    void update(T object);
    void delete(int id);

}
