package alic.students.repositories;

import alic.students.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class StudentsArrayListRepository implements IStudentsRepository {

    private ArrayList<Student> students = new ArrayList<>();

    public StudentsArrayListRepository(){

        students.add(new Student(1, "Claus", "Bove", LocalDate.of(2017,2,20), "221009-0099"));
        students.add(new Student(2, "Anna", "Bove", LocalDate.of(2018, 03, 04), "221"));
        students.add(new Student(3, "James", "Brown", LocalDate.of(2017, 05, 02), "0099"));
        students.add(new Student(4, "Jesus", "It", LocalDate.of(2018,02, 04), "2210"));
    }

    @Override
    public ArrayList<Student> readAll() {
        //Code reading from an ArrayList
        return students;
    }

    @Override
    public Student read(int id) {
        return students.get(id - 1);
    }

    @Override
    public boolean create(Student student) {
        //Code adding from an ArrayList
        students.add(student);
        student.setId(students.size());

        return true;
    }

    @Override
    public void update(Student student) {

        for (Student st : students) {

            if (st.getId() == student.getId()) {
                students.remove(st);
                students.add(student);
            }
        }
    }

    @Override
    public void delete(int id) {

        for (Student s: students) {
            if (s.getId() == id){
                students.remove(id-1);
            }
        }
    }

}
