package bai3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ArrayInteger {
    public static void main(String[] args) {
//        dao nguoc mang
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int arrays[] = new int[n];
        for (int i = 0; i < arrays.length; i++) {
            System.out.println("Element[" + i + "]: ");
            arrays[i] = scanner.nextInt();
            stack.push(arrays[i]);
        }
        System.out.println(Arrays.toString(arrays));
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arrays));
//    dao nguoc chuoi
        Stack<Character> wstack = new Stack<>();
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String str= sc.nextLine();
        String stackOut1="";
        for (int i=0;i<str.length();i++){
            wstack.push(str.charAt(i));
            stackOut1+=str.charAt(i);
        }
        System.out.println(wstack);
        System.out.println(stackOut1);
        String stackOut2="";
        for (int i=0;i<str.length();i++){
            stackOut2+=wstack.pop();
        }
        System.out.println(stackOut2);
    }
}
