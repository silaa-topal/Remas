package com.company.remasbackend.controller;

import com.company.remasbackend.model.Admin;
import com.company.remasbackend.model.Employee;
import com.company.remasbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("api/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees. (works!)
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //add new employee. (works!)
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
}
