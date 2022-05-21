package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b4;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static int maxArr(int[][] array, int row, int col) {
        int max = array[0][0];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TimPhanTuLonNhatTrongMangHaiChieu input = new TimPhanTuLonNhatTrongMangHaiChieu();
        System.out.println("Enter row: ");
        int row = scanner.nextInt();
        System.out.println("Enter column:");
        int col = scanner.nextInt();
        int[][] array = new int[row][col];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.println("Enter element of array [" + i + "]" + "[" + j + "] is: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Element in array is: ");
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }
        int result = input.maxArr(array, row, col);
        System.out.println("Max of array is: " + result);
    }
}