package com.example.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootproject.service.HelloService;

@RestController
public class HelloController {
    private final HelloService helloService;

    public HelloController(HelloService helloService){
        this.helloService = helloService;

    }

    @GetMapping("/home")
    public String hello() {
        return helloService.getGreeting();
    }
}
