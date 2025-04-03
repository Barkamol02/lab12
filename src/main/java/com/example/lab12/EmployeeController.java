package com.example.lab12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @GetMapping("/salary")
    public List<Employee> getEmployeesBySalary(@RequestParam Double threshold) {
        return repository.findBySalaryGreaterThanEqual(threshold);
    }
}
