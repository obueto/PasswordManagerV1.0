package com.example.passwordmgtsystem.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;

import javax.validation.constraints.Size;

@Data

public class UserDetails {
    @Size(max = 30)
    private String email;
    @Size(max = 30)
    private  String appName;
    private  String password;
    private  String urlAddress;

    @DBRef
    private Users loggedInUser;
}
