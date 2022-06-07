package bai5;

public class MinValue {
    public static int minArray(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++)
            if (array[i] < array[index])
                index = i;
        return index;
    }

    public static void main(String[] args) {
        int numbers[] = {4, 6, 2, 8, -3, 0, -8, 6, 3};
        int index = minArray(numbers);
        System.out.println("Phan tu nho nhat nam o vi tri: " + index);
    }
}
