package bai3;

import java.util.Scanner;

public class Maxarray {
    public static void main(String[] args) {
        int temp=0;
        double max=Math.pow(-2,31);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size= scanner.nextInt();
        double array[]=new double[size];
        for (int i=0;i<size;i++){
            System.out.print("Enter money: ");
            array[i]= scanner.nextDouble();
        }
        for (int i=0;i<size;i++)
            if (array[i]>max) {
                max = array[i];
                temp=i;
            }
        System.out.println("Gia tri tai san lon nhat: "+max+" ti $ o vi tri "+temp);
    }
}
