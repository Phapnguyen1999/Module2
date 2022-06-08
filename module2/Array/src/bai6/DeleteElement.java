package bai6;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = {1, 2, 3, 4, 3, 5};
        int array2[]=new int[array.length];
        System.out.println("Nhap phan tu can xoa: ");
        int elementDelete = scanner.nextInt();
//        for (int i = 0; i < array.length; i++)
//            if (array[i] == elementDelete)
//                System.out.print(i + " ");
//        int x = array.length;
//        for (int k = 0; k < array.length; k++)
//            for (int i = 0; i < array.length; i++) {
//                if (array[i] == elementDelete)
//                    for (int j = i; j < x - 1; j++) {
//                        array[i] = array[j + 1];
//                        i++;
//                    }
//            }
        int j=0;
        int count=0;
        for (int i:array)
            if (i==elementDelete) {
                count++;
                continue;
            } else {
                array2[j]=i;
                j++;
            }
        for (int i=0;i< array2.length-count;i++)
            System.out.print(array2[i]+" ");

//
//        System.out.println();
//        for (int i : array)
//            System.out.print(i + " ");
    }
}
