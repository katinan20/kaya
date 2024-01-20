package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.UserDTO;
import com.kaya.kaya01.Entity.User;
import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.ErrorCodes;
import com.kaya.kaya01.exception.GlobalException;
import com.kaya.kaya01.exception.InvalidEntityException;
import com.kaya.kaya01.repository.UserRepository;
import com.kaya.kaya01.service.UserService;
import com.kaya.kaya01.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implémentation de l'interface {@link UserService}.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /**
     * Crée un nouvel utilisateur en fonction des données fournies dans userDTO.
     *
     * @param userDTO Les données utilisateur pour créer un nouvel utilisateur.
     * @return Le userDTO créé.
     * @throws InvalidEntityException  Si userDTO n'est pas valide.
     * @throws EntityNotFoundException Si un utilisateur avec le même e-mail et numéro de téléphone existe déjà.
     */
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        try {
            // Logique de validation
            List<String> errors = UserValidator.validate(userDTO, userRepository);
            if (!errors.isEmpty()) {
                log.error("Validation échouée pour createUser. UserDTO : {}. Erreurs : {}", userDTO, errors);
                throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_FOUND, errors);
            }
            // Convertit le DTO en entité
            User newUser = toEntity(userDTO);

            // Définit l'utilisateur dans chaque adresse associée
            if (newUser.getAddresses() != null) {
                newUser.getAddresses().forEach(address -> address.setUser(newUser));
            }

            // Enregistre l'utilisateur avec les adresses associées
            return fromEntity(userRepository.save(newUser));
        } catch (InvalidEntityException | EntityNotFoundException e) {
            // Gérer les exceptions liées à la validation des entités ou à la non-existence de l'entité
            log.error("Une exception s'est produite lors de la création de l'utilisateur", e);
            throw e;
        } catch (GlobalException e) {
            // Gérer les autres exceptions non prévues en tant que GlobalException
            log.error("Une exception non prévue s'est produite lors de la création de l'utilisateur", e);
            throw new GlobalException(e.getStatusCode(), e.getErrorCode(), e.getLocalizedMessage());
        }
    }


    /**
     * Met à jour un utilisateur existant en fonction de l'ID et userDTO fournis.
     *
     * @param id      L'ID de l'utilisateur à mettre à jour.
     * @param userDTO Les données utilisateur mises à jour.
     * @return Le userDTO mis à jour.
     * @throws InvalidEntityException Si userDTO n'est pas valide.
     * @throws EntityNotFoundException Si l'utilisateur avec l'ID spécifié n'est pas trouvé.
     */
    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        if (id == null) {
            log.error("L'ID de l'utilisateur est nul");
            throw new InvalidEntityException("L'ID de l'utilisateur ne peut pas être nul");
        }

        // Valide userDTO avant la mise à jour
        List<String> errors = UserValidator.validate(userDTO, userRepository);
        if (!errors.isEmpty()) {
            log.error("Utilisateur invalide {}", userDTO);
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.USER_NOT_FOUND, errors);
        }

        // Recherche l'utilisateur existant
        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.USER_NOT_FOUND
                ));

        // Met à jour les champs de l'utilisateur
        userToUpdate.setFirstname(userDTO.getFirstname());
        userToUpdate.setLastname(userDTO.getLastname());
        userToUpdate.setEmail(userDTO.getEmail());
        userToUpdate.setDateOfBirth(userDTO.getDateOfBirth());
        userToUpdate.setPhoneNumber(userDTO.getPhoneNumber());

        // Enregistre l'utilisateur mis à jour
        User updatedUser = userRepository.save(userToUpdate);

        // Convertit et retourne le DTO mis à jour
        return fromEntity(updatedUser);
    }

    /**
     * Récupère un utilisateur en fonction de son ID.
     *
     * @param id L'ID de l'utilisateur à rechercher.
     * @return Le UserDTO correspondant à l'ID.
     * @throws InvalidEntityException Si l'ID de l'utilisateur est nul.
     * @throws EntityNotFoundException Si aucun utilisateur n'est trouvé avec l'ID spécifié.
     */
    @Override
    public UserDTO findUserById(Long id) {
        if (id == null) {
            log.error("L'ID de l'utilisateur est nul");
            throw new InvalidEntityException("L'ID de l'utilisateur ne peut pas être nul");
        }

        Optional<User> user = userRepository.findById(id);

        return user.map(this::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.USER_NOT_FOUND
                ));
    }

    /**
     * Récupère la liste de tous les utilisateurs.
     *
     * @return La liste de tous les UserDTO.
     */
    @Override
    public List<UserDTO> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    /**
     * Supprime un utilisateur en fonction de son ID.
     *
     * @param id L'ID de l'utilisateur à supprimer.
     * @throws InvalidEntityException  Si l'ID de l'utilisateur est nul.
     * @throws EntityNotFoundException Si aucun utilisateur n'est trouvé avec l'ID spécifié.
     */
    @Override
    public void deleteUser(Long id) {
        if (id == null) {
            log.error("L'ID de l'utilisateur à supprimer est nul");
            throw new InvalidEntityException("L'ID de l'utilisateur ne peut pas être nul");
        }

        // Vérifie si l'utilisateur existe avant de le supprimer
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


    /**
     * Convertit une entité User en DTO UserDTO.
     *
     * @param user L'entité User à convertir.
     * @return Le UserDTO converti.
     */
    public UserDTO fromEntity(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    /**
     * Convertit un DTO UserDTO en entité User.
     *
     * @param userDTO Le DTO UserDTO à convertir.
     * @return L'entité User convertie.
     */
    public User toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
