package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.Transaction;
import com.kaya.kaya01.enumEntity.TypeTransation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Builder
@Data
public class TransactionDTO {

    private Integer id;

    private BigDecimal montant;

    private TypeTransation typeTransation;

    private String statut;

    private LocationDTO location;

    public static TransactionDTO fromEntity(Transaction transaction){
        if (transaction == null){
            return null;
        }

        return TransactionDTO.builder()
                .id(transaction.getId())
                .montant(transaction.getMontant())
                .typeTransation(transaction.getTypeTransation())
                .statut(transaction.getStatut())
                .build();
    }


    public static Transaction toEntity(TransactionDTO transactionDTO){
        if (transactionDTO == null){
            return null;
        }

        Transaction transaction = new Transaction();

        transaction.setId(transactionDTO.getId());
        transaction.setMontant(transactionDTO.getMontant());
        transaction.setTypeTransation(transactionDTO.getTypeTransation());
        transaction.setStatut(transactionDTO.getStatut());

        return transaction;
    }
}
