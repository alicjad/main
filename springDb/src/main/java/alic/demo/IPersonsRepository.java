package alic.demo;

import java.util.ArrayList;

public interface IPersonsRepository {

    ArrayList<Person> readAll();
    Person read(int id);
    boolean create(Person p);
}
