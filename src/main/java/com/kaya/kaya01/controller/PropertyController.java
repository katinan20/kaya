package com.kaya.kaya01.controller;

import com.kaya.kaya01.DTO.PropertyDTO;
import com.kaya.kaya01.controller.api.PropertyApi;
import com.kaya.kaya01.service.serviceImp.PropertyServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropertyController implements PropertyApi {
    private PropertyServiceImp propertyServiceImp;
    @Autowired
    public PropertyController(PropertyServiceImp propertyServiceImp){
        this.propertyServiceImp = propertyServiceImp;
    }
    @Override
    public PropertyDTO creatProperty(PropertyDTO propertyDTO) {
        return propertyServiceImp.creatProperty(propertyDTO);
    }

    @Override
    public PropertyDTO findProperTyById(Long id) {
        return propertyServiceImp.findProperTyById(id);
    }

    @Override
    public List<PropertyDTO> findAllProperty() {
        return propertyServiceImp.findAllProperty();
    }

    @Override
    public PropertyDTO updatePropertyByIdAnd(Long id, PropertyDTO propertyDTO) {
        return propertyServiceImp.updatePropertyByIdAnd(id,propertyDTO);
    }

    @Override
    public void deletProperty(Long id) {
        propertyServiceImp.deletProperty(id);
    }
}
