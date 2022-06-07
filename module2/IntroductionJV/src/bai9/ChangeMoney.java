package bai9;

import java.util.Scanner;

public class ChangeMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("USD: ");
        double usd = scanner.nextDouble();
        System.out.print("VND: " + usd * 23000);
    }
}
