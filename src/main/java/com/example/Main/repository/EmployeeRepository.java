package com.example.Main.repository;

import com.example.Main.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT COUNT(DISTINCT e.empCity) FROM Employee e")
    long countDistinctCities();
}
