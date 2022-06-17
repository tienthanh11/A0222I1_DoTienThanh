package ss11_DSA_StackAndQueue.BaiTap.DaoNguocPhanTuSuDungStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DaoNguocPhanTuSuDungStack {
    static Scanner scanner = new Scanner(System.in);

    public static List<Integer> inputArray(List<Integer> array, int length) {
        for(int i = 0; i < length; i++) {
            System.out.print("Input element " + i + " : ");
            array.add(Integer.valueOf(scanner.nextLine()));
        }
        return array;
    }

    public static List<Integer> reverseArray(List<Integer> array) {
        Stack<Integer> stack = new Stack<>();
        for(Integer element : array) {
            stack.push(element);
        }
        array = new ArrayList<>();
        while (!stack.empty()) {
            array.add(stack.pop());
        }
        return array;
    }

    public static String reverseString(String str) {
        Stack<String> strings = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            strings.push(String.valueOf(str.charAt(i)));
        }
        StringBuilder result = new StringBuilder(" ");
        while (!strings.empty()) {
            result.append(strings.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int length = Integer.parseInt(scanner.nextLine());
        List<Integer> list = new ArrayList<>();
        inputArray(list, length);
        list = reverseArray(list);
        for(Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println("\n===============================");
        System.out.println("Enter string: ");
        String str = scanner.nextLine();
        str = reverseString(str);
        System.out.println("Result: " + str);
    }
}
