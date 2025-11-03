package com.demo.springboothelloworld.service;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employee getEmployee(int id, String name, String department, String location) {
        return new Employee(id,name,department,location);
    }

    public List<Employee> findAllEmployees() {
       return employeeRepository.findAll();
    }
}
