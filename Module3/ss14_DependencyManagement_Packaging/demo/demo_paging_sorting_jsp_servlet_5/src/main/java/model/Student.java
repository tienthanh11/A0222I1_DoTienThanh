package model;

public class Student {
    private Integer id;
    private String name;
    private String dateOfBirthday;
    private double mark;

    public Student() {
    }

    public Student(Integer id, String name, String dateOfBirthday, double mark) {
        this.id = id;
        this.name = name;
        this.dateOfBirthday = dateOfBirthday;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
}
