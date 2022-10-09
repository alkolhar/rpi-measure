package com.example.rpimeasure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // marks class as request handler (REST Controller)
public class RpiMeasureApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpiMeasureApplication.class, args);
    }

    @GetMapping("/hello") // mapping to GET request
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
