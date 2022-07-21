package BaiThiModule2.model;

public class Employee extends Human {
    private String salary;
    private String department;
    private String job;

    public Employee() {
    }

    public Employee(String id, String fullName, String birthday, String address, String phoneNumber, String salary, String department, String job) {
        super(id, fullName, birthday, address, phoneNumber);
        this.salary = salary;
        this.department = department;
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "salary='" + salary + '\'' +
                ", department='" + department + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public String getData() {
        return super.getData() + "," + getSalary() + "," + getDepartment() + "," + getJob();
    }
}
