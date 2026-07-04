package spring_learn.repository; // repository package

import org.springframework.data.jpa.repository.JpaRepository; // JPA repository

import spring_learn.model.Employee; // Employee entity

public interface EmployeeRepository 
        extends JpaRepository<Employee, Long> {
        // Employee = table name (Entity)
        // Long = primary key type (id)

    // Spring automatically gives:
    // save(), findAll(), findById(), deleteById()
}