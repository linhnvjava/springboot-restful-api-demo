package com.linhnvjava.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotEmpty(message = "User name should not be null or empty")
    private String name;

    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email should be valid")
    private String email;
}
