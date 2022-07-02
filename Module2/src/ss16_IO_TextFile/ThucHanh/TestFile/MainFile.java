package ss16_IO_TextFile.ThucHanh.TestFile;

import java.util.ArrayList;
import java.util.List;

public class MainFile {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Long", 18, "A0222I1", true));
        students.add(new Student("Tu", 19, "A0222I1", true));
        students.add(new Student("Duyet", 21, "A0222I2", true));
        students.add(new Student("Thanh", 20, "A0222I2", false));

        FileUtils.writeToFile(students);

        List<Student> result = FileUtils.getStudentFromFile("E:\\A0222I1_DoTienThanh\\Module2\\src\\ss16_IO_TextFile\\ThucHanh\\TestFile\\student.txt");
        result.stream().forEach(System.out::println);
    }
}
