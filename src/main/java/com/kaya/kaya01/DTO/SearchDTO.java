package com.kaya.kaya01.DTO;

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

    private Integer id;

    private String location;

    private BigDecimal priceRangMin;

    private BigDecimal priceRangMax;

    private String typeTrans;

    private Integer nomberOfRoome;

    private List<UserDTO> user;

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

    public static Search fromEntity(SearchDTO searchDTO){
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
