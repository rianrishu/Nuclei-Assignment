package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(MockitoExtension.class)
class UserManagementTest {

    @Test
    public void shouldTakeUserInputName() {

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

        InputStream in1 = new ByteArrayInputStream(input.getBytes());
        System.setIn((in1));
        Set<Integer> rollset = new HashSet<>();

        User result = new UserManagement().takeInput(new ArrayList<>(), rollset);
        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(roll, result.getRollno());
        assertEquals(address, result.getAddress());
        assertEquals(courses, result.getCourses());
    }
}
