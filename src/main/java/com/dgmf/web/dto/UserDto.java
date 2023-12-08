package com.dgmf.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Swagger Model Documentation
@Schema(
        description = "UserDto Model Information"
)
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {
    private Long id;
    @Schema(
            description = "User First Name"
    )
    @NotEmpty(message = "User First Name should not be Null or Empty")
    private String firstName;
    @Schema(
            description = "User Last Name"
    )
    @NotEmpty(message = "User Last Name should not be Null or Empty")
    private String lastName;
    @Schema(
            description = "User Email Address"
    )
    @NotEmpty(message = "User Email should not be Null or Empty")
    @Email(message = "User Email should be a Valid Email Address")
    private String email;
}
