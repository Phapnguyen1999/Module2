package bai6;

public class Prime20Number {
    public static void main(String[] args) {
        int countPrime = 0;
        for (int i = 1; countPrime < 20; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++)
                if (i % j == 0)
                    count++;
            if (count == 2) {
                countPrime++;
                System.out.print(i+" ");
            }
        }
    }
}
