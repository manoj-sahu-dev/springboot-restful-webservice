package com.manoj.springboot.restful.springbootrestfulwebservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "users first name must not be empty or null")
    private String firstName; // first name should not be null or empty

    @NotEmpty(message = "users last name must not be empty or null")
    private String lastName;

    @NotEmpty(message = "users emailmust not be empty or null")
    @Email(message = "users email must be valid")
    private String email; // must be valid email
}
