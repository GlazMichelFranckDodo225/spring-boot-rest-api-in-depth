package com.dgmf.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {
    private Long id;
    @NotEmpty(message = "User First Name should not be Null or Empty")
    private String firstName;
    @NotEmpty(message = "User Last Name should not be Null or Empty")
    private String lastName;
    @NotEmpty(message = "User Email should not be Null or Empty")
    @Email(message = "User Email should be a Valid Email Address")
    private String email;
}
