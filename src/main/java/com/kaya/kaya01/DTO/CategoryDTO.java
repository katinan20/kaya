package com.kaya.kaya01.DTO;


import com.kaya.kaya01.Entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Builder
@Data
public class CategoryDTO  {

    private Integer id;

    private String categorieName;

    private String description;

    private Date dateCreation;

    private Date lastModif;

    private List<PropertyDTO> propertyList;

    public static CategoryDTO fromEntity(Category category){
        if (category == null){
            return null;
        }
        return CategoryDTO.builder()
                .id(category.getId())
                .categorieName(category.getCategorieName())
                .description(category.getDescription())
                .dateCreation(category.getDateCreation())
                .lastModif(category.getLastModif())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO){

        if (categoryDTO == null){
            return null;
        }

        Category category = new Category();

        category.setId(categoryDTO.getId());
        category.setCategorieName(categoryDTO.getCategorieName());
        category.setDescription(categoryDTO.getDescription());
        category.setDateCreation(categoryDTO.getDateCreation());
        category.setLastModif(categoryDTO.getLastModif());

        return category;
    }

}
