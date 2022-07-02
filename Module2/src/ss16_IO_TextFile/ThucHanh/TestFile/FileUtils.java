package ss16_IO_TextFile.ThucHanh.TestFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String DELIMITER = ";";
    public static void writeToFile(List<Student> students) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\A0222I1_DoTienThanh\\Module2\\src\\ss16_IO_TextFile\\ThucHanh\\TestFile\\student.txt"))){
            for(Student st: students) {
                bufferedWriter.write(st.toData(DELIMITER));
                bufferedWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> getStudentFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                if(line.isEmpty()) {
                    continue;
                }
                String[] result = line.split(DELIMITER);
                String name = result[0];
                int age = Integer.parseInt(result[1]);
                String className = result[2];
                boolean sex = Boolean.parseBoolean(result[3]);
                students.add(new Student(name, age, className, sex));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
