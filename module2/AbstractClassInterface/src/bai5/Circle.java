package bai5;

public class Circle extends Shape {
    private double radius;

    public Circle() {}
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle have: " +
                + radius + " area " +
                getArea() + " Perimeter "
                + getPerimeter() +
                " color " + super.toString();
    }
}
