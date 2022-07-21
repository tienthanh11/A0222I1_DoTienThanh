package CaseStudy.models;

public class Employee extends Person {
    private String level;        //Trung cấp, Cao đẳng, Đại học, và sau đại học
    private String position;     //Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc.
    private int salary;

    public Employee() {
    }

    public Employee(String level, String position, int salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(int id, String fullName, String dataOfBirth, String gender, String identityCardNumber, String phoneNumber, String email, String level, String position, int salary) {
        super(id, fullName, dataOfBirth, gender, identityCardNumber, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
