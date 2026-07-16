package spring_learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring_learn.model.Employee;
import spring_learn.repository.EmployeeRepository;

@Service 
public class EmployeeService {

    @Autowired 
    private EmployeeRepository repo;


    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }
    public List<Employee> searchByName(String name) {
    return repo.findByNameContaining(name);
}

    
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }


    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}