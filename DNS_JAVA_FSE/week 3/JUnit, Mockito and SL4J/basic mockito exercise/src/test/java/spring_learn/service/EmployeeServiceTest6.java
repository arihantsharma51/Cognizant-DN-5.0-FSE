package spring_learn.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring_learn.model.Employee;
import spring_learn.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest6 {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void testMultipleReturns() {

        Employee emp1 = new Employee();
        emp1.setId(1L);
        emp1.setName("Rahul");

        Employee emp2 = new Employee();
        emp2.setId(2L);
        emp2.setName("Amit");

        Employee emp3 = new Employee();
        emp3.setId(3L);
        emp3.setName("Rohan");

        when(repository.findById(1L))
                .thenReturn(Optional.of(emp1))
                .thenReturn(Optional.of(emp2))
                .thenReturn(Optional.of(emp3));

        assertEquals("Rahul", service.getEmployeeById(1L).getName());

        assertEquals("Amit", service.getEmployeeById(1L).getName());

        assertEquals("Rohan", service.getEmployeeById(1L).getName());

        verify(repository, times(3)).findById(1L);

    }

}