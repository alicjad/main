package alic.students.repositories.util;
import alic.students.model.Course;

import java.sql.*;
import java.util.ArrayList;

public class CoursesDbRepository implements ICoursesRepository {

    ArrayList<Course> courses;

    private Connection connection;
    private PreparedStatement preparedSt;
    private ResultSet resultSet;

    public CoursesDbRepository(){
        this.connection = DbConnection.getConnection();
        this.courses = new ArrayList<>();
    }

    @Override
    public ArrayList<Course> readAll() {
        courses = new ArrayList<>();

        try{
            preparedSt = connection.prepareStatement("SELECT * FROM courses");
            resultSet = preparedSt.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            while (resultSet.next()) {
                courses.add(new Course(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getDate("startDate").toLocalDate(),
                        resultSet.getInt("etcs") ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return courses;
    }

    @Override
    public boolean create(Course course) {
        boolean c = false;

        try{
            System.out.println(course);
            preparedSt = connection.prepareStatement("INSERT INTO courses(title, startDate, etcs) VALUES (?, ?, ?)");

            preparedSt.setString(1, course.getTitle());
            preparedSt.setDate(2, Date.valueOf(course.getStartDate()));
            preparedSt.setInt(3, course.getEtcs());

            c = preparedSt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public Course read(int id) {
        try{
            preparedSt = connection.prepareStatement("SELECT * FROM courses WHERE courses.id = id");
            resultSet = preparedSt.executeQuery();

            if (resultSet.next()){
                return new Course(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getDate("startDate").toLocalDate(), resultSet.getInt("etcs"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return courses.get(id);
    }

    @Override
    public void update(Course course) {
        try{
            preparedSt = connection.prepareStatement("UPDATE courses SET title=?, startDate=?, etcs=? WHERE id=?;");

            preparedSt.setString(1, course.getTitle());
            preparedSt.setDate(2, Date.valueOf(course.getStartDate()));
            preparedSt.setInt(3, course.getEtcs());
            preparedSt.setInt(4, course.getId());

            preparedSt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

        try{
            preparedSt = connection.prepareStatement("DELETE FROM courses WHERE id=?;");
            preparedSt.setInt(1, id);

            preparedSt.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
