package org.example.assignment2;

import java.io.Serializable;
import java.util.ArrayList;

enum COURSES{
    A, B, C, D, E, F
}

public class User implements Serializable {
    private String name, address;
    private int rollno, age;
    private ArrayList<COURSES> courses;

    User(String name, int age, String address, int rollno, ArrayList<COURSES> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollno = rollno;
        this.courses = courses;
    }

    String getName() {
        return this.name;
    }

    String getAddress() {
        return this.address;
    }

    int getRollno() {
        return this.rollno;
    }

    int getAge() {
        return this.age;
    }

    ArrayList<COURSES> getCourses() {
        return this.courses;
    }

    void setName(String name){
        this.name = name;
    }

    void setAddress(String address){
        this.address = address;
    }

    void setRollno(int rollno){
        this.rollno = rollno;
    }

    void setAge(int age){
        this.age = age;
    }

    void setCourses(ArrayList<COURSES> courses){
        this.courses = courses;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (var course : this.courses) {
            sb.append(course.toString());
            sb.append(", ");
        }
        String coursesString = sb.toString();
        coursesString = coursesString.substring(0, coursesString.length() - 2);

        String str = String.format("%s\t\t%d\t\t%d\t%s\t%s", this.name, this.rollno,
                this.age, this.address, coursesString);
        return str;
    }
}
