package ss11_DSA_StackAndQueue.BaiTap.ChuyenDoiTuHeThapPhanSangHeNhiPhan;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChuyenDoiTuHeThapPhanSangHeNhiPhan a = new ChuyenDoiTuHeThapPhanSangHeNhiPhan();
        System.out.println("Enter number: ");
        int num = scanner.nextInt();
        System.out.println("Result: " + a.convert(num));
    }
}
