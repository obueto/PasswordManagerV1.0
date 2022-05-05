package com.example.passwordmgtsystem.repository;

import com.example.passwordmgtsystem.models.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

}
