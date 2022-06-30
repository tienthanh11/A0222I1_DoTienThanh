package ss15_XuLiNgoaiLeAndDebug.BaiTap.SuDungLopIllegalTriangleException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Triangle triangle = new Triangle();
        boolean done = false;

        while (!done) {
            System.out.println("Enter three sides: ");
            try {
                double side1 = Double.parseDouble(scanner.nextLine());
                double side2 = Double.parseDouble(scanner.nextLine());
                double side3 = Double.parseDouble(scanner.nextLine());
                triangle = new Triangle(side1, side2, side3);
                done = true;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(triangle.toString() +
                "\nArea: " + triangle.getArea() +
                "\nPerimeter: " + triangle.getPerimeter());
    }
}
