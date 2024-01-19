package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.Property;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Data
public class PropertyDTO   {

    private Integer id;

    private String titre;

    private String location;

    private BigDecimal prix;

    private String type;

    private String size;

    private String numberOfRooms;

    private String description;

    private Date dateDeCreation;
/*
    private LocationDTO locat;

    private CategoryDTO category;

    private List<PhotosDTO> photosList;*/

    public static PropertyDTO fromEntity(Property property){
        if (property == null){
            return null;
        }
        return PropertyDTO.builder()
                .id(property.getId())
                .titre(property.getTitre())
                .location(property.getLocation())
                .prix(property.getPrix())
                .type(property.getType())
                .size(property.getSize())
                .numberOfRooms(property.getNumberOfRooms())
                .description(property.getDescription())
                .dateDeCreation(property.getDateDeCreation())
                .build();
    }

    public static Property toEntity(PropertyDTO propertyDTO){
        if (propertyDTO == null){
            return null;
        }

        Property property = new Property();
        property.setId(propertyDTO.getId());
        property.setTitre(propertyDTO.getTitre());
        property.setLocation(propertyDTO.getLocation());
        property.setPrix(propertyDTO.getPrix());
        property.setSize(propertyDTO.getSize());
        property.setType(propertyDTO.getType());
        property.setNumberOfRooms(propertyDTO.getNumberOfRooms());
        property.setDescription(propertyDTO.getDescription());
        property.setDateDeCreation(property.getDateDeCreation());

        return property;
    }
}
