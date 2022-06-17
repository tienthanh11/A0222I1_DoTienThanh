package ss11_DSA_StackAndQueue.BaiTap.KiemTraDauNgoacTrongBieuThucSuDungStack;

import java.util.Scanner;

public class KiemTraDauNgoacTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        boolean isKiemTra = KiemTraDauNgoac.checkBracket(str);
        if (isKiemTra) {
            System.out.println("Hợp lệ");
        } else {
            System.out.println("Không hợp lệ");
        }
    }
}
