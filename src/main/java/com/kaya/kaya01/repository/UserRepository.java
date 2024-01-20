package com.kaya.kaya01.repository;

import com.kaya.kaya01.DTO.PhoneNumberDTO;
import com.kaya.kaya01.Entity.PhoneNumber;
import com.kaya.kaya01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPhoneNumberIn(String email, List<PhoneNumber> phoneNumber);

    Optional<User> findByPhoneNumberIn(List<PhoneNumber> phoneNumber);
}
