package com.kaya.kaya01.service;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.DTO.UserDTO;

import java.util.List;

public interface PropertyService {
    PropertyDTO creatProperty(PropertyDTO propertyDTO);
    PropertyDTO findProperTyById(Integer id);
    List<PropertyDTO> findAllProperty();
    PropertyDTO updatePropertyByIdAnd(Integer id, PropertyDTO propertyDTO);
    void deletProperty(Integer id);
}
