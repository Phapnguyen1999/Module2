package bai10;

import java.util.Scanner;

public class MininArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        System.out.print("Enter value: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int min = array[0];
        for (int i : array)
            if (i < min)
                min = i;
        System.out.println("Min is: " + min);
    }
}
