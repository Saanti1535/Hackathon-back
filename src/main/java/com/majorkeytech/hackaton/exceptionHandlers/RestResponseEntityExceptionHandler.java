package com.majorkeytech.hackaton.exceptionHandlers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.majorkeytech.hackaton.businessExceptions.DataConsistencyException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<String> handleSecurityException(SecurityException excepcion) {
        return new ResponseEntity<String>(excepcion.getMessage(), HttpStatus.UNAUTHORIZED);
    }
    
    @ExceptionHandler(DataConsistencyException.class)
    public ResponseEntity<String> handleDataConsistencyException(DataConsistencyException excepcion){
        return new ResponseEntity<String>(excepcion.getMessage(), HttpStatus.BAD_REQUEST);
    }
    
}
