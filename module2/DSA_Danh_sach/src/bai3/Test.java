package bai3;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> m1=new MyList<Integer>();
        m1.add(1,5);
        m1.add(2,7);
        m1.add(3,9);
        m1.add(4,3);
        m1.add(5,3);
        m1.add(6,3);
        System.out.println(m1.get(2));
        System.out.println(m1.remove(3));
        System.out.println(m1.size());
        System.out.println(m1.contains(6));
        double a=0.1;
        double b=0.3;
        System.out.println(a+b);
    }
}
