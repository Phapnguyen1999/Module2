package bai1;

public class TestSquare {
    public static void main(String[] args) {
        Square s1 = new Square();
        System.out.println(s1);
        s1 = new Square(4);
        System.out.println(s1);
        s1 = new Square(6, "Black", false);
        System.out.println(s1);
        System.out.println("Area: " + s1.getArea());
        System.out.println("Premiter: " + s1.getPerimeter());
    }
}
