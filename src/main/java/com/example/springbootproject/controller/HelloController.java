package com.example.springbootproject.controller;

import com.example.springbootproject.dto.ApiResponse;
import com.example.springbootproject.model.User;
import com.example.springbootproject.model.UserData;
import com.example.springbootproject.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
public class HelloController {

    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // Endpoint to return a greeting message
    @GetMapping("/get/users")
    public ResponseEntity<ApiResponse<Page<User>>> getAllUsers(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String sortDirection,
        @RequestParam(required = false) String search
    ) {
        Page<User> users = helloService.getAllUsers(page, size, sortBy, sortDirection,search);
        ApiResponse<Page<User>> response = new ApiResponse<>(
            200,
            "Users fetched successfully",
            users
        );
        return ResponseEntity.ok(response);
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
