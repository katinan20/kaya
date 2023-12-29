package com.kaya.kaya01.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Data
@Table(name = "user_app")
public class User  extends AbstractEntity{

    @Column(name = "codeUser")
    private String code;

    @Column(name = "nameUser")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "adrese")
    @Embedded // Utilisez @Embedded pour la classe intégrée Adresses
    private Adresses adresse;

    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE) // Ajouté pour préciser le type de date
    private Date dateNaissance;

    @Column(name = "password")
    private String password;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToOne
    private Search search;

    /////////////////////////

    @OneToMany(mappedBy = "user")
    private List<Location> locations;
}
