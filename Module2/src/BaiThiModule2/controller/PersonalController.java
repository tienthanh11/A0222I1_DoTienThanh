package BaiThiModule2.controller;

import BaiThiModule2.service.HumanService;

import java.util.Scanner;

public class PersonalController {
    static HumanService humanService = new HumanService();

    public static void main(String[] args) {
        displayMenu();
    }

    private static void displayMenu() {
        System.out.println("============= QUẢN LÝ NHÂN SỰ  ==============");
        while (true) {
            System.out.println("***** Chọn chức năng hệ thống *****");
            System.out.println("1. Thêm mới nhân sự. ");
            System.out.println("2. Xoá nhân sự. ");
            System.out.println("3. Xem danh sách nhân sự. ");
            System.out.println("4. Thoát. ");
            System.out.println("***** Chọn chức năng theo số *****");
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    System.out.println("========== Thêm mới nhân sự ==========");
                    humanService.addNew();
                    break;
                case "2":
                    System.out.println("========== Xoá nhân sự ==========");
                    humanService.delete();
                    break;
                case "3":
                    System.out.println("========== Xem danh sách nhân sự ==========");
                    humanService.display();
                    break;
                case "4":
                    System.out.println("========== Thoát ==========");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập từ 1 đến 4");
            }
        }
    }
}
