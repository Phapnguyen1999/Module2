package model;

import java.util.Date;

public class Person {
    private String fullName;
    private Date dayOfBirth;
    private String job;

    public Person(String fullName, Date dayOfBirth, String job){
        this.fullName=fullName;
        this.dayOfBirth=dayOfBirth;
        this.job=job;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", dayOfBirth=" + dayOfBirth +
                ", job='" + job + '\'' +
                '}';
    }
}
