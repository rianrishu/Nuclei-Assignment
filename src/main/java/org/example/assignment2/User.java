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

    @Override
    public String toString() {
        String str = String.format("%s\t\t%d\t\t%d\t%s\t", this.name, this.rollno,
                this.age, this.address);
        return str;
    }
}
