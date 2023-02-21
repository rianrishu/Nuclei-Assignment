package org.example.assignment2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserManagementTestUsingMockito {

    @Mock
    private Scanner scanner;

    @InjectMocks
    private UserManagement userManagement;

    @Test
    public void testInputMethod() {
        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 22;
        int nc = 4;
        ArrayList<COURSES> courses = new ArrayList<>();
        courses.add(COURSES.A);
        courses.add(COURSES.B);
        courses.add(COURSES.C);
        courses.add(COURSES.D);

        when(scanner.nextLine()).thenReturn(name, address);
        when(scanner.nextInt()).thenReturn(age, roll, nc, 1, 2, 3, 4);

        Set<Integer> rollset = new HashSet<>();

        User result = UserManagement.getInstance().takeInput(new ArrayList<>(), rollset, scanner);

        assertEquals(name, result.getName());
        assertEquals(age, result.getAge());
        assertEquals(roll, result.getRollno());
        assertEquals(address, result.getAddress());
        assertEquals(courses, result.getCourses());

    }

}