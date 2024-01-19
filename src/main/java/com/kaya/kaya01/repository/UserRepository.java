package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByNameAndEmailAndPhoneNumber(String name, String email, String phoneNumber);

}
