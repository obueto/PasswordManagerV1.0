package com.example.passwordmgtsystem.models;

import com.example.passwordmgtsystem.services.Password;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Document("Users")
public class Users {
    @Id
    private  String id;
    @UniqueElements
    @Size(max = 30)
    private String email;
    private String masterPassword;
//    private Password password;

}
