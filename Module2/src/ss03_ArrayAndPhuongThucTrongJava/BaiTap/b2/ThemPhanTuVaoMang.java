package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b2;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    Scanner scanner = new Scanner(System.in);
    void insertArr(int[] arr) {
        System.out.println("\nEnter number: ");
        int number = scanner.nextInt();
        System.out.println("Enter index: ");
        int index = scanner.nextInt();
        if(index < 0 || index > arr.length) {
            System.out.println("Not insert");
        }
        int[] newArr = new int[arr.length + 1];
        for(int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = number;
        for(int i = index + 1; i < newArr.length; i++) {
            newArr[i] = arr[i - 1];
        }
        System.out.println("Array after insert is: ");
        for(int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + "\t");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThemPhanTuVaoMang add = new ThemPhanTuVaoMang();
        System.out.println("Enter a size of array: ");
        int number = scanner.nextInt();
        int[] array =  new int[number];
        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter element of array [" + (i + 1) + "] is: ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Element in array: " );
        for(int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        add.insertArr(array);
    }
}
