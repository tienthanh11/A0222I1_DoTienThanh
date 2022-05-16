package ss01_IntroductionToJava.ThucHanh.b5;

import java.util.*;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which month that you want to count days? ");
        int month = scanner.nextInt();

        String daysInMonth;

        switch(month) {
            case 2:
                daysInMonth = "28 or 29";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
        }
        if(!daysInMonth.equals("")) {
            System.out.println("The month " + month + " has " + daysInMonth + " days");
        } else {
            System.out.println("Invalid input!");
        }
    }
}
