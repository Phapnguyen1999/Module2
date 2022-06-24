package bai4;

public class Circle extends Shape implements Resizeable {

    private double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {

        this.radius = radius;
    }

    public double getArea() {

        return radius * radius * Math.PI;
    }

    public double getPerimeter() {

        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius + super.toString() +
                ", Area="+getArea()+
                '}';
    }

    @Override
    public void resize(double percent) {
        System.out.println("Area after resize: "+(getArea()+getArea()*(percent/100)));
    }
}
