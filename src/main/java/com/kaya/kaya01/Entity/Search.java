package com.kaya.kaya01.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "search")
public class Search extends AbstractEntity{

    @Column(name = "location")
    private String location;

    @Column(name = "priceRangMin")
    private BigDecimal priceRangMin;

    @Column(name = "priceRangMax")
    private BigDecimal priceRangMax;

    @Column(name = "typeTrans")
    private String typeTrans;

    @Column(name = "nomberOfRoome")
    private Integer nomberOfRoome;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
