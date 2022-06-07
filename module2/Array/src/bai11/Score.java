package bai11;

import java.util.Scanner;

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter size: ");
            size = scanner.nextInt();
            if (size > 30 || size < 1)
                System.out.println("Enter size again!");
        } while (size > 30 || size < 1);
        int array[] = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        int count = 0;
        System.out.println("List score: ");
        for (int i : array) {
            System.out.print(i + " ");
            if (i >= 5 && i <= 10)
                count++;
        }
        System.out.println();
        System.out.print("The number of students pass the exam is: " + count);
    }
}
