package ss04_ClassAndObjectInJava.BaiTap.PhuongTrinhBac2;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b , c;

    QuadraticEquation() {

    }
    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getA() {
        return a;
    }
    double getB() {
        return b;
    }
    double getC() {
        return c;
    }

    double getDiscriminant() {
        return Math.pow(this.b, 2) - (4 * this.a * this.c);
    }

    double getRoot1() {
        if(getDiscriminant() >= 0) {
            return (-this.b + Math.pow(getDiscriminant(), 0.5)) / (2 * this.a);
        }
        return 0;
    }
    double getRoot2() {
        if(getDiscriminant() >= 0) {
            return (-this.b - Math.pow(getDiscriminant(), 0.5)) / (2 * this.a);
        }
        return 0;
    }

    void display() {
        System.out.println("Quadratic Equation is: \na = " + getA() + "\nb = " + getB() + "\nc = " + getC());
        if(getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + getRoot1() + " and " + getRoot2());
        } else if(getDiscriminant() == 0) {
            System.out.println("The equation has one root " + getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        QuadraticEquation input = new QuadraticEquation(a, b, c);
        input.display();
    }
}
