package com.souvik.model;

import java.util.List;

public class Student {
    private String rollNumber;
    private String name;
    private String level;
    private String section;
    private List<Subjects> subjects;

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public Student(){

    }

    public Student(String rollNumber, String name, String level, String section) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.level = level;
        this.section = section;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNumber='" + rollNumber + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", section='" + section + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
