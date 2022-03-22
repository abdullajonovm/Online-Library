package com.example.onlinekutubxona.repository;

import com.example.onlinekutubxona.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer> {
     Long countById(Integer id);
    Optional<Users> findByPhone(String phoneNumber);
    Optional<Users>findByPhoneAndPassword(String phon,String passwors);
}
