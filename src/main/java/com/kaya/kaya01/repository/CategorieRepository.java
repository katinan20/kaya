package com.kaya.kaya01.repository;

import com.kaya.kaya01.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Category, Long> {
}
