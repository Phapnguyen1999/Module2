package bai3;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1=new Circle(8);
        System.out.println(c1.getRadius());
        System.out.println("Radius is: "+c1.getRadius()+" Area is: "+ c1.getArea(c1.getRadius()));
    }
}
