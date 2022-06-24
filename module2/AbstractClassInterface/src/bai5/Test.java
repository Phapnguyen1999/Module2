package bai5;

public class Test {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Square(12);
        shapes[2] = new Rectangle(4,6);
        System.out.println("area of elements in array");
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof Square) {
                Colorable colorable = (Square) shape;
                colorable.howtoColor();
            }
        }
    }
}
