package com.manoj.springboot.restful.springbootrestfulwebservice.mapper;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()
        );
    }

    public static User mapFromUserDto(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }
}
