package houseHold;

import model.Person;

import java.util.Date;

public class HouseHold extends Person {
    private int numberOfpeople;
    private int numberOfhouse;
    private Person[] list;

    public HouseHold(int numberOfpeople,int numberOfhouse,String fullName, Date dayOfBirth, String job) {
        super(fullName, dayOfBirth, job);
        this.numberOfpeople=numberOfpeople;
        this.numberOfhouse=numberOfhouse;
    }

}
