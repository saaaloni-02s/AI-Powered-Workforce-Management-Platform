package com.example.Main.controller;

import com.example.Main.ai.GeminiService;
import com.example.Main.entity.Employee;
import com.example.Main.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AIController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/ai-assistant")
    public String aiPage() {
        return "ai-assistant";
    }

    @PostMapping("/ai-assistant")
    public String askAI(@RequestParam String question, Model model) {

        List<Employee> employees = employeeRepository.findAll();

        StringBuilder employeeData = new StringBuilder();

        for (Employee emp : employees) {

            employeeData.append(
                    "Name: " + emp.getEmpName() +
                            ", Age: " + emp.getEmpAge() +
                            ", City: " + emp.getEmpCity() +
                            ", State: " + emp.getEmpState() +
                            "\n"
            );
        }

        String prompt = """
                You are an AI HR Assistant for an Employee Management System.

                Answer the user's question naturally.

                Here is the current employee information from the company's database:

                %s

                Important:
                - Use this employee information when the question is about current employees.
                - Do not invent employee information.
                - Never mention or expose passwords.
                - If the question is unrelated to employees or HR, answer it normally using your general knowledge.

                User question:
                %s
                """.formatted(employeeData, question);

        String response = geminiService.askGemini(prompt);

        model.addAttribute("question", question);
        model.addAttribute("response", response);

        return "ai-assistant";
    }
}