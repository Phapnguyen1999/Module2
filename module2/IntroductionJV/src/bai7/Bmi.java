package bai7;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap can nang ");
        double weight = scanner.nextDouble();
        System.out.println("Nhap chieu cao");
        double height = scanner.nextDouble();
        double bmi = weight / (Math.pow(height, 2));
        System.out.printf("%-20s%s", "bmi", "Interpretation\n");
        if (bmi < 18.5)
            System.out.printf("%-20.2f%s", bmi, "Underweight");
        else if (bmi < 25)
            System.out.printf("%-20.2f%s", bmi, "Normal");
        else if (bmi < 30)
            System.out.printf("%-20.2f%s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%s", bmi, "Obese");
    }
}
