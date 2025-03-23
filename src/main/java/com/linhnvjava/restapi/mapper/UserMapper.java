package com.linhnvjava.restapi.mapper;

import com.linhnvjava.restapi.dto.UserDto;
import com.linhnvjava.restapi.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
       return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .build();
    }
}
