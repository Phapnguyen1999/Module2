package bai7;

import java.util.Scanner;

public class InsertElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = {1, 2, 4, 5, 7, 0, 0, 0, 0};
        System.out.println("Enter number: ");
        int numberInsert = scanner.nextInt();
        System.out.println("Enter index");
        int index = scanner.nextInt();
        if (index < 0 || index > array.length - 1) System.out.println("Khong chen duoc!");
        else {
            for (int i = array.length - 1; i >= index; i--)
                array[i] = array[i - 1];
            array[index] = numberInsert;
        }
        for (int i : array)
            System.out.print(i + " ");

    }
}
