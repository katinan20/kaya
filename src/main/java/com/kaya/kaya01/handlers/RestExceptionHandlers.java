package com.kaya.kaya01.handlers;

import com.kaya.kaya01.exception.EntityNotFoundException;
import com.kaya.kaya01.exception.InvalideEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(EntityNotFoundException exception, WebRequest webRequest){

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final  ErrorDTO errorDto = ErrorDTO.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalideEntityException.class)
    public ResponseEntity <ErrorDTO> handleException(InvalideEntityException exception, WebRequest webRequest){

        final HttpStatus badResquest = HttpStatus.BAD_REQUEST;
        final ErrorDTO errorDto = ErrorDTO.builder()
                .code(exception.getErrorCodes())
                .httpCode(badResquest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badResquest);
    }

}
