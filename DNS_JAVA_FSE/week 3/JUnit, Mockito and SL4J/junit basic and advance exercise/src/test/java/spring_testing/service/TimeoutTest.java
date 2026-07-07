package spring_testing.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TimeoutTest {

    CalculatorService1 service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService1();
    }

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testProcessData() {

        assertDoesNotThrow(() -> service.processData());

    }

}