package com.dgmf.web.controller;

import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Build Create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userService.createUser(userDto),
                HttpStatus.CREATED);
    }

    // Build Get User By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable("id") Long userDtoId) {
        // UserDto userDtoResponse = userService.getUserById(userId);
        // return ResponseEntity.ok(userDtoResponse);

        return ResponseEntity.ok(userService.getUserById(userDtoId));
    }

    // Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // List<UserDto> userDtos = userService.getAllUsers();
        // return ResponseEntity.ok(userDtos);

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @RequestBody UserDto userDto,
            @PathVariable("id") Long userDtoId) {
        return ResponseEntity.ok(userService.updateUser(
                userDto,
                userDtoId)
        );
    }

    // Build Delete User By Id REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(
            @PathVariable("id") Long UserDtoId) {
        userService.deleteUserById(UserDtoId);

        return ResponseEntity
                .ok("User with id : "
                        + UserDtoId + " Deleted Successfully.");
    }
}
