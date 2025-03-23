package com.linhnvjava.restapi.service.impl;

import com.linhnvjava.restapi.dto.UserDto;
import com.linhnvjava.restapi.entity.User;
import com.linhnvjava.restapi.mapper.AutoUserMapper;
import com.linhnvjava.restapi.mapper.UserMapper;
import com.linhnvjava.restapi.repository.UserRepository;
import com.linhnvjava.restapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User existingUser = optionalUser.get();
        return modelMapper.map(existingUser, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = AutoUserMapper.MAPPER.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return AutoUserMapper.MAPPER.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
