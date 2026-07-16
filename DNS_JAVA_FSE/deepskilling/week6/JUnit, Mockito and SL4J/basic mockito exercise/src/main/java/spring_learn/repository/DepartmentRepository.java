package spring_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import spring_learn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findByName(String name);

}