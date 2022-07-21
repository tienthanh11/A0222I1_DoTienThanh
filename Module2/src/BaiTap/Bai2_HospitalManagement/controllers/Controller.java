package BaiTap.Bai2_HospitalManagement.controllers;

import BaiTap.Bai2_HospitalManagement.service.BenhAnThuongImpl;
import BaiTap.Bai2_HospitalManagement.service.BenhAnVipImpl;
import BaiTap.Bai2_HospitalManagement.util.NotFoundMedicalRecordException;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) throws NotFoundMedicalRecordException {
        displayMenu();
    }

    public static void displayMenu() throws NotFoundMedicalRecordException {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN--");
            System.out.println("Chọn chức năng theo số (để tiếp tục): ");
            System.out.println("1.\tThêm mới");
            System.out.println("2.\tXóa");
            System.out.println("3.\tXem danh sách bệnh án");
            System.out.println("4.\tThoát");
            System.out.println("---------------------------");
            System.out.println("Chọn chức năng:");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai vui lòng nhập lại số: ");
                continue;
            }
            BenhAnThuongImpl benhAn = new BenhAnThuongImpl();
            switch (choice) {
                case 1:
                    benhAn.addNew();
                    break;
                case 2:
                    while (true) {
                        try {
                            benhAn.delete();
                        }
                        catch (NotFoundMedicalRecordException e) {
                            System.out.println("Error: Khong Ton Tai Benh An  -> Try again! ");
                            continue;
                        }
                        break;
                    }
                    break;
                case 3:
                    benhAn.display();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
                    choice = -1;
            }
        }
    }

    public static void addNewBenhAn() throws NotFoundMedicalRecordException {
        Scanner sc = new Scanner(System.in);
        BenhAnThuongImpl benhAnThuong = new BenhAnThuongImpl();
        BenhAnVipImpl benhAnVip = new BenhAnVipImpl();
        int choiceChildFunction = -1;
        while (choiceChildFunction != 0) {
            System.out.println("1.\tThem Benh An Thuong");
            System.out.println("2.\tThem Benh An Vip");
            System.out.println("3.\tReturn main menu");
            System.out.println("---------------------------");
            System.out.println("Select choice :");
            try {
                choiceChildFunction = Integer.parseInt(sc.nextLine());
            }catch (Exception e)
            {
                System.out.println("Nhập sai vui lòng nhập lại số: ");
                continue;
            }
            switch (choiceChildFunction) {
                case 1: benhAnThuong.addNew();
                    break;
                case 2: benhAnVip.addNew();
                    break;
                case 3: displayMenu();
                    break;
                default:
                    System.out.println("No choice!");
                    choiceChildFunction = -1;
            }
        }
    }
}

