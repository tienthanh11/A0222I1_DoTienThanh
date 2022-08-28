package repository.impl;

import model.Student;
import repository.BaseRepository;
import repository.IStudentRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private final String SELECT_ALL = "select * from student;";
    private final String DELETE_BY_ID = " delete from student where id = ?;";
    private final String ADD_NEW = "insert into student(`name`, gender,birthday,`point`,`account`,class_id,email) values (?,?,?,?,?,?,?);";

    @Override
    public List<Student> fillAll() {
        //Kết nối DB để lấy dữ liệu
        List<Student> studentList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                String birthday = resultSet.getString("birthday");
                int point = resultSet.getInt("point");
                String account = resultSet.getString("account");
                String email = resultSet.getString("email");
                int classId = resultSet.getInt("class_id");
                Student student = new Student(id, name, gender, birthday, point, account, classId, email);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student findBy(int id) {
        return null;
    }

    @Override
    public void add(Student student) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_NEW);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setBoolean(2, student.isGender());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setInt(4, student.getPoint());
            preparedStatement.setString(5, student.getAccount());
            preparedStatement.setInt(6, student.getClassId());
            preparedStatement.setString(7, student.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            int num = preparedStatement.executeUpdate();
            return (num == 1);
/*            if(num == 1) {
                return true;
            } else {
                return false;
            }*/
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
