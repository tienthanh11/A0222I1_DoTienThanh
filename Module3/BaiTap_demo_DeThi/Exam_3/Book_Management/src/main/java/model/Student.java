package model;

public class Student {
    private int studentId;
    private String name;
    private String className;

    public Student() {
    }

    public Student(int studentId, String name, String className) {
        this.studentId = studentId;
        this.name = name;
        this.className = className;
    }

    public Student(String name, String className) {
        this.name = name;
        this.className = className;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
