package ss11_DSA_StackAndQueue.BaiTap.KiemTraDauNgoacTrongBieuThucSuDungStack;

import java.util.Stack;

public class KiemTraDauNgoac {
    public static boolean checkBracket(String str) {
        Stack<Character> stack = new Stack<>();
        boolean check =false;
        for (int i = 0; i < str.length(); i++) {
            char c = (str.charAt(i));
            if ('(' == c) {
                stack.push((str.charAt(i)));
            } else if (')' == (str.charAt(i))) {
                if((stack.pop() != (')'))) {
                    check =true;
                    stack.push((str.charAt(i)));
                }
            }
        }
        return check;
    }
}
