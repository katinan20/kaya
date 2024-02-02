package com.kaya.kaya01.controller;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.controller.api.PropertyApi;
import com.kaya.kaya01.service.serviceImp.PropertyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController implements PropertyApi {
    private final PropertyServiceImp propertyServiceImp;
    @Autowired
    public PropertyController(PropertyServiceImp propertyServiceImp){
        this.propertyServiceImp = propertyServiceImp;
    }
    @Override
    public PropertyDTO createProperty(PropertyDTO propertyDTO) {
        return propertyServiceImp.creatProperty(propertyDTO);
    }

    @Override
    public PropertyDTO findPropertyById(Long id) {
        return propertyServiceImp.findProperTyById(id);
    }

    @Override
    public List<PropertyDTO> findAllProperties() {
        return propertyServiceImp.findAllProperty();
    }

    @Override
    public PropertyDTO updatePropertyById(Long id, PropertyDTO propertyDTO) {
        return propertyServiceImp.updatePropertyByIdAnd(id,propertyDTO);
    }

    @Override
    public void deleteProperty(Long id) {
        propertyServiceImp.deletProperty(id);
    }
}
