package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.Entity.Location;
import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.ErrorCodes;
import com.kaya.kaya01.exception.InvalideEntityException;
import com.kaya.kaya01.repository.LocationRepository;
import com.kaya.kaya01.repository.PropertyRepository;
import com.kaya.kaya01.repository.UserRepository;
import com.kaya.kaya01.service.LocationService;
import com.kaya.kaya01.validator.LocationValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LocationServiceImp implements LocationService {
    private LocationRepository locationRepository;
    private UserRepository userRepository;
    private PropertyRepository propertyRepository;
    @Autowired
    public LocationServiceImp(LocationRepository locationRepository,
                              UserRepository userRepository,
                              PropertyRepository propertyRepository
                             ) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        List<String> errors = LocationValidator.validate(locationDTO);

        // verifier si les champs sont remplit
        if (!errors.isEmpty()){
            log.error("location no valide {} ", locationDTO);
            throw new InvalideEntityException("location non valide", ErrorCodes.LOCATION_NOT_FOUND, errors);
        }

        //verification de l'existance
       /* if(locationRepository.findLocationByTypeLocation(locationDTO.getTypeLocation())){

        }
*/
        //Enregistrer la location
        //Location location = locationRepository.save(LocationDTO.toEntity(locationDTO));
        return LocationDTO.fromEntity(
                locationRepository.save(LocationDTO.toEntity(locationDTO))
        );
    }

    @Override
    public LocationDTO updateLocationById(Integer id, LocationDTO locationDTO) {
        if (id == null){
            log.error("l'ID n;existe pas dans la base de donnée");
            throw new InvalideEntityException("L'ID de la Location ne doit pas etre null");
        }

        // Valider le UserDTO avant la mise à jour
        List<String> errors = LocationValidator.validate(locationDTO);
        if (!errors.isEmpty()) {
            log.error("location invalide {}", locationDTO);
            throw new InvalideEntityException("lalocation n'est pas valide", ErrorCodes.LOCATION_NOT_FOUND, errors);
        }

        // rechercher l'utilisateur existant
        Location location = locationRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune location avec L'ID " +id+ "n a été trouver dans la base de donnée",
                        ErrorCodes.LOCATION_NOT_FOUND
                ));

        // Mise à jour des champs de l'utilisateur
        location.setCodeLocat(locationDTO.getCodeLocat());
        location.setTypeLocation(locationDTO.getTypeLocation());
        location.setStatusPayement(locationDTO.getStatusPayement());
        location.setPrixTotal(locationDTO.getPrixTotal());
        location.setDateReservation(locationDTO.getDateReservation());

        //Sauvegarder les informations
        Location location1 = locationRepository.save(location);

        //Convertir et retourner les donnée en DTO
        return LocationDTO.fromEntity(location1);
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        if (id == null){
            log.error("L ID est null");
            return null;
        }

        Optional<Location> location = locationRepository.findById(id);
        return Optional.of(LocationDTO.fromEntity(location.get())).orElseThrow(
                ()-> new EntityNotFoundException(
                        "aucune location avec L ID "+id+"n a été trouvé dans la base de donnée ",
                        ErrorCodes.LOCATION_NOT_FOUND
                )
        );
    }

    @Override
    public LocationDTO findLocationByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("le code est null");
            return null;
        }
        Optional<Location> location = locationRepository.findByCodeLocat(code);
        return Optional.of(LocationDTO.fromEntity(location.get())).orElseThrow(
                () -> new EntityNotFoundException(
                        "aucune location avec le code " + code + "n a été trouvé dans la base de donnée ",
                        ErrorCodes.LOCATION_NOT_FOUND
                )
        );
    }

    @Override
    public List<LocationDTO> findAllLocation() {
        return locationRepository.findAll().stream()
                .map(LocationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLocation(Integer id) {
        if (id == null){
            log.error("L'ID est null");
            return;
        }
        locationRepository.deleteById(id);
    }
}
