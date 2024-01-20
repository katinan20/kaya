package com.kaya.kaya01.utils;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.kaya.kaya01.exception.PhoneNumberValidationException;

import java.util.regex.Pattern;

public class ValidationUtils {

    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
    private static final String REGEX_PHONE_NUMBER = "^(\\+?\\d{1,3})?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})[-. ]*$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

    public static boolean isValidEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }
    public static boolean isValidPhone(String phone) {
        return Pattern.matches(REGEX_PHONE_NUMBER, phone);
    }


    public static boolean validatePhoneNumber(String phoneNumberRequest) {
        try {
            com.google.i18n.phonenumbers.Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(phoneNumberRequest, null);
            if (isValidPhone(phoneNumberRequest) && phoneNumberUtil.isPossibleNumber(phoneNumber) && phoneNumberUtil.isValidNumber(phoneNumber)) {
                return true;
            } else {
                throw determinePhoneNumberError(phoneNumber);
            }
        } catch (Exception e) {
            throw new PhoneNumberValidationException(e.hashCode(), "BAD_PHONE_NUMBER", e.getMessage());
        }
    }

    private static PhoneNumberValidationException determinePhoneNumberError(com.google.i18n.phonenumbers.Phonenumber.PhoneNumber phoneNumber) {
        PhoneNumberUtil.ValidationResult validationResult = phoneNumberUtil.isPossibleNumberWithReason(phoneNumber);
        String[] errorMessages = {
                "Phone number is not valid because it's too short",
                "Phone number is not valid because it's too long",
                "Phone number is not valid because it's not a valid country code",
                "Phone number is not valid because it's not a valid length"
        };

        String message = validationResult.ordinal() < errorMessages.length ? errorMessages[validationResult.ordinal()] : "Phone number is not valid";
        return new PhoneNumberValidationException(400, "BAD_PHONE_NUMBER", message);
    }
}
