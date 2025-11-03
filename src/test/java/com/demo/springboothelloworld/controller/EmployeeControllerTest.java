package com.demo.springboothelloworld.controller;

import com.demo.springboothelloworld.model.Employee;
import com.demo.springboothelloworld.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeService employeeService;



    @Test
    void shouldReturnEmployee_WhenStrictTrue_JsonAssert() throws Exception {
        //given
        String expected = "{\"id\":1,\"name\":\"raj\"}";
        String actual = "{\"id\": 1,\"name\": \"raj\"}";


        JSONAssert.assertEquals(expected, actual,true );

    }
    @Test
    void shouldReturnEmployee_WhenStrictFalse_JsonAssert() throws Exception {
        //given
        String expected = "{\"id\":1}";
        String actual = "{\"id\": 1,\"name\": \"raj\"}";


        JSONAssert.assertEquals(expected, actual,false );

    }
    @Test
    void findAllEmployees() throws Exception {

        //given
        given(employeeService.findAllEmployees()).willReturn(Arrays.asList(
                new Employee(1,"Test","Banking","Chennai"),
                new Employee(2,"Test1","Service","Chennai")
        ));

        //when
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/employees")
                .accept(MediaType.APPLICATION_JSON);

        //then
        MvcResult result =  mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(content().json("""
[
    {
        "id": 1,
        "name": "Test",
        "department": "Banking",
        "location":"Chennai"
        },
        {
        "id": 2,
        "name": "Test1",
        "department": "Service",
        "location":"Chennai"
        }
        ]
        """))  .andReturn();

    }
}