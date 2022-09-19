package repository;

import model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> selectStudent();
}
