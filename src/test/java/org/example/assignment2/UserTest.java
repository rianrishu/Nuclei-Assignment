package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testOfValueGiven() {
        ArrayList<Character> courses = new ArrayList<>();
        courses.add('A');
        courses.add('B');
        courses.add('C');
        courses.add('D');
        User user = new User("ram", 21, "everywhere", 12, courses);

        assertEquals("ram", user.getName());
        assertEquals(21, user.getAge());
        assertEquals("everywhere", user.getAddress());
        assertEquals(12, user.getRollno());
        assertEquals(courses, user.getCourses());
    }

}