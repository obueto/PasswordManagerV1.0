package com.example.passwordmgtsystem.dtos.requests;

import com.example.passwordmgtsystem.services.Password;
import lombok.Data;

@Data
public class CreateUserRequest {
    private String email;
    private String masterPassword;
//    private Password password;
}
