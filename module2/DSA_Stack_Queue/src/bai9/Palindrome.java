package bai9;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {

        Stack stack = new Stack();
        Queue queue = new Queue();
        char c;
        Scanner scanner = new Scanner(System.in);
        System.out.print("String need test is : ");
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            stack.push(c);
            queue.enQueue(c);
        }
        String stringStack = "";
        String stringQueue = "";
        while (!stack.isEmpty()) {
            stringStack += stack.pop();
        }
        while (!queue.isEmpty()) {
            stringQueue += queue.deQueue();
        }

        if (stringStack.equals(stringQueue)) {
            System.out.println("is Palindrome !");
        } else System.out.println("Not is Palindrome !");
    }
}
