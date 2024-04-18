package com.finance.banking.AuthenticationService.AuthExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InValidLoginCredentialsException extends RuntimeException{

    private HttpStatus errorStatus;

    public InValidLoginCredentialsException() {
        super("Invalid login");
    }

    public InValidLoginCredentialsException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorStatus = status;
    }
}
