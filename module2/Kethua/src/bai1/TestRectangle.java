package bai1;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle();
        System.out.println(rec1);
        rec1 = new Rectangle(7, 8);
        System.out.println(rec1);
        rec1 = new Rectangle(10, 12, "pink", true);
        System.out.println(rec1);
        System.out.println("Area: " + rec1.getArea());
        System.out.println("Perimeter: " + rec1.getPerimeter());
    }
}
