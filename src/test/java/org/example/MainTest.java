package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testMainOutput() {
        Main.main(new String[]{});
        String output = outContent.toString();

        assertTrue(output.contains("Hello and welcome!"));
        assertTrue(output.contains("Fruits: [apple, banana, cherry]"));
        assertTrue(output.contains("Colors:"));
        assertTrue(output.contains("red"));
        assertTrue(output.contains("green"));
        assertTrue(output.contains("blue"));
        assertTrue(output.contains("Scores:"));
        assertTrue(output.contains("Alice=95"));
        assertTrue(output.contains("Bob=82"));
        assertTrue(output.contains("Charlie=78"));
        for (int i = 1; i <= 5; i++) {
            assertTrue(output.contains("i = " + i));
        }
    }
}
