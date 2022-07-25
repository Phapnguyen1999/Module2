package bai8;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {

        Stack stack = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("Number need convert: ");
        int number = input.nextInt();

        int NUM = number;
        while (number != 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        System.out.println("result: " + NUM +
                " = " + "(" + str + ")" + "B");

    }
}
