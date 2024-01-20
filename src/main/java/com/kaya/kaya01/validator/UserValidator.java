package com.kaya.kaya01.validator;

import com.kaya.kaya01.DTO.AddressDTO;
import com.kaya.kaya01.DTO.UserDTO;
import com.kaya.kaya01.repository.UserRepository;
import com.kaya.kaya01.utils.ValidationUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validate(UserDTO userDTO, UserRepository userRepository) {

        List<String> errors = new ArrayList<>();

        if (userDTO == null) {
            errors.add("Veuillez renseigner les informations de l'utilisateur");
            return errors;
        }
        if (!StringUtils.hasLength(userDTO.getFirstname())) {
            errors.add("Veuillez renseigner votre Nom s'il vous plaît");
        }
        if (!StringUtils.hasLength(userDTO.getEmail()) || !ValidationUtils.isValidEmail(userDTO.getEmail())) {
            errors.add("Veuillez renseigner une adresse e-mail valide");
        }
        if (!StringUtils.hasLength(userDTO.getPhoneNumber()) || !ValidationUtils.validatePhoneNumber(userDTO.getPhoneNumber())) {
            errors.add("Veuillez renseigner un numéro de téléphone valide");
        }
        if (userDTO.getDateOfBirth() == null) {
            errors.add("Veuillez renseigner votre date de Naissance");
        }
        if (userDTO.getAddresses() == null || userDTO.getAddresses().isEmpty()) {
            errors.add("Veuillez renseigner vos Adresses S'il vous plaît");
        } else {
            for (int i = 0; i < userDTO.getAddresses().size(); i++) {
                String addressPrefix = "Adresse #" + (i + 1) + ": ";
                validateAddress(userDTO.getAddresses().get(i), addressPrefix, errors);
            }
        }

        // Vérifier si l'utilisateur existe déjà
        if (userRepository.findByEmailAndPhoneNumber(userDTO.getEmail(), userDTO.getPhoneNumber()).isPresent()) {
            errors.add("Un utilisateur avec le même e-mail et numéro de téléphone existe déjà");
        }
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            errors.add("Un utilisateur avec cet email existe déjà");
        }
        if (userRepository.findByPhoneNumber(userDTO.getPhoneNumber()).isPresent()) {
            errors.add("Un utilisateur avec le numéro de téléphone existe déjà");
        }

        return errors;
    }

    private static void validateAddress(AddressDTO address, String prefix, List<String> errors) {
        if (!StringUtils.hasLength(address.getStreet())) {
            errors.add(prefix + "Le champ adresse est obligatoire");
        }
        if (!StringUtils.hasLength(address.getCountry())) {
            errors.add(prefix + "Le champ pays est obligatoire");
        }
        if (!StringUtils.hasLength(address.getCity())) {
            errors.add(prefix + "Le champ 'Ville' est obligatoire");
        }
        if (!StringUtils.hasLength(address.getPostalCode())) {
            errors.add(prefix + "Le champ code postal est obligatoire");
        }
    }
}
