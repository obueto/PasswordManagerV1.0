package com.example.passwordmgtsystem.dtos.requests;

import lombok.Data;

@Data
public class UserRequestDto {

    private String email;
    private String masterPassword;

}
