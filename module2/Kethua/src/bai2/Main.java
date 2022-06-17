package bai2;

import bai3.Point3D;

public class Main {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder(5, 4, "green");
        System.out.println(c1);
        System.out.println("Area:" + c1.getVol());
    }

}
