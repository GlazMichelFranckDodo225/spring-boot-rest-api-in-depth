package com.dgmf.web.controller;

import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDtoRequest;
import com.dgmf.web.dto.UserDtoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        UserDtoResponse userDtoResponse = userService.getUserById(userId);

        return ResponseEntity.ok(userDtoResponse);
    }
}
