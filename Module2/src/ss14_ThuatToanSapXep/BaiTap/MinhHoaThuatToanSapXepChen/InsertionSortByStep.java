package ss14_ThuatToanSapXep.BaiTap.MinhHoaThuatToanSapXepChen;

import java.util.Scanner;

public class InsertionSortByStep {
    private static void inputArray(int[] array, int numberOfArray) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < numberOfArray; i++) {
            System.out.print("Array [" + i + "]: ");
            array[i] = sc.nextInt();
        }
    }
    private static void outputArray(int[] array, int numberOfArray) {
        for(int i = 0; i < numberOfArray; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) { //đoạn array[0] đã sắp xếp
            System.out.println("Gán x = " + array[i]);
            int x = array[i];
            System.out.println("Gán pos = " + i);
            int pos = i;
            while (pos > 0 && x <array[pos - 1]) {
                System.out.println("Gán array: " + array[pos] + " = " + array[pos - 1]);
                array[pos] = array[pos - 1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }
    public static void main(String[] args) {
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int numberOfArray = scanner.nextInt();
        array = new int[numberOfArray];
        inputArray(array, numberOfArray);
        outputArray(array, numberOfArray);
        insertionSort(array);
        System.out.println("\nArray after sorting (Insertion sort)");
        outputArray(array, numberOfArray);
    }
}
