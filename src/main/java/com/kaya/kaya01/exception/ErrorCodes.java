package com.kaya.kaya01.exception;

public enum ErrorCodes {
    CATEGORIE_NOT_FOUND(1000),
    LOCATION_NOT_FOUND(2000),
    PHOTO_NOT_FOUND(3000),
    PROPRIETE_NOT_FOUND(4000),
    SEARCH_NOT_FOUND(5000),
    TRANSACTION_NOT_FOUND(6000),
    USER_NOT_FOUND(7000);
    private int code;

    ErrorCodes(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
