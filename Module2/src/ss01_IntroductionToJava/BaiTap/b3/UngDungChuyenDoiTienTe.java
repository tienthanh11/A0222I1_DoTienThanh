package ss01_IntroductionToJava.BaiTap.b3;

import java.util.*;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        double rate = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double result = usd * rate;
        System.out.println("Số tiền sau khi đã quy đổi sang VND: " + result);
    }
}
