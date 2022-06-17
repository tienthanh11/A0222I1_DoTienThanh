package ss11_DSA_StackAndQueue.BaiTap.ChuyenDoiTuHeThapPhanSangHeNhiPhan;

import java.util.Stack;

public class ChuyenDoiTuHeThapPhanSangHeNhiPhan {
    public String convert(int number) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        int result;
        while (number != 0) {
            result = number % 2;
            stack.push(result);
            number /= 2;
        }
        while (!stack.empty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }
}
