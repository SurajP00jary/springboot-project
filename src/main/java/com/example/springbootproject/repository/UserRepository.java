package com.example.springbootproject.repository;
import com.example.springbootproject.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Optional, but good practice
public interface UserRepository extends JpaRepository<User, Long> {
        Page<User> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email, org.springframework.data.domain.Pageable pageable);
    // You can add custom queries if needed, but JpaRepository gives you many useful methods like save, findAll, findById, etc.
}
