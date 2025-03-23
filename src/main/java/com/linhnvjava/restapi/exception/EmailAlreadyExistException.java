package com.linhnvjava.restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailAlreadyExistException extends RuntimeException {

    private String messsage;

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
