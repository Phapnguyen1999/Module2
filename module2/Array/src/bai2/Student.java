package bai2;

import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        int count = 0;
        String[] students = {"Trung", "Luong", "Tien", "Thanh", "Vu", "Phap" };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String inputName = scanner.nextLine();
        for (int i = 0; i < students.length; i++)
            if (students[i].equals(inputName)) {
                count++;
                System.out.println("Position of the students in the list" + inputName + " is: " + i);
                break;
            }
        if (count == 0)
            System.out.println("Not found " + inputName + " in the list");
    }
}
