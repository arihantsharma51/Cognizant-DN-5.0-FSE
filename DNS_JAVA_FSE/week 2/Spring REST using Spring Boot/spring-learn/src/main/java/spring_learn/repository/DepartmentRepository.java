package spring_learn.repository; // repository package

import org.springframework.data.jpa.repository.JpaRepository; // JPA support

import spring_learn.model.Department; // Department entity

public interface DepartmentRepository 
        extends JpaRepository<Department, Long> {
        // Department table
        // Long = primary key type

    // We can also add custom methods like:
    // List<Department> findByName(String name);
}