package com.example.passwordmgtsystem.services;

import com.example.passwordmgtsystem.dtos.requests.CreateUserRequest;
import com.example.passwordmgtsystem.dtos.requests.UserRequestDto;
import com.example.passwordmgtsystem.dtos.responses.CreateUserResponse;
import com.example.passwordmgtsystem.repository.UserRepository;

public interface UserService {

        UserRepository getRepository();
        CreateUserResponse registerUser(CreateUserRequest createUserRequest);
        String updateUser( String id, UserRequestDto userDetails);
        void deleteByEmail(String email);


}
