package BaiThiModule2.model;

public class Student extends Human {
    private String scored;
    private String className;
    private String dayJoint;

    public Student() {
    }

    public Student(String id, String fullName, String birthday, String address, String phoneNumber, String scored, String className, String dayJoint) {
        super(id, fullName, birthday, address, phoneNumber);
        this.scored = scored;
        this.className = className;
        this.dayJoint = dayJoint;
    }

    public String getScored() {
        return scored;
    }

    public void setScored(String scored) {
        this.scored = scored;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDayJoint() {
        return dayJoint;
    }

    public void setDayJoint(String dayJoint) {
        this.dayJoint = dayJoint;
    }

    @Override
    public String toString() {
        return "Student{" +
                super.toString() +
                "scored='" + scored + '\'' +
                ", className='" + className + '\'' +
                ", dayJoint='" + dayJoint + '\'' +
                '}';
    }

    public String getData() {
        return super.getData() + "," + getScored() + "," + getClassName() + "," + getDayJoint();
    }
}
