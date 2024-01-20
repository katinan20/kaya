package com.kaya.kaya01.service;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.DTO.UserDTO;

import java.util.List;
public interface LocationService {
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO updateLocationById(Long id,LocationDTO locationDTO);
    LocationDTO findLocationById(Long id);
    LocationDTO findLocationByCode(String code);
    List<LocationDTO> findAllLocation();
    void  deleteLocation(Long id);

}
