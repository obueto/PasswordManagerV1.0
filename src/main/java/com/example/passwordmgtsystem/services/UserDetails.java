package com.example.passwordmgtsystem.services;

import com.example.passwordmgtsystem.dtos.requests.UserDetailsRequests;
import com.example.passwordmgtsystem.dtos.responses.RegisterUserDetailsResponse;

public interface UserDetails {
    RegisterUserDetailsResponse register(UserDetailsRequests request);

}
