package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.Entity.Property;
import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.ErrorCodes;
import com.kaya.kaya01.exception.InvalideEntityException;
import com.kaya.kaya01.repository.PropertyRepository;
import com.kaya.kaya01.service.PropertyService;
import com.kaya.kaya01.validator.PropertyValidador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PropertyServiceImp implements PropertyService {
    private PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImp(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDTO creatProperty(PropertyDTO propertyDTO) {

        List<String> errors = PropertyValidador.validate(propertyDTO);
        if (!errors.isEmpty()){
            log.error("Proppriété invalide {}", propertyDTO);
            throw new InvalideEntityException("La propriété n est pas valide", ErrorCodes.PROPRIETE_NOT_FOUND, errors);
        }
        return PropertyDTO.fromEntity(
                propertyRepository.save(
                        PropertyDTO.toEntity(propertyDTO)
                )
        );
    }

    @Override
    public PropertyDTO findProperTyById(Integer id) {
        if (id == null){
            log.error("L'ID ne doit pas être null");
            return null;
        }
        Optional<Property> property = propertyRepository.findById(id);
        return Optional.of(PropertyDTO.fromEntity(property.get())).orElseThrow(
                ()-> new EntityNotFoundException(
                        "La propriété avec l'ID "+ id +"n'existe pas dans la base de donnée",
                        ErrorCodes.PROPRIETE_NOT_FOUND
                )
        );
    }


    @Override
    public List<PropertyDTO> findAllProperty() {
        return propertyRepository.findAll()
                .stream()
                .map(PropertyDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO updatePropertyByIdAnd(Integer id, PropertyDTO propertyDTO) {
        if (id == null) {
            log.error("L'ID de la propriété est null");
            throw new InvalideEntityException("L'ID de la propriété n existe pas");
        }

        //valider la propriet dto avant la mise à jour
        List<String> errors = PropertyValidador.validate(propertyDTO);
        if (errors.isEmpty()) {
            log.error("Proppriété invalide {}", propertyDTO);
            throw new InvalideEntityException("La propriété n est pas valide", ErrorCodes.PROPRIETE_NOT_FOUND, errors);
        }

        // Rechercher la proprité existant
        Property updateProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune proprieté avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.PROPRIETE_NOT_FOUND
                ));
        // mise à jour de la propriété
        updateProperty.setType(propertyDTO.getTitre());
        updateProperty.setLocation(propertyDTO.getLocation());
        updateProperty.setSize(propertyDTO.getSize());
        updateProperty.setPrix(propertyDTO.getPrix());
        updateProperty.setDescription(propertyDTO.getDescription());
        updateProperty.setDateDeCreation(propertyDTO.getDateDeCreation());
        updateProperty.setNumberOfRooms(propertyDTO.getNumberOfRooms());
        updateProperty.setType(propertyDTO.getType());

        // Sauvegarder les données
        Property prop = propertyRepository.save(updateProperty);
        return PropertyDTO.fromEntity(prop);
    }

    @Override
    public void deletProperty(Integer id) {
        if (id == null) {
            log.error("L'ID de la propriété à supprimer est nul");
            throw new InvalideEntityException("L'ID de la propriété ne peut pas être nul");
        }

        // Vérifier si l'utilisateur existe avant de le supprimer
        if (!propertyRepository.existsById(id)) {
            log.error("Aucune propriété trouvé avec l'ID: {}", id);
            throw new EntityNotFoundException(
                    "Aucune propriété avec l'ID " + id + " n'a été trouvé dans la base de données",
                    ErrorCodes.USER_NOT_FOUND
            );
        }
        propertyRepository.deleteById(id);
        log.info("propriété avec ID: {} supprimé avec succès", id);

    }
}
