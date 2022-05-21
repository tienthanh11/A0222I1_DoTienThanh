package ss03_ArrayAndPhuongThucTrongJava.ThucHanh.b1;

import java.util.Scanner;

public class DaoNguocCacPhanTuCuaMang {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter a size: ");
            size = sc.nextInt();
            if(size > 20) {
                System.out.println("Size dose not exceed 20");
            }
        } while (size > 20);

        array = new int[size];
        for(int i = 0; i < array.length; i++) {
            System.out.print("Enter element [" + (i + 1) + "] is : " );
            array[i] = sc.nextInt();
        }

        System.out.println("Element in array: " );
        for(int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        for(int j = 0; j < Math.sqrt(array.length); j++) {
            int temp = array[j];
            array[j] = array[size - 1 - j];
            array[size - 1 - j] = temp;
        }
        System.out.println("\nReverse array: ");
        for(int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
