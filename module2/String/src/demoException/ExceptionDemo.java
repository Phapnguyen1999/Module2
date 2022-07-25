package demoException;

public class ExceptionDemo {
    public static void main(String args[]) {
        int x = 10;
        int y = 10;
        try {
            int num = y / x;
        } catch (Exception ex) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        System.out.println("next-statement: Outside of try-catch");
    }
}
