package com.example.passwordmgtsystem.controllers;

import com.example.passwordmgtsystem.dtos.requests.CreateUserRequest;
import com.example.passwordmgtsystem.dtos.responses.APIResponse;
import com.example.passwordmgtsystem.exceptions.PasswordMgtException;
import com.example.passwordmgtsystem.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pm/api/v1")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<?> createNewUserAccount(@RequestBody CreateUserRequest createUserRequest) {
        try {
            APIResponse response = APIResponse.builder()
                    .message("id: " + userService.registerUser(createUserRequest))
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (PasswordMgtException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
