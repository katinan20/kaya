package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.PropertyType;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PropertyTypeDTO {

    private Long id;

    @JsonProperty("typeName")
    private String typeName;

    // Vous pouvez ajouter d'autres champs ou DTOs si nécessaire

    public static PropertyTypeDTO fromEntity(PropertyType propertyType) {
        if (propertyType == null) {
            return null;
        }
        return PropertyTypeDTO.builder()
                .id(propertyType.getId())
                .typeName(propertyType.getTypeName())
                // Ajoutez d'autres conversions si nécessaire
                .build();
    }

    public static PropertyType toEntity(PropertyTypeDTO propertyTypeDTO) {
        if (propertyTypeDTO == null) {
            return null;
        }

        PropertyType propertyType = new PropertyType();
        propertyType.setId(propertyTypeDTO.getId());
        propertyType.setTypeName(propertyTypeDTO.getTypeName());
        // Ajoutez d'autres conversions si nécessaire

        return propertyType;
    }
}
