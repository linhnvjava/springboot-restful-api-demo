package com.linhnvjava.restapi.service;

import com.linhnvjava.restapi.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user);
    void deleteUser(Long id);
}
