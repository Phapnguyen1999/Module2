package bai3;

public class Circle {
    private double radius=1;
    private String color="red";
    public Circle(){

    }
    public Circle(double radius){
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }
    public double getArea(double radius){
        this.radius=getRadius();
        return Math.PI*(Math.pow(radius,2));
    }
}
