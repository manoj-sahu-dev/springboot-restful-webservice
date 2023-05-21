package com.manoj.springboot.restful.springbootrestfulwebservice.service;

import java.util.List;

import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long id);
}
