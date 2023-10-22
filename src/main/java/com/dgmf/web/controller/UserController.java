package com.dgmf.web.controller;

import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDtoRequest;
import com.dgmf.web.dto.UserDtoResponse;
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
    @PostMapping("/create")
    public ResponseEntity<UserDtoResponse> createUser(
            @RequestBody UserDtoRequest userDtoRequest
    ) {

        return new ResponseEntity<>(
                userService.createUser(userDtoRequest),
                HttpStatus.CREATED);
    }

    // Build Get User By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoResponse> getUserById(
            @PathVariable("id") Long userId) {
        // UserDtoResponse userDtoResponse = userService.getUserById(userId);
        // return ResponseEntity.ok(userDtoResponse);

        return ResponseEntity.ok(userService.getUserById(userId));
    }

    // Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDtoResponse>> getAllUsers() {
        // List<UserDtoResponse> userDtos = userService.getAllUsers();
        // return ResponseEntity.ok(userDtos);

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoResponse> updateUser(
            @RequestBody UserDtoRequest userDtoRequest,
            @PathVariable("id") Long userDtoRequestId) {
        return ResponseEntity.ok(userService.updateUser(
                userDtoRequest,
                userDtoRequestId)
        );
    }

    // Build Delete User By Id REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long userDtoRequestId) {
        userService.deleteUserById(userDtoRequestId);

        return ResponseEntity
                .ok("User with id : "
                        + userDtoRequestId + " Deleted Successfully.");
    }
}
