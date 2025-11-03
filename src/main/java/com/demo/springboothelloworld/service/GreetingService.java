package com.demo.springboothelloworld.service;

import com.demo.springboothelloworld.config.ApplicationProperties;
import com.demo.springboothelloworld.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    private final ApplicationProperties applicationProperties;

    @Autowired
    public GreetingService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public String sayHello(String name) {
        String s = name == null ? applicationProperties.getName(): name;
        return String.format("%s %s", applicationProperties.getGreeting(), s);
    }



}
