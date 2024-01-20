package com.kaya.kaya01.exception;

import lombok.Getter;

@Getter
public class PhoneNumberValidationException extends RuntimeException {
    private final int statusCode;
    private final String errorCode;

    public PhoneNumberValidationException(int statusCode, String errorCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

}
