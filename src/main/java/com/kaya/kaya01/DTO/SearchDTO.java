package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.Search;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Data
public class SearchDTO {

    private Long id;

    private String location;

    private BigDecimal priceRangMin;

    private BigDecimal priceRangMax;

    private String typeTrans;

    private Integer nomberOfRoome;

    private List<UserDTO> user;

    public SearchDTO(@JsonProperty("id")Long id,
                     @JsonProperty("location")String location,
                     @JsonProperty("priceRangMin")BigDecimal priceRangMin,
                     @JsonProperty("priceRangMax")BigDecimal priceRangMax,
                     @JsonProperty("typeTrans")String typeTrans,
                     @JsonProperty("nomberOfRoome")Integer nomberOfRoome,
                     @JsonProperty("user")List<UserDTO> user) {
        this.id = id;
        this.location = location;
        this.priceRangMin = priceRangMin;
        this.priceRangMax = priceRangMax;
        this.typeTrans = typeTrans;
        this.nomberOfRoome = nomberOfRoome;
        this.user = user;
    }

    public static SearchDTO fromEntity(Search search){
        if (search == null){
            return null;
        }
        return SearchDTO.builder()
                .id(search.getId())
                .location(search.getLocation())
                .priceRangMin(search.getPriceRangMin())
                .priceRangMax(search.getPriceRangMax())
                .typeTrans(search.getTypeTrans())
                .nomberOfRoome(search.getNomberOfRoome())
                .build();
    }

    public static Search toEntity(SearchDTO searchDTO){
        if (searchDTO == null){
            return null;
        }

        Search search = new Search();

        search.setId(searchDTO.getId());
        search.setLocation(searchDTO.getLocation());
        search.setPriceRangMin(searchDTO.getPriceRangMin());
        search.setPriceRangMax(searchDTO.getPriceRangMax());
        search.setTypeTrans(searchDTO.getTypeTrans());
        search.setNomberOfRoome(searchDTO.getNomberOfRoome());

        return search;

    }
}
