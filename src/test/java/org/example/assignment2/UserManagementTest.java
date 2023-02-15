package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserManagementTest {

    @Test
    public void testForValuesStored() {

        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 21;
        int nc = 4;
        ArrayList<COURSES> courses = new ArrayList<>();
        courses.add(COURSES.A);
        courses.add(COURSES.B);
        courses.add(COURSES.C);
        courses.add(COURSES.D);

        String input = name + "\n" + age + "\n" + address + "\n" + roll + "\n" + nc + "\n" + 1 + "\n" + 2 + "\n" + 3 + "\n" + 4 + "\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn((in));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Set<Integer> rollset = new HashSet<>();

        User result = UserManagement.getInstance().takeInput(new ArrayList<>(), rollset);
        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(roll, result.getRollno());
        assertEquals(address, result.getAddress());
        assertEquals(courses, result.getCourses());
    }


    //TODO : Error in generating this test case
    @Test
    public void testForTypeMistmatchInput() {
        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 21;
        int nc = 4;
        ArrayList<COURSES> courses = new ArrayList<>();
        courses.add(COURSES.A);
        courses.add(COURSES.B);
        courses.add(COURSES.C);
        courses.add(COURSES.D);

        String input = name + "\n" + "twenty" + "\n" + age + "\n" + address + "\n" + "one" + "\n" +
                roll + "\n" + nc + "\n" + 1 + "\n" + "one" + "\n" + 2 + "\n" + 3 + "\n" + 4 + "\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn((in));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Set<Integer> rollset = new HashSet<>();

        User result = UserManagement.getInstance().takeInput(new ArrayList<>(), rollset);

        String expectedPrintedOutput = "Enter name : Enter age : Please enter age in round off number.(ex: 22, 23)\n" +
                "Enter age : Enter address : Enter rollno : Please enter roll number in number.(ex: 1, 2)\n" +
                "Enter rollno : Enter number of courses : Choose 4 courses from \n" +
                "Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Please enter option number in number\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): courses added\n" +
                "User added successfully\n\n";
        assertEquals(expectedPrintedOutput, outputStream.toString());

    }

    @Test
    public void testForAllValidInput() {
        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 21;
        int nc = 4;
        ArrayList<COURSES> courses = new ArrayList<>();
        courses.add(COURSES.A);
        courses.add(COURSES.B);
        courses.add(COURSES.C);
        courses.add(COURSES.D);

        String input = name + "\n" + age + "\n" + address + "\n" + roll + "\n" + nc + "\n" + 1 + "\n" + 2 + "\n" + 3 + "\n" + 4 + "\n";

        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn((in));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Set<Integer> rollset = new HashSet<>();

        User result = UserManagement.getInstance().takeInput(new ArrayList<>(), rollset);

        String expectedPrintedOutput = "Enter name : Enter age : Enter address : Enter rollno : Enter number of courses : Choose 4 courses from \n" +
                "Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): Available Courses : \n" +
                "1.A\n" +
                "2.B\n" +
                "3.C\n" +
                "4.D\n" +
                "5.E\n" +
                "6.F\n" +
                "Enter option ex:-(1, 2, 3, 4, 5, or 6): courses added\n" +
                "User added successfully\n\n";
        assertEquals(expectedPrintedOutput, outputStream.toString());
    }
}
