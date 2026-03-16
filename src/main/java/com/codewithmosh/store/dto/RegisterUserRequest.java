package com.codewithmosh.store.dto;

import lombok.Data;

/* carlpeters created on 16/03/2026 inside the package - com.codewithmosh.store.dto */
@Data
public class RegisterUserRequest {

    private String name;
    private String email;
    private String password;
}
