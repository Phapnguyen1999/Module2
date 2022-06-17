package bai1;

public class Square extends Shape {
    private double size = 1;

    public Square() {

    }

    public Square(double size) {
        this.size = size;
    }

    public Square(double size, String color, boolean filled) {
        super(color, filled);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return size * 4;
    }

    @Override
    public String toString() {
        return "A Square with size=" + getSize() + ", which is a subclass of " + super.toString();
    }
}
