package com.majorkeytech.hackaton.businessExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataConsistencyException extends RuntimeException {
    public DataConsistencyException(String message){
        super(message);
    }
}
