package com.demo.springboothelloworld.service;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.repo.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {



    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void findAllEmployees() {

        given(employeeRepository.findAll()).willReturn(Arrays.asList(
                new Employee(1,"Test","Banking","Chennai"),
                new Employee(2,"Test1","Service","Chennai")
        ));

        List<Employee> actual = employeeService.findAllEmployees();
        assertEquals("Banking",actual.get(0).getDepartment());
        assertEquals("Service",actual.get(1).getDepartment());
    }
}