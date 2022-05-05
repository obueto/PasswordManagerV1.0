package com.example.passwordmgtsystem.dtos.requests;

import lombok.Data;

@Data
public class RegisterUserDetails {

    private String email;
    private String masterPassword;

}
