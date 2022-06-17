package ss11_DSA_StackAndQueue.BaiTap.KiemTraChuoiPalindromeSuDungQueue;

import java.util.Scanner;

public class ChuoiPalindromeTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChuoiPalindrome a = new ChuoiPalindrome();
        System.out.println("Enter string: ");
        String str = scanner.nextLine();
        boolean isPalindrome = a.compare(a.addStack(str), a.addQueue(str));
        if(isPalindrome) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not is Palindrome");
        }
    }
}
