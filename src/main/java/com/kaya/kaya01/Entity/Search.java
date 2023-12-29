package com.kaya.kaya01.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    ////////////////////
    @OneToMany(mappedBy = "search")
    private List<User> user;
}
