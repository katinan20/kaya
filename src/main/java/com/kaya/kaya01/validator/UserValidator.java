package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.DTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDTO userDTO){

        List<String> errores = new ArrayList<>();

        if (userDTO == null ){

            return null;
        }

        return errores;
    }
}
