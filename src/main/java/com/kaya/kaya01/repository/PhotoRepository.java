package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.Photos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photos, Integer> {
}
