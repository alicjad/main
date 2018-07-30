package alic.students.repositories.util;

import alic.students.model.Course;

import java.util.ArrayList;

public interface ICoursesRepository {

    //An interface is a contract witch classes can implement.

    ArrayList<Course> readAll();
    boolean create(Course course);
    Course read(int id);
    void update(Course course);
    void delete(int id);

}
