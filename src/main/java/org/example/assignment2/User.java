package org.example.assignment2;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String name, address;
    private int rollno, age;
    private ArrayList<Character> courses;

    User(String name, int age, String address, int rollno, ArrayList<Character> courses) {
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

    ArrayList<Character> getCourses() {
        return this.courses;
    }

    @Override
    public String toString() {
        String str = String.format("%s\t\t%d\t\t%d\t%s\t", this.name, this.rollno,
                this.age, this.address);
        return str;
    }
}
