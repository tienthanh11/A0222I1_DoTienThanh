package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b3;

import java.util.Scanner;

public class GopMang {
    void poolingArr(int[] array1, int[] array2) {
        int size3 = array1.length + array2.length;
        int[] array3 = new int[size3];
        for(int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for(int i = 0; i < array2.length; i++) {
            array3[i + array1.length] = array2[i];
        }
        System.out.println("\nArray after merging is: ");
        for(int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + "\t");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a size of first array: ");
        int size1 = scanner.nextInt();
        int[] array1 = new int[size1];
        for(int i = 0; i < array1.length; i++) {
            System.out.println("Enter element of first array [" + (i + 1) + "] is: ");
            array1[i] = scanner.nextInt();
        }

        System.out.println("Enter a size of second array: ");
        int size2 = scanner.nextInt();
        int[] array2 = new int[size2];
        for(int i = 0; i < array2.length; i++) {
            System.out.println("Enter element of second array [" + (i + 1) + "] is: ");
            array2[i] = scanner.nextInt();
        }

        System.out.println("Element in first array: ");
        for(int j = 0; j < array1.length; j++) {
            System.out.print(array1[j] + "\t");
        }

        System.out.println("\nElement in second array: ");
        for(int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + "\t");
        }

        GopMang a = new GopMang();
        a.poolingArr(array1, array2);
    }
}
