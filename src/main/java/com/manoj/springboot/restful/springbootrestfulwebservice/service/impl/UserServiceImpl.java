package com.manoj.springboot.restful.springbootrestfulwebservice.service.impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return existingUser;
    }

    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).get();
        userRepository.delete(existingUser);
    }
}
