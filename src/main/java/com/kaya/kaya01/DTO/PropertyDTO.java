package com.kaya.kaya01.DTO;

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

    private LocationDTO locat;

    private CategoryDTO category;

    private List<PhotosDTO> photosList;


}
