package com.example.Main.controller;

import com.example.Main.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;

@Controller
public class PageController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String home(Model model, Authentication authentication){

        model.addAttribute("totalEmployees",
                employeeService.getAllEmployees().size());

        model.addAttribute("username", authentication.getName());

        // Fetch the distinct city count and send it to the dashboard
        model.addAttribute("totalLocations", employeeService.countDistinctCities());

        return "index";
    }

}

