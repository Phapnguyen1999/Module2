package bai3;

import java.time.LocalTime;

public class StopWatch {
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalTime getStartTime(LocalTime startTime) {
        return startTime;
    }

    public LocalTime getEndTime(LocalTime endTime) {

        return endTime;
    }
    public void start(){
        this.startTime=LocalTime.now();
        getStartTime(startTime);
    }
    public void stop(){
        this.endTime=LocalTime.now();
        getEndTime(endTime);
    }
    public void getElapsedTime(){
        int ElapsedTime= (startTime.toSecondOfDay() -endTime.toSecondOfDay());
        System.out.println("So mili giay dem duoc: "+ElapsedTime);
    }
}
