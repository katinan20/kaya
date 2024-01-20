package com.kaya.kaya01.controller;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.controller.api.LocationApi;
import com.kaya.kaya01.service.serviceImp.LocationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController implements LocationApi {
    private LocationServiceImp locationServiceImp;
    @Autowired
    public LocationController(LocationServiceImp locationServiceImp){
        this.locationServiceImp = locationServiceImp;
    }
    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) {
        return locationServiceImp.createLocation(locationDTO);
    }

    @Override
    public LocationDTO updateLocationById(Long id, LocationDTO locationDTO) {
        return locationServiceImp.updateLocationById(id,locationDTO);
    }

    @Override
    public LocationDTO findLocationById(Long id) {
        return locationServiceImp.findLocationById(id);
    }

    @Override
    public LocationDTO findLocationByCode(String code) {
        return locationServiceImp.findLocationByCode(code);
    }

    @Override
    public List<LocationDTO> findAllLocation() {
        return locationServiceImp.findAllLocation();
    }

    @Override
    public void deleteLocation(Long id) {
        locationServiceImp.deleteLocation(id);
    }
}
