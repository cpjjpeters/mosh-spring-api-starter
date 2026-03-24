package com.codewithmosh.store.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/* carlpeters created on 16/03/2026 inside the package - com.codewithmosh.store.dto */
@Data
public class RegisterUserRequest {

    @NotBlank(message = "name is required")
    @Size(min = 3, max = 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 25, message = "Password must be at least 6 charactersbut <25")
    private String password;
}
