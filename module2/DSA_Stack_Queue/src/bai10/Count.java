package bai10;

import java.util.LinkedList;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {

        LinkedList<Character> bStack = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("input string test  : ");
        String stringg = input.nextLine();
        boolean isTrue = true;
        for (int i = 0; i < stringg.length(); i++) {
            if (stringg.charAt(i) == '(') {
                bStack.push(stringg.charAt(i));
            } else if (stringg.charAt(i) == ')') {
                if (bStack.size() == 0) {
                    isTrue = false;
                    break;
                } else {
                    bStack.pop();
                }
            }
        }
        if (bStack.size() != 0) {
            isTrue = false;
        }
        if (isTrue) {
            System.out.println("Well");
        } else System.out.println("???");
    }
}
