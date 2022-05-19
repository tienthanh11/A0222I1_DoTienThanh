package ss02_VongLapTrongJava.BaiTap.b3;

public class HienThiCacSoNguyenToNhoHon100 {
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
         int n = 2;
         for(int i = 1; i <= 100; i++) {
            if(isPrime(n)) {
                System.out.println("Các số nguyên tố " + i + "là: " + n + " ");
            }
            n++;
        }
    }
}
