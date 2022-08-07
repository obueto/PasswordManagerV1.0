package com.example.passwordmgtsystem.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class UrlDetailsRequest {
    private String email;
    private String appName;
    private String urlAddress;
    private String password;

}
