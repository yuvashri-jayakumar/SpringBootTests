package com.demo.springboothelloworld;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.boot.json.JsonParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonPathTest {

    @Test
    void shouldMatchSize(){

        String response = """
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
                """;

        DocumentContext context =  JsonPath.parse(response);
       List<Integer> ids = context.read("$..id");
        System.out.println(ids);
       String name =  context.read("$.[1].name");
        System.out.println(name);
        List<String> locations =   context.read("$..location");
       assertThat(locations).containsOnly("Chennai","Bangalore");
        System.out.println(context.read("$.[0:2]").toString());// starting index including // end index excluding
        System.out.println(context.read("$.[?(@.name=='Yuva')]").toString());
        System.out.println(context.read("*.name=='Yuva')]").toString());

    }
}
