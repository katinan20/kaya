package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
