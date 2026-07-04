package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create Employee
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read Employee By Id
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Update Employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
    // PAGINATION
public Page<Employee> getEmployees(int page, int size) {

    Pageable pageable = PageRequest.of(page, size);

    return employeeRepository.findAll(pageable);

}

// SORT ASCENDING
public List<Employee> sortEmployees() {

    return employeeRepository.findAll(
            Sort.by("name")
    );

}

// SORT DESCENDING
public List<Employee> sortEmployeesDesc() {

    return employeeRepository.findAll(
            Sort.by("name").descending()
    );

}
}