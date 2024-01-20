package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.Address;
import com.kaya.kaya01.Entity.User;
import com.kaya.kaya01.service.serviceImp.UserServiceImpl;
import lombok.*;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddressDTO {
    @JsonProperty("street")
    private String street;

    @JsonProperty("city")
    private String city;

    @JsonProperty("postalCode")
    private String postalCode;

    @JsonProperty("country")
    private String country;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("additionalInfo")
    private String additionalInfo;

    @JsonProperty("addressType")
    private String addressType;

}
