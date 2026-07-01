package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(String name);

}