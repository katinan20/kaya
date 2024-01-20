package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPhoneNumber(String email, String phoneNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
