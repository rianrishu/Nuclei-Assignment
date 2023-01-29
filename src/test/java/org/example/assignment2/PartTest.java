package org.example.assignment2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@ExtendWith(MockitoExtension.class)
class PartTest {

    @Test
    public void shouldTakeUserInputName() {

        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 21;
        int nc = 4;
        ArrayList<Character> courses = new ArrayList<>();
        courses.add('A');
        courses.add('B');
        courses.add('C');
        courses.add('D');

        String input = name + "\n" + age + "\n" + address + "\n" + roll + "\n" + nc + "\n" + "A" + "\n" + "B" + "\n" + "C" + "\n" + "D" + "\n";

        InputStream in1 = new ByteArrayInputStream(input.getBytes());
        System.setIn((in1));
        Set<Integer> rollset = new HashSet<>();

        User result = new Part().takeInput(rollset);
        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(roll, result.getRollno());
        assertEquals(address, result.getAddress());
        assertEquals(courses, result.getCourses());
    }
}
