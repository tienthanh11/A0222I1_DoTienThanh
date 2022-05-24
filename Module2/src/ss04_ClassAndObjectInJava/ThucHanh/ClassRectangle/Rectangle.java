package ss04_ClassAndObjectInJava.ThucHanh.ClassRectangle;

import java.util.Scanner;

public class Rectangle {

    double width, height;

    Rectangle() {

    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return this.width * this.height;
    }

    double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    String display() {
        return "Rectangle{" + "width = " + width + ", height = " + height + "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter the height: ");
        double height = scanner.nextDouble();
        Rectangle rec = new Rectangle(width, height);
        System.out.println("Your rectangle \n" + rec.display());
        System.out.println("Perimeter of the rectangle is: " + rec.getPerimeter());
        System.out.println("Area of the rectangle is: " + rec.getArea());
    }
}
