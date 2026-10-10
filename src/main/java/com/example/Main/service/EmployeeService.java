package com.example.Main.service;

import com.example.Main.entity.Employee;
import com.example.Main.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // --- NEW METHOD ADDED HERE ---
    public long countDistinctCities() {
        return employeeRepository.countDistinctCities();
    }
    // -----------------------------

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }

    public Employee updateEmployee(int id, Employee employee) {
        Employee emp = employeeRepository.findById(id).orElse(null);

        if(emp != null){
            emp.setEmpName(employee.getEmpName());
            emp.setEmpAge(employee.getEmpAge());
            emp.setEmpCity(employee.getEmpCity());
            emp.setEmpState(employee.getEmpState());
            emp.setEmpPassword(employee.getEmpPassword());

            return employeeRepository.save(emp);
        }

        return null;
    }
}
