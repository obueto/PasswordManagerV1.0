package com.example.passwordmgtsystem.dtos.requests;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String masterPassword;

}
