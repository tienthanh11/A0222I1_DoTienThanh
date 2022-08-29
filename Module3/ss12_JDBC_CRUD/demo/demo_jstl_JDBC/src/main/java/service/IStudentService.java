package service;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> findAll();

    Student findBy(int id);

    Map<String, String> add(Student student);

    boolean delete(int id);
}
