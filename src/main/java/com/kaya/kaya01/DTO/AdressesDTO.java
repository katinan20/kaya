package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.Adresses;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdressesDTO {
    @JsonProperty("adresse")
    private String adresse;

    @JsonProperty("ville")
    private String ville;

    @JsonProperty("codePostal")
    private String codePostal;

    @JsonProperty("pays")
    private String pays;

    public AdressesDTO(String adresse,
                       String ville,
                       String codePostal,
                       String pays) {
        this.adresse = adresse;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
    }

    public static AdressesDTO fromEntity(Adresses adresses){
        if (adresses == null){
            return null;
        }
        return AdressesDTO.builder()
                .adresse(adresses.getAdresse())
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

        adresses.setAdresse(adressesDTO.getAdresse());
        adresses.setPays(adressesDTO.getPays());
        adresses.setVille(adressesDTO.getVille());
        adresses.setCodePostal(adressesDTO.getCodePostal());

        return adresses;
    }
}
