package com.souvik.model;

public class Subjects {
    private String name;
    private int mark;

    public Subjects(){

    }

    public Subjects(String name, int mark) {
        this.name = name;
        this.mark = mark;
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
        return "Subjects{" +
                "name='" + name + '\'' +
                ", mark=" + mark +
                '}';
    }
}
