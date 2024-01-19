package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PhotosDTO;
import com.kaya.kaya01.DTO.PropertyDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PropertyValidador {

    public static List<String> validate(PropertyDTO propertyDTO){

        List<String> errores = new ArrayList<>();

        if (propertyDTO == null ){
            errores.add("Veillez renseigner le titre de la propriété");
            errores.add("Veillez renseigner la location de la propriété");
            errores.add("Veillez renseigner le prix de la propriété");
            errores.add("Veillez renseigner le type de la propriété");
            errores.add("Veillez renseigner la taille de la propriété");
            errores.add("Veillez renseigner le nombre de propriété que vous voulez");
            errores.add("Veillez renseigner la description de la propriéte ");
            return errores;
        }
        if (!StringUtils.hasLength(propertyDTO.getTitre())){errores.add("Veillez renseigner le titre de la propriété");}
        if (!StringUtils.hasLength(propertyDTO.getSize())){errores.add("Veillez renseigner la taille de la propriété");}
        if (!StringUtils.hasLength(propertyDTO.getLocation())){errores.add("Veillez renseigner la location de la propriété");}
        if (propertyDTO.getPrix() == null){errores.add("Veillez renseigner le prix de la propriété");}
        if (!StringUtils.hasLength(propertyDTO.getType())){errores.add("Veillez renseigner le type de la propriété");}
        if (propertyDTO.getNumberOfRooms() == null){errores.add("Veillez renseigner le nombre de propriété que vous voulez");}
        if (!StringUtils.hasLength(propertyDTO.getDescription())){errores.add("Veillez renseigner la description de la propriéte ");}
        return errores;
    }
}
