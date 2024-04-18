package com.finance.banking.AuthenticationService.AuthExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InValidSignUpDetailsException extends RuntimeException{

    private HttpStatus errorStatus;

    public InValidSignUpDetailsException() {
        super("Invalid Details");
    }

    public InValidSignUpDetailsException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorStatus = status;
    }
}
