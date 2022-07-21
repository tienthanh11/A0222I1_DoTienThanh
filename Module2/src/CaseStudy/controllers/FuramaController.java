package CaseStudy.controllers;

import CaseStudy.services.Implement.CustomerServiceImpl;
import CaseStudy.services.Implement.EmployeeServiceImpl;
import CaseStudy.services.Implement.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        boolean check = true;
        while (check) {
            System.out.println("*----------- MENU -----------*");
            System.out.println("* 1. Employee Management.    *");
            System.out.println("* 2. Customer Management.    *");
            System.out.println("* 3. Facility Management.    *");
            System.out.println("* 4. Booking Management.     *");
            System.out.println("* 5. Promotion Management.   *");
            System.out.println("* 6. Exit.                   *");
            System.out.println("*------------ *** -----------*");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose menu option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    displayEmployeeMenu();
                    break;
                case 2:
                    displayCustomerMenu();
                    break;
                case 3:
                    displayFacilityMenu();
                    break;
                case 4:
                    displayBookingMenu();
                    break;
                case 5:
                    displayPromotionMenu();
                    break;
                case 6:
                    check = false;
                    break;
            }
        }
    }

    public static void displayEmployeeMenu() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println(" -------- Employee --------- *");
            System.out.println("1.\tDisplay list employees   *");
            System.out.println("2.\tAdd new employee         *");
            System.out.println("3.\tEdit employee            *");
            System.out.println("4.\tReturn main menu         *");
            System.out.println(" --------------------------- *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose employee's option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    employeeService.displayEmployee();
                    break;
                case 2:
                    employeeService.addNewEmployee();
                    break;
                case 3:
                    employeeService.editEmployee();
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }

    public static void displayCustomerMenu() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println(" -------- Customers -------- *");
            System.out.println("1.\tDisplay list customers   *");
            System.out.println("2.\tAdd new customers        *");
            System.out.println("3.\tEdit customers           *");
            System.out.println("4.\tReturn main menu         *");
            System.out.println(" --------------------------- *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose customers's option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    customerService.displayCustomer();
                    break;
                case 2:
                    customerService.addNewCustomer();
                    break;
                case 3:
                    customerService.editCustomer();
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }

    public static void displayFacilityMenu() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println(" ------------- Facility ------------- *");
            System.out.println("1.\tDisplay list facility             *");
            System.out.println("2.\tAdd new facility                  *");
            System.out.println("3.\tDisplay list facility maintenance *");
            System.out.println("4.\tReturn main menu                  *");
            System.out.println(" ------------------------------------ *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose facility's option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    facilityService.displayFacility();
                    break;
                case 2:
                    addNewFacilityMenu();
                    break;
                case 3:
                    facilityService.displayMaintenance();
                    break;
                case 4:
                    check = false;
                    break;
            }
        }
    }

    public static void addNewFacilityMenu() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        boolean check = true;
        while (check) {
            System.out.println(" ----- Add Facility ----- *");
            System.out.println("1.\tAdd New Villa.        *");
            System.out.println("2.\tAdd New House.        *");
            System.out.println("3.\tAdd New Room.         *");
            System.out.println("4.\tBack to menu.         *");
            System.out.println(" ------------------------ *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose a service: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    facilityService.addNewVilla();
                    break;
                case 2:
                    facilityService.addNewHouse();
                    break;
                case 3:
                    facilityService.addNewRoom();
                    break;
                case 4:
                    check = false;
                    break;
            }

        }
    }

    public static void displayBookingMenu() {
        boolean check = true;
        while (check) {
            System.out.println(" --------- Booking --------- *");
            System.out.println("1.\tAdd new booking          *");
            System.out.println("2.\tDisplay list booking     *");
            System.out.println("3.\tCreate new contracts     *");
            System.out.println("4.\tDisplay list contracts   *");
            System.out.println("5.\tEdit contracts           *");
            System.out.println("6.\tReturn main menu         *");
            System.out.println(" --------------------------- *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose booking's option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
            }
        }
    }

    public static void displayPromotionMenu() {
        boolean check = true;
        while (check) {
            System.out.println(" ------------- Promotion -------------- *");
            System.out.println("1.\tDisplay list customers use service  *");
            System.out.println("2.\tDisplay list customers get voucher  *");
            System.out.println("3.\tReturn main menu                    *");
            System.out.println(" -------------------------------------- *");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please choose promotion's option: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
            }
        }
    }
}
