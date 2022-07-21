package BaiTap.Bai3_PersonManagement.service;

import BaiTap.Bai3_PersonManagement.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentService implements StudentImpl {
    private static ArrayList<Student> studentArrayList = new ArrayList<>();
    private static Scanner  scanner = new Scanner(System.in);
    static {
        reader();
    }

    public void write() {
        try {
            FileWriter fileWriter = new FileWriter("src\\BaiTap\\Bai3_PersonManagement\\data\\student.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(Student student: studentArrayList) {
                bufferedWriter.write(student.getId() + "," +
                        student.getName() + "," +
                        student.getBirthday() + "," +
                        student.getGender() + "," +
                        student.getClassLearn() + "," +
                        student.getPoint());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reader() {
        try {
            FileReader fileReader = new FileReader("src\\BaiTap\\Bai3_PersonManagement\\data\\student.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] data;
            String line;
            Student student;
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split(",");
                student = new Student(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
                studentArrayList.add(student);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void addNewStudent() {
        System.out.println("Enter id student: ");
        String id = scanner.nextLine();
        while (!(id.matches("[S][V][-][0-9]{4}"))){
            System.out.println("please re-enter: ");
            System.out.println("Enter id student: ");
            id = scanner.nextLine();
        }

        System.out.println("Enter name student: ");
        String name = scanner.nextLine();

        String birthday;
        do {
            System.out.println("Enter birthday: ");
            birthday = scanner.nextLine();
        } while (!Pattern.matches("(((0[1-9]|[12][0-9]|30)[-\\/](0[13-9]|1[012])|31[-\\/](0[13578]|1[02])|(0[1-9]|1[0-9]|2[0-8])[-\\/]02)" +
                "[-\\/](19[0-9]{2}|200[012])|29[-\\/]02[-\\/]" +
                "([0-9]{2}(([2468][048]|[02468][48])|[13579][26])|([13579][26]|[02468][048]|0[0-9]|1[0-6])00))$", birthday));

        System.out.println("*--- Gender ---*");
        System.out.println("* 1. Male.     *");
        System.out.println("* 2. Female.   *");
        System.out.println("* 3. Other.    *");
        System.out.println("*--------------*");
        String gender = " ";
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:
                gender = "Male";
                break;
            case 2:
                gender = "Female";
                break;
            case 3:
                gender = "Other";
                break;
        }

        System.out.println("Enter name class learn: ");
        String classLearn = scanner.nextLine();

        System.out.println("Enter point of student: ");
        Double point = Double.parseDouble(scanner.nextLine());
        while (point < 0 || point > 100) {
            System.out.println("Please re-enter student point: ");
            point = Double.parseDouble(scanner.nextLine());
        }
        Student student = new Student(id, name, birthday, gender, classLearn, point);
        studentArrayList.add(student);
        write();
    }


    @Override
    public void deleteStudent() {
        System.out.println("Enter student id to delete: ");
        String id;
        do {
            id = scanner.nextLine();
        } while (id.compareTo("") == 0);
        try {
            for(int i = 0; i < studentArrayList.size(); i++) {
                if(studentArrayList.get(i).getId().equals(id)) {
                    System.out.println("Do you want to delete?: ");
                    System.out.println("1.\tYes.");
                    System.out.println("2.\tNo.");
                    int choice = Integer.parseInt(scanner.nextLine());
                    if(choice == 1) {
                        studentArrayList.remove(i);
                        System.out.println("Delete successfully");
                        break;
                    } else {
                        break;
                    }
                }
                if(!(studentArrayList.get(i).getId().equals(id))) {
                    System.out.println("No student to delete");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage() + "return main menu");
            scanner.nextLine();
        }
        write();
    }

    @Override
    public void searchStudent() {
        System.out.println("Enter name to search: ");
        String strStudent = scanner.nextLine();

        ArrayList<Student> arrayList = new ArrayList<>();
        for (Student student : studentArrayList) {
            if (student.getName().toLowerCase().contains(strStudent.toLowerCase())) {
                arrayList.add(student);
            }
        }
        if(arrayList.size() == 0) {
            System.out.println("No name to delete");
        } else {
            for(Student student: arrayList) {
                System.out.println(student);
            }
        }
    }

    @Override
    public void displayStudent() {
        for(Student student: studentArrayList) {
            System.out.println(student);
        }
    }
}
