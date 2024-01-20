package com.kaya.kaya01.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kaya.kaya01.DTO.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Data
@Table(name = "address")
public class Address extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "address_type")
    private String addressType;

    @JsonIgnoreProperties("addresses")
    @ManyToOne
    private User user;

}
