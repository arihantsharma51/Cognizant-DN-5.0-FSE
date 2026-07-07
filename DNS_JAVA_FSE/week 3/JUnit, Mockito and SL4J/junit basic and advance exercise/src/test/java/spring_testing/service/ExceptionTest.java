package spring_testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    CalculatorService1 service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService1();
    }

    @Test
    void testValidDivision() {

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