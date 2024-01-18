package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.Location;
import com.kaya.kaya01.enumEntity.TypeLocation;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class LocationDTO  {

    private Integer id;

    private String codeLocat;

    private Instant dateEntre;

    private Instant dateSortie;

    private Instant dateReservation;

    private BigDecimal prixTotal;

    private TypeLocation typeLocation;

    private String statusPayement;

    private UserDTO user;

    private List<TransactionDTO> transactionList;

    private PropertyDTO property;

    public static LocationDTO fromEntity(Location location){
        if (location == null){
            return null;
        }
        return LocationDTO.builder()
                .id(location.getId())
                .codeLocat(location.getCodeLocat())
                .dateEntre(location.getDateEntre())
                .dateSortie(location.getDateSortie())
                .dateReservation(location.getDateReservation())
                .prixTotal(location.getPrixTotal())
                .typeLocation(location.getTypeLocation())
                .statusPayement(location.getStatusPayement())
                .build();
    }

    public static Location toEntity(LocationDTO locationDTO){
        if (locationDTO == null){
            return null;
        }
        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setCodeLocat(locationDTO.getCodeLocat());
        location.setDateEntre(locationDTO.getDateEntre());
        location.setDateSortie(locationDTO.getDateSortie());
        location.setDateReservation(locationDTO.getDateReservation());
        location.setPrixTotal(locationDTO.getPrixTotal());
        location.setTypeLocation(locationDTO.getTypeLocation());
        location.setStatusPayement(locationDTO.getStatusPayement());

        return location;
    }


}
