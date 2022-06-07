package bai8;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do dai array 1: ");
        int size1 = scanner.nextInt();
        int array1[] = new int[size1];
        for (int i = 0; i < size1; i++) {
            System.out.println("Nhap phan tu " + i + " : ");
            array1[i] = scanner.nextInt();
        }
        System.out.print("Do dai array 2: ");
        int size2 = scanner.nextInt();
        int array2[] = new int[size2];
        for (int i = 0; i < size2; i++) {
            System.out.println("Nhap phan tu " + i + " : ");
            array2[i] = scanner.nextInt();
        }
        int array3[] = new int[size1 + size2];
        int j = 0;
        for (int i : array1) {
            array3[j] = i;
            j++;
        }
        for (int i : array2) {
            array3[j] = i;
            j++;
        }
        for (int i : array3)
            System.out.print(i + " ");
    }
}
