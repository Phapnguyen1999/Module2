package bai2;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1=new Car("Mercedes E300","I4 2.0L 1.991cc");
        System.out.println("Name:"+car1.getName()+" Engine:"+car1.getEngine()+" Number: "+car1.numberOfCars);
        Car car2=new Car("Mercedes S450","I6 2999cc");
        System.out.println("Name:"+car2.getName()+" Engine:"+car2.getEngine()+" Number: "+car2.numberOfCars);
    }

}
