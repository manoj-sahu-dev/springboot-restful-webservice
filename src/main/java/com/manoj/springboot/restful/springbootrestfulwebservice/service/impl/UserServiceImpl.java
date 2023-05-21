package com.manoj.springboot.restful.springbootrestfulwebservice.service.impl;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;
import com.manoj.springboot.restful.springbootrestfulwebservice.mapper.UserMapper;
import com.manoj.springboot.restful.springbootrestfulwebservice.repository.UserRepository;
import com.manoj.springboot.restful.springbootrestfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into user object
        User user = UserMapper.mapFromUserDto(userDto);
        User savedUser = userRepository.save(user);
        // convert user entity to UserDto
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long id) {
        var user = userRepository.findById(id);
        return UserMapper.mapToUserDto(user.get());
    }

    @Override
    public List<UserDto> getAllUsers() {
        var usersDto = userRepository.findAll();
        return usersDto.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
        return UserMapper.mapToUserDto(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).get();
        userRepository.delete(existingUser);
    }
}
