package com.kaya.kaya01.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberToCarrierMapper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.kaya.kaya01.exception.PhoneNumberValidationException;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Builder
@Data
@Table(name = "phone_number")
public class PhoneNumber extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "carrier_name")
    private String carrierName;

    @Column(name = "country_iso")
    private String countryIso;

    @JsonIgnoreProperties("phone_numbers")
    @ManyToOne
    private User user;

    // Other fields and methods

    // Method to automatically populate carrierName and countryIso based on the phone number
    public void populatePhoneDetails() {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        PhoneNumberToCarrierMapper carrierMapper = PhoneNumberToCarrierMapper.getInstance();
        try {
            com.google.i18n.phonenumbers.Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(this.phone,null);
            carrierName = carrierMapper.getNameForNumber(phoneNumber, Locale.getDefault());
            countryIso = phoneNumberUtil.getRegionCodeForNumber(phoneNumber);
        } catch (NumberParseException e) {
            throw new PhoneNumberValidationException(400, "BAD_PHONE_NUMBER", e.getLocalizedMessage());
        }
    }
}
