package bai12;

import java.util.Scanner;

public class SumColum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so hang: ");
        int m = scanner.nextInt();
        ;
        System.out.print("Nhap so cot: ");
        int n = scanner.nextInt();
        double arr[][] = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                System.out.printf("arr[%d][%d] = ", i, j);
                arr[i][j] = scanner.nextInt();
            }
        System.out.print("Nhap cot muon tinh tong: ");
        int colum = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (j == colum)
                    sum += arr[i][j];
        System.out.printf("Cot " + colum + " co tong la: " + sum);
    }
}
