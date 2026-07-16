package spring_learn.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import spring_learn.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    void testFindByNameContaining() {

        Employee emp = new Employee();
        emp.setName("Rahul");
        emp.setEmail("rahul@gmail.com");

        repository.save(emp);

        List<Employee> employees = repository.findByNameContaining("Rah");

        assertFalse(employees.isEmpty());

        assertEquals("Rahul", employees.get(0).getName());

    }

}