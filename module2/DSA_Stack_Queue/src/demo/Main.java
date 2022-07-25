package demo;


import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Tạo Queue sử dụng class LinkedList
        Queue<Integer> numbers = new LinkedList<>();

//        // Chèn phần tử chỉ định vào Queue bằng phương thức offer
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue: " + numbers);
        // Truy cập các phần tử trong Queue
        int accessedNumber = numbers.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);
        accessedNumber = numbers.peek();
        System.out.println("Truy cập phần tử: " + accessedNumber);

//
//        // Loại bỏ các phần tử tron Queue
//        int removedNumber = numbers.poll();
//        System.out.println("Loại bỏ phần tử: " + removedNumber);
//
//        System.out.println("Cập nhật Queue: " + numbers);
    }
}
