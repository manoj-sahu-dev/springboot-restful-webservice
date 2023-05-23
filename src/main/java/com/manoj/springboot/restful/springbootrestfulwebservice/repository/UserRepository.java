package com.manoj.springboot.restful.springbootrestfulwebservice.repository;

import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
