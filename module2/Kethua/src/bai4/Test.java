package bai4;

import bai3.Point3D;

public class Test {
    public static void main(String[] args) {
        Point p=new Point();
        System.out.println(p);
        p=new Point(7,8);
        System.out.println(p);
        MovablePoint mova1=new MovablePoint(7,8,8,9);
        System.out.println(mova1.move());
    }
}
