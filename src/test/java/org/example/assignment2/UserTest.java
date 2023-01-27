package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testOfValueGiven(){
        ArrayList<Character> courses = new ArrayList<Character>();
        courses.add('A');
        courses.add('B');
        courses.add('C');
        courses.add('D');
        User user = new User("ram", 21, "everywhere", 12, courses);

        assertEquals("ram", user.name);
        assertEquals(21, user.age);
        assertEquals("everywhere", user.address);
        assertEquals(12, user.rollno);
        assertEquals(courses ,user.courses);
    }

}