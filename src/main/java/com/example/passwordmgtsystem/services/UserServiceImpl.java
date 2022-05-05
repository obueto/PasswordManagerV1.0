package com.example.passwordmgtsystem.services;
import com.example.passwordmgtsystem.dtos.requests.CreateUserRequest;
import com.example.passwordmgtsystem.dtos.requests.UserDetailsRequests;
import com.example.passwordmgtsystem.dtos.responses.CreateUserResponse;
import com.example.passwordmgtsystem.dtos.responses.RegisterUserDetailsResponse;
import com.example.passwordmgtsystem.exceptions.PasswordMgtException;
import com.example.passwordmgtsystem.models.UserDetails;
import com.example.passwordmgtsystem.models.Users;
import com.example.passwordmgtsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;


    @Override
    public UserRepository getRepository() {
        return userRepository;
    }

    @Override
    public CreateUserResponse registerUser(CreateUserRequest createUserRequest) {
        Optional<Users>optionalUsers = userRepository.findUsersByEmail(createUserRequest.getEmail());
        if (optionalUsers.isPresent()){
            throw new PasswordMgtException("user is already present");
        }
            Users users = new Users();
            users.setEmail(createUserRequest.getEmail());
//            users.setPassword(createUserRequest.getPassword());
            users.setMasterPassword(createUserRequest.getMasterPassword());
            userRepository.save(users);

        CreateUserResponse response = new CreateUserResponse();
        response.setDetails("Account created successfully");
        response.setMessage("Please check your email address for a confirmation email");
        return response;
    }


    @Override
    public void updateUser(String email, String id) {

    }

    @Override
    public void deleteByEmail(String email) {

    }
}
