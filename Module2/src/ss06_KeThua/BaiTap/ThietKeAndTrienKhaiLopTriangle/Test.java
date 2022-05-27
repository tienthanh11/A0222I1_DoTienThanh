package ss06_KeThua.BaiTap.ThietKeAndTrienKhaiLopTriangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        System.out.println("Enter color");
        String color=input.nextLine();
        System.out.println("Enter side1");
        double side1= input.nextDouble();
        System.out.println("Enter side2");
        double side2= input.nextDouble();
        System.out.println("Enter side3");
        double side3 =input.nextDouble();
        Triangle triangle = new Triangle(side1, side2, side3, color,true);
        System.out.println(triangle.toString());
    }
}
