package com.demo.springboothelloworld.controller;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.model.GreetingResponse;
import com.demo.springboothelloworld.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/api/hello") // (3)
    public GreetingResponse sayHello(
            @RequestParam(name = "name", required = false) String name) {
        String greeting = greetingService.sayHello(name);
        return new GreetingResponse(greeting);
    }


}
