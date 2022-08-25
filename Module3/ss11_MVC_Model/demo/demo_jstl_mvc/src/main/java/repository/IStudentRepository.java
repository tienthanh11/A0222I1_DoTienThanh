package repository;

import model.Student;

import java.util.List;
import java.util.Map;

public interface IStudentRepository {
    List<Student> findAll();

    Student findBy(int id);

    boolean add(Student student);

    boolean delete(int id);
}
