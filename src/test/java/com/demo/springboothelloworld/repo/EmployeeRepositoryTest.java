package com.demo.springboothelloworld.repo;

import com.demo.springboothelloworld.model.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findAllEmployees() {

       List<Employee> employees =  employeeRepository.findAll();

        assertEquals(3, employees.size());
    }

}