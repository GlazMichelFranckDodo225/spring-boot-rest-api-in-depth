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
    @NotEmpty // Value is not "Null" or "Empty"
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email // Email should be a Valid Email Address
    private String email;
}
