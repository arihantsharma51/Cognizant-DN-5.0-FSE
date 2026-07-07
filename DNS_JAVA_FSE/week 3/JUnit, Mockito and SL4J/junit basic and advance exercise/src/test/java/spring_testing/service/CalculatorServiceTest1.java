package spring_testing.service;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorServiceTest1 {

    CalculatorService1 service;

    @BeforeAll
    static void beforeAll() {
        System.out.println("===== Starting All Tests =====");
    }

    @BeforeEach
    void setUp() {
        service = new CalculatorService1();
        System.out.println("Calculator Object Created");
    }

    @ParameterizedTest
    @CsvSource({
        "10,20,30",
        "5,5,10",
        "100,200,300",
        "0,0,0",
        "-10,20,10"
    })
    void testAddParameterized(int a, int b, int expected) {

        // Arrange

        // Act
        int result = service.add(a, b);

        // Assert
        assertEquals(expected, result);

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