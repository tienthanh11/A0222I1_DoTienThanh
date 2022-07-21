package BaiTap.Bai3_PersonManagement.controller;

import BaiTap.Bai3_PersonManagement.service.LecturersService;
import BaiTap.Bai3_PersonManagement.service.StudentService;

import java.util.Scanner;

public class MenuCodeGym {
    public static void main(String[] args) {
        CodeGym();
    }

    public static void CodeGym() {
        int choose = 0;
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        while (check) {
            System.out.println("*-------------------- MENU --------------------*");
            System.out.println("* 1. Lecturers management program.             *");
            System.out.println("* 2. Student management program.               *");
            System.out.println("* 3. Exit.                                     *");
            System.out.println("*----------------------------------------------*");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect, please re-enter: ");
            }
            switch (choose) {
                case 1:
                    displayLecturersMenu();
                    break;
                case 2:
                    displayStudentMenu();
                    break;
                case 3:
                    check = false;
                    break;
            }
        }
    }

    public static void displayLecturersMenu() {
        LecturersService lecturersService = new LecturersService();
        int choose = 0;
        boolean check = true;
        while (check) {
            System.out.println("*----- Lecturers management program -----*");
            System.out.println("* 1. Add new lecturers.                  *");
            System.out.println("* 2. Delete lecturers.                   *");
            System.out.println("* 3. Display list lecturers.             *");
            System.out.println("* 4. Search lecturers.                   *");
            System.out.println("* 5. Return main menu.                   *");
            System.out.println("*----------------------------------------*");
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter the lecturers function: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect, please re-enter: ");
            }
            switch (choose) {
                case 1:
                    lecturersService.addNewLecturers();
                    break;
                case 2:
                    lecturersService.deleteLecturers();
                    break;
                case 3:
                    lecturersService.displayLecturers();
                    break;
                case 4:
                    lecturersService.searchLecturers();
                    break;
                case 5:
                    check = false;
                    break;
            }
        }
    }

    public static void displayStudentMenu() {
        StudentService studentService = new StudentService();
        int choose = 0;
        boolean check = true;
        while (check) {
            System.out.println("*----- Student management program -----*");
            System.out.println("* 1. Add new student.                  *");
            System.out.println("* 2. Delete student.                   *");
            System.out.println("* 3. Display list student.             *");
            System.out.println("* 4. Search student.                   *");
            System.out.println("* 5. Return main student.              *");
            System.out.println("*----------------------------------------*");
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("Enter the student function: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Incorrect, please re-enter: ");
            }
            switch (choose) {
                case 1:
                    studentService.addNewStudent();
                    break;
                case 2:
                    studentService.deleteStudent();
                    break;
                case 3:
                    studentService.displayStudent();
                    break;
                case 4:
                    studentService.searchStudent();
                    break;
                case 5:
                    check = false;
                    break;
            }
        }
    }
}
