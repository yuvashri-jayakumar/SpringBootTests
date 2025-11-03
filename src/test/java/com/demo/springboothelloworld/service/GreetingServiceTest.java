package com.demo.springboothelloworld.service;

import com.demo.springboothelloworld.config.ApplicationProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {

    @Mock
    private ApplicationProperties applicationProperties;

    @InjectMocks
    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        System.out.println("setUp");
        given(applicationProperties.getGreeting()).willReturn("Hello World");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void shouldGreetWithDefaultName_When_ProvidedNameIsEmpty() {
        //given
        given(applicationProperties.getName()).willReturn("Yuva");
        //when
        String greeting = greetingService.sayHello(null);

        //then
        Assertions.assertEquals("Hello World Yuva", greeting);
    }

    @Test
    void shouldGreetWithGivenName_When_ProvidedNameIsNotEmpty() {
        //when
        String greeting = greetingService.sayHello("John");

        //then
        Assertions.assertEquals("Hello World John", greeting);
    }
}