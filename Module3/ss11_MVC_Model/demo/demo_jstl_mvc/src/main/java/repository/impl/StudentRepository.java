package repository.impl;

import model.Student;
import repository.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {

    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "thanh", true, "12-12-2022", 9, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(2, "thanh2", false, "12-12-2022", 3, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(3, "thanh3", false, "12-12-2022", 8, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(4, "thanh4", true, "12-12-2022", 7, "thanhdt", 1, "thanhdt@gmail.com"));
        studentList.add(new Student(5, "thanh5", true, "12-12-2022", 6, "thanhdt", 1, "thanhdt@gmail.com"));
    }

    @Override
    public List<Student> findAll() {
        // Kết nối DB để lấy dữ liệu
        return studentList;
    }

    @Override
    public Student findBy(int id) {
        return null;
    }

    @Override
    public boolean add(Student student) {
        studentList.add(student);
        return true;
    }

    @Override
    public boolean delete(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                break;
            }
        }
        return true;
    }
}
