package com.example.passwordmgtsystem.models;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Document("Users")
public class User {
    @Id
    private  String id;
    @UniqueElements
    @Size(max = 30)
    private String email;
    private String masterPassword;


}
