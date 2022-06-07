package bai13;

import java.util.Scanner;

public class Sumnal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = scanner.nextInt();
        double arr[][] = new double[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arr[i][j] = scanner.nextInt();
            }
        double sum = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (i == j) sum += arr[i][j];
        System.out.print("Tong duong cheo chinh la: " + sum);
    }
}