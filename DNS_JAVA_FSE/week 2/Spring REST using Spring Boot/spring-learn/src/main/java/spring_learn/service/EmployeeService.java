package spring_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_learn.model.Employee;
import spring_learn.repository.EmployeeRepository;

@Service // business logic layer
public class EmployeeService {

    @Autowired // inject repository
    private EmployeeRepository repo;

    // CREATE / UPDATE
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // READ BY ID
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}