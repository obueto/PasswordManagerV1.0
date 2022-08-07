package com.example.passwordmgtsystem.services;

import com.example.passwordmgtsystem.dtos.requests.UrlDetailsRequest;
import com.example.passwordmgtsystem.dtos.responses.RegisterUserResponse;
import com.example.passwordmgtsystem.exceptions.PasswordMgtException;
import com.example.passwordmgtsystem.models.UrlDetails;
import com.example.passwordmgtsystem.models.User;
import com.example.passwordmgtsystem.repository.UrlDetailsRepository;
import com.example.passwordmgtsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final UrlDetailsRepository userDetailsRepository;
    private PasswordEncoder encoder;
    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository,UrlDetailsRepository urlDetailsRepository){
        this.userRepository = userRepository;
        this.userDetailsRepository = urlDetailsRepository;
        this.encoder = new BCryptPasswordEncoder();
    }
    @Override
    public RegisterUserResponse register(UrlDetailsRequest request) {
        //searched for user trying to add url details
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(()->new PasswordMgtException("user does not exist")); //if user not found throw exception
        //if user is found, create url details object from incoming request
        UrlDetails userDetails = new UrlDetails(request.getEmail(), request.getAppName(),
                request.getPassword(), request.getUrlAddress(), user);
        //save details in db
        UrlDetails userDetails1 = userDetailsRepository.save(userDetails);
        //create RegisterResponse object to be returned
        RegisterUserResponse registerUserDetailsResponse = new RegisterUserResponse();
        //set values from user details saved to db on the register user details response object
        registerUserDetailsResponse.setDetails(userDetails1.getUrlAddress());
        registerUserDetailsResponse.setDetails(userDetails1.getPassword());
        registerUserDetailsResponse.setMessage("url and password added successfully");
        //return response
        return registerUserDetailsResponse;

    }

    @Override
    public User findUserDetails(String email) {
        Optional<User> optionalUser = userDetailsRepository.findUrlDetailsByEmail(email);
        User user = new User();
        if (optionalUser.isEmpty()) {
            throw new PasswordMgtException("user url details not found");
        } else if (optionalUser.get().getEmail().equals(user.getEmail())) ;

        return user;

    }
}



