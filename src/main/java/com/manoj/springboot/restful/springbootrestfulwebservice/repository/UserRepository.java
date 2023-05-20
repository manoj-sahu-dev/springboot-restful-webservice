package com.manoj.springboot.restful.springbootrestfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
