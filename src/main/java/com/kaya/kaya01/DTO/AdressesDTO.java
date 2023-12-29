package com.kaya.kaya01.DTO;

import com.kaya.kaya01.Entity.Adresses;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Builder

public class AdressesDTO {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostal;

    private String pays;


    public static AdressesDTO fromEntity(Adresses adresses){
        if (adresses == null){
            return null;
        }
        return AdressesDTO.builder()
                .adresse1(adresses.getAdresse1())
                .adresse2(adresses.getAdresse2())
                .ville(adresses.getVille())
                .codePostal(adresses.getCodePostal())
                .pays(adresses.getPays())
                .build();
    }

    public static Adresses toEntity(AdressesDTO adressesDTO){
        if (adressesDTO == null){
            return null;
        }

        Adresses adresses = new Adresses();

        adresses.setAdresse1(adressesDTO.getAdresse1());
        adresses.setAdresse2(adressesDTO.getAdresse2());
        adresses.setPays(adressesDTO.getPays());
        adresses.setVille(adressesDTO.getVille());
        adresses.setCodePostal(adressesDTO.getCodePostal());

        return adresses;
    }
}
