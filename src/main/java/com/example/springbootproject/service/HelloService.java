package com.example.springbootproject.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String getGreeting() {
        return "Hello, Spring Boot!";
    }
}
