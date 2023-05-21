package com.manoj.springboot.restful.springbootrestfulwebservice.controller;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {
        UserDto user = null;
        try {
            user = userService.getUserById(id);
        } catch (NoSuchElementException e) {
            System.out.println("user not found: " + id + ", error: " + e.getMessage());
        }
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("user deleted", HttpStatus.OK);

    }
}
