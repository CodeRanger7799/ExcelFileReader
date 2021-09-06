package com.souvik.model;

public class SubjectsDto {
    private String rollNumber;
    private String name;
    private int mark;

    public SubjectsDto(){

    }

    public SubjectsDto(String rollNumber, String name, int mark) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.mark = mark;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "SubjectsDto{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
