package bai3;

public class Circle {
    private String color = "red";
    private int radius = 1;
    private boolean filled = true;

    public Circle() {

    }

    public Circle(int radius) {

        this.radius = radius;
    }

    public Circle(int radius, String color, boolean filled) {
        this.radius = radius;
        this.color = color;
        this.filled = filled;
    }

    public double getRadius() {

        return radius;
    }

    public void setRadius(int radius) {

        this.radius = radius;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {

        this.filled = filled;
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
                "color='" + color + '\'' +
                ", radius=" + radius +
                ", filled=" + filled +
                '}';
    }
}
