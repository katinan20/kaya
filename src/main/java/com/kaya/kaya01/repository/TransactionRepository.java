package com.kaya.kaya01.repository;

import com.kaya.kaya01.DTO.TransactionDTO;
import com.kaya.kaya01.Entity.Transaction;
import com.kaya.kaya01.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
