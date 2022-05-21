package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b6;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void sumOfColumn(int[][] array, int row) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter column: ");
        int column = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += array[i][column];
        }
        System.out.println("Sum of " + column + " column is: " + sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TinhTongCacSoOMotCotXacDinh sum = new TinhTongCacSoOMotCotXacDinh();
        System.out.println("Enter row: ");
        int row = scanner.nextInt();
        System.out.println("Enter column: ");
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Enter element of array [" + i + "]" + "[" + j + "] is: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Element in array is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        sum.sumOfColumn(array, row);
    }
}

