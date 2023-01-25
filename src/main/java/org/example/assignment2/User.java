package org.example.assignment2;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    String name, address;
    int rollno, age;
    ArrayList<Character> courses;
    User(String name, int age, String address, int rollno, ArrayList<Character> courses){
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollno = rollno;
        this.courses = courses;
    }

    void display(){
        System.out.print(this.name + "\t" + this.rollno + "\t\t" + this.age + "\t" + this.address + "\t\t");
        for(char it : courses){
            System.out.print(it + ", ");
        }
        System.out.println();
    }
}
