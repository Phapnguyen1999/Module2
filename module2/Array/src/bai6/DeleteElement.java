package bai6;

import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int array[] = {1, 2, 3, 4, 3, 5};
        System.out.println("Nhap phan tu can xoa: ");
        int elementDelete = scanner.nextInt();
        for (int i = 0; i < array.length; i++)
            if (array[i] == elementDelete)
                System.out.print(i + " ");
        int x = array.length;
        for (int k = 0; k < array.length; k++)
            for (int i = 0; i < array.length; i++) {
                if (array[i] == elementDelete)
                    for (int j = i; j < x - 1; j++) {
                        array[i] = array[j + 1];
                        i++;
                    }
            }
        System.out.println();
        for (int i : array)
            System.out.print(i + " ");
    }
}
