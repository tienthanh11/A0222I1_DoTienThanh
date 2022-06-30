package ss15_XuLiNgoaiLeAndDebug.ThucHanh.DebugUngDungJava;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants: ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a: ");
        double a = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter b: ");
        double b = Double.parseDouble(scanner.nextLine());

        if(a != 0) {
            double solution = -b / a;
            System.out.printf("The solution is: %f!", solution);
        } else {
            if(b == 0) {
                System.out.print("The solution is all x!");
            } else {
                System.out.println("No solution!");
            }
        }
    }
}
