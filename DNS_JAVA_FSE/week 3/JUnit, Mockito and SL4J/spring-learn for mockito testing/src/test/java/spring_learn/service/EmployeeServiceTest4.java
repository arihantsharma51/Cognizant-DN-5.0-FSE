package spring_learn.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
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
public class EmployeeServiceTest4 {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void testAnyLongMatcher() {

        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Rahul");
        employee.setEmail("rahul@gmail.com");

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(employee));

        Employee result = service.getEmployeeById(100L);

        verify(repository).findById(anyLong());

        assertEquals("Rahul", result.getName());

    }

}