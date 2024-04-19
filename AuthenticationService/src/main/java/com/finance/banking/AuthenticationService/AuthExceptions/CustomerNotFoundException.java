package com.finance.banking.AuthenticationService.AuthExceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomerNotFoundException extends RuntimeException{

    private HttpStatus errorStatus;

    public CustomerNotFoundException() {
        super("Customer Not found");
    }

    public CustomerNotFoundException(String errorMessage, HttpStatus status) {
        super(errorMessage);
        this.errorStatus = status;
    }
}
