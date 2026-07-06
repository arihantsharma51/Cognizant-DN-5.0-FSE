package spring_testing.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorServiceTest {

    CalculatorService service;

    @BeforeAll
    static void beforeAll() {
        System.out.println("===== Starting All Tests =====");
    }

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
        System.out.println("Calculator Object Created");
    }

    @Test
    void testAdd() {

        // Arrange
        int a = 10;
        int b = 20;

        // Act
        int result = service.add(a, b);

        // Assert
        assertEquals(30, result);
    }

    @Test
    void testDivide() {

        // Arrange
        int a = 20;
        int b = 5;

        // Act
        int result = service.divide(a, b);

        // Assert
        assertEquals(4, result);
    }

    @Test
    void testDivideByZero() {

        // Arrange
        int a = 20;
        int b = 0;

        // Act & Assert
        assertThrows(ArithmeticException.class, () -> service.divide(a, b));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Finished");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("===== All Tests Completed =====");
    }
}