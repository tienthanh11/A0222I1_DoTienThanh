package ss03_ArrayAndPhuongThucTrongJava.BaiTap.b8;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {

    public static void countChar(String str) {
        Scanner sc = new Scanner(System.in);
        String[] character = str.split("");
        int count = 0;
        System.out.println("Enter character: ");
        String keys = sc.nextLine();
        for(int i = 0; i < character.length; i++) {
            if(character[i].equals(keys)) {
                count++;
            }
        }
        System.out.println("Number of occurrences of '" + keys + "' is: " + count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemSoLanXuatHienCuaKyTuTrongChuoi in = new DemSoLanXuatHienCuaKyTuTrongChuoi();
        System.out.println("Enter string: ");
        String string = scanner.nextLine();
        in.countChar(string);
    }
}
