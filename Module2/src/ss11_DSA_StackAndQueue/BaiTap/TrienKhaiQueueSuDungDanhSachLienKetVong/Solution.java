package ss11_DSA_StackAndQueue.BaiTap.TrienKhaiQueueSuDungDanhSachLienKetVong;

public class Solution {
    Queue queue = new Queue();
    public void enQueue(int data) {
        if(queue.getFront() == null) {
            queue.setFront(new Node(data));
            queue.setRear(queue.getFront());
            queue.getFront().setLink(queue.getRear());
            queue.getRear().setLink(queue.getFront());
        } else {
            queue.getRear().setLink(new Node(data));
            queue.setRear(queue.getRear().getLink());
            queue.getRear().setLink(queue.getFront());
        }
    }

    public Integer deQueue() {
        if(queue.getFront() == null) {
            return null;
        } else if(queue.getFront() == queue.getRear()) {
            Node temp = queue.getFront();
            queue.setFront(null);
            queue.setRear(null);
            return temp.getData();
        } else {
            Node temp = queue.getFront();
            queue.setFront(queue.getFront().getLink());
            queue.getRear().setLink(queue.getFront());
            return temp.getData();

        }
    }

    public void displayQueue() {
        Node temp = queue.getFront();
        do {
            System.out.println(temp.getData());
            temp = temp.getLink();
        } while (temp != queue.getRear().getLink());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.enQueue(2);
        solution.enQueue(3);
        solution.enQueue(4);
        solution.enQueue(5);
        solution.deQueue();
        solution.deQueue();
        solution.displayQueue();
    }
}
