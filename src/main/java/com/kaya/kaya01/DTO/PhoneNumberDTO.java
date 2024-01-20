package com.kaya.kaya01.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PhoneNumberDTO {
    @JsonProperty("phone")
    private String phone;
}
