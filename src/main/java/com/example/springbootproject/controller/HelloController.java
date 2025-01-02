package com.example.springbootproject.controller;

import com.example.springbootproject.model.User;
import com.example.springbootproject.model.UserData;
import com.example.springbootproject.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // Endpoint to return a greeting message
    @GetMapping("/home")
    public String hello() {
        return helloService.getGreeting();
    }

    // Endpoint to create a new user and save to the database
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return helloService.createUser(user); // Calls the service to save the user
    }

    // Endpoint to create UserData and save it to the database
    @PostMapping("/users/data")
    public UserData createUserData(@RequestBody UserData data) {
        // Save UserData and return the saved UserData object
        return helloService.createUserData(data);
    }
}
