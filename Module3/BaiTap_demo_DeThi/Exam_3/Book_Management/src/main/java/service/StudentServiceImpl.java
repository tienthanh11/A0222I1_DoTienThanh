package service;

import model.Student;
import repository.IStudentRepo;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements IStudentService {
    IStudentRepo studentRepo = new StudentRepositoryImpl();

    @Override
    public List<Student> selectStudent() {
        return studentRepo.selectStudent();
    }
}
