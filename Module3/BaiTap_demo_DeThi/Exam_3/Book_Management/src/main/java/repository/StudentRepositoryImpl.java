package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepo {
    public final static String SELECT_ALL_STUDENT = "select * from student";

    @Override
    public List<Student> selectStudent() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String className = rs.getString("class_name");
                Student student = new Student(id, name, className);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }
}
