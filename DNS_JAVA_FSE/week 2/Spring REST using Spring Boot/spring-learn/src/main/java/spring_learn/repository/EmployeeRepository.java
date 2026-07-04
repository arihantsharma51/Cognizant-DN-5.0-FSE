package spring_learn.repository; 
import org.springframework.data.jpa.repository.JpaRepository; 

import spring_learn.model.Employee; 

public interface EmployeeRepository 
        extends JpaRepository<Employee, Long> {
}