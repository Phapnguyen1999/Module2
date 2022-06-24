package bai4;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;

    public Rectangle(){

    }
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }
    public Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.width=width;
        this.height=height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return width*height;
    }
    public double getPerimeter(){
        return (width+height)*2;
    }
    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height + super.toString()+
                ", Area="+getArea()+
                '}';
    }

    @Override
    public void resize(double percent) {
        System.out.println("Area after resize: "+(getArea()+getArea()*(percent/100)));
    }
}
