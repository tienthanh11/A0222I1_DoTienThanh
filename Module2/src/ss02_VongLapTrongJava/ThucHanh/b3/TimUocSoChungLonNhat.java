package ss02_VongLapTrongJava.ThucHanh.b3;

import java.util.Scanner;

public class TimUocSoChungLonNhat {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Enter a: ");
        a = scanner.nextInt();
        System.out.println("Enter b: ");
        b = scanner.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if(a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }

        while (a != b) {
            if(a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        System.out.println("Greatest common factor: " + a);
    }
}
