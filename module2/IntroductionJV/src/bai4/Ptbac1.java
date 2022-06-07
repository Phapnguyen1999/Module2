package bai4;

import java.util.Scanner;

public class Ptbac1 {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b; ");
        double b = scanner.nextDouble();
        System.out.println("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            double x = (c - b) / a;
            System.out.printf("Phuong trinh co nghiem la %f!\n", +x);
        } else if (b == c) {
            System.out.print("Phuong trinh vo so nghiem");
        } else {
            System.out.print("Phuong trinh vo nghiem");
        }
    }
}
