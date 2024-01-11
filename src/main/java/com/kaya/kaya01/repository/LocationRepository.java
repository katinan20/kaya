package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    Optional<Location> findByCodeLocat(String code);
}
