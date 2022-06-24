package ss13_ThuatToanTimKiem.BaiTap.CaiDatThuatToanTimKiemNhiPhanSuDungDeQuy;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveBinarySearch {
    static int binarySearch(int[] array, int left, int right, int value) {
        while (right >= left) {
            int middle = (left + right) / 2;
            if(array[middle] == value) {
                return middle;
            } else if(value > array[middle]) {
                return binarySearch(array, middle + 1, right, value);
            } else {
                return binarySearch(array, left, middle - 1, value);
            }
        }
        return -1;
/*        left = 0;
        right = array.length -1;
        while (right >= left){
            int middle = (left + right) / 2;
            if(value == array[middle]) {
                return middle;
            } else if(value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;*/
    }

    public static void main(String[] args) {
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size in array: ");
        int size = scanner.nextInt();

        array = new int[size];
        for(int i = 0; i < array.length; i++) {
            System.out.println("Enter element '" + (i + 1) + "' is: ");
            array[i] = scanner.nextInt();
        }

        System.out.println("The elements in the array are: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        System.out.println("\nThe array after sorting is: ");
        Arrays.sort(array);
        for(int x : array) {
            System.out.print(x + "\t");
        }

        System.out.println("\nEnter the number to search is: ");
        int value = scanner.nextInt();

        int index = binarySearch(array, 0, array.length -1, value);
        if(index == -1) {
            System.out.println("No values found");
        } else {
            System.out.println(value + " in position " + index);
        }
    }
}
