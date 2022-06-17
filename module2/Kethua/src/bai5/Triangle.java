package bai5;

import java.util.Arrays;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {

    }

    public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double[] getTriangle() {
        double[] array = {side1, side2, side3};
        return array;
    }

    public void setTriangle(double side1, double side2, double side3) {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        } else {
            System.out.println("Khong hinh thanh duoc tam giac!");
            return;
        }
    }

    public double getArea() {
        getTriangle();
        double p = (side1 + side2 + side3) / 2;
        double s = Math.pow(p * (p - side1) * (p - side2) * (p - side3), 0.5);
        return Math.round(s*100.0)/100.0;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        if (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1) {
            return Arrays.toString(getTriangle())
                    + " Is a Triangle! ;" + " Area is: " + getArea()
                    + "; Perimeter: " + getPerimeter() + " " + super.toString();
        } else {
            return "Khong hinh thanh duoc tam giac!";
        }
    }
}
