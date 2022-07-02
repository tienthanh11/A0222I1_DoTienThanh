package ss16_IO_TextFile.ThucHanh.TestFile;

public class Student {
    private String name;
    private int age;
    private String className;
    private boolean sex;

    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(String name, int age, String className, boolean sex) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.sex = sex;
    }

    public static Student getStudent(String name, int age) {
        return new Student(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String toData(String delimiter) {
        return name + delimiter + age + delimiter + className + delimiter + sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", sex=" + sex +
                '}';
    }
}
