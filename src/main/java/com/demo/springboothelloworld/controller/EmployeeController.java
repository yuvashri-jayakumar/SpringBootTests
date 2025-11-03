package com.demo.springboothelloworld.controller;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/api/employee") // (3)
    public Employee getEmployee(
            @RequestParam(name = "id", required = true) int id,
            @RequestParam(name = "name", required = false) String name,
                    @RequestParam(name = "department", required = false) String department,
            @RequestParam(name = "location", required = false) String location) {
        return employeeService.getEmployee(id,name,department,location);
    }

    @GetMapping("/api/employees") // (3)
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }
}
