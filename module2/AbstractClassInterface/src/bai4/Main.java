package bai4;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[3];
        Circle c=new Circle(7,"green",true);
        Rectangle r=new Rectangle(3,4,"blue",false);
        Square s=new Square(5,"orange",true);
        shapes[0]=c;
        shapes[1]=r;
        shapes[2]=s;
        for (Shape shape:shapes){
            System.out.println(shape);
        }
        double percent=Math.floor(Math.random()*100)+1;
        c.resize(percent);
//        percent=Math.floor(Math.random()*100)+1;
        r.resize(percent);
//        percent=Math.floor(Math.random()*100)+1;
        s.resize(percent);

    }
}
