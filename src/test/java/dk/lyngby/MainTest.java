package dk.lyngby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class MainTest {

    @BeforeAll
    static void setupAll() {
        // Initial setup code here
        System.out.println("Setup before all tests");
    }

    @BeforeEach
    void setUp() {
        // Setup code before each test
    }

    @AfterEach
    void tearDown() {
        // Cleanup code after each test
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> Main.main(new String[]{}), "Main method should not throw any exceptions");
    }
}