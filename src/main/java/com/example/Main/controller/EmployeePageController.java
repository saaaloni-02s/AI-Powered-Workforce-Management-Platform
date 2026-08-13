package com.example.Main.controller;

import com.example.Main.entity.Employee;
import com.example.Main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeePageController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public String saveEmployee(Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";

    }
    @GetMapping("/viewEmployees")
    public String viewEmployees(Model model) {

        model.addAttribute("employees", employeeService.getAllEmployees());

        return "viewEmployees";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){

        employeeService.deleteEmployee(id);

        return "redirect:/viewEmployees";

    }
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model model) {

        Employee employee = employeeService.getEmployeeById(id);

        model.addAttribute("employee", employee);

        return "editEmployee";
    }
    @PostMapping("/updateEmployee")
    public String updateEmployee(Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/viewEmployees";
    }
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "accessDenied";
    }
    @GetMapping("/add")
    public String addEmployeePage() {
        return "addEmployee";
    }
}
