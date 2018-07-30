package alic.students.repositories.util;

import alic.students.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public class CoursesArrayListRepository implements ICoursesRepository {

    private ArrayList<Course> courses = new ArrayList<>();

    public CoursesArrayListRepository(){
        courses.add(new Course(1, "Asp.NET MVC", LocalDate.of(2017, 07,07), 10));
        courses.add(new Course(2, "Javascript", LocalDate.of(2018, 05, 07), 10));
        courses.add(new Course(3, "Trains", LocalDate.of(2017, 06, 02), 10));
    }

    @Override
    public ArrayList<Course> readAll() {
        return null;
    }

    @Override
    public boolean create(Course course) {
        return false;
    }

    @Override
    public Course read(int id) {
        return null;
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(int id) {

    }
}
