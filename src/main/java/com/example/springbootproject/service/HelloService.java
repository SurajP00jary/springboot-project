package com.example.springbootproject.service;

import com.example.springbootproject.model.User;
import com.example.springbootproject.model.UserData;
import com.example.springbootproject.repository.UserDataRepository;
import com.example.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;

    // Constructor injection for UserRepository
    @Autowired
    public HelloService(UserRepository userRepository,UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
    }

    // Basic greeting message
    public String getGreeting() {
        return "Hello, Spring Boot!";
    }

    // Method to create and save a user to the database
    public User createUser(User user) {
        // Save user to the database
        return userRepository.save(user);
    }
    public UserData createUserData(UserData data) {
        System.out.println(data.getPhone());
        // Save user to the database
        return userDataRepository.save(data);
    }
}
