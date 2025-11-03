package com.demo.springboothelloworld;

import com.demo.springboothelloworld.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class SpringBootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloworldApplication.class, args);
    }

}
