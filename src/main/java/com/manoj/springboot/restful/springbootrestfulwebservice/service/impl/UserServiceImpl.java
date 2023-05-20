package com.manoj.springboot.restful.springbootrestfulwebservice.service.impl;

import org.springframework.stereotype.Service;

import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;
import com.manoj.springboot.restful.springbootrestfulwebservice.repository.UserRepository;
import com.manoj.springboot.restful.springbootrestfulwebservice.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

}
