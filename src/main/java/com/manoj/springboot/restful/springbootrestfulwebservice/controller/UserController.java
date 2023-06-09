package com.manoj.springboot.restful.springbootrestfulwebservice.controller;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<UserDto>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();

        return new ResponseEntity<List<UserDto>>(users, HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto user) {
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<UserDto>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<String>("user deleted", HttpStatus.OK);

    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                resourceNotFoundException.getMessage(),
//                webRequest.getDescription(true),
//                "USER_NOT_FOUND"
//        );
//        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
}
