package spring_testing.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorServiceTest {

    CalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
    }

    @Test
    void testAdd() {
        int result = service.add(10, 20);
        assertEquals(30, result);
    }

    @Test
    void testDivide() {
        int result = service.divide(20, 5);
        assertEquals(4, result);
    }

    @Test
    void testDivideByZero() {

        assertThrows(ArithmeticException.class, () -> {
            service.divide(20, 0);
        });

    }

}