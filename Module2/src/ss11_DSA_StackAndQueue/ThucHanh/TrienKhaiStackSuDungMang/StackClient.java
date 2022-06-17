package ss11_DSA_StackAndQueue.ThucHanh.TrienKhaiStackSuDungMang;

public class StackClient {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("1. Size of stack after push operations: " + stack.size());
        System.out.printf("2. elements from stack: ");

        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3. Size of stack after pop operations: " + stack.size());
    }
}
