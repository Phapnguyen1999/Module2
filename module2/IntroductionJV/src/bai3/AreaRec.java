package bai3;

import java.util.Scanner;

public class AreaRec {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap width");
        width = scanner.nextFloat();
        System.out.println("Nhap height");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("Dien tich la " + area);
    }
}
