package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.Location;
import com.kaya.kaya01.enumEntity.TypeLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByCodeLocat(String code);
    Boolean findLocationByTypeLocation(TypeLocation status);
}
