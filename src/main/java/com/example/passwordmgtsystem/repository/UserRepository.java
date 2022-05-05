package com.example.passwordmgtsystem.repository;

import com.example.passwordmgtsystem.models.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserRepository extends MongoRepository<Users,String>{
    Optional<Users> findUsersByEmail(String email);
//Users findUsersByEmail(String email);
Users deleteUsersByMasterPasswordAndEmail(String password, String email);
Users queryAllByEmail(String email);




}
