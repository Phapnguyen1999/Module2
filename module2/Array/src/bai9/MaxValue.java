package bai9;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Nhập số hàng của ma trận: ");
        int n = scanner.nextInt();
        System.out.print("Nhập số cột của ma trận: ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        double max=Math.pow(-2,31);
        System.out.print("Nhập các phần tử của mảng: \n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("a[%d][%d] = ", i, j);
                arr[i][j] = scanner.nextInt();
                if (arr[i][j]>max)
                    max=arr[i][j];
            }
        }
        System.out.println(max);

    }
}
