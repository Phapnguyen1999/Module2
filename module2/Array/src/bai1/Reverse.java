package bai1;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        int temp = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap size: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter array[" + i + "]: ");
            array[i] = scanner.nextInt();
        }
        for (int i : array)
            System.out.print(i + " ");
        for (int i = 0; i <= size / 2; i++) {
            temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
        System.out.println();
        for (int i : array)
            System.out.print(i + " ");


    }
}
