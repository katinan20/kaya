package com.kaya.kaya01.service.serviceImp;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.repository.LocationRepository;
import com.kaya.kaya01.repository.PropertyRepository;
import com.kaya.kaya01.repository.TransactionRepository;
import com.kaya.kaya01.repository.UserRepository;
import com.kaya.kaya01.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LocationServiceImp implements LocationService {
    private LocationRepository locationRepository;
    private UserRepository userRepository;
    private PropertyRepository propertyRepository;
    private TransactionRepository transactionRepository;

    @Autowired
    public LocationServiceImp(LocationRepository locationRepository,
                              UserRepository userRepository,
                              PropertyRepository propertyRepository,
                              TransactionRepository transactionRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        
        return null;
    }

    @Override
    public LocationDTO updateLocationById(Integer id, LocationDTO locationDTO) {
        return null;
    }

    @Override
    public LocationDTO findLocationById(Integer id) {
        return null;
    }

    @Override
    public LocationDTO findLocationByCode(String code) {
        return null;
    }

    @Override
    public List<LocationDTO> findAllLocation() {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }
}
