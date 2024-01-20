package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.AddressDTO;
import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.DTO.UserDTO;
import com.kaya.kaya01.Entity.Property;
import com.kaya.kaya01.Entity.User;
import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.ErrorCodes;
import com.kaya.kaya01.exception.InvalidEntityException;
import com.kaya.kaya01.repository.PropertyRepository;
import com.kaya.kaya01.service.PropertyService;
import com.kaya.kaya01.validator.PropertyValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
    ModelMapper modelMapper;

    @Autowired
    public PropertyServiceImp(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDTO creatProperty(PropertyDTO propertyDTO) {

        List<String> errors = PropertyValidator.validate(propertyDTO);

        if (!errors.isEmpty()){
            log.error("Propriété invalide {}", propertyDTO);
            throw new InvalidEntityException("La propriété n'est pas valide", ErrorCodes.PROPRIETE_NOT_FOUND, errors);
        }
        return fromEntity(
                propertyRepository.save(
                        toEntity(propertyDTO)
                )
        );
    }

    @Override
    public PropertyDTO findProperTyById(Long id) {
        if (id == null){
            log.error("L'ID ne doit pas être null");
            return null;
        }

        Optional<Property> property = propertyRepository.findById(id);

        return property.map(this::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID " + id + " n'a été trouvé dans la base de données",
                        ErrorCodes.USER_NOT_FOUND
                ));
    }


    @Override
    public List<PropertyDTO> findAllProperty() {
        return propertyRepository.findAll()
                .stream()
                .map(this::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDTO updatePropertyByIdAnd(Long id, PropertyDTO propertyDTO) {
        if (id == null) {
            log.error("L'ID de la propriété est null");
            throw new InvalidEntityException("L'ID de la propriété n'existe pas");
        }

        // Valider la propriété DTO avant la mise à jour
        List<String> errors = PropertyValidator.validate(propertyDTO);
        if (errors.isEmpty()) {
            log.error("Propriété invalide {}", propertyDTO);
            throw new InvalidEntityException("La propriété n'est pas valide", ErrorCodes.PROPRIETE_NOT_FOUND, errors);
        }

        // Rechercher la propriété existante
        Property updateProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucune propriété avec l'ID " + id + " n'a été trouvée dans la base de données",
                        ErrorCodes.PROPRIETE_NOT_FOUND
                ));
        // Mise à jour de la propriété
        updateProperty.setNumberOfBedrooms(propertyDTO.getNumberOfBedrooms());
        updateProperty.setNumberOfBathrooms(propertyDTO.getNumberOfBathrooms());
        updateProperty.setAreaInSquareMeters(propertyDTO.getAreaInSquareMeters());
        updateProperty.setHasKitchen(propertyDTO.isHasKitchen());
        updateProperty.setHasWifi(propertyDTO.isHasWifi());
        updateProperty.setAddress(AddressImp.toEntity(propertyDTO.getAddressDTO()));
        updateProperty.setPricePerNight(propertyDTO.getPricePerNight());
        updateProperty.setDescription(propertyDTO.getDescription());

        // Sauvegarder les données
        Property prop = propertyRepository.save(updateProperty);
        return fromEntity(prop);
    }

    @Override
    public void deletProperty(Long id) {
        if (id == null) {
            log.error("L'ID de la propriété à supprimer est nul");
            throw new InvalidEntityException("L'ID de la propriété ne peut pas être nul");
        }

        // Vérifier si l'utilisateur existe avant de le supprimer
        if (!propertyRepository.existsById(id)) {
            log.error("Aucune propriété trouvée avec l'ID: {}", id);
            throw new EntityNotFoundException(
                    "Aucune propriété avec l'ID " + id + " n'a été trouvée dans la base de données",
                    ErrorCodes.USER_NOT_FOUND
            );
        }
        propertyRepository.deleteById(id);
        log.info("Propriété avec ID: {} supprimée avec succès", id);
    }


    public PropertyDTO fromEntity(Property property) {
        return modelMapper.map(property, PropertyDTO.class);
    }

    public Property toEntity(PropertyDTO propertyDTO) {
        Property property;
        property = modelMapper.map(propertyDTO, Property.class);
        return property;
    }
}
