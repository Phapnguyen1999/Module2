package bai6;

public class MyQueue {
    private int capacity;
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;
    private int[] queueArr;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull() {
        boolean status = false;
        if (currentSize == capacity) {
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty() {
        boolean status = false;
        if (currentSize == 0) {
            status = true;
        }
        return status;
    }

    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Đã đầy, không thể thêm phần tử " + item);
        } else {
            tail++;

            if (tail == capacity -1) {
                tail = 0;
            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("phần tử" + item + " đã thêm vào hàng đợi ");
        }
    }

    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Chưa đầy, không thể xóa phần tử khỏi hàng đợi");
        } else  {
            head++;

            if (head == capacity - 1) {
                System.out.println("đã xóa xong :" + queueArr[head - 1]);
            } else {
                System.out.println("đã xóa xong " + queueArr[ head - 1]);
            }
            currentSize--;
        }
    }

}
