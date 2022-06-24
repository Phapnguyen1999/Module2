package ex;

public class Siddeley extends Machine implements Flyable{
    public Siddeley(String name){
        super(name);
    }
    @Override
    public void fly() {
        System.out.println("bay bang dong co phan luc");
    }

    @Override
    public String toString() {
        System.out.println(" is a plane ");
        return super.toString();
    }
}
