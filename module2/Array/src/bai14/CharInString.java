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
        for (int i = 0; i < str.length(); i++)
            if (character.charAt(0) == str.charAt(i))
                count++;
        System.out.printf("So lan '%s' xuat hien trong chuoi la %d", character, count);
    }
}
