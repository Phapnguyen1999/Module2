package bai4;

public class Main {
    public static void main(String[] args) {
        MyFan myFan1 = new MyFan(10, "yellow", true);
        myFan1.setSpeed(myFan1.getFAST());
        System.out.println(myFan1.toString());
    }
}
