package ex;

public class Bolt extends Animal implements Barkable, Runable {
    public Bolt(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("chay 4 chan");
    }

    @Override
    public void bark() {
        System.out.println("Gau gau .....");
    }

    @Override
    public String toString() {
        System.out.print(getName()+" is a dog ");
        run();
        bark();
        return super.toString();
    }
}
