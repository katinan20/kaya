package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.PropertyDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PropertyValidator {

    public static List<String> validate(PropertyDTO propertyDTO){

        List<String> errors = new ArrayList<>();

        if (propertyDTO == null) {
            errors.add("Veuillez renseigner les informations de la propriété");
            return errors;
        }
        // Valider les champs requis
        if (propertyDTO.getPropertyTypeDTO() == null) {
            errors.add("Veuillez renseigner le type de propriété");
        }
        if (propertyDTO.getNumberOfBedrooms() <= 0) {
            errors.add("Le nombre de chambres doit être supérieur à zéro");
        }
        if (propertyDTO.getNumberOfBathrooms() <= 0) {
            errors.add("Le nombre de salles de bains doit être supérieur à zéro");
        }
        if (propertyDTO.getAreaInSquareMeters() <= 0) {
            errors.add("La surface en mètres carrés doit être supérieure à zéro");
        }

        if (propertyDTO.getPricePerNight() <= 0) {
            errors.add("Le prix par nuit doit être supérieur à zéro");
        }
        if (!StringUtils.hasLength(propertyDTO.getDescription())) {
            errors.add("Veuillez renseigner la description de la propriété");
        }

        // Valider les champs optionnels
        if (propertyDTO.getId() != null && propertyDTO.getId() < 0) {
            errors.add("L'ID de la propriété doit être un nombre positif");
        }

        // Valider d'autres champs selon vos besoins

        return errors;
    }
}
