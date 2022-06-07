package bai8;

import java.util.Scanner;

public class SayHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("My name is ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name);

    }
}
