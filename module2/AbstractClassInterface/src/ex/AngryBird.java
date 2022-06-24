package ex;

public class AngryBird extends Animal implements  Flyable {
     public AngryBird(String name){
         super(name);
     }

    @Override
    public void fly() {
        System.out.println("bay bang cach dap canh");
    }

    @Override
    public String toString() {
        System.out.print(getName()+" is a bird ");
        fly();
                return super.toString();
    }
}
