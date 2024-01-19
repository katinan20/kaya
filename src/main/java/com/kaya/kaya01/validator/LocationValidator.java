package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.CategoryDTO;
import com.kaya.kaya01.DTO.LocationDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LocationValidator {
    public static List<String> validate(LocationDTO locationDTO){

        List<String> errores = new ArrayList<>();

        if (locationDTO == null ){

            errores.add("Veillez renseigner la date d Entrée");
            errores.add("Veillez renseigner la date de sortie");
            errores.add("Veillez renseigner le type de de location'");
            errores.add("Veillez renseigner le statut de la transaction");
            errores.add("Veillez renseigner le prix unitaire TTC de l'article");
            errores.add("Veillez sélectionner une catégorie");
            errores.add("");

            return errores;
        }

        if (locationDTO.getTypeLocation() == null){
            errores.add("le Champ le type de location est obligatoire");
        }
        if (!StringUtils.hasLength(locationDTO.getStatusPayement())){
            errores.add("Veillez renseigner le statut de la transaction");
        }
        return errores;
    }
}
