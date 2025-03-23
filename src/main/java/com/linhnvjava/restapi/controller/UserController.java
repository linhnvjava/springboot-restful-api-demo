package com.linhnvjava.restapi.controller;

import com.linhnvjava.restapi.dto.UserDto;
import com.linhnvjava.restapi.exception.ErrorDetails;
import com.linhnvjava.restapi.exception.ResourceNotFoundException;
import com.linhnvjava.restapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        user.setId(id);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}

