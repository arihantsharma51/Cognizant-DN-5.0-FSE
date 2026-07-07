package spring_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import spring_learn.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    List<Employee> findByNameContaining(String name);

    List<Employee> findByNameStartingWith(String name);

    List<Employee> findByNameEndingWith(String name);

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Employee searchByEmail(String email);

}