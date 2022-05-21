package ss03_ArrayAndPhuongThucTrongJava.ThucHanh.b6;

import java.util.Scanner;

public class UngdungDemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        int size;
        int[] arrary;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = scanner.nextInt();
            if(size > 30) {
                System.out.println("Size should not exceed 30");
            }
        } while (size > 30);

        arrary = new int[size];
        for(int i = 0; i < arrary.length; i++) {
            System.out.println("Enter a mark for student " + (i + 1) + " : ");
            arrary[i] = scanner.nextInt();
        }

        int count = 0;
        System.out.println("List of mark: ");
        for(int j = 0; j < arrary.length; j++) {
            System.out.print(arrary[j] + "\t");
            if(arrary[j] >= 5 && arrary[j] <= 10) {
                count++;
            }
        }
        System.out.println("\nThe number of students passing the exam is: " + count);
    }
}
