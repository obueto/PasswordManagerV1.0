package com.example.passwordmgtsystem;

import com.example.passwordmgtsystem.models.UserDetails;
import com.example.passwordmgtsystem.models.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class PasswordMgtSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordMgtSystemApplication.class, args);
    }


}
