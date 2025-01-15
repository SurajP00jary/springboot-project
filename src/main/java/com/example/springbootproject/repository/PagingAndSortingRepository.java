package com.example.springbootproject.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootproject.model.User;

public interface PagingAndSortingRepository extends JpaRepository<User,Long> {
    
}
