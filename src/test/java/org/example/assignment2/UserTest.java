package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testOfValueGiven() {
        ArrayList<COURSES> courses = new ArrayList<>();

        courses.add(COURSES.A);
        courses.add(COURSES.B);
        courses.add(COURSES.C);
        courses.add(COURSES.D);
        User user = new User("ram", 21, "everywhere", 12, courses);

        assertEquals("ram", user.getName());
        assertEquals(21, user.getAge());
        assertEquals("everywhere", user.getAddress());
        assertEquals(12, user.getRollno());
        assertEquals(courses, user.getCourses());
    }

}