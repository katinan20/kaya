package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.AdressesDTO;
import com.kaya.kaya01.DTO.UserDTO;
import com.kaya.kaya01.Entity.User;
import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.ErrorCodes;
import com.kaya.kaya01.exception.InvalideEntityException;
import com.kaya.kaya01.repository.UserRepository;
import com.kaya.kaya01.service.UserService;
import com.kaya.kaya01.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceIpm implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceIpm(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {

        List<String> errors  = UserValidator.validate(userDTO);
        if (!errors.isEmpty()){
            log.error("Utilisateur invalide {} ", userDTO);
            throw new InvalideEntityException(
                    "l'utilisateur n'est pas vilide",
                    ErrorCodes.USER_NOT_FOUND,
                    errors
            );
        }
        return UserDTO.fromEntity(
                userRepository.save(
                        UserDTO.toEntity(userDTO)
                )
        );
    }

    @Override
    public UserDTO updateUserById(Integer id, UserDTO userDTO) {
        if (id == null) {
            log.error("L'ID de l'utilisateur est nul");
            throw new InvalideEntityException("L'ID de l'utilisateur ne peut pas être nul");
        }

        // Valider le UserDTO avant la mise à jour
        List<String> errors = UserValidator.validate(userDTO);
        if (!errors.isEmpty()) {
            log.error("Utilisateur invalide {}", userDTO);
            throw new InvalideEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_FOUND, errors);
        }

        // Rechercher l'utilisateur existant
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.USER_NOT_FOUND
                ));

        // Mise à jour des champs de l'utilisateur
        userToUpdate.setCode(userDTO.getCode());
        userToUpdate.setName(userDTO.getName());
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setDateNaissance(userDTO.getDateNaissance());
        userToUpdate.setPhoneNumber(userDTO.getPhoneNumber());
        userToUpdate.setAdresse(AdressesDTO.toEntity(userDTO.getAdressesDTO()));

        // Sauvegarder l'utilisateur mis à jour
        User updatedUser = userRepository.save(userToUpdate);

        // Convertir et retourner le DTO mis à jour
        return UserDTO.fromEntity(updatedUser);
    }

    @Override
    public UserDTO findUserById(Integer id) {
        if (id ==  null){
            log.error("User ID is null");
            return null;
        }

        Optional<User> user = userRepository.findById(id);

        return Optional.of(UserDTO.fromEntity(user.get())).orElseThrow(
                ()-> new EntityNotFoundException(
                        "Aucun utilisateur avec l ID "+id+" n a ete trouver dans la base de donnée",
                        ErrorCodes.USER_NOT_FOUND
                )
        );
    }

    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteUser(Integer id) {
            if (id == null) {
                log.error("L'ID de l'utilisateur à supprimer est nul");
                throw new InvalideEntityException("L'ID de l'utilisateur ne peut pas être nul");
            }

            // Vérifier si l'utilisateur existe avant de le supprimer
            if (!userRepository.existsById(id)) {
                log.error("Aucun utilisateur trouvé avec l'ID: {}", id);
                throw new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.USER_NOT_FOUND
                );
            }
            userRepository.deleteById(id);
            log.info("Utilisateur avec ID: {} supprimé avec succès", id);

    }
}
