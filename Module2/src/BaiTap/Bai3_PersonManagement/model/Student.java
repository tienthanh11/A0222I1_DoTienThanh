package BaiTap.Bai3_PersonManagement.model;

public class Student extends Person {
    private String classLearn;
    private double point;

    public Student() {
    }

    public Student(String id, String name, String birthday, String gender, String classLearn, double point) {
        super(id, name, birthday, gender);
        this.classLearn = classLearn;
        this.point = point;
    }

    public String getClassLearn() {
        return classLearn;
    }

    public void setClassLearn(String classLearn) {
        this.classLearn = classLearn;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "classLearn='" + classLearn + '\'' +
                ", point=" + point +
                '}';
    }
}
