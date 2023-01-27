package org.example.assignment2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class PartTest {

    @Test
    public void shouldTakeUserInput() {
        Part inputOutput= new Part();

        String name = "rishu anand";
        int age = 21;
        String address = "this address";
        int roll = 21;
        int nc = 4;

        String expectedoutput = "Enter name : " + name +
        "\nEnter age : " + age +
        "\nEnter address : " + address +
        "\nEnter rollno : " + roll +
        "Enter number of courses : " + nc +
        "\nEnter 4 courses : " + "A B C D\n";

        String input = name + "\n" + age + "\n" + address + "\n" + roll + "\n" + nc + "\n" + "A"
                + "\n" + "B" + "\n" + "C" + "\n" + "D" + "\n";

        InputStream in1 = new ByteArrayInputStream(input.getBytes());
        System.setIn((in1));

//        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outContent));
//        assertEquals(expectedoutput, Part.takeInput());
//        inputOutput.takeInput();
        assertEquals("rishu anand", Part.takeInput());
    }
}
