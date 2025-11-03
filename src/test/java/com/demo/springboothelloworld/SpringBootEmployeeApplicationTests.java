package com.demo.springboothelloworld;

import com.demo.springboothelloworld.model.Employee;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = {"classpath:config.properties"})
public class SpringBootEmployeeApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    void contextLoads() throws JSONException {
        String response = this.restTemplate.getForObject("/api/employees", String.class);
        JSONAssert.assertEquals("""
[
    {
        "id": 1,
        "name": "Raj",
        "department": "IT",
        "location":"Chennai"
        },
        {
        "id": 2,
        "name": "Yuva",
        "department": "ECE",
        "location":"Bangalore"
        },
        {
        "id": 3,
        "name": "Naveen",
        "department": "EEE",
        "location":"Bangalore"
        }
        ]
        """,response, false);
    }
}
