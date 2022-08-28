package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> fillAll();
    Student findBy(int id);
    void add(Student student);
    boolean delete(int id);
}
