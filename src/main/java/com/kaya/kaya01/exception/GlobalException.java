package com.kaya.kaya01.exception;

import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private final int statusCode;
    private final String errorCode;

    public GlobalException(int statusCode, String errorCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public GlobalException(String message, Throwable cause, int statusCode, String errorCode){
        super(message, cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }

    public GlobalException(String message, int statusCode, String errorCode){
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
    }
}
