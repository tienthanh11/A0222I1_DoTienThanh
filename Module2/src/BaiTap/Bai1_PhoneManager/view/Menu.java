package BaiTap.Bai1_PhoneManager.view;

import BaiTap.Bai1_PhoneManager.exception.NotFoundException;
import BaiTap.Bai1_PhoneManager.model.AuthenticPhone;
import BaiTap.Bai1_PhoneManager.model.HandPhone;
import BaiTap.Bai1_PhoneManager.model.Phone;
import BaiTap.Bai1_PhoneManager.service.PhoneService;
import BaiTap.Bai1_PhoneManager.validate.Valid;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static PhoneService phoneService = new PhoneService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("*------ MENU -----*");
            System.out.println("* 1. Create.      *");
            System.out.println("* 2. Display.     *");
            System.out.println("* 3. Delete.      *");
            System.out.println("* 4. Search.      *");
            System.out.println("* 5. Exit.        *");
            System.out.println("*-----------------*");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    create();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }

    private static void create() {
        System.out.println("*------ CREATE PHONE -----*");
        System.out.println("* 1. Authentic.           *");
        System.out.println("* 2. Hand.                *");
        System.out.println("*-------------------------*");
        int choice = getChoice();

        String name = "";
        do{
            System.out.print("Input name:");
            name = scanner.nextLine();
        }while (!Valid.checkName(name));

        String price = "";
        do{
            System.out.print("Enter price: ");
            price = scanner.nextLine();
        }while (!Valid.isNumber(price));

        String manufacture = inputIsEmpty("Enter manufacture: ");

        if(choice == 1) {
            int granteeByYear = Integer.parseInt(inputIsEmpty("Enter grantee by year: "));
            String granteeByCode = inputIsEmpty("Enter grantee by code");
            AuthenticPhone authenticPhone = new AuthenticPhone(0, name, Double.parseDouble(price), manufacture, granteeByYear, granteeByCode);
            phoneService.create(authenticPhone);
        } else {
            String country = inputIsEmpty("Enter country: ");
            String status = inputIsEmpty("Enter status: ");
            HandPhone handPhone = new HandPhone(0, name, Integer.parseInt(price), manufacture, country, status);
            phoneService.create(handPhone);
        }
        System.out.println("Created successfully");
    }

    private static void display() {
        List<Phone> phones = phoneService.findAll();
        for (Phone phone : phones) {
            System.out.println(phone);
        }
    }

    private static void delete() {
        display();
        boolean tmp = false;
        do{
           System.out.print(tmp ?  "Enter id to delete again: " : "Enter id to delete: ");
           int id = Integer.parseInt(scanner.nextLine());
           try{
               phoneService.delete(id);
               System.out.println("Deleted successfully");
               tmp = false;
           }catch (NotFoundException e) {
               System.out.println(e.getMessage());
               tmp = true;
           }
       }while (tmp);
    }

    private static void search() {
        System.out.println("Enter name to search: ");
        String name = scanner.nextLine();
        List<Phone> phones = phoneService.search(name);

        if(phones.size() > 0) {
            for (Phone phone : phones) {
                System.out.println(phone);
            }
        } else {
            System.out.println("Empty list");
        }
    }

    private static int getChoice(){
        System.out.println("Enter your choice :");
        return Integer.parseInt(scanner.nextLine());
    }

    private static String inputIsEmpty(String field){
        String val = "0";
        do {
            System.out.print(val.isEmpty() ? "Invalid format. Input again:" : field);
            val = scanner.nextLine();
        }while (val.trim().isEmpty());

        return val;
    }
}
