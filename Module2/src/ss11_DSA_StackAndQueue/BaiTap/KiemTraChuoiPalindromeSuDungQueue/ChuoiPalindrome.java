package ss11_DSA_StackAndQueue.BaiTap.KiemTraChuoiPalindromeSuDungQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ChuoiPalindrome {
    public Stack<String> addStack(String str) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            stack.push(String.valueOf(str.charAt(i)));
        }
        return stack;
    }

    public Queue<String> addQueue(String str) {
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < str.length(); i++) {
            queue.add(String.valueOf(str.charAt(i)));
        }
        return  queue;
    }

    public boolean compare(Stack<String> stack, Queue<String> queue) {
        while (!stack.empty()) {
            if(!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }
}
