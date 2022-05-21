package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b7;

import java.util.Scanner;

public class TinhTongCacSoODuongCheoChinhCuaMaTranVuong {

    public static float sumDiagonal(float[][] array, int height) {
        float sum = 0;
        for(int i = 0; i < height; i++) {
            sum += array[i][i];
            sum += array[i][array.length - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TinhTongCacSoODuongCheoChinhCuaMaTranVuong sumMatrix = new TinhTongCacSoODuongCheoChinhCuaMaTranVuong();
        System.out.println("Enter height: ");
        int height = scanner.nextInt();
        float[][] matrixArr = new float[height][height];
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < height; j++) {
                System.out.println("Enter matrix in array [" + i + "][" + j + "] is: ");
                matrixArr[i][j] = scanner.nextFloat();
            }
        }
        System.out.println("Matrix in array is: ");
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < height; j++) {
                System.out.print(matrixArr[i][j] + "\t");
            }
            System.out.print("\n");
        }
        float result = sumMatrix.sumDiagonal(matrixArr, height);
        System.out.println("Sum of the numbers on the main diagonal of the square matrix: " + result);
    }
}
