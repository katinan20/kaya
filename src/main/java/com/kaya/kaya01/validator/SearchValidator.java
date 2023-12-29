package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.DTO.SearchDTO;

import java.util.ArrayList;
import java.util.List;

public class SearchValidator {

    public static List<String> validate(SearchDTO searchDTO){

        List<String> errores = new ArrayList<>();

        if (searchDTO == null ){

            return null;
        }

        return errores;
    }
}
