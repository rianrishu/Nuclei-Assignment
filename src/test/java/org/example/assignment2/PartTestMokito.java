package org.example.assignment2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PartTestMokito {

    @Mock
    private Scanner ms;

    @InjectMocks
    private Part part;

    @Test
    public void testInputMethod() {
        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 22;
        int nc = 4;
        ArrayList<Character> courses = new ArrayList<>();
        courses.add('A');
        courses.add('B');
        courses.add('C');
        courses.add('D');

        when(ms.nextLine()).thenReturn(name, address);
        when(ms.nextInt()).thenReturn(age, roll, nc);
        when(ms.next()).thenReturn("A", "B", "C", "D");

        User result = part.takeInput(new HashSet<>(), ms);

        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(roll, result.getRollno());
        assertEquals(address, result.getAddress());
        assertEquals(courses, result.getCourses());


    }
}