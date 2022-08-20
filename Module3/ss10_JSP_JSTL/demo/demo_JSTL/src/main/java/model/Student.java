package model;

public class Student {
    private int id;
    private String name;
    private boolean gender;
    private String birthday;
    private int point;
    private String account;
    private int classId;
    private String email;

    public Student() {
    }

    public Student(int id, String name, boolean gender, String birthday, int point, String account, int classId, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.point = point;
        this.account = account;
        this.classId = classId;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
