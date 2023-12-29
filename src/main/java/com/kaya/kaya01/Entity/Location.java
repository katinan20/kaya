package com.kaya.kaya01.Entity;

import com.kaya.kaya01.enumEntity.TypeLocation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Table(name = "location")
public class Location extends AbstractEntity {

    @Column(name = "dateEntre")
    private Instant dateEntre;

    @Column(name = "dateSortie")
    private Instant dateSortie;

    @Column(name = "dateReservation")
    private Instant dateReservation;

    @Column(name = "prixTotal")
    private BigDecimal prixTotal;

    @Column(name = "typeLocation")
    @Enumerated(EnumType.STRING)
    private TypeLocation typeLocation;

    @Column(name = "status")
    private String statusPayement;

    /////////////////////////////

    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;

    @OneToMany(mappedBy = "location")
    private List<Transaction> transactionList;

    @OneToOne
    @JoinColumn(name = "idproperty")
    private Property property;


}
