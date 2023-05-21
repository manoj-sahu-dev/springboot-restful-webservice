package com.manoj.springboot.restful.springbootrestfulwebservice.service;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    List<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
