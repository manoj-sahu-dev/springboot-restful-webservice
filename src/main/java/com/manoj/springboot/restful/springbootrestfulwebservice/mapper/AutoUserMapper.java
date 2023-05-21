package com.manoj.springboot.restful.springbootrestfulwebservice.mapper;

import com.manoj.springboot.restful.springbootrestfulwebservice.dto.UserDto;
import com.manoj.springboot.restful.springbootrestfulwebservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper getInstance = Mappers.getMapper(AutoUserMapper.class);

    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);
}
