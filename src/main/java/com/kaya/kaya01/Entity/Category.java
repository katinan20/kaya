package com.kaya.kaya01.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Table(name = "Category")
public class Category extends AbstractEntity{

    @Column(name = "CategorieName")
    private String CategorieName;

    @Column(name = "description")
    private String description;

    @Column(name = "dateCreation")
    private Date dateCreation;

    @Column(name = "lastModif")
    private Date lastModif;

    @OneToMany(mappedBy = "category")
    private List<Property> propertyList;

}
