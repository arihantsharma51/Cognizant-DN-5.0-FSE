package spring_learn.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import spring_learn.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceExceptionTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService service;

    @Test
    void testEmployeeNotFound() {

        when(repository.findById(100L))
                .thenReturn(Optional.empty());

        assertNull(service.getEmployeeById(100L));

    }

}