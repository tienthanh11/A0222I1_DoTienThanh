package ss02_VongLapTrongJava.BaiTap.b1;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    Scanner sc = new Scanner(System.in);
    public void rectangle() {
        int chieuDai;
        int chieuRong;
        System.out.println("Nhập vào chiều dài: ");
        chieuDai =  sc.nextInt();
        System.out.println("Nhập vào chiều rộng: ");
        chieuRong = sc.nextInt();
        for(int i = 1; i <= chieuDai; i++) {
            for(int j = 1; j <= chieuRong; j++) {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
    }

    public void squareTriangle() {
        int canh;
        System.out.println("Nhập cạnh của tam giác vuông: ");
        canh = sc.nextInt();
        for(int i = 1; i <= canh; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
    }
    public void isoscelesTriangle() {
        System.out.println("Nhập chiều cao: ");
        int height = sc.nextInt();
        int m = height, n = height;
        for(int i = 1; i <= height; i++) {
            for(int k = height; k > i; k--) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * height - 1; j++) {
                if(j >= m && j <= n) {
                    System.out.print("*");
                }
            }
            m--;
            n++;
            System.out.print("\n");
        }
    }
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            HienThiCacLoaiHinh a = new HienThiCacLoaiHinh();
            System.out.println("==========Menu==========");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("========================");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    a.rectangle();
                    break;
                case 2:
                    a.squareTriangle();
                    break;
                case 3:
                    a.isoscelesTriangle();
                    break;
                case 4:
                    System.exit(choice);
            }
        }
    }
}
