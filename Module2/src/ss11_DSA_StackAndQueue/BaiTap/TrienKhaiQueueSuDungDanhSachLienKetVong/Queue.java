package ss11_DSA_StackAndQueue.BaiTap.TrienKhaiQueueSuDungDanhSachLienKetVong;

public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
    }

    public Queue(Node front, Node rear) {
        this.front = front;
        this.rear = rear;
    }

    public Node getFront() {
        return front;
    }

    public void setFront(Node front) {
        this.front = front;
    }

    public Node getRear() {
        return rear;
    }

    public void setRear(Node rear) {
        this.rear = rear;
    }
}
