package spring_learn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import spring_learn.model.Employee;
import spring_learn.service.EmployeeService;

@RestController 
@RequestMapping("/employees") 
public class EmployeeController {

    @Autowired 
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

 
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

  
    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping
    public Employee update(@RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

  
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Deleted Successfully";
    }
}