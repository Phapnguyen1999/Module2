package bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDenta() > 0)
            System.out.printf("The equation has tow roots %.2f and %.2f",quadraticEquation.getRoot1(),quadraticEquation.getRoot2());
        else
            if (quadraticEquation.getDenta()==0)
                System.out.printf("The euqtion has one root %.2f",quadraticEquation.getRoot());
            else
                System.out.println("The equation has no real roots");

    }
}
