package alic.students.repositories;

import alic.students.model.Student;
import java.util.ArrayList;

public interface IStudentsRepository {

    //An interface is a contract witch classes can implement.

    ArrayList<Student> readAll();
    boolean create(Student student);
    Student read(int id);
    void update(Student student);
    void delete(int id);

}