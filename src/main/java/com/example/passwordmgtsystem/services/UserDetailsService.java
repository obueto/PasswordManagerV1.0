package com.example.passwordmgtsystem.services;

import com.example.passwordmgtsystem.dtos.requests.UrlDetailsRequest;
import com.example.passwordmgtsystem.dtos.responses.RegisterUserResponse;
import com.example.passwordmgtsystem.models.User;

public interface UserDetailsService {
    RegisterUserResponse register(UrlDetailsRequest request);
    User findUserDetails(String email);

}
