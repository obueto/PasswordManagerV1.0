package com.example.passwordmgtsystem.repository;

import com.example.passwordmgtsystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
    Optional<User> findUserByEmail(String email);
//Users findUsersByEmail(String email);
User deleteUsersByMasterPasswordAndEmail(String password, String email);
User queryAllByEmail(String email);




}
