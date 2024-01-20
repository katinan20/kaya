package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.Property;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class PropertyDTO {

    private Long id;

    @JsonProperty("propertyType")
    private PropertyTypeDTO propertyTypeDTO;

    @JsonProperty("numberOfBedrooms")
    private int numberOfBedrooms;

    @JsonProperty("numberOfBathrooms")
    private int numberOfBathrooms;

    @JsonProperty("areaInSquareMeters")
    private double areaInSquareMeters;

    @JsonProperty("hasKitchen")
    private boolean hasKitchen;

    @JsonProperty("hasWifi")
    private boolean hasWifi;

    @JsonProperty("address")
    private AddressDTO addressDTO;

    @JsonProperty("pricePerNight")
    private double pricePerNight;

    @JsonProperty("description")
    private String description;

    @JsonProperty("category")
    private CategoryDTO categoryDTO;


}
