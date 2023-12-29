package com.kaya.kaya01.Entity;

import com.kaya.kaya01.enumEntity.TypeTransation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "transaction")
public class Transaction extends AbstractEntity {

    @Column(name = "montant")
    private BigDecimal montant;

    @Column(name = "typeTransation")
    @Enumerated(EnumType.STRING)
    private TypeTransation typeTransation;

    @Column(name = "status")
    private String statut;

    //////////////
    @ManyToOne
    @JoinColumn(name = "idlocation")
    private Location location;
}
