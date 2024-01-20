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
public class Property extends AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_type_id")
    private PropertyType propertyType;

    @Column(name = "num_bedrooms")
    private int numberOfBedrooms;

    @Column(name = "num_bathrooms")
    private int numberOfBathrooms;

    @Column(name = "area_square_meters")
    private double areaInSquareMeters;

    @Column(name = "has_kitchen")
    private boolean hasKitchen;

    @Column(name = "has_wifi")
    private boolean hasWifi;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "price_per_night")
    private double pricePerNight;

    @Column(name = "description", length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "property")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "property")
    private List<Review> reviews;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToMany
    @JoinTable(
            name = "property_amenities",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "amenity_id"))
    private List<Amenity> amenities;

    @ManyToMany
    @JoinTable(
            name = "property_advantages",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "advantage_id"))
    private List<Advantage> advantages;

    @ManyToMany
    @JoinTable(
            name = "property_nearby_locations",
            joinColumns = @JoinColumn(name = "property_id"),
            inverseJoinColumns = @JoinColumn(name = "nearby_location_id"))
    private List<NearbyLocation> nearbyLocations;
}
