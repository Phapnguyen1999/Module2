package bai7;

import java.util.Arrays;
import java.util.Scanner;

public class InsertElement {
    public static int[] insertNumber(int number, int index, int arr[]) {
        int arr2[] = new int[arr.length + 1];
        int j = 0;
        for (int i = 0; i < index; i++) {
            arr2[j] = arr[i];
            j++;
        }
        arr2[index] = number;
        j++;
        for (int i = index; i < arr.length; i++) {
            arr2[j] = arr[i];
            j++;
        }
        return arr2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size array: ");
        int size = scanner.nextInt();
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("array[%d]= ", i);
            array[i] = scanner.nextInt();
        }
            System.out.println("Enter number: ");
            int numberInsert = scanner.nextInt();
            System.out.println("Enter index");
            int index = scanner.nextInt();
            insertNumber(numberInsert, index, array);
        System.out.println(Arrays.toString(insertNumber(numberInsert, index, array)));
//        int array2[]=new int[array.length+1];
////        if (index < 0 || index > array.length - 1) System.out.println("Khong chen duoc!");
////        else {
////            for (int i = array.length - 1; i >= index; i--)
////                array[i] = array[i - 1];
////            array[index] = numberInsert;
////        }
////        for (int i : array)
////            System.out.print(i + " ");
//        int j=0;
//        for (int i=0;i<index;i++){
//            array2[j]=array[i];
//            j++;
//        }
//        array2[index]=numberInsert;
//        j++;
//        for (int i=index;i<array.length;i++){
//            array2[j]=array[i];
//            j++;
//        }
//        for (int i:array2)
//            System.out.print(i+" ");
    }
}
