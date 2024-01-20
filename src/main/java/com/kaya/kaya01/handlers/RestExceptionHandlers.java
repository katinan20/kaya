package com.kaya.kaya01.handlers;

import com.kaya.kaya01.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collection;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleException(EntityNotFoundException exception, WebRequest webRequest) {

        final HttpStatus notFound = HttpStatus.NOT_FOUND;
        final ErrorDTO errorDto = ErrorDTO.builder()
                .code(exception.getErrorCodes())
                .httpCode(notFound.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorDto, notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDTO> handleException(InvalidEntityException exception, WebRequest webRequest) {

        final HttpStatus badResquest = HttpStatus.BAD_REQUEST;
        final ErrorDTO errorDto = ErrorDTO.builder()
                .code(exception.getErrorCodes())
                .httpCode(badResquest.value())
                .message(exception.getMessage())
                .errors(exception.getErrors())
                .build();
        return new ResponseEntity<>(errorDto, badResquest);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleGlobalException(GlobalException ex, WebRequest request) {
        // Create a custom error response without the stack trace
        com.kaya.kaya01.handlers.ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(PhoneNumberValidationException.class)
    public ResponseEntity<Object> handleGlobalException(PhoneNumberValidationException ex, WebRequest request) {
        // Create a custom error response without the stack trace
        com.kaya.kaya01.handlers.ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getErrorCode(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
