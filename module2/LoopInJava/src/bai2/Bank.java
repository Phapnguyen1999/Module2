package bai2;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("So tien gui ");
        double money = scanner.nextDouble();
        System.out.print("Lai suat ");
        double laisuat = scanner.nextDouble();
        System.out.print("So thang gui ");
        int month = scanner.nextInt();
        double tienlai = 0;
        tienlai += money * ((laisuat / 100)) / 12 * month;
        System.out.printf("Tien lai %.3f\n ", tienlai);
    }
}
