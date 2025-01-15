package com.example.springbootproject.service;

import com.example.springbootproject.model.User;
import com.example.springbootproject.model.UserData;
import com.example.springbootproject.repository.UserDataRepository;
import com.example.springbootproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    // Basic getapi 
 public Page<User> getAllUsers(int page, int size, String sortBy, String sortDirection,String search) {
    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) 
                ? Sort.by(sortBy).ascending() 
                : Sort.by(sortBy).descending();
    Pageable pageable = PageRequest.of(page, size, sort);
    if (search != null && !search.isEmpty()) {
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(search, search, pageable);
    }
    return userRepository.findAll(pageable);
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
