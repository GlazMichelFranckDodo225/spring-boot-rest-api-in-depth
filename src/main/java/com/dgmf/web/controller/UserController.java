package com.dgmf.web.controller;

import com.dgmf.exception.ErrorDetails;
import com.dgmf.exception.ResourceNotFoundException;
import com.dgmf.service.UserService;
import com.dgmf.web.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, " +
                "Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Swagger API Documentation
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to Save User in the Database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // Build Create User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(
                userService.createUser(userDto),
                HttpStatus.CREATED);
    }

    // Swagger API Documentation
    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to Get a Single " +
                    "User from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Get User By Id REST API
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(
            @PathVariable("id") Long userDtoId) {
        // UserDto userDtoResponse = userService.getUserById(userId);
        // return ResponseEntity.ok(userDtoResponse);

        return ResponseEntity.ok(userService.getUserById(userDtoId));
    }

    // Swagger API Documentation
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to Get All the  " +
                    "Users from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Get All Users REST API
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        // List<UserDto> userDtos = userService.getAllUsers();
        // return ResponseEntity.ok(userDtos);

        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Swagger API Documentation
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to Update a Particular  " +
                    "User in the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Update User REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @Valid
            @RequestBody UserDto userDto,
            @PathVariable("id") Long userDtoId) {
        return ResponseEntity.ok(userService.updateUser(
                userDto,
                userDtoId)
        );
    }

    // Swagger API Documentation
    @Operation(
            summary = "Delete User By Id REST API",
            description = "Delete User By Id REST API is used to Delete a Particular  " +
                    "User from the Database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Delete User By Id REST API
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(
            @PathVariable("id") Long UserDtoId) {
        userService.deleteUserById(UserDtoId);

        return ResponseEntity
                .ok("User with id "
                        + UserDtoId + " Deleted Successfully.");
    }

    // Build Exception Handler
    // @ExceptionHandler() ==> To handle specific Exception and
    // sending a custom Response to the Client
    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException resourceNotFoundException,
            WebRequest webRequest
    ) {
        ErrorDetails errorDetails = ErrorDetails.builder()
                .timestamp(LocalDateTime.now())
                .message(resourceNotFoundException.getMessage())
                .path(webRequest.getDescription(false))
                .errorCode("USER_NOT_FOUND")
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}
