package com.example.passwordmgtsystem.repository;

import com.example.passwordmgtsystem.models.UrlDetails;
import com.example.passwordmgtsystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UrlDetailsRepository extends MongoRepository<UrlDetails, String> {
Optional<User> findUrlDetailsByEmail(String email);
}
