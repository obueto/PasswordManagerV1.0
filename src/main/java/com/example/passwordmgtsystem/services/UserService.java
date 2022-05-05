package com.example.passwordmgtsystem.services;

import com.example.passwordmgtsystem.dtos.requests.CreateUserRequest;
import com.example.passwordmgtsystem.dtos.requests.UserDetailsRequests;
import com.example.passwordmgtsystem.dtos.responses.CreateUserResponse;
import com.example.passwordmgtsystem.dtos.responses.RegisterUserDetailsResponse;
import com.example.passwordmgtsystem.repository.UserRepository;

public interface UserService {

        UserRepository getRepository();
        CreateUserResponse registerUser(CreateUserRequest createUserRequest);
        void updateUser(String email, String id);
        void deleteByEmail(String email);


}
