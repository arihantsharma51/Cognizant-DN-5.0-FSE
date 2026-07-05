package spring_testing.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class CalculatorServiceTest {

    CalculatorService service;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("===== Starting Calculator Tests =====");
    }

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
        System.out.println("Object Created");
    }

    @Test
    void testAdd() {
        int result = service.add(10, 20);
        assertEquals(30, result);
    }

    @Test
    void testNotEquals() {
        int result = service.add(10, 20);
        assertNotEquals(50, result);
    }

    @Test
    void testTrue() {
        assertTrue(20 > 10);
    }

    @Test
    void testFalse() {
        assertFalse(20 < 10);
    }

    @Test
    void testNotNull() {
        assertNotNull(service);
    }

    @Test
    void testNull() {
        String name = null;
        assertNull(name);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Completed");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("===== All Tests Finished =====");
    }
}