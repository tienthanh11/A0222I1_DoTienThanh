package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b1;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    Scanner scanner = new Scanner(System.in);
    void deleteArray(int[] array) {
        int[] newArr = new int[array.length - 1];
        System.out.println("\nEnter the element you want to delete: ");
        int num = scanner.nextInt();
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] == num) {
                count = 1;
                for(int j = 0; j < i; j++) {
                    newArr[j] = array[j];
                }
                for(int j = i + 1; j < array.length; j++) {
                    newArr[j - 1] = array[j];
                }
            }
        }
        if(count == 1) {
            System.out.println("Array after delete is: ");
            for(int i = 0; i < newArr.length; i++) {
                System.out.print(newArr[i] + "\t");
            }
        } else {
            System.out.println("Not element found!!!");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        XoaPhanTuKhoiMang delete = new XoaPhanTuKhoiMang();
        System.out.println("Enter a size of array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Enter element of array [" + (i + 1) + "] is: ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Element in array: " );
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        delete.deleteArray(arr);
    }
}
