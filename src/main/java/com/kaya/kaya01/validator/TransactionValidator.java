package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.SearchDTO;
import com.kaya.kaya01.DTO.TransactionDTO;

import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {
    public static List<String> validate(TransactionDTO transactionDTO){

        List<String> errores = new ArrayList<>();

        if (transactionDTO == null ){

            return null;
        }

        return errores;
    }
}
