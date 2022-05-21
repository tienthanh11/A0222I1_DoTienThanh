package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b5;

import ss03_ArrayAndPhuongThucTrongJava.BaiTap.b4.TimPhanTuLonNhatTrongMangHaiChieu;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static int minArr(int[] array) {
        int min = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimGiaTriNhoNhatTrongMang a = new TimGiaTriNhoNhatTrongMang();
        System.out.println("Enter a size of array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Enter element of array [" + i + "] is: ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Element in array is: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        int result = a.minArr(arr);
        System.out.println("\nMin of array: " + result);
    }
}
