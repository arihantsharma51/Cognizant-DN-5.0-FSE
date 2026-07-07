package spring_testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorServiceTest2 {

    CalculatorService1 service = new CalculatorService1();

    @Test
    void testAddition() {
        assertEquals(15, service.add(10, 5));
    }

    @Test
    void testDivision() {
        assertEquals(5, service.divide(25, 5));
    }
}