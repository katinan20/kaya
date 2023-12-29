package com.kaya.kaya01.handlers;

import com.kaya.kaya01.exception.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {

    private Integer httpCode; // 404 ou 403 ...
    private ErrorCodes code;

    private String message;

    private List<String> errors = new ArrayList<>();
}
