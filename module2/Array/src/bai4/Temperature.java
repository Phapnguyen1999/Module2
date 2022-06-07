package bai4;

import java.util.Scanner;

public class Temperature {
    public static double celToFah(double C) {
        double F = (9.0 / 5) * C + 32;
        return F;
    }

    public static double fahToCel(double F) {
        double C = (5.0 / 9) * (F - 32);
        return C;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Fahrenheit: ");
                    fahrenheit = scanner.nextDouble();
                    System.out.println("Fahrenheit to Celsius: " + fahToCel(fahrenheit));
                    break;
                case 2:
                    System.out.print("Enter Celsius: ");
                    celsius = scanner.nextDouble();
                    System.out.println("Celsius to Fahrenheit: " + celToFah(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
}

