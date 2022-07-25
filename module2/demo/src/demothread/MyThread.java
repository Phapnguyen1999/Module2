package demothread;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MyThread m1= new MyThread();
        m1.start();
        MyThread m2= new MyThread();
        m2.start();
        System.out.println("list: ");

//        3 tieu trinh dang chay song song
    }
}
