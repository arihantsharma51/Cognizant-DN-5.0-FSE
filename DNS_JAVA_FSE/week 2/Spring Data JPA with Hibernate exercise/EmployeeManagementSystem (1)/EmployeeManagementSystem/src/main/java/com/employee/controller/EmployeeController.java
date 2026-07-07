package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")

public class EmployeeController {
    

    @Autowired
    private EmployeeService employeeService;

    // CREATE
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }
    

    // READ ALL
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // UPDATE
    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
    // PAGINATION

    @GetMapping("/page")

    public Page<Employee> getEmployees(

    @RequestParam int page,

    @RequestParam int size

    ){

        return employeeService.getEmployees(page,size);

    }

    // SORT ASCENDING

    @GetMapping("/sort")

    public List<Employee> sortEmployees(){

        return employeeService.sortEmployees();

    }

    // SORT DESCENDING

    @GetMapping("/sortDesc")

    public List<Employee> sortEmployeesDesc(){

        return employeeService.sortEmployeesDesc();

    }
}
