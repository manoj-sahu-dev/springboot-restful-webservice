package com.manoj.springboot.restful.springbootrestfulwebservice.service.impl;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;
import com.manoj.springboot.restful.springbootrestfulwebservice.mapper.AutoUserMapper;
import com.manoj.springboot.restful.springbootrestfulwebservice.repository.UserRepository;
import com.manoj.springboot.restful.springbootrestfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDto into user object
        //User user = UserMapper.mapFromUserDto(userDto);
//        User user = modelMapper.map(userDto, User.class);
        User user = AutoUserMapper.getInstance.mapToUser(userDto);

//        User savedUser = userRepository.save(user);
        User savedUser = userRepository.save(user);

        // convert user entity to UserDto
        //return UserMapper.mapToUserDto(savedUser);
//        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoUserMapper.getInstance.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        var optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
//        return modelMapper.map(user, UserDto.class);
        return AutoUserMapper.getInstance.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        var usersDto = userRepository.findAll();
//        return usersDto.stream().map((user -> modelMapper.map(user, UserDto.class))).collect(Collectors.toList());
        return usersDto.stream().map((user -> AutoUserMapper.getInstance.mapToUserDto(user))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        userRepository.save(existingUser);
//        return UserMapper.mapToUserDto(existingUser);
//        return modelMapper.map(existingUser, UserDto.class);
        return AutoUserMapper.getInstance.mapToUserDto(existingUser);
    }

    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).get();
        userRepository.delete(existingUser);
    }
}
