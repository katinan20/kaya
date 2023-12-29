package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PhotosDTO;
import com.kaya.kaya01.DTO.PropertyDTO;

import java.util.ArrayList;
import java.util.List;

public class PropertyValidador {

    public static List<String> validate(PropertyDTO propertyDTO){

        List<String> errores = new ArrayList<>();

        if (propertyDTO == null ){

            return null;
        }

        return errores;
    }
}
