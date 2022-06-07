package bai14;

import java.util.Scanner;

public class CharInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string: ");
        String str = input.nextLine();
        System.out.print("Enter char: ");
        String character = input.nextLine();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
            System.out.println(character.equals(str.charAt(i)));
        }
        System.out.printf("So lan %s xuat hien trong chuoi la %d", character, count);
    }
}
