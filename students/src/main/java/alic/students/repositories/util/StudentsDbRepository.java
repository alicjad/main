package alic.students.repositories.util;

import alic.students.model.Student;
import alic.students.repositories.IStudentsRepository;

import java.sql.*;
import java.util.ArrayList;

public class StudentsDbRepository implements ICrudRepository<Student> {

    ArrayList<Student> students;

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet result;

    public StudentsDbRepository(){
        this.conn = DbConnection.getConnection();
        //this.students = new ArrayList<>();
    }

    @Override
    public ArrayList<Student> readAll() {
        students = new ArrayList<>();

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM students");
            result = preparedStatement.executeQuery();

        } catch (SQLException e){
            e.printStackTrace();
        }

        try {

            while (result.next()){
                students.add(new Student(result.getInt("id"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        result.getDate("enrollment_date").toLocalDate(),
                        result.getString("cpr") ));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return students;
    }

    @Override
    public boolean create(Student student) {
        boolean s = false;

        try{
            System.out.println(student);
            preparedStatement = conn.prepareStatement("INSERT INTO students(first_name, last_name, enrollment_date, cpr) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getEnrollmentDate()));
            preparedStatement.setString(4, student.getCpr());

            s = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return s;
    }

    @Override
    public Student read(int id) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM students WHERE students.id = id");
            result = preparedStatement.executeQuery();

            if (result.next()){
                return new Student(result.getInt("id"), result.getString("first_name"), result.getString("last_name"), result.getDate("enrollment_date").toLocalDate(), result.getString("cpr"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students.get(id);

    }

    @Override
    public void update(Student student) {
        try {
            preparedStatement = conn.prepareStatement("UPDATE students SET first_name =?, last_name = ?, enrollment_date = ?, cpr = ? WHERE id =?;");

            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getEnrollmentDate()));
            preparedStatement.setString(4, student.getCpr());
            preparedStatement.setInt(5, student.getId());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM students WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
