package com.example.passwordmgtsystem.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Document
@NoArgsConstructor
@Getter
@Setter


public class UrlDetails {
    @Size(max = 30)
    private String email;
    @Size(max = 30)
    private  String appName;
    private  String password;
    private  String urlAddress;

    @DBRef
    private User loggedInUser;

    public UrlDetails(String email, String appName, String password, String urlAddress, User loggedInUser) {
        this.email = email;
        this.appName = appName;
        this.password = password;
        this.urlAddress = urlAddress;
        this.loggedInUser = loggedInUser;
    }
}
