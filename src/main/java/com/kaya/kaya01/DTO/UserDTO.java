package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaya.kaya01.Entity.User;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("phoneNumber")
    private List<PhoneNumberDTO> phoneNumber;

    @JsonProperty("addresses")  // Change from "address" to "addresses"
    private List<AddressDTO> addresses;

}
