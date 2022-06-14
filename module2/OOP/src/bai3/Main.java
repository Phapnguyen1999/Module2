package bai3;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Dang dem thoi gian...");
        for (int i = 1; i <= 1000000; i++) {
            stopWatch.stop();
            stopWatch.getElapsedTime();
        }
    }
}
