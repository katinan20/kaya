package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDTO categoryDTO){

        List<String> errores = new ArrayList<>();

        if (categoryDTO == null ){

            return null;
        }

        return errores;
    }
}
