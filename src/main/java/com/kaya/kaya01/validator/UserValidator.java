package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.DTO.UserDTO;
import org.springframework.util.StringUtils;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDTO userDTO){

        List<String> errores = new ArrayList<>();

        if (userDTO == null ){
            errores.add("Veillez renseigner votre Nom s'il vous plaît");
            errores.add("Veillez renseigner votre Email");
            errores.add("Veillez renseigner votre numero téléphonique");
            errores.add("Veillez renseigner votre date de Naissance");
            errores.add("Veillez renseigner vos Adresses S 'il vous plait");

            return errores;
        }
        if (!StringUtils.hasLength(userDTO.getName())){
            errores.add("Veillez renseigner votre Nom s'il vous plaît");
        }
        if (!StringUtils.hasLength(userDTO.getEmail())){
            errores.add("Veillez renseigner votre Email");
        }
        if (!StringUtils.hasLength(userDTO.getPhoneNumber())){
            errores.add("Veillez renseigner votre numero téléphonique");
        }
        if (userDTO.getDateNaissance() == null){
            errores.add("Veillez renseigner votre date de Naissance");
        }
        if (userDTO.getAdressesDTO() == null){
            errores.add("Veillez renseigner vos Adresses S 'il vous plait");
        }else {
            if (!StringUtils.hasLength(userDTO.getAdressesDTO().getAdresse())){
                errores.add("Le champs adresse est obligatoire ");
            }
            if (!StringUtils.hasLength(userDTO.getAdressesDTO().getPays())){
                errores.add("Le champs pays est obligatoire");
            }
            if (!StringUtils.hasLength(userDTO.getAdressesDTO().getVille())){
                errores.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(userDTO.getAdressesDTO().getCodePostal())){
                errores.add("Le champs code postal est obligatoire");
            }

        }
        return errores;
    }
}
