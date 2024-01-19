package com.kaya.kaya01.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class Adresses {

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "ville")
    private String ville;

    @Column(name = "codePostal")
    private String codePostal;

    @Column(name = "pays")
    private String pays;

}
