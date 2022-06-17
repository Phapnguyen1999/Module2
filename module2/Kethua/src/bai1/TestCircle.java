package bai1;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(7);
        System.out.println(circle);
        circle = new Circle("blue", true, 3.5);
        System.out.println(circle);
        circle.setRadius(-1);
        System.out.println(circle.getRadius());
        System.out.printf("%.2f", circle.getArea());
        System.out.println();
        System.out.printf("%.2f", circle.getPremeter());
    }
}
