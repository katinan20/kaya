package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.DTO.PhotosDTO;

import java.util.ArrayList;
import java.util.List;

public class PhotoValidator {
    public static List<String> validate(PhotosDTO photosDTO){

        List<String> errores = new ArrayList<>();

        if (photosDTO == null ){

            return null;
        }

        return errores;
    }
}
