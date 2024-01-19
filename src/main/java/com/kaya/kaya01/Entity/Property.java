package com.kaya.kaya01.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@Table(name = "property")
public class Property  extends AbstractEntity{
    @Column(name = "title")
    private String titre;

    @Column(name = "location")
    private String location;

    @Column(name = "price")
    private BigDecimal prix;

    @Column(name = "type")
    private String type;

    @Column(name = "size")
    private String size;

    @Column(name = "numberOfRooms")
    private String numberOfRooms;

    @Column(name = "description")
    private String description;

    @Column(name = "dateCreation")
    private Date dateDeCreation;

    ///////////////////////////

    @OneToOne(mappedBy = "property")
    private Location locat;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "property")
    private List<Photos> photosList;

    /*@PrePersist
    public void prePersist() {
        dateDeCreation = Date.now();
    }*/
}
