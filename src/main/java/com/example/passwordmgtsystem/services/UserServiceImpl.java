package com.example.passwordmgtsystem.services;
import com.example.passwordmgtsystem.dtos.requests.CreateUserRequest;
import com.example.passwordmgtsystem.dtos.requests.UserRequestDto;
import com.example.passwordmgtsystem.dtos.responses.CreateUserResponse;
import com.example.passwordmgtsystem.exceptions.PasswordMgtException;
import com.example.passwordmgtsystem.models.User;
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
        Optional<User>optionalUser = userRepository.findUserByEmail(createUserRequest.getEmail());
        if (optionalUser.isPresent()){
            throw new PasswordMgtException("user is already present");
        }
            User users = new User();
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
    public  String updateUser(String email, UserRequestDto userDetails) {
            User users = userRepository.findUserByEmail(email).orElseThrow(()-> new
                    PasswordMgtException("user account does not exist"));
            boolean isUpdated = false;
            if (!(userDetails.getEmail()== null || userDetails.getEmail().trim().equals(""))) {
                users.setEmail(userDetails.getEmail());
                isUpdated = true;
            }
            if (!(userDetails.getMasterPassword()== null || userDetails.getMasterPassword().trim().equals(""))) {
                users.setMasterPassword(userDetails.getMasterPassword());
                isUpdated = true;
            }
            if (isUpdated) {
                userRepository.save(users);
            }
            return "user details updated successfully";
        }



    @Override
    public void deleteByEmail(String email){
            User users = userRepository.findUserByEmail(email).orElseThrow(() -> new PasswordMgtException("user not found"));
            userRepository.delete(users);
        }
    }

