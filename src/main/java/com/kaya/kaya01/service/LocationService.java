package com.kaya.kaya01.service;

import com.kaya.kaya01.DTO.LocationDTO;
import com.kaya.kaya01.DTO.UserDTO;

import java.util.List;
public interface LocationService {
    LocationDTO createLocation(LocationDTO locationDTO);
    LocationDTO updateLocationById(Integer id,LocationDTO locationDTO);
    LocationDTO findLocationById(Integer id);
    LocationDTO findLocationByCode(String code);
    List<LocationDTO> findAllLocation();
    void  deleteUser(Integer id);

}
