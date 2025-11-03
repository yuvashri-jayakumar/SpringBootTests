package com.demo.springboothelloworld.controller;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.model.GreetingResponse;
import com.demo.springboothelloworld.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.json.JsonAssert;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.jayway.jsonpath.internal.function.ParamType.JSON;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @MockitoBean
    private GreetingService greetingService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnGreeting() throws Exception {
        //given
        given(greetingService.sayHello("Hari")).willReturn("Hello World Hari");

        mockMvc.perform(get("/api/hello?name={name}","Hari"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.greeting", is("Hello World Hari")));
    }

    @Test
    void shouldReturnGreetingWithDefaultName() throws Exception {
        //given
        given(greetingService.sayHello(null)).willReturn("Hello World Yuva");

        //when
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/hello")
                .accept(String.valueOf(MediaType.APPLICATION_JSON));


       //then0;
        MvcResult result =  mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("""
{"greeting":"Hello World Yuva"}
"""
                        ))
                .andReturn();

    }




}