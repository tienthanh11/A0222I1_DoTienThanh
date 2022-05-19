package ss02_VongLapTrongJava.BaiTap.b2;

import java.util.*;

public class HienThi20SoNguyenToDauTien {

    public static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        } else {
            for(int i = 2; i <= Math.sqrt(n); i++) {
                if(n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers;
        System.out.println("Nhập vào số lượng số nguyên tố là: ");
        numbers = sc.nextInt();
        int count = 0;
        int n = 2;
        while (count < numbers) {
            if(isPrime(n)) {
                System.out.println("Các số nguyên tố là: " + n + " ");
                count++;
            }
            n++;
        }
    }
}
