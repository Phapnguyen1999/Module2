package bai4;

public class Square extends Shape implements Resizeable {
    private double size;

    public Square(){

    }
    public Square(double size){
        this.size=size;
    }
    public Square (double size,String color,boolean filled){
        super(color, filled);
        this.size=size;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getArea(){
        return size*size;
    }
    public double getPerimeter(){
        return size*4;
    }

    @Override
    public String toString() {
        return "Square{" +
                "size=" + size +super.toString()+
                ", Area="+ getArea()+
                '}';
    }
    public void resize(double percent) {
        System.out.println("Area after resize: "+(getArea()+getArea()*(percent/100)));
    }
}
