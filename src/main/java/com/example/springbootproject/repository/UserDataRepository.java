package com.example.springbootproject.repository;

import com.example.springbootproject.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<UserData, Long> {
    // Custom query methods for UserData can go here if needed
}
